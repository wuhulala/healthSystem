<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/1/6
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">

</head>
<body>
<jsp:include page="head.jsp"/>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="sidebar.jsp"/>
        <div class="content">
            <div class="row ">
                <div class="col-sm-12 ">
                    <h2>订单</h2>
                </div>
                <!-- search star -->
                <div class="form-horizontal clearfix">
                    <div class="col-lg-4 col-sm-3 pl0">

                    </div>
                    <div class="col-lg-4 col-sm-5">

                    </div>
                    <div class="col-lg-4 col-sm-4">
                        <div class="form-group">
                            <div class="col-lg-11 col-sm-11 input-group">
                                <input type="text" id="keyword" placeholder="套餐名称/联系人/联系方式"
                                       class="input-sm form-control" >
                                <span class="input-group-btn">
                                        <button type="button" class="btn btn-sm btn-primary"
                                                 onclick="search()"> 搜索</button> </span>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- search end -->
                <div class="col-sm-12 ">
                    <table id="userTable" class="table table-bordered table-hover table-striped table-responsive  ">
                        <thead>
                        <tr>
                            <th>订单号</th>
                            <th>套餐名称</th>
                            <th>联系人</th>
                            <th>联系方式</th>
                            <th>预约时间</th>
                            <th>价格（元）</th>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/sidebar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/table/colResizable-1.5.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/admin/order.js"></script>

<script type="text/javascript">

    var table;
    $(function () {
        //初始化导航栏
        // initSidebar();
        search();
    });
    function createTable() {
        // DataTable
        table = $('#userTable').DataTable({
            dom: 'rt<"table-footer"<"col-sm-3"i><"col-sm-2"l><"col-sm-6"p>>',
            serverSide: true,//设置服务端模式,搜索需要根据传参实现
            ajax: {
                url: "/order/list",
                dataType: 'json',
                data: {
                    keyword: $("#keyword").val()
                }
            },
            searching: false,
            language: {
                "processing": "玩命加载中...",
                "lengthMenu": "显示 _MENU_ 项结果",
                "zeroRecords": "没有匹配结果",
                "info": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "infoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "infoFiltered": "(由 _MAX_ 项结果过滤)",
                "infoPostFix": "",
                "url": "",
                "paginate": {
                    "first": "首页",
                    "previous": "上一页",
                    "next": "下一页",
                    "last": "末页"
                }
            },
            ordering: false,
            createdRow: function (row) {
                $(row).click(function () {
                })
            },
            columns: [
                {"data": "serialNumber"},
                {"data": "comboName"},
                {"data": "nickName"},
                {"data": "phone"},
                {"data": "examTime"},
                {"data": "price"},
                {"data": null}
            ],
            columnDefs: [
                {
                    targets: 6,
                    render: function (a) {
                        var html = "";
                        html += "<a target='_blank' class='btn btn-primary btn-xs' href='/order/"+a.id+"/detail'>查看详情</a>&nbsp";
                        return html;
                    }
                }

            ],
            lengthMenu: [[10, 20, 50, -1], ["10", "20", "50", "全部"]],//自定义单页显示
            initComplete: function () {
            }
        });
    }


    function search() {
        if (table != null) {
            table.destroy();
        }
        createTable();
    }


</script>
</body>
</html>
