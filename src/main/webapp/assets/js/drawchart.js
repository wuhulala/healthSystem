var randomScalingFactor = function(){ return Math.round(Math.random()*100)};
var data1 = {
    labels : ["January","February","March","April","May","June","July"],
    datasets : [
        {
            fillColor : "rgba(220,220,220,0.5)",
            strokeColor : "rgba(220,220,220,1)",
            data : [65,59,90,81,56,55,40]
        },
        {
            fillColor : "rgba(151,187,205,0.5)",
            strokeColor : "rgba(151,187,205,1)",
            data : [28,48,40,19,96,27,100]
        }
    ]
}

var data2 = {
    labels : ["January","February","March","April","May","June","July"],
    datasets : [
        {
            fillColor : "rgba(220,220,220,0.5)",
            strokeColor : "rgba(220,220,220,1)",
            pointColor : "rgba(220,220,220,1)",
            pointStrokeColor : "#fff",
            data : [65,59,90,81,56,55,40]
        },
        {
            fillColor : "rgba(151,187,205,0.5)",
            strokeColor : "rgba(151,187,205,1)",
            pointColor : "rgba(151,187,205,1)",
            pointStrokeColor : "#fff",
            data : [28,48,40,19,96,27,100]
        }
    ]
}

var data3 = {
    labels : ["Eating","Drinking","Sleeping","Designing","Coding","Partying","Running"],
    datasets : [
        {
            fillColor : "rgba(220,220,220,0.5)",
            strokeColor : "rgba(220,220,220,1)",
            pointColor : "rgba(220,220,220,1)",
            pointStrokeColor : "#fff",
            data : [65,59,90,81,56,55,40]
        },
        {
            fillColor : "rgba(151,187,205,0.5)",
            strokeColor : "rgba(151,187,205,1)",
            pointColor : "rgba(151,187,205,1)",
            pointStrokeColor : "#fff",
            data : [28,48,40,19,96,27,100]
        }
    ]
}

var data4 = [
    {
        label:"lala",
        value: 30,
        color:"#F38630"
    },
    {
        label:"nana",
        value : 50,
        color : "#E0E4CC"
    },
    {
        label:"haha",
        value : 100,
        color : "#69D2E7"
    },
    {
        label:"wuwu",
        value : 1000,
        color : "#222"
    }
]

function createdata(a,b,c){

    var obj = new Object();
    obj.label = a;
    obj.value = b;
    obj.color = c;

    return obj;
}

$(function(){
    var ctx = document.getElementById("barChart").getContext("2d");
    window.myLine = new Chart(ctx).Bar(data1);
    ctx = document.getElementById("lineChart").getContext("2d");
    window.myLine = new Chart(ctx).Line(data2);
    ctx = document.getElementById("radarChart").getContext("2d");
    window.myLine = new Chart(ctx).Radar(data3);
    ctx = document.getElementById("pieChart").getContext("2d");
    window.myLine = new Chart(ctx).Pie(data4);
});

var dataPie = new Array();
function drawchart(){

    var label = $("#label").val();
    var value = $("#value").val();
    var color = $("#color").val();

    var obj = createdata(label,value,color);


    dataPie.push(obj);

    var d = [
        {
            label:obj.label,
            value:obj.value,
            color:obj.color
        }
    ];



    ctx = document.getElementById("pieChart1").getContext("2d");
    window.myLine = new Chart(ctx).Pie(d);

}
