<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/1/5
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>预约</title>
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
                <input id="formToken" name="formToken" value="${formToken}" hidden/>
                <div class="form-group row">
                    <label class="col-sm-2  control-label"><font color="red">*</font>用户名</label>
                    <div class=" col-sm-4">
                        <input id="username" value="${sessionScope.loginUser.name}" type="text" name="nickName"
                               placeholder="请输入用户名" class="form-control"
                               onblur="checkLength4()">

                    </div>
                    <div class=" col-sm-4 ">
                        <p id="Message4"><span style="color: red"></span></p>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2  control-label"><font color="red">*</font>手机号</label>
                    <div class=" col-sm-4">
                        <input id="nickName" value="${sessionScope.loginUser.phone}" type="text" name="phone"
                               placeholder="请输入手机号" class="form-control"
                               onblur="checkLength0()">
                    </div>
                    <div class=" col-sm-4">
                        <p id="Message0"><span style="color: red"></span></p>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2  control-label"><font color="red">*</font>性别</label>
                    <div class=" col-sm-6">
                        <label class="radio-inline">
                            <input type="radio" value="男" name="sex" checked="checked">
                            男
                        </label>
                        <label class="radio-inline">
                            <input type="radio" value="女" name="sex">
                            女
                        </label>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2  control-label"><font color="red">*</font>预约时间</label>
                    <div class=" col-sm-4">
                        <input type="date" id="orderDate" class="form-control" name="examTime" value="2017-01-12">
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
                    <div class="col-sm-offset-8 col-sm-4">
                        <select id="organizationSelect" onchange="changeOrganization()" class="form-control">
                            <option>请选择机构</option>
                            <option>1</option>
                            <option>2</option>
                        </select>
                    </div>
                    <div class="col-sm-12" id="organizationDiv">

                    </div>
                </div>
            </div>
        </div>

        <div class="row appointment-item">
            <div class="col-sm-12">
                <h3>套餐信息</h3>
                <div class="col-sm-12">
                    <div class="col-sm-offset-8 col-sm-4">
                        <select id="comboSelect" onchange="changeCombo()" class="form-control">
                            <option>请选择套餐</option>
                            <option>1</option>
                            <option>2</option>
                        </select>
                    </div>
                    <div class="col-sm-12" id="comboDiv">

                    </div>
                </div>
            </div>
        </div>
        <div class="row appointment-item">
            <div class="col-sm-8">
                <h3>可加项选择</h3>
                <div class="col-sm-12" id="extraDiv">

                </div>

            </div>
        </div>
    <div class="pull-right">
        <span>实付金额</span>
        <span class="appointment-money">0元</span>
        <button class="btn btn-info btn-lg" id="submitButton" onclick="submitOrder()">提交订单</button>
    </div>
    <hr/>
</div>
<div class="modal fade " id="info-modal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog ">
        <div class="modal-content ">
            <div class="modal-header modal-header-reverse">
                <a class="close"
                   data-dismiss="modal" aria-hidden="true">
                    &times;
                </a>
                <h4 class="modal-title">
                    套餐详情
                </h4>
            </div>
            <div class="modal-body">

                <table class="table table-bordered ">
                    <tr>
                        <td>名称</td>
                        <td><p></p></td>
                    </tr>
                    <tr>
                        <td>价格(元)</td>
                        <td><p></p></td>
                    </tr>
                    <tr>
                        <td>详细信息</td>
                        <td></td>
                    </tr>
                </table>
            </div>
        </div><!-- /.modal-content -->
    </div>
</div>

<jsp:include page="template/footer.jsp"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/view/appointment.js"></script>
</body>
</html>
