<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/1/4
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>体检预约中心</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
    <link href="${pageContext.request.contextPath}/assets/css/font-awesome.css" rel="stylesheet">

</head>
<body>

<jsp:include page="template/head.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-sm-9">
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" style="height:400px" role="listbox">
                    <div class="item active">
                        <img src="/assets/images/lunbo/lunbo1.JPG" width="100%" height="100%">
                    </div>
                    <div class="item">
                        <img src="/assets/images/lunbo/lunbo2.PNG" width="100%" height="100%" alt="...">

                    </div>
                    <div class="item">
                        <img src="/assets/images/lunbo/lunbo3.PNG" width="100%" height="100%" alt="...">
                    </div>
                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
        <div class="col-sm-3 platform-info">
            <div class="platform-info-header">
                欢迎来到体检预约平台
            </div>
            <div class="platform-info-list">
                <div class="platform-info-item">
                    平台注册用户 : 1230203 人
                </div>
                <div class="platform-info-item">
                    累计预约量&nbsp;&nbsp;&nbsp; : 1024503 次
                </div>
                <div class="platform-info-item">
                    昨日浏览量&nbsp;&nbsp;&nbsp; : 1042352 次
                </div>
            </div>


            <div align="center">
                ${sessionScope.loginUser == null?'<a class="btn btn-lg btn-primary platform-info-button" href="userLogin.html" >请登录</a>':'<a href="appointment" class="btn btn-lg btn-info platform-info-button" >快速预约</a>'}
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <div class="pull-left">
                <h2>推荐套餐</h2>
            </div>

        </div>
        <div class="col-sm-12 combo-div" id="comboDiv">


        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <div class="pull-left">
                <h2>推荐机构</h2>
            </div>

        </div>
        <div class="col-sm-12 combo-div" id="organizationDiv">


        </div>
    </div>

</div>
<div class="container-fluid footer-bar" style="list-style: none">
    <div class="col-sm-12">
        <div class="col-sm-offset-2 col-sm-2">
            <ul>
                <li><b>新手指南</b></li>
                <li><a href="/help/us_3.html" target="_blank" rel="external nofollow">新会员注册</a></li>
                <li><a href="/help/us_4.html" target="_blank" rel="external nofollow">用户登录</a></li>
                <li><a href="/help/us_5.html" target="_blank" rel="external nofollow">找回密码</a></li>
            </ul>
        </div>
        <div class="col-sm-2">
            <ul>
                <li><b>常见问题</b></li>
                <li><a href="/help/us_6.html" target="_blank" rel="external">预约流程</a></li>
                <li><a href="/help/us_7.html" target="_blank" rel="external">检前注意事项</a></li>
                <li><a href="/help/us_8.html" target="_blank" rel="external">体检流程</a></li>
            </ul>
        </div>
        <div class="col-sm-2">
            <ul>
                <li><b>售后服务</b></li>
                <li><a href="/help/us_9.html" target="_blank" rel="external nofollow">退款规则</a></li>
                <li><a href="/help/us_10.html" target="_blank" rel="external nofollow">修改预约信息</a></li>
                <li><a href="/help/us_11.html" target="_blank" rel="external nofollow">检后服务</a></li>
            </ul>
        </div>
        <div class="col-sm-2">
            <ul>
                <li><b>机构服务</b></li>
                <li><a href="/help/us_12.html" target="_blank" rel="external nofollow">机构入驻</a></li>
                <li><a href="/help/us_13.html" target="_blank" rel="external nofollow">企业团检</a></li>
                <li><a href="/adminLogin.html" target="_blank" rel="external nofollow">后台登录</a></li>
            </ul>
        </div>
    </div>

</div>
<jsp:include page="template/footer.jsp"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>

<script type="text/javascript">
    $(function () {
        initOrganization();
        initCombo();
    })
    //初始化推荐套餐
    function initCombo() {
        var comboDiv = $("#comboDiv");
        $.getJSON('combo/least', function (result) {
            if (result.returnCode == 'SUCCESS') {
                var data = result.data;
                for (var i = 0; i < data.length; i++) {
                    comboDiv.append(generatorPic(data[i].picture, data[i].name, data[i].price + "元"));

                }
            }
        })
    }
    //初始化推荐机构
    function initOrganization() {
        var organizationDiv = $("#organizationDiv");
        $.getJSON('organization/least', function (result) {
            if (result.returnCode == 'SUCCESS') {
                var data = result.data;
                for (var i = 0; i < data.length; i++) {
                    organizationDiv.append(generatorPic(data[i].picture, data[i].name, data[i].phone));

                }
            }
        })
    }

    function generatorPic(picUrl, name, price) {
        var picHtml = '<div class="col-sm-3 combo-view" >' +
                        ' <img width="100%" src="' + picUrl + '" />' +
                        '<p class="combo-name">' + name + '</p>' +
                        '<p class="combo-price">' + price + '</p>' +
                        '</div>'
                ;
        return picHtml;
    }

    function showDes(data) {
        var tongbao = $(data).children('img');
        $(data).children('.pic-info').animate({"width": tongbao.width(), "height": tongbao.height() * 0.2});
    }
    function hideDes(data) {
        $(data).children('.pic-info').animate({"height": 0});
    }
</script>
</body>
</html>
