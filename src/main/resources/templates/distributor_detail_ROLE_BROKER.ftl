<#--<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />-->

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>个人中心 客户详情 </title>

    <link href="${rc.contextPath}/components/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <script src="${rc.contextPath}/js/jquery/jquery.js" type="text/javascript"></script>
    <script src="${rc.contextPath}/components/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

    <script type="text/javascript" src="${rc.contextPath}/components/bootstrap_table/bootstrap-table.min.js"></script>
    <script type="text/javascript" src="${rc.contextPath}/components/bootstrap_table/bootstrap-table-zh-CN.min.js"></script>
    <script type="text/javascript" src="${rc.contextPath}/components/bootstrap-select/js/bootstrap-select.min.js"></script>


</head>
<body>
<div class="container" style="margin-bottom:80px; margin-top:0px">

<h1 class="page-header">
    <small>账户详情</small>
</h1>



<div class=" ">
<div class="tabpanel">
    <ul class="nav nav-tabs " id="ajaxTabs" role="tablist">

        <li role="presentation" class="active"><a href="#companies" aria-controls="capitalHistory" role="tab"
                                                  data-toggle="tab">基本信息 <span class="badge"></span></a></li>
        <li role="presentation" class=""><a href="#account" aria-controls="account" role="tab"
                                            data-toggle="tab">我的信息 <span class="badge"></span></a></li>

        <li role="presentation" class=""><a href="#deliveryOrer" aria-controls="deliveryOrer" role="tab"
                                                  data-toggle="tab">开户煤矿 <span class="badge"></span></a></li>

        <li role="presentation" class=""><a href="#transfer" aria-controls="capitalHistory" role="tab"
                                            data-toggle="tab">发货详情 <span class="badge"></span></a></li>

        <li role="presentation" class=""><a href="#capital" aria-controls="capitalHistory" role="tab"
                                            data-toggle="tab">资金统计 <span class="badge"></span></a></li>


        <li role="presentation" class=""><a href="#employee" aria-controls="employee" role="tab"
                                            data-toggle="tab">员工 <span class="badge"></span></a></li>
    </ul>


    <div  class="tab-content">

    <div class="tab-pane active" id="companies">


    <div class="row" style="padding-top: 10px;padding-bottom: 10px">
        <div class="col-lg-6">
            <div class="panel panel-default">
                <div class="panel-heading">基本信息</div>
                <div class="panel-body">
                    <ul class="list-group">
                        <li class="list-group-item">名称：${deliveryOrderMap.name!''}</li>
                        <li class="list-group-item">编号： ${deliveryOrderMap.no!''}</li>
                        <li class="list-group-item">状态：</li>




                        <li class="list-group-item">是否绑定平台：
                        <#if deliveryOrderMap.status?? && deliveryOrderMap.status =="Valid">

                            有效
                        <#else>
                            无效
                        </#if>
                            <button id="" type="button" class="btn btn-primary"  data-toggle="modal" data-target="#boundDistributorModal">
                                绑定
                            </button>

                            <button id="" type="button" class="btn btn-primary"  data-toggle="modal" data-target="#getBoundDistributorQrcodeModal">
                                获取绑定二维码
                            </button>

                            <script type="text/javascript">


                                function refresh() {
                                    $('#station-table').bootstrapTable('refresh');
                                }

                                function selectedRow_() {
                                    var row =  $('#station-table').bootstrapTable('getSelections');
                                    return row;
                                }


                                $("#boundBtn").click(function() {
                                    var row = selectedRow_();
                                    $('#boundDistributorModal').modal();

                                    if (row != '') {
                                        $('#boundDistributorModal').modal();
                                        //   alert(JSON.stringify(row[0]));
                                        //   $('#addStationModalForm .companyId').val(row[0].id);

                                    }
                                });



                            </script>


                        </li>




                        <li class="list-group-item">类型： ${deliveryOrderMap.type!''}

                            <button id="beTraderRequestBtn" type="button" class="btn btn-primary"  data-toggle="modal" data-target="#beTraderRequestModal">
                                申请成交易商
                            </button>

                            <script type="text/javascript">


                                function refresh() {
                                    $('#station-table').bootstrapTable('refresh');
                                }

                                function selectedRow_() {
                                    var row =  $('#station-table').bootstrapTable('getSelections');
                                    return row;
                                }


                                $("#beTraderRequestBtn").click(function() {
                                    var row = selectedRow_();
                                    $('#beTraderRequestModal').modal();

                                    if (row != '') {
                                        $('#beTraderRequestModal').modal();

                                    }
                                });



                            </script>


                        </li>

                    </ul>
                </div>

            </div>
        </div>
        <div class="col-lg-6">
            <div class="panel panel-default">
                <div class="panel-heading">财务信息</div>
                <div class="panel-body">
                <#if deliveryOrderMap??>
                <div class="">


                <div class="">


                <table class="table" data-show-header="false">
                    <thead>
                    <tr>
                        <th colspan="4">基本信息</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td class="active">预收账款：</td>
                        <td colspan="3"><strong>${deliveryOrderMap.advancedPaymentAmount!''}</strong></td>
                    </tr>
                    <tr>
                        <td class="active">已核算账款：</td>
                        <td colspan="3"><strong>${deliveryOrderMap.advancedPaymentAmount!''}</strong></td>
                    </tr>


                    <tr>
                        <td class="active">贸易商：</td>
                        <td colspan="3"><a href="${deliveryOrderMap.companyUrl!''}">${deliveryOrderMap.abbreviationName!''}</a></td>
                    </tr>



                    </tbody>
                </table>




                <label>扫一扫微信获得信息 </label>

                <div class="thumbnail">
                    <img src="${qrcodeUrl!'/logo.png'}">
                </div>

                    <#if verification??>

                    <table  class="table table-condensed">
                        <thead>
                        <tr>
                            <th>验证信息</th>
                            <th></th>


                        </tr>
                        </thead>
                        <tbody>
                        <tr  >
                            <td class="active">揽货验证密码：</td>
                            <td >    <input type="text" id="demandNum" name="demandNum"  placeholder="测试-揽货密码" value="${verification.code}"/></td>
                        </tr>
                        <tr>
                            <td class="active">验证二维码</td>
                            <td>


                                <script type="text/javascript" src="/qrcode.js"></script>
                                <input id="text" type="text" value="${qrcodeContent!''}" style="width:80%" />
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

                                        /*                           if (!elText.value) {
                                                                       alert("Input a text");
                                                                       elText.focus();
                                                                       return;
                                                                   }*/


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
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    </#if>

                </div>



                </div>
                <#else>
                <div class="col-lg-12">
                    <form id="longitudeLatitudeForm" class="navbar-form" role="search" action="${getUrl}">
                        <input  type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                        <div class="form-group">
                            <input class="input-lg" type="text" class="form-control" name="code" placeholder="" value="">
                        </div>

                        <button id="longitudeLatitudeFormFormBtn" type="button" class="btn btn-primary  btn-lg">提取</button>
                    </form>

                    <script  type="text/javascript">

                        $("#longitudeLatitudeFormFormBtn").click(function() {
                            alert($('#longitudeLatitudeForm').serialize());
                            var req = $.ajax({
                                url:  $('#longitudeLatitudeForm').attr('action'),
                                type: 'POST',
                                data:  $('#longitudeLatitudeForm').serialize(),
                            });
                            req.done(function (data) {
                                alert("成功:"+data.message);

                                if (data.status) {
                                    alert("成功:"+data.message);

                                    window.location.href = data.url;
                                } else {
                                    alert(data.message);
                                }
                            });
                        });
                    </script>

                </div>

                </#if>

                </div>

            </div>
        </div>
    </div>


    </div>
    <div class="tab-pane " id="account">
    <div class="row" style="padding-top: 10px;padding-bottom: 10px">
        <div class="col-lg-6">
            <ul class="list-group">
                <li class="list-group-item">名称：${person.realName!''}</li>
                <li class="list-group-item">编号： ${user.userId!''}</li>
                <li class="list-group-item">电话： ${user.mobile!''}${person.phoneNumber!''}</li>



                <li class="list-group-item">是否绑定平台：
                <#if deliveryOrderMap.status?? && deliveryOrderMap.status =="Valid">

                    有效
                <#else>
                    无效
                </#if>
                    微信扫一扫 关注 货源信息
                    <input id="text" type="hidden" value="${qrcodeContent!'我啊你你'}" style="width:80%" />

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

                    <button id="" type="button" class="btn btn-primary"  data-toggle="modal" data-target="#boundDistributorModal">
                        绑定
                    </button>

                    <button id="" type="button" class="btn btn-primary"  data-toggle="modal" data-target="#getBoundDistributorQrcodeModal">
                        获取绑定二维码
                    </button>

                    <script type="text/javascript">


                        function refresh() {
                            $('#station-table').bootstrapTable('refresh');
                        }

                        function selectedRow_() {
                            var row =  $('#station-table').bootstrapTable('getSelections');
                            return row;
                        }


                        $("#boundBtn").click(function() {
                            var row = selectedRow_();
                            $('#boundDistributorModal').modal();

                            if (row != '') {
                                $('#boundDistributorModal').modal();
                                //   alert(JSON.stringify(row[0]));
                                //   $('#addStationModalForm .companyId').val(row[0].id);

                            }
                        });



                    </script>


                </li>




                <li class="list-group-item">类型： ${deliveryOrderMap.type!''}

                    <button id="beTraderRequestBtn" type="button" class="btn btn-primary"  data-toggle="modal" data-target="#beTraderRequestModal">
                        申请成交易商
                    </button>



                </li>

            </ul>

        </div>
</div>
    </div>





    <div class="tab-pane" id="transfer" style="padding-top: 10px;padding-bottom: 10px">
        <div id="toolbar_inventory" class="btn-group" >

            <button id="viewCapacityBtn" type="button" class="btn btn-success">
                <i class="">查看详情</i>
            </button>

            <script type="text/javascript">


                function refresh() {
                    $('#station-table').bootstrapTable('refresh');
                }

                function selectedRow_() {
                    var row =  $('#station-table').bootstrapTable('getSelections');
                    return row;
                }


                $("#editBtn").click(function() {
                    var row = selectedRow_();

                    if (row != '') {
                        $('#addStationModal').modal();
                        alert(JSON.stringify(row[0]));
                        $('#addStationModalForm .companyId').val(row[0].id);

                    }
                });



            </script>


        </div>

        <table class=" table-striped" id="companies-table" data-url="${transferUrl!''}" data-toggle="table" data-classes="table table-hover"   data-method="GET"
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
               data-toolbar="#toolbar_inventory">
            <thead>
            <tr>



                <th data-field="createDate">名称</th>


                <th data-field="plateNumber">车牌号</th>
                <th data-field="amount">净重</th>


                <th data-field="status">余额</th>

                <th data-field="description">描述</th>

            <#--
                                            <th data-field="companyName | senderCompanyName"  data-formatter="companyInfoFormatter">发送者</th>
            -->
            </tr>
            </thead>
        </table>

    </div>
    <div class="tab-pane " id="deliveryOrer" style="padding-top: 10px;padding-bottom: 10px">
        <div id="toolbar_producer" class="btn-group" >
            <a id="addBtn"  type="button" href="${producerUrl!''}" class="btn btn-primary"  >
                开户
            </a>
        </div>



        <table class=" table-striped" id="delivery-table" data-url="${openAccountproducerUrl!''}" data-toggle="table" data-classes="table table-hover"   data-method="GET"
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
               data-search="true"
               data-show-refresh="true"
               data-toolbar="#toolbar_producer"
               >
            <thead>
            <tr>
                <th data-field="state" data-radio="true"></th>
                <th data-field="createDate">时间</th>

                <th data-field="name">名称</th>

                <th data-field="no">编号</th>

                <th data-field="automaticStatus">实属提煤系统</th>

                <th data-field="status">状态</th>

                <th data-field="status" data-formatter="operationInfoFormatter">操作</th>

            </tr>
            </thead>
        </table>

    </div>
    <div class="tab-pane " id="capital" style="padding-top: 10px;padding-bottom: 10px">
        <div id="toolbar_advancedPayment" class="btn-group" >



            <button id="addBtn" type="button" class="btn btn-primary"  data-toggle="modal" data-target="#addLineModal">
                添加
            </button>

            <script type="text/javascript">


                function refresh() {
                    $('#station-table').bootstrapTable('refresh');
                }

                function selectedRow_() {
                    var row =  $('#station-table').bootstrapTable('getSelections');
                    return row;
                }


                $("#editBtn").click(function() {
                    var row = selectedRow_();

                    if (row != '') {
                        $('#addStationModal').modal();
                        alert(JSON.stringify(row[0]));
                        $('#addStationModalForm .companyId').val(row[0].id);

                    }
                });



            </script>


        </div>

        <table class=" table-striped" id="companies-table" data-url="${advancedPaymentTransferUrl!''}" data-toggle="table" data-classes="table table-hover"   data-method="GET"
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
               data-toolbar="#toolbar_advancedPayment">
            <thead>
            <tr>



                <th data-field="createDate">时间</th>




                <th data-field="amount">发生金额</th>

                <th data-field="credit">贷</th>
                <th data-field="debit">借</th>
                <th data-field="balance">余额</th>
                <th data-field="description">描述</th>

            <#--
                                            <th data-field="companyName | senderCompanyName"  data-formatter="companyInfoFormatter">发送者</th>
            -->
            </tr>
            </thead>
        </table>

    </div>



    <div class="tab-pane " id="employee" style="padding-top: 10px;padding-bottom: 10px">


    <div class="">

        <a id="addBtn"  href="${employeeUrl!''}" class="btn btn-defualt"  >
            管理员工
        </a>        <div id="toolbar_employee" class="btn-group" >




            <script type="text/javascript">


                function refresh() {
                    $('#station-table').bootstrapTable('refresh');
                }

                function selectedRow_() {
                    var row =  $('#station-table').bootstrapTable('getSelections');
                    return row;
                }


                $("#editBtn").click(function() {
                    var row = selectedRow_();

                    if (row != '') {
                        $('#addStationModal').modal();
                        alert(JSON.stringify(row[0]));
                        $('#addStationModalForm .companyId').val(row[0].id);

                    }
                });



            </script>


        </div>

        <table class=" table-striped" id="companies-table" data-url="${employeeUrl}" data-toggle="table" data-classes="table table-hover"   data-method="GET"
               data-content-type="application/x-www-form-urlencoded; charset=UTF-8"
               data-query-params-type="unlimit"
               data-query-params="queryParams"
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
               data-toolbar="#toolbar_employee">
            <thead>
            <tr>



                <th data-field="createDate">名称</th>


                <th data-field="name">名字</th>
                <th data-field="phone">手机号</th>



            </tr>
            </thead>
        </table>

        <div id="tradeCountContainer" style="width:100%; height: 400px"></div>
    </div>

    </div>

    </div>

</div>




</div>

<div id="beTraderRequestModal" class="modal fade" role="dialog">
    <div id="login-overlay" class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">与平台帐号绑定</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12">
                        <form id="beTraderRequestModalForm"   novalidate="novalidate" action="${beTraderRequestUrl!''}">
                            <input style="margin-bottom: 15px;" type="" placeholder="" class="companyId hidden" name="id" value="${deliveryOrder.id!''}"  >
                            <div class="form-group">
                                <label for="username" class="control-label">编号</label>
                                <input style="margin-bottom: 15px;" type="" placeholder="no" class="companyId form-control input-lg" name="no" value=""  >
                                <span class="help-block"></span>
                            </div>
                            <button id="beTraderRequestModalFormBtn"  type="buttom" data-dismiss="modal"   class="btn btn-primary ">确定</button>
                        </form>
                        <script  type="text/javascript">

                            $("#beTraderRequestModalFormBtn").click(function() {
                                alert($('#beTraderRequestModalForm').serialize());

                                var req = $.ajax({
                                    url:  $('#beTraderRequestModalForm').attr('action'),
                                    type: 'post',
                                    data:  $('#beTraderRequestModalForm').serialize(),
                                });
                                req.done(function (data) {
                                    if (data.status) {
                                        alert("成功:"+data.message);
                                        window.location.reload(true);
                                    } else {
                                        alert(data.message);
                                    }
                                });
                            });
                        </script>

                    </div>
                </div>




            </div>
        </div>
    </div>
</div>
<div id="getBoundDistributorQrcodeModal" class="modal fade" role="dialog">
    <div id="login-overlay" class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">获取绑定二维码</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12">
                        <form id="getBoundDistributorQrcodeModalForm"   novalidate="novalidate" action="${getBindQrcodeUrl!''}">
                            <input style="margin-bottom: 15px;" type="" placeholder="" class="companyId hidden" name="id" value="${deliveryOrder.id!''}"  >
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                            <div class="form-group">
                                <label for="username" class="control-label">编号</label>
                                <input style="margin-bottom: 15px;" type="" placeholder="no" class="companyId form-control input-lg" name="no" value=""  >

                                <span class="help-block"></span>
                            </div>


                        <#--
                                                        <div class="form-group">
                                                            <label for="username" class="control-label">位置</label>

                                                            <select class="selectpicker" &lt;#&ndash;data-max-options="2" &ndash;&gt; id="departureStation" name="departureStation" class="form-control" placeholder="特征">
                                                            &lt;#&ndash; <select class="form-control select2" id="userType" name="userType"  placeholder="公司类型"  multiple="multiple">&ndash;&gt;

                                                            <#if stations??>
                                                                <#list stations as feature>
                                                                    <option value="${feature.id}" >${feature.id!''}--${feature.name!''}--${feature.description!''}</option>

                                                                </#list>
                                                            </#if>

                                                            </select>



                                                            </select>
                                                            <span class="help-block"></span>
                                                        </div>

                            -->

                            <button id="getBoundDistributorQrcodeModalFormBtn"  type="buttom" data-dismiss="modal"   class="btn btn-primary ">确定</button>
                        </form>
                        <script  type="text/javascript">

                            $("#getBoundDistributorQrcodeModalFormBtn").click(function() {
                                alert($('#getBoundDistributorQrcodeModalForm').serialize());

                                var req = $.ajax({
                                    url:  $('#getBoundDistributorQrcodeModalForm').attr('action'),
                                    type: 'post',
                                    data:  $('#getBoundDistributorQrcodeModalForm').serialize(),
                                });
                                req.done(function (data) {
                                    if (data.status) {
                                        alert("成功:"+data.message);
                                        window.location.reload(true);
                                    } else {
                                        alert(data.message);
                                    }
                                });
                            });
                        </script>

                    </div>
                </div>




            </div>
        </div>
    </div>
</div>

<div id="addLineModal" class="modal fade" role="dialog">
    <div id="login-overlay" class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">输入当前库存</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="well">

                            <form id="addLineModalForm"   novalidate="novalidate" action="${addInventoryUrl!''}">
                                <input style="margin-bottom: 15px;" type="" placeholder="" class="companyId hidden" name="id" value="${deliveryOrder.id}"  >


                                <div class="form-group">
                                    <label for="username" class="control-label">数量</label>
                                    <input style="margin-bottom: 15px;" type="" placeholder="数量" class="companyId form-control input-lg" name="amount" value=""  >


                                    <span class="help-block"></span>
                                </div>


                            <#--
                                                            <div class="form-group">
                                                                <label for="username" class="control-label">位置</label>

                                                                <select class="selectpicker" &lt;#&ndash;data-max-options="2" &ndash;&gt; id="departureStation" name="departureStation" class="form-control" placeholder="特征">
                                                                &lt;#&ndash; <select class="form-control select2" id="userType" name="userType"  placeholder="公司类型"  multiple="multiple">&ndash;&gt;

                                                                <#if stations??>
                                                                    <#list stations as feature>
                                                                        <option value="${feature.id}" >${feature.id!''}--${feature.name!''}--${feature.description!''}</option>

                                                                    </#list>
                                                                </#if>

                                                                </select>



                                                                </select>
                                                                <span class="help-block"></span>
                                                            </div>

                                -->

                                <button id="addLineModalFormBtn"  type="buttom" data-dismiss="modal"   class="btn btn-primary ">确定</button>
                            </form>
                            <script  type="text/javascript">

                                $("#addLineModalFormBtn").click(function() {
                                    alert($('#addLineModalForm').serialize());

                                    var req = $.ajax({
                                        url:  $('#addLineModalForm').attr('action'),
                                        type: 'post',
                                        data:  $('#addLineModalForm').serialize(),
                                    });
                                    req.done(function (data) {
                                        if (data.status) {
                                            alert("成功:"+data.message);
                                            window.location.reload(true);
                                        } else {
                                            alert(data.message);
                                        }
                                    });
                                });
                            </script>
                        </div>


                    </div>
                </div>




            </div>
        </div>
    </div>
</div>




<div id="boundDistributorModal" class="modal fade" role="dialog">
    <div id="login-overlay" class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">与平台帐号绑定</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12">
                        <form id="addLineModalForm"   novalidate="novalidate" action="${addInventoryUrl!''}">
                            <input style="margin-bottom: 15px;" type="" placeholder="" class="companyId hidden" name="id" value="${deliveryOrder.id!''}"  >


                            <div class="form-group">
                                <label for="username" class="control-label">编号</label>
                                <input style="margin-bottom: 15px;" type="" placeholder="no" class="companyId form-control input-lg" name="no" value=""  >


                                <span class="help-block"></span>
                            </div>


                            <button id="addLineModalFormBtn"  type="buttom" data-dismiss="modal"   class="btn btn-primary ">确定</button>
                        </form>
                        <script  type="text/javascript">

                            $("#addLineModalFormBtn").click(function() {
                                alert($('#addLineModalForm').serialize());

                                var req = $.ajax({
                                    url:  $('#addLineModalForm').attr('action'),
                                    type: 'post',
                                    data:  $('#addLineModalForm').serialize(),
                                });
                                req.done(function (data) {
                                    if (data.status) {
                                    if (data.status) {
                                        alert("成功:"+data.message);
                                        window.location.reload(true);
                                    } else {
                                        alert(data.message);
                                    }
                                });
                            });
                        </script>

                    </div>
                </div>




            </div>
        </div>
    </div>
</div>



<script type="text/javascript">
    function queryParams(params) {
        params.page = params.pageNumber - 1;
        params.size = params.pageSize;
        var status = $.trim($("#status").val());


        if (status) {
            params.status = status;
        }

        return params;
    }


    function handleResponse(original) {
        var res = {};
        res.rows = original.content;
        res.total = original.totalElements;

        return res;
    }




</script>
</body>
</html>