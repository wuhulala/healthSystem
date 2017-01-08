/**
 * Created by xueaohui on 2016/1/10.
 * ��������Ϊȫ�ֱ���
 * allPageNum ȫ��ҳ��
 * curPageNum ��ǰҳ�����
 * startPageNum ��ǰҳ�����
 * navSize ����ж��ٸ�������ť
 * getDataByCurPage() ���ݵ�ǰ��ҳ�Ż�ȡ���ݣ�����д��
 */


    var allPageNum = 0;// ȫ��ҳ��
    var curPageNum = 1;// ��ǰҳ�����
    var startPageNum = 1;//��ʼҳ�����
    var navSize = 10; //����ж��ٸ�������ť

    /*��ʼ����ҳ*/
    function initPagination(){

        $(".pagination").html('' +
            '<li><a href="#" class="pre-btn" onclick="PrePage()">��һҳ</a></li>' +
                //'<li><a href="#" class="pre-btn disabled">...</a></li>' +
            '<li><a href="#" class="next-btn" onclick="nextPage()">��һҳ</a></li>' +
            '');

        $(".pre-btn").hide();

    }

    function init(){
        allPageNum = 0;// ȫ��ҳ��
        curPageNum = 1;// ��ǰҳ�����
        startPageNum = 1;//��ʼҳ�����
    }
    /*������ҳ*/
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

    /*���click�¼�*/
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

    /*���ı�ҳ�浼��ҳ��*/
    function moveToNextNav(){



        startPageNum = startPageNum + 1;

        createPagination();

    }

    /*��ǰ�ı�ҳ�浼��ҳ��*/
    function moveToPreNav(){

        startPageNum = startPageNum - 1;
        createPagination();

    }

    /*��һҳ*/
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

    /*��һҳ*/
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

    /*��ʾ��������һҳ����һҳѡ��*/
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

