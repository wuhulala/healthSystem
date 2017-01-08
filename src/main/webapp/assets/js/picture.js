/**
 * Created by xueaohui on 2016/2/13.
 */

$(function(){
    showAllPic();
});
function addPic(){
    $("#pic").trigger("click");


}

function showPicModal(){
    $("#pic").val("");
    $("#viewmodal").modal("show");


}
function uploadPic(){
    if(!$("#pic").val()){
        showAlert("请选择图片",1);
        return false;
    }else{
        $.ajaxFileUpload({
            url : 'picture',
            secureuri : false,
            fileElementId :['pic'] ,
            dataType : 'json',
            type:'post',
            success : function(data) {

                $("#pic").val("");
                $("#viewmodal").modal("hide");
                showAlert("上传成功");
                $("#progress").css("width","0%").html("0%");

                showAllPic();

            },
            error : function() {
                showAlert('网络超时',1);
            }
        });

        setTimeout('showProgress()',100);
    }

}




function showAllPic(){
    $.ajax({
        url:'pictures',
        dataType:'json',
        type:'get',
        success:function(data){

            var info = data['result'];

            $(".pic-view").html("");

            for(var i in info){

                var str = "<div  class='col-sm-4 ' onmouseenter='showDes(this)' onmouseleave='hideDes(this)'>" +
                    "<input type='checkbox' value='"+info[i].id+"'  name='selectpic'/>" +
                    "<div  class='pic-info'><p>"+info[i].name+"</p></div>" +
                    "<img width='100%'  height='33%'  src='"+info[i].path+"'>" +
                    "</div>";
                $(".pic-view").append(str);

            }

        },
        error:function(){

            showAlert('网络超时',1);

        }
    })
}

function showDes(data){
    //
    var tongbao = $(data).children('img');
    $(data).children('.pic-info').animate({"width":tongbao.width(),"height":tongbao.height()*0.3});
}
function hideDes(data){
    $(data).children('.pic-info').animate({"height":0});

}

function showProgress(){
    $.ajax({
        url:'progress',
        type:'get',
        dataType:'json',
        success:function(data){
            if(data.percent*100==100){
                $("#progress").css("width",data.percent*100+"%").html("上传成功");
            }else{
                $("#progress").css("width",data.percent*100+"%").html(parseInt(data.percent*100)+"%");
                setTimeout("showProgress()",100);
            }

        }
    });
}

function clearProgress(){
    $("#progress").css("width","0%").html("0%");
}


function checkAll(){
    var x = $(".pic-view input:checkbox");

    for(var i in x){
        if(x[i].checked==true){
            for(var j in x){
                x[j].checked=false;
            }
            return true;
        }
    }
    for(var j in x){
        x[j].checked=true;
    }
}

function delCheck(){

    var data = getCheck();

    var str = "";
    for(var i in data){
        str += "chk=" +data[i];
        if(parseInt(i)+1 != data.length){
            str += "&";
        }
    }

    if(str == ""){
        showAlert("未选择图片");
        return false;
    }

    $.ajax({
        url:'picture/delete',
        data:str,
        dataType:'json',
        type:'post',
        success:function(data){
            showAlert("删除成功");
            showAllPic();
        },
        error:function(){
            showAlert('网络超时',1);
        }

    })
}
function getCheck(){
    var x = $(".pic-view input[name='selectpic']:checked");

    var chk_val = [];
    x.each(function () {
        chk_val.push($(this).val());
    });

    return chk_val;
}

function showAlert(data){
    var arg = arguments;

    $("#alert-info").removeClass("alert-info").removeClass('alert-danger');

    if(arg&&arg.length==2){
        $("#alert-info").addClass('alert-danger');
    }else{
        $("#alert-info").addClass("alert-success");
    }
    $("#alert-info p").html(data)
    $("#alert-info").fadeIn();
    setTimeout('hideAlert()',1000);
}
function hideAlert(){
    $("#alert-info").fadeOut();
}