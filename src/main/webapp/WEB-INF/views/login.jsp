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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
</head>
<body>
<nav class="navbar  navbar-inverse" role="navigation">
    <div class="navbar-header">
        <a class="navbar-brand" href="login.jsp"> <span style="color: white">后台管理系统</span></a>
    </div>
    <div>
        <ul class="nav navbar-nav">
            <%--导航栏--%>
        </ul>
    </div>
</nav>
<div class="col-md-12">
    <div class="col-md-4 col-md-offset-4">
        <h2 align="center">管理员登录</h2>
        <hr/>
        <form id="loginForm"  method="post" action="adminLogin" >
            <div class="form-group ">
                <div class="col-md-12">
                    <input required id="username" class="form-control"  type="text" name="name" placeholder="请输入用户名" required="required" >
                </div>
            </div>
            <div class="form-group ">
                <div class="col-md-12">
                    &nbsp
                </div>
            </div>
            <div class="form-group ">
                <div class="col-md-12">
                    <input required id="password" class="form-control" type="password" name="password" placeholder="请输入密码" required="required"  >
                </div>
            </div>
            <div class="form-group ">
                <div class="col-md-12">
                    &nbsp
                </div>
            </div>
            <div class="form-group ">
                <div class="col-md-12">
                    <input class="btn btn-primary btn-block " type="submit"  value="登 录"  >
                </div>
            </div>

        </form>
    </div>
</div>
<script type="text/javascript">
    function login(form) {
        if(form.name.value==""){
            alert("用户名不能为空");
            return false;
        }
        if(form.password.value==""){
            alert("密码不能为空");
            return false;
        }
    }
</script>
</body>
</html>
