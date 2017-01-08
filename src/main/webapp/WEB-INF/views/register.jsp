<%--
  Created by IntelliJ IDEA.
  User: minglin
  Date: 2016/12/5
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册新用户</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
</head>
<body>
<div class="col-md-12">


    <br/>
    <br/>

    <div class="col-sm-6 col-sm-offset-3">
        <h2 align="center">欢迎注册体检预约系统</h2>
        <hr/>
    </div>
    <div class="col-sm-offset-2 col-sm-10">
        <form role="form" class="form-horizontal" id="registerForm">

            <div class="form-group">
                <label class="col-sm-2  control-label">用户名</label>
                <div class=" col-sm-6">
                    <input id="username" type="text" name="name" placeholder="请输入用户名" class="form-control"
                           onblur="checkLength4()">

                </div>
                <p id="Message4"><span style="color: red"></span></p>

            </div>


            <div class="form-group ">
                <div class="col-sm-2  col-sm-8">
                    <p style="color: #ee0000" id="message"></p>
                </div>
            </div>
            <div class="form-group ">
                <label class="col-sm-2 control-label">密码</label>
                <div class=" col-sm-6">
                    <input id="newPass" type="password" name="password" placeholder="请输入新密码" class="form-control"
                           onblur="checkLength1()">
                </div>
                <p id="Message1"></p>

            </div>

            <div class="form-group">
                <label class=" col-sm-2 control-label">确认密码</label>
                <div class=" col-sm-6">
                    <input id="rePass" type="password" name="repass" placeholder="请确认密码" class="form-control"
                           onblur="checkLength2()">
                </div>
                <p id="Message2"></p>
            </div>
            <div class="form-group ">
                <label class="col-sm-2  control-label">手机号</label>
                <div class=" col-sm-6">
                    <input id="nickName" type="text" name="phone" placeholder="请输入手机号" class="form-control"
                           onblur="checkLength0()">

                </div>
                <p id="Message0"><span style="color: red"></span></p>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-6 ">
                    <a class="pull-right" href="login.html">已有账号，直接登录</a>
                </div>

            </div>

            <input class="col-sm-offset-2 col-sm-6 btn btn-success" type="button" onclick="register()" value="注册"/>

        </form>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/view/register.js"></script>

</body>
</html>
