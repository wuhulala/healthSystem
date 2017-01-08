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
    <title>体检套餐</title>
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
                    <h2>体检套餐</h2>
                </div>
                <!-- search star -->
                <div class="form-horizontal clearfix">
                    <div class="col-lg-4 col-sm-3 pl0">
                        <button class="btn btn-success" data-toggle="modal" data-target="#add-modal"><i
                                class="glyphicon glyphicon-plus"></i>&nbsp;添加套餐
                        </button>
                    </div>
                    <div class="col-lg-4 col-sm-5">

                    </div>
                    <div class="col-lg-4 col-sm-4">
                        <div class="form-group">
                            <div class="col-lg-11 col-sm-11 input-group">
                                <input type="text" id="keyword" placeholder="名称"
                                       class="input-sm form-control">
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
                            <th>序号</th>
                            <th>名称</th>
                            <th>价格(元)</th>
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
<div class="modal fade " id="edit-modal" tabindex="-1" role="dialog"
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
                <form class="form-horizontal" role="form" id="edit-form">
                    <input type="text" name="id" id="edit-id" hidden/>

                    <div class="form-group">
                        <label for="edit-name" class="col-sm-2 control-label">名称</label>
                        <div class="col-sm-10">
                            <input type="text" name="name" class="form-control" id="edit-name" placeholder="请输入名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-price" class="col-sm-2 control-label">价格</label>
                        <div class="col-sm-10">
                            <input type="number" name="price" id="edit-price" class="form-control" placeholder="请输入价格">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">详细</label>
                        <div class="col-sm-10 project-div">

                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="button" class="btn btn-default" onclick="saveInfo()">保存</button>
                        </div>
                    </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div>
</div>
<div class="modal fade " id="add-modal" tabindex="-1" role="dialog"
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
                <form class="form-horizontal" id="add-form">

                    <div class="form-group">
                        <label for="edit-name" class="col-sm-2 control-label">名称</label>
                        <div class="col-sm-10">
                            <input type="text" name="name" class="form-control" id="add-name" placeholder="请输入名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-price" class="col-sm-2 control-label">价格</label>
                        <div class="col-sm-10">
                            <input type="number" name="price" id="add-price" class="form-control" placeholder="请输入价格">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">详细</label>
                        <div class="col-sm-10 project-div">

                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="button" class="btn btn-default" onclick="addInfo()">保存</button>
                        </div>
                    </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/sidebar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/assets/js/table/colResizable-1.5.min.js"></script>
<script type="text/javascript">

    var table;
    $(function () {
        //初始化导航栏
        initProjectDiv();
        search();
    });
    function createTable() {
        // DataTable
        console.log("asd---asdasd");

        table = $('#userTable').DataTable({
            dom: 'rt<"table-footer"<"col-sm-3"i><"col-sm-2"l><"col-sm-6"p>>',
            serverSide: true,//设置服务端模式,搜索需要根据传参实现
            ajax: {
                url: "/combo",
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
                {"data": null},
                {"data": "name"},
                {"data": "price"},
                {"data": null}
            ],
            columnDefs: [
                {
                    targets: 3,
                    render: function (item) {
                        var html = "";
                        html += "<a class='btn btn-primary btn-xs' onclick='showInfo(" + JSON.stringify(item) + ")' href='#'><i class='glyphicon glyphicon-tasks'></i>&nbsp;查看详情</a>&nbsp";
                        html += "<a class='btn btn-warning btn-xs' onclick='editInfo(" + JSON.stringify(item) + ")' href='#'><i class='glyphicon glyphicon-edit'></i>&nbsp;编辑</a>&nbsp";
                        html += "<a class='btn btn-danger btn-xs' onclick='deleteInfo(" + JSON.stringify(item) + ")' href='#'><i class='glyphicon glyphicon-trash'></i>&nbsp;删除</a>&nbsp";

                        return html;
                    }
                },
                {
                    targets: 0,
                    render: function (data, type, row, meta) {
                        var html = meta.row + 1;
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

    function showInfo(item) {
        $("#info-modal").modal('show');
        $("#info-modal table tr:eq(0) td:eq(1) p").html(item.name);
        $("#info-modal table tr:eq(1) td:eq(1) p").html(item.price);
        $("#info-modal table tr:eq(2) td:eq(1) p").html(item.price);

        var projects = findProjectsBYId(item.id);
        console.log(projects);
        if (projects.length == 0) {
            $("#info-modal table tr:eq(2) td:eq(1)").html("暂无项目");
            return;
        }
        var html = [];
        html.push("<table class='table table-bordered '><tr><th>项目名</th><th>介绍</th></tr>")
        for (var i = 0; i < projects.length; i++) {
            html.push("<tr>")
            html.push("<td>" + projects[i].name + "</td>")
            html.push("<td>" + projects[i].comments + "</td>")
            html.push("</tr>")
        }
        html = html.join("");
        $("#info-modal table tr:eq(2) td:eq(1)").html(html);
    }

    function editInfo(item) {
        $("#edit-modal").modal('show');
        $("#edit-id").val(item.id);
        $("#edit-name").val(item.name);
        $("#edit-price").val(item.price);
        var projects = findProjectsBYId(item.id);
        $("#edit-modal .project-div input").each(function (index, obj) {
            $(this).prop('checked', false)
        });
        $("#edit-modal .project-div input").each(function (index, obj) {
            for (var i = 0; i < projects.length; i++) {
                if ($(this).val() == projects[i].id) {
                    $(this).prop('checked', true)
                }
            }
        })
    }

    function saveInfo() {
        console.log($("#edit-form").serialize());
        $.ajax({
            url: '/combo',
            type: 'POST',
            data: $("#edit-form").serialize() + '&_method=PUT',
            dataType: 'json',
            success: function (result) {
                if (result.resultCode) {
                    $("#edit-modal").modal('hide');
                    search();
                } else {
                    alert("更新失败");
                }
            }
        })
    }
    function addInfo() {
        $.ajax({
            url: '/combo',
            type: 'POST',
            data: $("#add-form").serialize(),
            dataType: 'json',
            success: function (result) {
                if (result.resultCode) {
                    $("#add-modal").modal('hide');
                    search();
                } else {
                    alert("添加失败");
                }
            }
        })
    }
    function deleteInfo(item) {
        if (confirm("你确认要删除" + item.name + "?")) {
            $.ajax({
                url: '/combo',
                type: 'POST',
                data: {
                    _method: 'DELETE',
                    id: item.id
                },
                dataType: 'json',
                success: function (result) {
                    if (result.resultCode) {
                        search();
                    } else {
                        alert("删除失败");
                    }
                }
            })
        }
    }

    function findProjectsBYId(id) {
        var data;
        $.ajax({
            url: '/combo/' + id + '/project',
            type: 'GET',
            async: false,
            dataType: 'json',
            success: function (result) {
                data = result.data;
            }
        });
        return data;
    }

    function initProjectDiv() {
        $.getJSON("/project/list", function (result) {
            var projects = result;
            var html = [];
            for (var i = 0; i < projects.length; i++) {
                html.push('<div class="checkbox"><label>');
                html.push('<input type="checkbox" name="projectId" value="' + projects[i].id + '">' + projects[i].name);
                html.push('</label> </div>');
            }
            $(".project-div").html(html.join(""));
        })
    }

</script>
</body>
</html>
