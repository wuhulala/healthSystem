<%--
  Created by IntelliJ IDEA.
  User: xueaohui
  Date: 2016/1/16
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="${pageContext.request.contextPath}/css/slider.css" rel="stylesheet">
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/root.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/sidebar.js"></script>

</head>
<body >
<div class="content col-sm-2" style="background-color: #1d2939;width:200px;height: 100%" >

<ul id="main-nav" class="nav nav-tab nav-stacked" >
  <h3 style="color: white">控制台</h3>
  <li >
    <a href="#systemSetting" class="nav-header collapsed first-menu" data-toggle="collapse">
      系统管理演示
      <span><i  class="pull-right icon-plus"></i></span>
    </a>
    <ul id="systemSetting" class=" nav nav-list collapse secondmenu" >
      <li><a href="user.html" id="user">用户管理</a></li>
      <li><a href="picture.html" id="picture">图片管理</a></li>

    </ul>
  </li>
  <li>
    <a href="#zujian"  class="nav-header collapsed first-menu" data-toggle="collapse">
      ui组件演示
      <span><i  class="pull-right icon-minus"></i></span>
    </a>
    <ul id="zujian" class="nav nav-list collapse secondmenu" aria-expanded="true" >
      <li><a href="table.html" id="table"  >表格</a></li>
      <li><a href="layout.html" id="layout">布局</a></li>
      <li><a href="form.html" id="form">表单</a></li>
      <li><a href="button.html" id="button">按钮</a></li>
      <li><a href="chart.html" id="chart"></i>报表</a></li>
      <li><a href="404.html" id="404"></i>404页面</a></li>
      <li><a href="500.html" id="500"></i>500页面</a></li>
    </ul>
  </li>
  <li>
    <a href="#">
      看着不错
      <span class="label label-warning pull-right">5</span>
    </a>
  </li>
  <li>
    <a href="#">
      真的
    </a>
  </li>
  <li>
    <a href="#">
      还能有假
    </a>
  </li>
</ul>
</div>
</body>
</html>
