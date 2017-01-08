<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/font-awesome.css">

<link href="${pageContext.request.contextPath}/assets/css/sidebar.css" rel="stylesheet">
<div id="sidebar">
    <ul id="main-nav" class="nav nav-tabs nav-stacked">

        <li id="order">
            <a href="order.htm"><i class="fa fa-edit"></i>&nbsp;&nbsp;订单</a>
        </li>
        <li id="project">
            <a href="project.htm"><i class="fa fa-server"></i>&nbsp;&nbsp;体检项目</a>
        </li>
        <li id="combo">
            <a href="combo.htm"><i class="fa fa-list-ul"></i>&nbsp;&nbsp;体检套餐</a>
        </li>
        <li id="organization">
            <a href="organization.htm"><i class="fa fa-th"></i>&nbsp;&nbsp;体检机构</a>
        </li>

        <li style="position: fixed;bottom: 0;width: 220px">
            <a href="#" onclick="logout()"><i class="fa fa-mail-reply"></i>&nbsp;&nbsp;退出</a>
        </li>
    </ul>

</div>
