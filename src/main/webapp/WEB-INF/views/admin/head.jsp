<%--
  Created by IntelliJ IDEA.
  User: xueaohui
  Date: 2016/1/13
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="navbar navbar-inverse " role="navigation" style="background-color: #1cc09f">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse"
                data-target="#navbar"><span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
                class="icon-bar"></span> <span class="icon-bar"></span></button>
        <a class="navbar-brand">
            <span style="color: white">体检预约中心后台管理系统</span>
        </a>
    </div>
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbar">
            <ul class="nav navbar-nav ">
            </ul>
            <ul class="nav navbar-nav navbar-right ">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">${sessionScope.loginAdmin.name}<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#" onclick="logout()"><i class="fa fa-mail-reply"></i>&nbsp;&nbsp;退出</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>

    <div id="tip">

    </div>
</div>

<div id="alert-info" hidden class="alert alert-success alert-right">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <p></p>
</div>
<script type="text/javascript">
    function logout() {
        if(confirm("确认要退出系统吗?")){
            window.location.href = "/user/logout";
        }
    }
</script>