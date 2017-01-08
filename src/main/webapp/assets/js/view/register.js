/**
 * Created by Administrator on 2016/3/4.
 */
function checkLength0(){
    var data = $("#nickName").val();
    var telReg = !!data.match(/^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/)
    if(!data){
        $("#Message0").css("color","#ee0000").html("手机号不能为空");
        return false;
    }
    if(!telReg){
        $("#Message0").css("color","#ee0000").html("手机号格式不正确");
        return false;
    }
    $("#Message0").css("color","#00ee00").html("√");
    return true;
}

function checkLength1(){
    var passRegex = /^.{6,16}$/;
    var data = $("#newPass").val();
    if(!data){
        $("#Message1").css("color","#ee0000").html("密码不能为空");
        return false;
    }
    if(!passRegex.test(data)){
        $("#Message1").css("color","#ee0000").html("密码长度应为6-16位");
        return false;
    }
    $("#Message1").css("color","#00ee00").html("√");
    return true;
}
function checkLength2(){
    var data = $("#rePass").val();
    var data2 = $("#newPass").val();
    if(!data){
        $("#Message2").css("color","#ee0000").html("确认密码不能为空");
        return false;
    }
    if(data!=data2){
        $("#Message2").css("color","#ee0000").html("两次密码不一致");
        return false;
    }
    $("#Message2").css("color","#00ee00").html("√");
    return true;
}

function checkLength4(){
    var data = $("#username").val();
    if(!data){
        $("#Message4").css("color","#ee0000").html("用户名不能为空");
        return false;
    }

    $("#Message4").css("color","#00ee00").html("√");
    return true;
}

function register() {
    if(checkLength4() && checkLength1() && checkLength2() && checkLength0()){
        $.ajax({
            url:'user/register',
            type:'post',
            data:$("#registerForm").serialize(),
            dataType:'json',
            success:function (data) {
                if(data.resultCode == '1101'){
                    alert("注册成功");
                    window.location.href = "userLogin.html";
                }else if(data.resultCode == '1102'){
                    $("#Message4").css("color","#ee0000").html("注册失败");
                }else{
                    $("#Message4").css("color","#ee0000").html("用户名已存在");
                }

            },
            error:function (data) {

            }
        })
    }
}