<%--
  Created by IntelliJ IDEA.
  User: xueaohui
  Date: 2016/1/16
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>表格演示</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dataTables.bootstrap.min.css">

  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.dataTables.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/dataTables.bootstrap.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/table/colResizable-1.5.min.js" ></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/table.js" ></script>
</head>
<body >
<jsp:include page="template/head.jsp"/>
<div class="container-fluid">
  <div class="row">
      <jsp:include page="template/sidebar.jsp"/>

    <div class="content col-sm-10 " >

      <div class="container-fluid">
        <div class="row">
          <div class="col-sm-12 ">
            <h2>管理表格</h2>
          </div>
          <!-- search star -->
          <div class="form-horizontal clearfix">
            <div class="col-lg-4 col-sm-3 pl0">
              <div class="form-group">
                <div class="col-lg-8 col-sm-7">
                  <select class="input-sm form-control input-s-sm inline">
                    <option value="0">请选择</option>
                    <option value="1">冻结</option>
                    <option value="2">开放</option>
                    <option value="3">审核</option>
                  </select>
                </div>
              </div>
            </div>
            <div class="col-lg-4 col-sm-5">
              <div class="form-group">
                <label class="col-lg-3  col-sm-3 control-label">日期：</label>
                <div class="col-lg-8 col-sm-8 input-group date">
                  <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                  <input type="email" placeholder="2014-11-17" class="input-sm form-control">
                  <span class="input-group-addon">到</span>
                  <input type="text" class="input-sm form-control" name="end" value="" placeholder="2014-11-17">
                </div>
              </div>
            </div>
            <div class="col-lg-4 col-sm-4">
              <div class="form-group">
                <div class="col-lg-12 col-sm-12 input-group">
                  <input type="email" placeholder="请输入关键字" class="input-sm form-control">
		                                 <span class="input-group-btn">
                                        <button type="button" class="btn btn-sm btn-primary"> 搜索</button> </span>
                </div>
              </div>
            </div>
          </div>
          <!-- search end -->
          <div class="col-sm-12 " >
            <table id="userTable" class="table table-bordered table-hover table-striped table-responsive table-cell " >
              <thead >
              <tr >
                <th>
                  <input class="cursor-pointer" type="checkbox"/>
                </th>
                <th>序号</th>
                <th>账号</th>
                <th>密码</th>
                <th>登陆状态</th>
                <th>头像</th>
                <th>操作</th>
              </tr>
              </thead>
              <tbody>
              </tbody>


            </table>

          </div>

        </div>
      </div>


    </div>
  </div>
</div>

<div class="modal fade " id="infomodal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog ">
    <div class="modal-content ">
      <div class="modal-header modal-header-reverse">
        <a class="close"
                data-dismiss="modal" aria-hidden="true">
          &times;
        </a>
        <h4 class="modal-title">
          管理员详情
        </h4>
      </div>
      <div class="modal-body">

        <table class="table table-bordered ">
          <tr>
            <td>编号</td>
            <td><p></p></td>
          </tr>
          <tr>
            <td>账号</td>
            <td><p></p></td>
          </tr>
          <tr>
            <td>密码</td>
            <td><p></p></td>
          </tr>
          <tr>
            <td>登陆状态</td>
            <td><p></p></td>
          </tr>
          <tr>
            <td>头像</td>
            <td><p></p></td>
          </tr>
        </table>
      </div>
    </div><!-- /.modal-content -->
  </div>
</div>

</body>


</html>
