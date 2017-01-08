<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/assets/css/head.css" rel="stylesheet">

<div class="container-fluid">
    <div class="row top-bar">
        <div class="col-sm-12">
            <div class="pull-right ">
                <a href='/index.html'><i class="glyphicon glyphicon-inbox"></i>首页</a>&nbsp;&nbsp;|&nbsp;&nbsp;
                您好！  <c:if test="${sessionScope.loginUser == null}">
                    <a href="/userLogin.html">请登录</a>
                </c:if>
                <c:if test="${sessionScope.loginUser != null}">
                    <a href="/order">${sessionScope.loginUser.name}</a>
                </c:if>
                ${sessionScope.loginUser == null?'<a href="register.html">注册</a>':'<a onclick = "logout()" class="text-danger" href="#">退出</a>'}
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    function logout() {
        if(confirm("确认要退出系统吗?")){
            window.location.href = "/user/logout";
        }
    }
</script>