/**
 * Created by xueaohui on 2016/1/22.
 */


$(function(){
    //initSidebar();
    initInput();

})



function initInput(){

    $("#form_datepicker").datetimepicker({
        format: "yyyy-mm-dd hh:00:00",
        autoclose: true,
        minView: "day",
        maxView: "decade",
        todayBtn: true,
        pickerPosition: "bottom-left"
    }).on("click", function (ev) {
        //alert("点击了")
    });

    $("#timestart").datetimepicker({
        format: "yyyy-mm-dd hh:00:00",
        autoclose: true,
        minView: "day",
        maxView: "decade",
        pickerPosition: "bottom-left"
    }).on("click", function (ev) {
        $("#timestart").datetimepicker("setEndDate", $("#timeend").val());

        if($("#timestart").val()){
        }
    });

    $("#timeend").datetimepicker({
        format: "yyyy-mm-dd hh:00:00",
        autoclose: true,
        minView: "day",
        maxView: "decade",
        pickerPosition: "bottom-left"
    }).on("click",function(ev){
        $("#timeend").datetimepicker("setStartDate", $("#timestart").val());

        // alert($("#timeend").val());
        if($("#timeend").val()){
        }

    });

    $("[data-toggle='tooltip']").tooltip();

}

function testupload(){


    $("#uploadbtn").attr("disabled","disabled").val("正在上传");
    $("#uploadform [type='file']").attr("disabled","disabled");

    $.ajaxFileUpload({
        url : '/sss/upload.do',
        secureuri : false,
        fileElementId :['file1','file2','file3'] ,
        dataType : 'json',
        success : function(data) {
            if(data=='failure'){
                alert("上传文件失败,请检查网络连接");
            }
        }
    });
    showProgress();


}

function showProgress(){

    $.ajax({
        url:'/sss/getuploadinfo',
        type:'get',
        dataType:'json',
        success:function(data){
            if(data.percent==100){
                $("#progress").css("width",data.percent+"%").html("上传成功");
                $("#uploadbtn").removeAttr("disabled").val("上传");
                $("#uploadform [type='file']").removeAttr("disabled").val();
            }else{
                $("#progress").css("width",data.percent+"%").html(data.percent+"%");
                setTimeout("showProgress()",1000);
            }

        }
    });

}

function clearProgress(){
    $("#progress").css("width","0%").html("0%");

}




