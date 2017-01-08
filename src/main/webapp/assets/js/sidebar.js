/**
 * Created by xueaohui on 2016/1/23.
 */

$(function(){

    initSidebar();

})

function initSidebar(){
    var id = getPageId();
    $("#"+id).addClass("active");
}
function getPageId(){

    var x = window.location.pathname;
    var array = x.split("/");
    var array2 = array[array.length-1].split(".");
    var id = array2[0];
    //alert(data);
    return id;
}