/**
 * Created by xueaohui on 2016/1/17.
 */
var table;
$(function() {
    //初始化导航栏
   // initSidebar();
    search();
} );



function createTable(){
    // DataTable
    table = $('#userTable').DataTable( {
        dom: 'rt<"table-footer"<"col-md-3 col-sm-4"i><"col-md-5 col-sm-4"l><"col-md-4 col-sm-4"p>>',
        serverSide: true,//设置服务端模式,搜索需要根据传参实现
        ajax: {
            url: "getAllAdmin.json",
        },
        searching:false,
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
            "first":    "首页",
                "previous": "上一页",
                "next":     "下一页",
                "last":     "末页"
        }
    },
        ordering:  false,
        createdRow:function(row){
            $(row).click(function(){
            })
        },
        columns: [
            {"data": null},
            {"data": null},
            {"data":"username"},
            {"data":"password"},
            {"data":"isLogin"},
            {"data":"photo"},
            {"data": null}
        ],
        columnDefs: [
            {
                targets: 6,
                render: function (a) {
                    var html = "";
                    html += "<a class='btn btn-primary btn-xs' onclick='showinfo("+a.id+")' href='#'>查看详情</a>&nbsp";
                    html += "<a class='btn btn-warning btn-xs' onclick='alert("+a.id+")' href='#'>修改</a>&nbsp";
                    html += "<a class='btn btn-danger btn-xs' onclick='alert("+a.id+")' href='#'>删除</a>&nbsp";

                    return html;
                }
            },
            {
                targets: 4,

                render: function (data, type, row,   meta ) {


                    var html = row.isLogin==1?"在线":"离线";

                    return html;
                }
            },
            {
                targets: 1,

                render: function (data, type, row,   meta ) {


                    var html = meta.row+1;

                    return html;
                }
            },
            {
                targets: 0,

                render: function (data, type, row,   meta ) {


                    var html = "<input type='checkbox' class='cursor-pointer'>";

                    return html;
                }
            }

        ],
        lengthMenu: [[10, 20, 50, -1], ["10", "20", "50", "全部"]],//自定义单页显示
        initComplete:function(){
        }
    } );
}


function search(){
    if(table!=null){

        table.fnClearTable(0);
        table.fnDraw(); //重新加载数据

    }else{
        createTable();

    }
}

function showinfo(id){
    $.ajax({
        url:'getAdminById.json?id='+id,
        type:'get',
        dataType:'json',
        success:function(data){

            $("#infomodal").modal('show');
            $("#infomodal table tr:eq(0) td:eq(1) p").html(data['id']);
            $("#infomodal table tr:eq(1) td:eq(1) p").html(data['username']);
            $("#infomodal table tr:eq(2) td:eq(1) p").html(data['password']);
            $("#infomodal table tr:eq(3) td:eq(1) p").html(data['isLogin']=='1'?"在线":"离线");
            $("#infomodal table tr:eq(4) td:eq(1) p").html(data['photo']);

        },
        error:function(){

            alert("网络塞车");
        }
    })
}

