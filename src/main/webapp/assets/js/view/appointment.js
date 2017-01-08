/**
 * Created by Administrator on 2017/1/6.
 */
var allOrg = null;
var allCombo = null;
var extraProject = null;
var allPrice = 0;
var lock = false;

$(function () {
    document.getElementById('orderDate').valueAsDate = new Date();
    initOrganizationSelect();
    initComboSelect();
});

function initComboSelect() {
    $.getJSON('combo/list', function (result) {
        allCombo = result.data;
        var html = [];
        html.push("<option value='-1'>请选择套餐</option>")
        for (var i = 0; i < allCombo.length; i++) {
            html.push("<option value='" + i + "'>" + allCombo[i].name + "</option>")
        }
        $("#comboSelect").html(html.join(""));
    })
}
function initOrganizationSelect() {
    $.getJSON('organization/list', function (result) {
        allOrg = result.data;
        var html = [];
        html.push("<option value='-1'>请选择机构</option>")
        for (var i = 0; i < allOrg.length; i++) {
            html.push("<option value='" + i + "'>" + allOrg[i].name + "</option>")
        }
        $("#organizationSelect").html(html.join(""));
    })
}

//当机构改变时
function changeOrganization() {
    var orgIndex = $("#organizationSelect").val();
    var nowOrg = allOrg[orgIndex];
    var html = [];
    html.push('<img src="' + nowOrg.picture + '" style="float: left" width="200px" height="200px"/>')
    html.push('<h3>' + nowOrg.name + '</h3>');
    html.push('<p>' + nowOrg.phone + '</p>');

    $("#organizationDiv").html(html.join(""));
}

//当套餐改变时
function changeCombo() {
    var comboIndex = $("#comboSelect").val();
    console.log("combo : " + comboIndex);
    var nowCombo = allCombo[comboIndex];
    changeExtraProject(nowCombo.id);
    var html = [];
    html.push('<img src="' + nowCombo.picture + '" style="float: left" width="200px" height="200px"/>')
    html.push('<h3>' + nowCombo.name + '</h3>');
    html.push('<p>' + nowCombo.price + '元</p>');
    html.push('<button class="btn btn-primary" onclick="showInfo('+comboIndex+')">查看详情</button>');

    $("#comboDiv").html(html.join(""));
}

function changeExtraProject(comboId) {
    var html = [];
    updatePrice();
    $.getJSON('combo/' + comboId + '/extra', function (result) {
        extraProject = result.data;
        for (var i = 0; i < extraProject.length; i++) {
            html.push('<div class="checkbox"><label><input onclick="checkProject(this)" type="checkbox" name="projectId" value="' + i + '">' + extraProject[i].name + ' </label> </div>');
        }
        $("#extraDiv").html(html.join(""));
    })
}

function checkProject(obj) {
    updatePrice();
}

function updatePrice() {
    var comboIndex = $("#comboSelect").val();
    var nowCombo = allCombo[comboIndex];
    allPrice = nowCombo.price;
    $("#extraDiv .checkbox label input").each(function (index) {
        if ($(this).prop("checked")) {
            allPrice += extraProject[index].price;
        }
    });
    $(".appointment-money").html(allPrice + "元")
}

function submitOrder() {
    var orgIndex = $("#organizationSelect").val();
    if(comboIndex == -1){
        alert("请选择机构");
        return;
    }
    var comboIndex = $("#comboSelect").val();
    if(comboIndex == -1){
        alert("请选择套餐");
        return;
    }
    var comboName = allCombo[comboIndex].name;
    var orgName = allOrg[orgIndex].name;
    var extra = findProjectsBYId(allCombo[comboIndex].id);
    $("#extraDiv .checkbox label input").each(function (index) {
        if ($(this).prop("checked")) {
            extra.push(extraProject[index]);
        }
    });
    var extraInfo = JSON.stringify(extra);
    var a = [];
    a.push('orgName='+orgName);
    a.push("comboName="+comboName);
    a.push("extraInfo="+extraInfo);
    a.push("price="+allPrice);

    var data = $("#infoForm").serialize()+"&"+a.join("&");
    $.ajax({
        url:'/order',
        type:'post',
        data:data,
        dataType:'json',
        beforeSend:function(XHR){
            lock = true;
            updateSubmitButton();
        },
        success:function (result) {
            if(result.returnCode == 'SUCCESS'){
                alert("提交订单成功");
                window.location.href = 'order';
            }

        },
        error:function () {
            lock = false;
            updateSubmitButton();
        }
    })
    console.log(data);
}

function findProjectsBYId(id) {
    var data;
    $.ajax({
        url: '/combo/' + id + '/project',
        type: 'GET',
        async: false,
        dataType: 'json',
        success: function (result) {
            data = result.data;
        }
    });
    return data;
}
function showInfo(id) {
    var item = allCombo[id];

    $("#info-modal").modal('show');
    $("#info-modal table tr:eq(0) td:eq(1) p").html(item.name);
    $("#info-modal table tr:eq(1) td:eq(1) p").html(item.price);
    var projects = findProjectsBYId(item.id);
    if (projects.length == 0) {
        $("#info-modal table tr:eq(2) td:eq(1)").html("暂无项目");
        return;
    }
    var html = [];
    html.push("<table class='table table-bordered '><tr><th>项目名</th><th>介绍</th></tr>")
    for (var i = 0; i < projects.length; i++) {
        html.push("<tr>")
        html.push("<td>" + projects[i].name + "</td>")
        html.push("<td>" + projects[i].comments + "</td>")
        html.push("</tr>")
    }
    html = html.join("");
    $("#info-modal table tr:eq(2) td:eq(1)").html(html);
}

function updateSubmitButton() {
    if(lock){
        $("#submitButton").attr("disabled","disabled");
        $("#submitButton").text("提交中...");

    }else{
        $("#submitButton").removeAttr("disabled")
        $("#submitButton").text("提交订单");

    }
}