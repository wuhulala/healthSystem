<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/1/5
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>订单详情</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
    <link href="${pageContext.request.contextPath}/assets/css/font-awesome.css" rel="stylesheet">

</head>
<body>
<jsp:include page="template/head.jsp"/>
<div class="container">
    <form id="infoForm">
        <input value="${sessionScope.loginUser.id}" type="text" name="userId" hidden/>

        <div class="row appointment-item">
            <div class="col-sm-12">
                <h3>订单人信息</h3>
                <div class="form-group row">
                    <label class="col-sm-2  control-label"><font color="red">*</font>用户名</label>
                    <div class=" col-sm-4">
                        ${order.nickName}

                    </div>

                </div>
                <div class="form-group row">
                    <label class="col-sm-2  control-label"><font color="red">*</font>手机号</label>
                    <div class=" col-sm-4">
                        ${order.phone}

                    </div>

                </div>
                <div class="form-group row">
                    <label class="col-sm-2  control-label"><font color="red">*</font>性别</label>
                    <div class=" col-sm-6">
                        ${order.sex}

                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2  control-label"><font color="red">*</font>预约时间</label>
                    <div class=" col-sm-4">
                        <fmt:formatDate value="${order.examTime}" pattern="yyyy-MM-dd"/>
                    </div>
                </div>
            </div>
        </div>
    </form>

    <div class="row appointment-item">
        <div class="col-sm-12">

            <h3>
                机构信息
            </h3>
            <div class="col-sm-12">
                ${order.orgName}
            </div>
        </div>
    </div>

    <div class="row appointment-item">
        <div class="col-sm-12">
            <h3>套餐信息</h3>
            <div class="col-sm-12">
                ${order.comboName}
            </div>
        </div>
    </div>
    <div class="row appointment-item">
        <div class="col-sm-8">
            <h3>订单详细项目</h3>
            <div class="col-sm-12" id="extraDiv">
                <div class="col-sm-12" id="comboDiv">
                    <table class="table table-bordered">
                        <tr>
                            <th>名称</th>
                            <th>内容</th>
                        </tr>
                        <c:forEach items="${projects}" var="project">
                            <tr>
                                <td>${project.name}</td>
                                <td>${project.comments}</td>
                            </tr>
                        </c:forEach>

                    </table>
                </div>
            </div>

        </div>
    </div>
    <div class="row appointment-item">
        <div class="col-sm-12">
            <h3>实付金额</h3>
            <div class="pull-left">
                <span class="appointment-money">${order.price}元</span>
            </div>

        </div>
    </div>

    <hr/>
</div>

<jsp:include page="template/footer.jsp"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
</body>
</html>
