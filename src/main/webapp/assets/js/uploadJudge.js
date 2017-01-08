/**
 * Created by xueaohui on 2016/1/12.
 */

function lotterImgJudge(obj){

    if(!pngJudge(obj)||!sizeJudge(obj)){
        $("#"+obj.id).val("");
        return false;
    };

   var objUrl = getObjectURL(obj.files[0]) ;
    $("#"+obj.id).next().remove();
    $("#"+obj.id).after("<span id='preview'"+obj.id+"><img onmouseover='showlottoryImg(this)' onmouseout='showsmalllottoryImg(this)' src='"+objUrl+"' width='50' height='50'></span>");

}

function show11largeImg(obj){

    obj.style.width = 500;
    obj.style.height = 500;

}

function show11normalImg(obj){

    obj.style.width = 50;
    obj.style.height = 50;
}

function show53largeImg(obj){

    obj.style.width = 500;
    obj.style.height = 300;

}

function show53normalImg(obj){

    obj.style.width = 50;
    obj.style.height = 30;
}

function showlottoryImg(obj){

    obj.style.width = 540;
    obj.style.height = 190;

}

function showsmalllottoryImg(obj){

    obj.style.width = 108;
    obj.style.height = 54;

}
function productImgJudge(obj){


    if(!jpg_pngJudge(obj)||!sizeJudge(obj)){
        $("#"+obj.id).val("");
        return false;
    };
    var objUrl = getObjectURL(obj.files[0]) ;
    $("#"+obj.id).next().remove();
    $("#"+obj.id).after("<span id='preview'"+obj.id+"><img  onmouseover='show11largeImg(this)' onmouseout='show11normalImg(this)' src='"+objUrl+"' width='50' height='50'></span>");

}

function ActiveImgJudge(obj){


    if(!jpg_pngJudge(obj)||!sizeJudge(obj)){
        $("#"+obj.id).val("");
        return false;
    };
    var objUrl = getObjectURL(obj.files[0]) ;
    $("#"+obj.id).next().remove();
    $("#"+obj.id).after("<span id='preview'"+obj.id+"><img onmouseover='show53largeImg(this)' onmouseout='show53normalImg(this)' src='"+objUrl+"' width='50' height='30' ></span>");

}
function previewPic(obj){


    if(!jpg_pngJudge(obj)||!sizeJudge(obj)){
        $("#"+obj.id).val("");
        return false;
    };
    var objUrl = getObjectURL(obj.files[0]) ;

    $("#preview").attr("src",objUrl);
    clearProgress();
}
function pngJudge(obj){

    var photoExt=obj.value.substr(obj.value.lastIndexOf(".")).toLowerCase();//获得文件后缀名
    if(photoExt!='.png'&&photoExt!='.PNG'){
        alert("请上传后缀名为png的照片!");
        return false;
    }
    return true;

}

function jpg_pngJudge(obj){
    var photoExt=obj.value.substr(obj.value.lastIndexOf(".")).toLowerCase();//获得文件后缀名

    if(photoExt!='.png'&&photoExt!='.jpg'){
        alert("请上传后缀名为jpg或png的照片!");
        return false;
    }
    return true;

}

function sizeJudge(obj){
    var fileSize = 0;
    var isIE = /msie/i.test(navigator.userAgent) && !window.opera;
    if (isIE && !obj.files) {
        var filePath = obj.value;
        var fileSystem = new ActiveXObject("Scripting.FileSystemObject");
        var file = fileSystem.GetFile (filePath);
        fileSize = file.Size;
    }else {
        fileSize = obj.files[0].size;
    }
    fileSize=Math.round(fileSize/1024*100)/100; //单位为KB
    if(fileSize>500){
        alert("图片最大尺寸为500KB，请重新上传!");
        return false;
    }
    return true;
}

//建立一個可存取到该file的url
function getObjectURL(file) {
    var url = null ;
    if (window.createObjectURL!=undefined) { // basic
        url = window.createObjectURL(file) ;
    } else if (window.URL!=undefined) { // mozilla(firefox)
        url = window.URL.createObjectURL(file) ;
    } else if (window.webkitURL!=undefined) { // webkit or chrome
        url = window.webkitURL.createObjectURL(file) ;
    }
    return url ;
}





