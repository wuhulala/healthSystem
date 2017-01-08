/**
 * Created by xueaohui on 2016/1/10.
 * 开放数据为全局变量
 * allPageNum 全部页码
 * curPageNum 当前页面号码
 * startPageNum 当前页面号码
 * navSize 最多有多少个导航按钮
 * getDataByCurPage() 根据当前的页号获取数据（必须写）
 */


    var allPageNum = 0;// 全部页码
    var curPageNum = 1;// 当前页面号码
    var startPageNum = 1;//开始页面号码
    var navSize = 10; //最多有多少个导航按钮

    /*初始化分页*/
    function initPagination(){

        $(".pagination").html('' +
            '<li><a href="#" class="pre-btn" onclick="PrePage()">上一页</a></li>' +
                //'<li><a href="#" class="pre-btn disabled">...</a></li>' +
            '<li><a href="#" class="next-btn" onclick="nextPage()">下一页</a></li>' +
            '');

        $(".pre-btn").hide();

    }

    function init(){
        allPageNum = 0;// 全部页码
        curPageNum = 1;// 当前页面号码
        startPageNum = 1;//开始页面号码
    }
    /*创建分页*/
    function createPagination(){

        initPagination();
        if(allPageNum==0){
            $(".next-btn").hide();
            $(".pre-btn").hide();
            return false;
        }

        if(allPageNum>navSize){
            $("<li class='disabled'><a href='#' class='pre-btn'>...</a></li>").insertBefore($(".pagination").children().last());
            for(var i  = startPageNum ; i <= startPageNum + navSize - 1 ; i ++){
                $("<li><a href='#' class='page-num'>"+i+"</a></li>").insertBefore($(".pagination").children().last());
            }
            $("<li class='disabled'><a href='#' class='next-btn'>...</a></li>").insertBefore($(".pagination").children().last());
        }else{
            for(var i  = 1 ; i<=allPageNum ; i ++){
                $("<li><a href='#' class='page-num'>"+i+"</a></li>").insertBefore($(".pagination").children().last());
            }
        }

        $(".pagination li").each(function(){
            if($(this).children().text() == curPageNum){
                $(this).addClass("active");
                $(this).siblings().removeClass("active");
            }
        });

        togglePreAndNextButton();

        pagingOnclick();

    }

    /*添加click事件*/
    function pagingOnclick(){


        $(".pagination li .page-num").click(function(){
            $(this).parent().siblings().removeClass("active");
            $(this).parent().addClass("active");
            //alert($(this).text());

            curPageNum = $(this).text();

            if(curPageNum == startPageNum+navSize-1&&curPageNum<allPageNum){
                moveToNextNav();
            }
            if(curPageNum == startPageNum&&curPageNum<allPageNum&&curPageNum>1){
                moveToPreNav();
            }

            togglePreAndNextButton();

        })

    }

    /*向后改变页面导航页码*/
    function moveToNextNav(){



        startPageNum = startPageNum + 1;

        createPagination();

    }

    /*向前改变页面导航页码*/
    function moveToPreNav(){

        startPageNum = startPageNum - 1;
        createPagination();

    }

    /*上一页*/
    function PrePage(){
        var curPage = $(".pagination").find(".active");


        if(curPageNum == 1){

            return false;

        }
        if(curPageNum == startPageNum && startPageNum > 1){

            curPageNum = parseInt(curPageNum) - 1;
            moveToPreNav();

        }
        else{

            curPageNum = curPage.prev().children().text();
            curPage.removeClass("active");
            curPage.prev().addClass("active");

        }


        togglePreAndNextButton();

    }

    /*下一页*/
    function nextPage(){
        var curPage = $(".pagination").find(".active");


        if(curPageNum >= allPageNum){
            return false;
        }

        if(allPageNum > navSize){

            if(curPageNum == startPageNum + navSize - 2 && curPageNum != allPageNum-1){

                curPageNum = parseInt(curPageNum) + 1;
                moveToNextNav();


            }else{
                curPageNum = curPage.next().children().text();
                curPage.removeClass("active");
                curPage.next().addClass("active");

            }
        }else{

            if(curPageNum < allPageNum ){
                curPageNum = curPage.next().children().text();
                curPage.removeClass("active");
                curPage.next().addClass("active");

            }

        }


        togglePreAndNextButton();




    }

    /*显示或隐藏上一页或下一页选项*/
    function togglePreAndNextButton(){


        if(curPageNum==1){
            $(".pre-btn").hide();
        }else{
            $(".pre-btn").show();
        }

        if(curPageNum==allPageNum){
            $(".next-btn").hide();
        }else{
            $(".next-btn").show();
        }

        getDataByCurPage();
    }

