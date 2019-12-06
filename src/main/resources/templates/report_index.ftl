<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="refresh"content="${interval};url=${selfUrl}">

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>${company.companyName}</title>
    <link href="${rc.contextPath}/components/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${rc.contextPath}/components/bootstrap-select/css/bootstrap-select.min.css" rel="stylesheet">
    <link href="${rc.contextPath}/components/bootstrap_table/bootstrap-table.min.css" rel="stylesheet">

    <script src="${rc.contextPath}/js/jquery/jquery.js" type="text/javascript"></script>

    <script src="https://img.hcharts.cn/highcharts/highcharts.js"></script>
    <script src="https://img.hcharts.cn/highcharts/modules/exporting.js"></script>
    <script src="https://img.hcharts.cn/highcharts-plugins/highcharts-zh_CN.js"></script>
    <script type="text/javascript" src="${rc.contextPath}/components/bootstrap_table/bootstrap-table.min.js"></script>
    <script type="text/javascript" src="${rc.contextPath}/components/bootstrap_table/bootstrap-table-zh-CN.min.js"></script>
    <script type="text/javascript" src="${rc.contextPath}/components/bootstrap-select/js/bootstrap-select.min.js"></script>


    <script src="${rc.contextPath}/components/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>


    <script src="https://img.hcharts.cn/highcharts/modules/variwide.js"></script>
</head>

<body>
<div class="container" style=" margin-top:5px ;width: 1470px;">

<nav class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
        <button type="button " class="navbar-toggle btn-primary" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>

        <a class="navbar-brand " href="${configurationUrl}"><img class="" src="${rc.contextPath}/images/logo_header.png" style="width:90px; ;"></a>

    </div>
    <div>    <h3><strong>${company.companyName}</strong> |  ${company.companyNo}</h3></div>




</div>

</nav>


<div class="row">

    <div class="col-lg-12">
        <#if reportPage.name??>
                    <div class="page-header">

                        <h2>
                            <small>...</small>${reportPage.name}
                        </h2>
                    </div>
        </#if>

        <div id="producerContainer" style="min-width:400px;height:400px"></div>
        <script>
            function refresh_container_producerDistributorOpenAccountDate() {
                $.get("${producerDistributorOpenAccountDateUrl}", function (result) {

                    var chart = Highcharts.chart('producerContainer', {
                        chart: {
                            type: 'column'
                        },
                        title: {
                            text: '实时价格'
                        },
                        subtitle: {
                            text: '数据来源: yulinmei.cn'
                        },
                        legend: {
                            itemStyle: {
                                'fontSize': '18px'
                            }
                        },
                        xAxis: {
                            categories: result.categories,
                            crosshair: true,
                            labels: {
                                style: {
                                    fontWeight: 'bold',
                                    'fontSize': '15px'
                                },
                                rotation: 30, //倾斜的角度
                            }
                        },
                        yAxis: {
                            min: 0,
                            title: {
                                text: '降雨量 (mm)'
                            }
                        },
                        tooltip: {
                            // head + 每个 point + footer 拼接成完整的 table
                            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                            '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
                            footerFormat: '</table>',
                            shared: true,
                            useHTML: true
                        },
                        plotOptions: {
                            column: {
                               /* borderWidth: 0,*/
                                dataLabels: {
                                    enabled: true,
                                    allowOverlap: true, // 允许数据标签重叠
                                    formatter: function()
                                    {
                                       // return data[this.x].name + " " + data[this.x].y;
                                        return '<span class="label label-success"> '+ this.point.tax + '</span>' + this.y
                                    },
                                },

                            },

                        },
                        /*
                                        plotOptions: {
                                            bar: {
                                                dataLabels: {
                                                    enabled: true,
                                                    allowOverlap: true // 允许数据标签重叠
                                                }
                                            }
                                        },*/
                        series: result.series,
          /*               [{
                    name: '东京',
                    data: [{y:49.9,name:"333"}, {y:49.9,name:"333"}, {y:49.9,name:"333"}, {y:49.9,name:"333"}, {y:49.9,name:"333"}, {y:49.9,name:"333"}, {y:49.9,name:"333"}, {y:49.9,name:"333"}, {y:49.9,name:"333"}, {y:49.9,name:"333"}, {y:49.9,name:"333"}, {y:49.9,name:"333"}]
                }, {
                    name: '纽约',
                    data: [83.6, 78.8, 98.5, 93.4, 106.0, 84.5, 105.0, 104.3, 91.2, 83.5, 106.6, 92.3]
                }, {
                    name: '伦敦',
                    data: [48.9, 38.8, 39.3, 41.4, 47.0, 48.3, 59.0, 59.6, 52.4, 65.2, 59.3, 51.2]
                }, {
                    name: '柏林',
                    data: [42.4, 33.2, 34.5, 39.7, 52.6, 75.5, 57.4, 60.4, 47.6, 39.1, 0, 51.1]
                }]*/
                    });


                });
            }
            refresh_container_producerDistributorOpenAccountDate();
        </script>
    </div>
</div>
<#--
    <div class="row">
&lt;#&ndash;    <div class="col-lg-9">
        <div id="priceByGranularityContainer" style="width:100%; height: 200px"></div>
&ndash;&gt;

    <div class="col-lg-9">
        <div id="container" style="/*width:100%;*/ height: 300px"></div>

        <script type="text/javascript">


            function refresh_container() {


                $.get("${getInventoryUrl}", function(data) {
                    Highcharts.chart('container', {
                        chart: {
                            type: 'variwide' // varwide 依赖 varwide.js
                        },
                        title: {
                            text: '当前横山区三八块报价和库存',
                            floating: true,
                            align: "center"
                        },
                        subtitle: {
                            text: null// '数据来源：<a href="http://ec.europa.eu/eurostat/web/' +         'labour-market/labour-costs/main-tables">eurostat</a>'
                        },
                        xAxis: {
                            type: 'category',
                            title: {
                                text: '* 柱子宽度与 库存 成正比'
                            },
                            labels : {
                                style : {
                                    'fontSize' : '18px'
                                },
                                rotation: 30, //倾斜的角度
                            }
                        },
                        yAxis: {
                            title: {
                                text: '价格'
                            }
                        },
                        legend: {
                            enabled: false
                        },
                        series: [{
                            name: '价格',
                            data:data.data ,
                            dataLabels: {
                                inside:true,
                                enabled: true,
                                style : {'fontSize' : '18px'},
                                format: '￥{point.y:.0f}/吨'
                            },
                            tooltip: {
                                pointFormat: '{point.series.name}价格： <b>￥ {point.y}元/吨</b><br>' +
                                '库存: <b> {point.z} 吨</b><br>'
                            },
                            colorByPoint: true
                        }]
                    });

                });

            }


            refresh_container()

        </script>


    </div>


    </div>
-->



<div class="  col-lg-12" >

    <div class="col-lg-5">
        <div id="inventoryClumnContainer" style="min-width:400px;height:400px"></div>
        <script>

            function refresh_container_producerInventoryClumnDate() {
                $.get("${producerInventoryClumnDateUrl}", function(result) {
                    var chart = Highcharts.chart('inventoryClumnContainer', {
                        chart: {
                            type: 'column'
                        },
                        title: {
                            text: '实时库存'
                        },
                        xAxis: {
                            categories: result.categories, //['苹果', '橘子', '梨', '葡萄', '香蕉']*/
                            crosshair: true,
                            /*                        labels : {
                                                        style : {
                                                            'fontSize' : '18px'
                                                        },
                                                        rotation: 30, //倾斜的角度
                                                    }*/
                            labels : {
                                style : {
                                    fontWeight: 'bold',
                                    'fontSize' : '15px'
                                },
                                rotation: 30, //倾斜的角度
                            }
                        },
                        yAxis: {
                            min: 0,
                            title: {
                                text: '总量'
                            },
                            stackLabels: {  // 堆叠数据标签
                                enabled: true,
                                style: {
                                    fontWeight: 'bold',
                                    color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
                                }
                            }
                        },
                        legend: {
                            align: 'right',
                            x: -30,
                            verticalAlign: 'top',
                            y: 25,
                            floating: true,
                            backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',
                            borderColor: '#CCC',
                            borderWidth: 1,
                            shadow: false
                        },
                        tooltip: {
                            formatter: function () {
                                return '<b>' + this.x + '</b><br/>' +
                                        this.series.name + ': ' + this.y + '<br/>' +
                                        '总量: ' + this.point.stackTotal;
                            }
                        },
                        plotOptions: {
                            column: {
                                stacking: 'normal',
                                dataLabels: {
                                    enabled: true,
                                    color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white',
                                    style: {
                                        // 如果不需要数据标签阴影，可以将 textOutline 设置为 'none'
                                        textOutline: '1px 1px black'
                                    }
                                }
                            }
                        },
                        series:result.series
                    });

                });

            }
            refresh_container_producerInventoryClumnDate();
        </script>


        <table class=" table-striped" id="station-table" data-url="${productUrl}" data-toggle="table" data-classes="table table-hover"   data-method="GET"
               data-content-type="application/x-www-form-urlencoded; charset=UTF-8"
               data-query-params-type="unlimit"
               data-query-params="queryParams_company"
               data-response-handler="handleResponse"
               data-pagination="true"
               data-side-pagination="server"
               data-page-number="1"
               data-page-list="[10]"
               data-page-size="10"
               data-click-to-select="true"
               data-single-select="true">
            <thead>
            <tr>
                <th data-field="producer">煤矿</th>
                <th data-field="coalType">产品</th>
                <th data-field="granularity">粒度</th>
                <th data-field="tax" data-formatter="taxFormatter">税</th>
                <th data-field="quote">价格</th>
                <th data-field="inventory">库存</th>
            </tr>
            </thead>
        </table>

    </div>

        <div class="col-lg-3 hidden">
            <table class=" table-striped" id="location-table" data-url="${storageUrl}" data-toggle="table" data-classes="table table-hover"   data-method="GET"
                   data-content-type="application/x-www-form-urlencoded; charset=UTF-8"
                   data-query-params-type="unlimit"
                   data-query-params="queryParams_company"
                   data-response-handler="handleResponse"
                   data-pagination="true"
                   data-side-pagination="server"
                   data-page-number="1"
                   data-page-list="[10]"
                   data-page-size="10"
                   data-click-to-select="true"
                   data-single-select="true">
                <thead>
                <tr>
                    <th data-field="companyName"><h4>堆场</h4>企业</th>


                    <th data-field="name">名称</th>

                    <th data-field="status">状态</th>
                    <th data-field="" data-formatter="operationInfoFormatter">操作</th>
                </tr>
                </thead>
            </table>
        </div>
    <div class="  col-lg-4" >
        <div id="inventoryContainer" style="min-width:400px;height:400px"></div>
        <script>

            function refresh_container_inventoryData() {
                $.get("${inventoryDataUrl}", function(result){
                    var  chart = Highcharts.chart('inventoryContainer', {
                        chart: {
                            plotBackgroundColor: null,
                            plotBorderWidth: null,
                            plotShadow: false
                        },
                        title: {
                            text: '库存占比'
                        },
                        tooltip: {
                            headerFormat: '{series.name}<br>',
                            pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
                        },
                        plotOptions: {
                            pie: {
                                allowPointSelect: true,
                                cursor: 'pointer',
                                dataLabels: {
                                    enabled: true,
                                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                                    style: {
                                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                                    }
                                },
                                states: {
                                    hover: {
                                        enabled: false
                                    }
                                },
                                slicedOffset: 20,         // 突出间距
                                point: {                  // 每个扇区是数据点对象，所以事件应该写在 point 下面
                                    events: {
                                        // 鼠标滑过是，突出当前扇区
                                        mouseOver: function() {
                                            this.slice();
                                        },
                                        // 鼠标移出时，收回突出显示
                                        mouseOut: function() {
                                            this.slice();
                                        },
                                        // 默认是点击突出，这里屏蔽掉
                                        click: function() {
                                            return false;
                                        }
                                    }
                                }
                            }
                        },
                        series: [{
                            type: 'pie',
                            name: '库存',
                            data: //[{name:"樊河三号矿",y:4364.77},{name:"张家洼煤矿",y:2000.0},{name:"山东煤矿",y:1000.0},{name:"兴维煤矿",y:400.0},{name:"正和煤矿",y:5500.0},{name:"胜凯煤矿",y:3400.0}]
                            result

                            /*[
                                ['Firefox',   45.0],
                                ['IE',       26.8],
                                {
                                    name: 'Chrome',
                                    y: 12.8,
                                    sliced: true, // 突出显示这个点（扇区），用于强调。
                                },
                                ['Safari',    8.5],
                                ['Opera',     6.2],
                                ['其他',   0.7]
                            ]*/
                        }]
                    });
                });

            }
            refresh_container_inventoryData();
        </script>
        <table class=" table-striped" id="event-table" data-url="${eventUrl}" data-toggle="table" data-classes="table table-hover"   data-method="GET"
               data-content-type="application/x-www-form-urlencoded; charset=UTF-8"
               data-query-params-type="unlimit"
               data-query-params="queryParams_company"
               data-response-handler="handleResponse"
               data-pagination="true"
               data-side-pagination="server"
               data-page-number="1"
               data-page-list="[10]"
               data-page-size="10"
               data-click-to-select="true"
               data-single-select="true">
            <thead>
            <tr>
                <th data-field="companyName"><h4>事件</h4>企业</th>

                <th data-field="description">描述</th>

                <th data-field="createDate">时间</th>
            </tr>
            </thead>
        </table>

    </div>



    <div class="col-lg-3 " id="user">

        <div class="col-lg-3">

            <marquee behavior="scroll" direction="left" scrollamount="5">微信扫一扫 关注 货源信息 榆林煤市场动态</marquee>

        <#if permanentQrcode??>

        <input id="text" type="hidden" value="${permanentQrcode.content!'我啊你你'}" style="width:80%" />
        <#else>
            <input id="text" type="hidden" value="${permanentQrcodecontent!'我啊你你'}" style="width:80%" />
        </#if>
            <script type="text/javascript" src="${rc.contextPath}/js/qrcode.js"></script>
            <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                <g id="qrcode_div"/>
            </svg>
            <script type="text/javascript">
                var qrcode = new QRCode(document.getElementById("qrcode_div"), {
                    width : 100,
                    height : 100,
                    useSVG: true
                });

                function makeCode () {
                    var elText = document.getElementById("text");

                    if (!elText.value) {
                        alert("Input a text");
                        elText.focus();
                        return;
                    }

                    qrcode.makeCode(elText.value);
                }

                makeCode();

                $("#text").
                on("blur", function () {
                    makeCode();
                }).
                on("keydown", function (e) {
                    if (e.keyCode == 13) {
                        makeCode();
                    }
                });
            </script>

        </div>

        <table class=" table-striped" id="follower-table" data-url="${followerUrl!''}" data-toggle="table" data-classes="table table-hover"   data-method="GET"
               data-content-type="application/x-www-form-urlencoded; charset=UTF-8"
               data-query-params-type="unlimit"
               data-query-params="queryParams_company"
               data-response-handler="handleResponse"
               data-pagination="true"
               data-side-pagination="server"
               data-page-number="1"
               data-page-list="[10]"
               data-page-size="10"
               data-click-to-select="true"
               data-single-select="true"
<#--               data-search="true"
               data-show-refresh="true"-->>
            <thead>
            <tr>


                <th data-field="name" >昵称
                </th>

                <th data-field="modifyDate">时间</th>

            </tr>            </tr>
            </thead>
        </table>




    </div>
    <div class="col-lg-2 hidden">
        <table class=" table-striped table-condensed" id="station-table" data-url="${shipmentUrl!''}" data-toggle="table" data-classes="table table-hover"   data-method="GET"
               data-content-type="application/x-www-form-urlencoded; charset=UTF-8"
               data-query-params-type="unlimit"
               data-query-params="queryParams_company"
               data-response-handler="handleResponse"
               data-pagination="true"
               data-side-pagination="server"
               data-page-number="1"
               data-page-list="[10]"
               data-page-size="10"
               data-click-to-select="true"
               data-single-select="true">
            <thead>
            <tr>

                <th data-field="distributor">分销商</th>
                <th data-field="license">车牌号</th>
                <th data-field="product">产品</th>
                <th data-field="quote">当前价格</th>

                <th data-field="tareWeight">皮重</th>
                <th data-field="grossWeight">毛重</th>
                <th data-field="netWeight">净重</th>


            </tr>
            </thead>
        </table>

    </div>



</div>

<#include "./common/page_foot_section_usercenter.ftl">





</body>


<script type="text/javascript">
    function operationInfoFormatter(value, row, index) {
        return  '<a type="button" href="' + row.url + '" class="b">查看</a>';
    }
    function taxFormatter(value, row, index) {
        if(row.tax == '出矿不含税'){
            return  '';
        }
        if(row.tax != '出矿不含税'){
            return  '<span class="label label-success">税</span>';
        }
    }


    function originToDestinationInfoFormatter(value, row, index) {
        return '<div class="">'  + row.origin  +
                '<hr style="margin-top: 0px;       margin-bottom: 0px;" >'   +'<span class="pull-right" style="   margin-bottom: 0px; padding-bottom: 0px; ">'+ row.destination  +'</span></div>';

    }

    function queryParams(params) {
        params.page = params.pageNumber - 1;
        params.size = params.pageSize;

        var sender = $.trim($("#search_param").val());

        if (sender) {
            params.q = sender;
        }
        return params;
    }
    $('#supplies-table').bootstrapTable({
        onLoadSuccess: function (data) {
            $('[data-trigger="hover"]').popover();

        }
    });



    function ompanyInfoFormatter(value, row, index) {
        return  ' <div class="img-comment-list">  <div  class="comment-img"  > <img class="" src="'+row.companyLogoUrl+'"/> </div>'+
                ' <div class="comment-text">'+
                '<strong><a href="'+ row.companyUrl + '">' + row.companyName  + '</a></strong>'+
                '<p class="">@'+ row.inventoryCounty + '</p> '+
                '</div>'+
                ' </div>';
    }



    function refresh() {
        $('#companies-table').bootstrapTable('refresh');
    }

    function handleResponse(original) {
        var res = {};
        res.rows = original.content;
        res.total = original.totalElements;
        return res;
    }

    $('.selectpicker').selectpicker();

    $('.searchBtn').bind('click', function(){
        refresh();

    });


    var req = $.ajax({
        url: '${yulinmeiIndexUrl}',
        type: 'get',
        data: {
        }
    });
    req.done(function (data) {
        getData = data;

      //alert(JSON.stringify(getData.data));
        var    chart = Highcharts.chart('priceByGranularityContainer', {
            chart: {
                zoomType: 'x'
            },
            title: {
                text: null
            },
/*            subtitle: {
                text: document.ontouchstart === undefined ?
                        '榆林末煤价格走势'
            },*/
            xAxis: {
                type: 'datetime',
                dateTimeLabelFormats: {
                    millisecond: '%H:%M:%S.%L',
                    second: '%H:%M:%S',
                    minute: '%H:%M',
                    hour: '%H:%M',
                    day: '%m-%d',
                    week: '%m-%d',
                    month: '%Y-%m',
                    year: '%Y'
                },
        //        max: 25,
                ordinal:false,
                endOnTick: true
            },
            tooltip: {
                dateTimeLabelFormats: {
                    millisecond: '%H:%M:%S.%L',
                    second: '%H:%M:%S',
                    minute: '%H:%M',
                    hour: '%H:%M',
                    day: '%Y-%m-%d',
                    week: '%m-%d',
                    month: '%Y-%m',
                    year: '%Y'
                }
            },
            yAxis: {
                title: {
                    text: '价格'
                }
            },
            legend: {
                enabled: false
            },
            plotOptions: {
                area: {
                    fillColor: {
                        linearGradient: {
                            x1: 0,
                            y1: 0,
                            x2: 0,
                            y2: 1
                        },
                        stops: [
                            [0, Highcharts.getOptions().colors[0]],
                            [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
                        ]
                    },
                    marker: {
                        radius: 2
                    },
                    lineWidth: 1,
                    states: {
                        hover: {
                            lineWidth: 1
                        }
                    },
                    threshold: null
                }
            },
            series: [{
                type: 'area',
                name: '美元兑欧元',
                data:getData.data
            }]
        });

    });





</script>



<script src="${rc.contextPath}/js/bootstrap-notify.min.js" type="text/javascript"></script>
<script src="https://cdn.jsdelivr.net/sockjs/1/sockjs.min.js"></script>
<script src="${rc.contextPath}/js/stomp.js" type="text/javascript"></script>
<script type="text/javascript">
    var stompClient = null;
    function setConnected(connected) {
        $("#connect").prop("disabled", connected);
        $("#disconnect").prop("disabled", !connected);
        if (connected) {
            $("#conversation").show();
        }
        else {
            $("#conversation").hide();
        }
        $("#greetings").html("");
    }

    function connect() {
        //   var socket = new SockJS('${websocket_url}');
        var socket = new SockJS('${rc.contextPath}/ws');


        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            setConnected(true);
            console.log('Connected: ' + frame);

            stompClient.subscribe('${websocket_topic}', function (greeting) {

                console.log("------"+JSON.parse(greeting.body));
                console.log("------ event-table ");
               // alert(JSON.stringify(greeting.body));
                var map = JSON.parse(greeting.body);
                if(map.type=="Follower"){
                    event_follower(map)


                }else  if(map.type=="inventory"){
                    event_inventory(map)


                } if(map.type=="redirect"){
                    console.log("------reload ");
                    window.location.href = map.content;
                }else{
                    event_default(map)
                }

            });


        });
    }

    function disconnect() {
        if (stompClient != null) {
            stompClient.disconnect();
        }
        setConnected(false);
        console.log("Disconnected");
    }



    function sendName() {
        stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
    }

    function showGreeting(message) {
        $("#greetings").append("<tr><td>" + message + "</td></tr>");
    }

    $(function () {
        $("form").on('submit', function (e) {
            e.preventDefault();
        });
        $( "#connect" ).click(function() { connect(); });
        connect();

        $( "#disconnect" ).click(function() { disconnect(); });
        $( "#send" ).click(function() { sendName(); });
    });





    function event_follower(map) {
        $('#follower-table').bootstrapTable('refresh');

        $.notify({
            title: map.nickname,
            message:" 关注了我们 " ,
            delay: 5000,
            allow_dismiss: true,
        },{
            type: 'success',
            animate: {
                enter: 'animated fadeInUp',
                exit: 'animated fadeOutRight'
            },
            // type: 'minimalist',
            delay:5000,
            allow_dismiss: true,
            placement: {
                from: 'bottom',
                align: 'left'
            },
            offset: 20,
            spacing: 10,
            z_index: 1031,

        });


    }

    function event_default(map) {

        $('#inventory-table').bootstrapTable('refresh');
        $('#event-table').bootstrapTable('refresh');
        refresh_container_producerDistributorOpenAccountDate();

        $.notify({
            title: map.distributor,
            message:map.plateNumber +" "+ map.productName,
            delay: 5000,
            allow_dismiss: true,

        },{
            type: 'info',
            animate: {
                enter: 'animated fadeInUp',
                exit: 'animated fadeOutRight'
            },
            // type: 'minimalist',
            delay:5000,
            allow_dismiss: true,
            placement: {
                from: 'bottom',
                align: 'left'
            },
            offset: 20,
            spacing: 10,
            z_index: 1031,

        });
    }
    function event_inventory(map) {

        $('#inventory-table').bootstrapTable('refresh');
        $('#event-table').bootstrapTable('refresh');
        refresh_container_inventoryData();
        refresh_container_producerInventoryClumnDate();
        $.notify({
            title: map.distributor,
            message:map.plateNumber +" "+ map.productName,
            delay: 5000,
            allow_dismiss: true,

        },{
            type: 'info',
            animate: {
                enter: 'animated fadeInUp',
                exit: 'animated fadeOutRight'
            },
            // type: 'minimalist',
            delay:5000,
            allow_dismiss: true,
            placement: {
                from: 'bottom',
                align: 'left'
            },
            offset: 20,
            spacing: 10,
            z_index: 1031,

        });
    }


</script>



</html>