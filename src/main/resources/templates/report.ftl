<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>市场分析</title>
    <link href="${rc.contextPath}/components/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <script src="${rc.contextPath}/js/jquery/jquery.js" type="text/javascript"></script>




</head>

<body>
<div class="container" style="margin-bottom:80px; margin-top:5px ;">

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

</nav>

    <div class="row">
        <div class=-"col-lg-12">
            <div id="container" style="width:100%; height: 200px"></div>
        </div>

        <div class="col-lg-12">
            <div id="priceByGranularityContainer" style="width:100%; height: 200px"></div>
<#--            <hr>-->
        </div>


        <div class="col-lg-12">
            <table class=" table-striped" id="inventory-table" data-url="${itemUrl}" data-toggle="table" data-classes="table table-hover"   data-method="GET"
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
                   data-search="true"
                   data-show-refresh="true"
            >
                <thead>
                <tr>



                    <th data-field="distributor" data-formatter="companyInfoFormatter">煤矿</th>

                    <th data-field="name" data-formatter="productInfoFormatter">产品</th>

                    <th data-field="granularity">类型</th>

                    <th data-field="quantityOnHand">当前库存</th>
                    <th data-field="quote">当前价格</th>


                </tr>
                </thead>
            </table>

        </div>


    </div>


</div>








</body>
<script type="text/javascript" src="${rc.contextPath}/components/bootstrap_table/bootstrap-table.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/components/bootstrap_table/bootstrap-table-zh-CN.min.js"></script>


<script src="${rc.contextPath}/components/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

<script src="https://img.hcharts.cn/highcharts/highcharts.js"></script>

<script src="https://img.hcharts.cn/highcharts/modules/variwide.js"></script>

<script type="text/javascript">



    var req = $.ajax({
        url: '${yulinmeiIndexUrl}',
        type: 'get',
        data: {
        }
    });
    req.done(function (data) {
        getData = data;

        chart = Highcharts.chart('priceByGranularityContainer', {
            chart: {
                zoomType: 'x'
            },
            title: {
                text: '面煤价格走势'
            },
            subtitle: {
                text: document.ontouchstart === undefined ?
                        '鼠标拖动可以进行缩放' : '手势操作进行缩放'
            },
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
                }
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
                name: '面煤价格',
                data: getData.data
            }]
        });

    });





</script>

<script type="text/javascript">

    function companyInfoFormatter(value, row, index) {


        return   '<strong><a href="http://'+ row.companyUrl + '">' + row.companyName  + '</a></strong>';



    }
    function productInfoFormatter(value, row, index) {


        return   '<strong><a href="'+ row.productUrl + '">' + row.name  +'/'+row.productNo+ '</a></strong>';



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



    function handleResponse(original) {
        var res = {};
        res.rows = original.content;
        res.total = original.totalElements;
        //alert(JSON.stringify(original));
        return res;
    }



    function refresh_container() {
        var req = $.ajax({
            url: '${getInventoryUrl}',
            type: 'get',
            data: {
            }
        });
        req.done(function (data) {


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
                            'fontSize' : '16px'
                        },
                        rotation: 90, //倾斜的角度
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
                        style : {'fontSize' : '16px'},
                        format: '￥{point.y:.0f}/吨'
                    },
                    tooltip: {
                        pointFormat: '价格： <b>￥ {point.y}/吨</b><br>' +
                        '库存: <b> {point.z} 吨</b><br>'
                    },
                    colorByPoint: false
                }]
            });
        });

    }


    refresh_container()

</script>



</html>