<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/1/5
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>订单中心</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
    <link href="${pageContext.request.contextPath}/assets/css/font-awesome.css" rel="stylesheet">

</head>
<body>
<jsp:include page="template/head.jsp"/>
<div class="container">
    <div class="col-sm-12">
        <c:forEach var="item" items="${orders}">
        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-sm-4 text-center">
                        订单编号： ${item.serialNumber}
                    </div>
                    <div class="col-sm-4 text-center">
                        金额：<span style="font-size:large;color: darkred;"> ${item.price}</span>元
                    </div>
                    <div class="col-sm-4 text-center">
                        联系人： ${item.nickName}
                    </div>
                </div>
            </div>
            <div class="panel-body">
                <div class="col-sm-12">
                    <div class="col-sm-6">

                        <img src="assets/images/o1.png" width="100px" height="100px" style="float: left;"/>
                        <div style="position:relative;top:-5px;left: 20px">
                            <h3> ${item.comboName}</h3>
                            <h4>
                                    ${item.orgName}
                            </h4>
                            <h5>
                                <fmt:formatDate type="date" value="${item.examTime}" />
                            </h5>
                        </div>

                    </div>
                    <div class="col-sm-3">
                        <p>等待付款</p>
                        <a target="_blank" href="order/${item.id}/detail" class="">订单详情</a>
                    </div>
                    <div class="col-sm-3">
                        <button class="btn btn-info">去付款</button>
                    </div>
                </div>
            </div>
        </div>
        </c:forEach>

    </div>
</div>
<jsp:include page="template/footer.jsp"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
</body>
</html>
