<%--
  Created by IntelliJ IDEA.
  User: minglin
  Date: 2016/12/5
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
</head>
<body>
<div class="col-md-12">
    <div class="col-md-4 col-md-offset-4" style="padding:20px;background-color: rgba(222, 222, 222, 0.71)">
        <h2 align="center">欢迎登录体检预约系统</h2>
        <hr/>
        <form id="loginForm"  class="form-horizontal" >
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <input id="username" type="text" name="name" placeholder="请输入用户名" class="form-control"
                           onblur="checkLength4()">
                </div>

                <p id="Message4"><span style="color: red"></span></p>
            </div>
            <div class="form-group ">
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                    <input id="newPass" type="password" name="password" placeholder="请输入密码" class="form-control"
                           onblur="checkLength1()">
                </div>
                <p id="Message1"></p>

            </div>
            <div class="form-group ">
                <div class="col-md-12">
                    <div class="pull-right">
                        <a href="register.html">还没有账号?请先注册</a>
                    </div>
                </div>
            </div>
            <div class="form-group ">
                <div class="col-sm-offset-2 col-sm-6">
                    <input class="btn btn-primary btn-block " type="button" onclick="login()"  value="登 录"  >
                </div>
            </div>

        </form>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
<script type="text/javascript">

    function checkLength1(){
        var data = $("#newPass").val();
        if(!data){
            $("#Message1").css("color","#ee0000").html("密码不能为空");
            return false;
        }
        $("#Message1").css("color","#00ee00").html("√");
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

    function login() {
        if(checkLength4() && checkLength1()){
            $.ajax({
                url:'user/login',
                type:'post',
                data:$("#loginForm").serialize(),
                dataType:'json',
                success:function (data) {
                    if(data.resultCode == '0'){
                        window.location.href = "index.html";
                    }else if(data.resultCode == '1002'){
                        $("#Message4").css("color","#ee0000").html("用户名或密码错误");
                    }

                },
                error:function (data) {

                }
            })
        }
    }
</script>
</body>
</html>
