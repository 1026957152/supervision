<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>榆林煤 库存作业</title>
    <link href="${rc.contextPath}/components/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${rc.contextPath}/components/bootstrap-select/css/bootstrap-select.min.css" rel="stylesheet">

    <script src="${rc.contextPath}/js/jquery/jquery.js" type="text/javascript"></script>
   <script src="${rc.contextPath}/components/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

    <style type="text/css">


        .target-fix {
            padding-top: 45px;
            margin-top: -10px;
            display: block;
            height: 0;
            overflow: hidden;
        }

        .first {
            width: 10%;
        }

        .second {
            width: 30%;
        }
        .third {
            width: 40%;
        }

        .forth {
            width: 10%;
        }

        .img-comment-list  > div {
            display:table-cell;
        }

        .img-comment-list img {
            border-radius:50%;
            width: 80px;
            height: 80px;
            margin-right: 10px;
            margin-top: 20px;
        }

        .img-comment-list p {
            margin: 0;
        }

        .img-comment-list span {
            font-size: .8em;
            color: #aaa;
        }

        .xs-first {
            width: 25%;
        }

        .xs-second {
            width: 25%;
        }
    </style>



</head>

<body>
<div class="container" style="margin-bottom:80px; margin-top:10px ">
<h1 class="page-header">
    <small>配置</small>
</h1>


    <div class="row "  >


        <div class="col-sm-12">
        <ul class="nav nav-tabs" id="ajaxTabs" role="tablist">
            <li class="active"><a href="#companies" data-url="ajax/2.html" role="tab" data-toggle="tab" aria-expanded="false"><strong>统计项目</strong> <span class="badge"></span></a></li>
            <li class=""><a href="#transfer" data-url="ajax/2.html" role="tab" data-toggle="tab" aria-expanded="false"><strong>包含元素</strong> <span class="badge"></span></a></li>

            <li class=""><a href="#reconciliation" data-url="ajax/2.html" role="tab" data-toggle="tab" aria-expanded="false"><strong>对账单</strong> <span class="badge"></span></a></li>

        </ul>
             <div  class="tab-content" style="padding-top: 10px;padding-bottom: 10px">


                    <div class="tab-pane active" id="companies">

                        <div id="toolbar" class=" " >




                                      <button id="addBtn" type="button" class="btn btn-primary"  data-toggle="modal" data-target="#addLineModal">
                                          新建统计项目
                                             </button>

                            <script type="text/javascript">


                                function refresh() {
                                    $('#station-table').bootstrapTable('refresh');
                                }

                                function selectedRow_() {
                                    var row =  $('#instance-table').bootstrapTable('getSelections');
                                    return row;
                                }


                                $("#editBtn").click(function() {
                                    var row = selectedRow_();

                                    if (row != '') {
                                        $('#editLineModal').modal();
                                        alert(JSON.stringify(row[0]));
                                        $('#instanceId').val(row[0].id);

                                    }
                                });



                            </script>


                        </div>


                        <table class=" table-striped" id="instance-table" data-url="${porformanceObjectUrl!''}" data-toggle="table" data-classes="table table-hover"   data-method="GET"
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
                                data-toolbar="#toolbar">
                            <thead>
                            <tr>

                                <th data-field="state" data-checkbox="true"></th>

                                <th data-field="createDate">时间</th>
                                <th data-field="name">name</th>


                                <th data-field="status" >状态</th>
                                <th data-field="description" >描述</th>

<#--
                                <th data-field="companyName | senderCompanyName"  data-formatter="companyInfoFormatter">发送者</th>
-->
                            </tr>
                            </thead>
                        </table>

                 </div>
                 <div class="tab-pane " id="transfer">

                     <div id="transfer_toolbar" class="" >

                         <select class="selectpicker" data-max-options="2"  id="object-selectpicker" name="feature" class="form-control" placeholder="开户分销商">

                         <#if porformanceObjects??>
                             <#list porformanceObjects as feature>
                                 <option value="${feature.id}" >${feature.id!''}--${feature.name!''}</option>

                             </#list>
                         </#if>

                         </select>

                         <button id="addBtn" type="button" class="btn btn-primary"  data-toggle="modal" data-target="#addItemModal">
                             添加元素
                         </button>



                     <#--                     <button id="addBtn" type="button" class="btn btn-primary"  data-toggle="modal" data-target="#addLineModal">
                                              添加
                                          </button>-->

                         <script type="text/javascript">


                             function refresh() {
                                 $('#station-table').bootstrapTable('refresh');
                             }

                             function selectedRow_transfer() {
                                 var row =  $('#transfer-table').bootstrapTable('getSelections');
                                 return row;
                             }


                             $("#createReconciliationBtn").click(function() {
                                 var row = selectedRow_transfer();

                                 if (row != '') {
                                     $('#editLineModal').modal();
                                     alert(JSON.stringify(row[0]));
                                     $('#instanceId').val(row[0].id);

                                 }
                             });



                         </script>



                     </div>
                     <table class=" table-striped" id="object-item-table" data-url="${performanceObjectItemsUrl!''}" data-toggle="table" data-classes="table table-hover"   data-method="GET"
                            data-content-type="application/x-www-form-urlencoded; charset=UTF-8"
                            data-query-params-type="unlimit"
                            data-query-params="queryParams_item"
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
                            data-toolbar="#transfer_toolbar">
                         <thead>
                         <tr>





                             <th data-field="state" data-checkbox="true"></th>

                             <th data-field="createDate">时间</th>
                             <th data-field="name">元素编号</th>

                             <th data-field="status" >状态</th>
                             <th data-field="reconcileStatus" >对账状态</th>



                         </tr>
                         </thead>
                     </table>

                 </div>



                    <div class="tab-pane " id="reconciliation">

                        <div id="reconciliation_toolbar" class="" >

                            <select class="selectpicker" data-max-options="2"  id="feature" name="feature" class="form-control" placeholder="开户分销商">

                            <#if distributors??>
                                <#list distributors as feature>
                                    <option value="${feature.id}" >${feature.id!''}--${feature.displayName!''}</option>

                                </#list>
                            </#if>

                            </select>


                            <button id="createReconciliationBtn" type="button" class="btn btn-primary" >
                                建立对账系统
                            </button>

                        <#--                     <button id="addBtn" type="button" class="btn btn-primary"  data-toggle="modal" data-target="#addLineModal">
                                                 添加
                                             </button>-->

                            <script type="text/javascript">


                                function refresh() {
                                    $('#station-table').bootstrapTable('refresh');
                                }

                                function selectedRow_transfer() {
                                    var row =  $('#transfer-table').bootstrapTable('getSelections');
                                    return row;
                                }


                                $("#createReconciliationBtn").click(function() {
                                    var row = selectedRow_transfer();

                                    if (row != '') {
                                        $('#editLineModal').modal();
                                        alert(JSON.stringify(row[0]));
                                        $('#instanceId').val(row[0].id);

                                    }
                                });



                            </script>


                        </div>
                        <table class=" table-striped" id="transfer-table" data-url="${reconciliationUrl!''}" data-toggle="table" data-classes="table table-hover"   data-method="GET"
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
                               data-toolbar="#reconciliation_toolbar">
                            <thead>
                            <tr>




                                <th data-field="state" data-checkbox="true"></th>
                                <th data-field="no" >编号</th>
                                <th data-field="createDate">开始时间</th>
                                <th data-field="periodBeginDate">开始时间</th>
                                <th data-field="periedEndDate">结束时间</th>
                                <th data-field="distributor" data-formatter="companyInfoFormatter">分销商</th>

                                <th data-field="inventoryNo" >产品编号</th>
                                <th data-field="totalAmount" >金额</th>

                                <th data-field="totalQuantity" >数量</th>
                                <th data-field="status" >状态</th>
                                <th data-field="no" >编号</th>
                                <th data-field="no"  data-formatter="reconciliationOperationFormatter">操作</th>



                            </tr>
                            </thead>
                        </table>

                    </div>

             </div>


        </div>




    </div>


<div id="addLineModal" class="modal fade" role="dialog">
    <div id="login-overlay" class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">添加区域</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="well">

                            <form id="addLineModalForm"   novalidate="novalidate" action="{command_create_url}">
                                <input style="margin-bottom: 15px;" type="" placeholder="Username" class="companyId hidden" name="companyId" value=""  >








                                <div class="form-group">
                                    <label for="username" class="control-label">名称</label>
                                    <input style="margin-bottom: 15px;" type="" placeholder="Username" class="companyId form-control" name="lineName" value=""  >


                                    <span class="help-block"></span>
                                </div>


                                <div class="form-group">
                                    <label for="username" class="control-label">描述</label>
                                    <input style="margin-bottom: 15px;" type="" placeholder="Username" class="companyId form-control" name="description" value=""  >
                                    <span class="help-block"></span>
                                </div>



                                <div class="form-group">
                                    <label for="username" class="control-label">位置</label>

                                    <select class="selectpicker" <#--data-max-options="2" --> id="departureStation" name="departureStation" class="form-control" placeholder="特征">
                                    <#-- <select class="form-control select2" id="userType" name="userType"  placeholder="公司类型"  multiple="multiple">-->

                                    <#if stations??>
                                        <#list stations as feature>
                                            <option value="${feature.id}" >${feature.id!''}--${feature.name!''}--${feature.description!''}</option>

                                        </#list>
                                    </#if>

                                    </select>



                                    </select>
                                    <span class="help-block"></span>
                                </div>

                                <div class="form-group">
                                    <label for="username" class="control-label">位置</label>

                                    <select class="selectpicker" <#--data-max-options="2" --> id="arrivalStation" name="arrivalStation" class="form-control" placeholder="特征">
                                    <#-- <select class="form-control select2" id="userType" name="userType"  placeholder="公司类型"  multiple="multiple">-->

                                    <#if stations??>
                                        <#list stations as feature>
                                            <option value="${feature.id}" >${feature.id!''}--${feature.name!''}--${feature.description!''}</option>

                                        </#list>
                                    </#if>

                                    </select>



                                    </select>
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

<div id="editLineModal" class="modal fade" role="dialog">
    <div id="login-overlay" class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">录入皮重</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="well">

                            <form id="editLineModalForm"   novalidate="novalidate" action="${createTransferUrl!''}">
                                <input style="margin-bottom: 15px;" id="instanceId" type="" placeholder="Username" class="id " name="instanceId" value=""  >
                                <input type="hidden" name="{_csrf.parameterName}" value="{_csrf.token}"/>

                                <div class="form-group">
                                    <label for="username" class="control-label">毛重</label>
                                    <input style="margin-bottom: 15px;" type="" placeholder="毛重" class="name form-control input-lg" name="grossWeight" value=""  >


                                    <span class="help-block"></span>
                                </div>


                                <div class="form-group">
                                    <label for="username" class="control-label">描述</label>
                                    <input style="margin-bottom: 15px;" type="" placeholder="Username" class="description form-control" name="description" value=""  >
                                    <span class="help-block"></span>
                                </div>



                                <button id="editLineModalFormBtn"  type="buttom" data-dismiss="modal"   class="btn btn-primary ">确定</button>
                            </form>
                            <script  type="text/javascript">

                                $("#editLineModalFormBtn").click(function() {
                                    alert($('#editLineModalForm').serialize());

                                    var req = $.ajax({
                                        url:  $('#editLineModalForm').attr('action'),
                                        type: 'post',
                                        data:  $('#editLineModalForm').serialize(),
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

<#--<#include "./common/page_foot_section.ftl">-->

<div id="addItemModal" class="modal fade" role="dialog">
    <div id="login-overlay" class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">添加元素</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="well">

                            <form id="addItemModalForm"   novalidate="novalidate" action="${add_item_url}">
                                <input style="margin-bottom: 15px;" type="" placeholder="Username" class="companyId hidden" name="companyId" value=""  >
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>



                                <div class="form-group">
                                    <label for="username" class="control-label">编号</label>
                                    <input style="margin-bottom: 15px;" type="" placeholder="Username" class="companyId form-control" name="no" value=""  >


                                    <span class="help-block"></span>
                                </div>




                                <button id="addItemModalFormBtn"  type="buttom" data-dismiss="modal"   class="btn btn-primary ">确定</button>
                            </form>
                            <script  type="text/javascript">

                                $("#addItemModalFormBtn").click(function() {
                                    alert($('#addItemModalForm').serialize());

                                    var req = $.ajax({
                                        url:  $('#addItemModalForm').attr('action'),
                                        type: 'post',
                                        data:  $('#addItemModalForm').serialize(),
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





</body>
<script type="text/javascript" src="${rc.contextPath}/components/bootstrap_table/bootstrap-table.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/components/bootstrap_table/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/components/bootstrap-select/js/bootstrap-select.min.js"></script>

<script>

    $('#object-selectpicker').on('change', function(){
        var selected = $(this).find("option:selected").val();
        $('#object-item-table').bootstrapTable('refresh');
    });

</script>
<script type="text/javascript">
function originToDestinationInfoFormatter(value, row, index) {



    return '<div class="">'  + row.origin  +
            '<hr style="margin-top: 0px;       margin-bottom: 0px;" >'   +'<span class="pull-right" style="   margin-bottom: 0px; padding-bottom: 0px; ">'+ row.destination  +'</span></div>';

}
    function queryParams_item(params) {
        params.page = params.pageNumber - 1;
        params.size = params.pageSize;

        var sender = $.trim($("#search_param").val());

        if (sender) {
            params.q = sender;
        }

        var feature = $.trim($("#feature-selectpicker").val());

        if (feature) {
            params.objectId = feature;
        }

        //  alert(JSON.stringify(sender))
        return params;
    }

    function queryParams(params) {
        params.page = params.pageNumber - 1;
        params.size = params.pageSize;

        var sender = $.trim($("#search_param").val());

        if (sender) {
            params.q = sender;
        }
        //alert(JSON.stringify(sender))
        return params;
    }
    $('#supplies-table').bootstrapTable({
        onLoadSuccess: function (data) {
            $('[data-trigger="hover"]').popover();

        }
    });



    function companyInfoFormatter(value, row, index) {


        return   '<strong><a href="'+ row.distributorUrl + '">' + row.distributor  + '</a></strong>';



    }

  /*  function companyInfoFormatter(value, row, index) {



        var inventories = "";
        $.each(row.inventories, function (n, value) {
            //  alert(n + ' ' + value);
            var trs = "";
            trs += "<a href='"+value.storageUrl+"'>" + value.storageName + "</a> 存 " + value.quantityOnHand + " 吨 ";
            inventories += trs;
        });

        var indicators = "";
        $.each(row.indicators, function (n, value) {
            //  alert(n + ' ' + value);
            var trs = "";
            trs += "" + value.symbol + " " + value.value + "  "+value.unit;
            indicators += trs;
        });

        return "    <div class='col-sm-3 no-padding photobox'>"+
        '                <div class=" carousel-row">'+
                ' <div class=" slide-row">'+
                ' <div id="carousel-1" class="carousel slide slide-carousel" data-ride="carousel">'+
                '  <!-- Indicators -->'+
        '  <ol class="carousel-indicators">'+
        '  <li data-target="#carousel-1" data-slide-to="0" class="active"></li>'+
        '  <li data-target="#carousel-1" data-slide-to="1"></li>'+
        '  <li data-target="#carousel-1" data-slide-to="2"></li>'+
        '  </ol>'+

        '      <!-- Wrapper for slides -->'+
        '   <div class="carousel-inner">'+
        '          <div class="item active">'+
        '           <img src="'+row.companyLogoUrl+'" alt="Image">'+
        '             </div>'+

        '  </div>'+
        '   </div>'+
        '    <div class="slide-content">'+
        '          <h4><a href=" '+ row.companyUrl + '">'+ row.companyName+'<a></h4>'+

        '  </div>'+
        '  </div>'+

        '    </div>'+
        '    </div>'+

        '    </div>'+

            //row.companyDesc+


    '<div class="col-sm-7 add-desc-box">'+
               ' <div class="add-details">'+
               ' <h4 class="add-title"> <a href="'+row.url+'"> '+ row.granularity+' </a> <small>'+  row.companyAddress+'</small> </h4>'+
    ' <span class="info-row"> <span class="add-type business-ads tooltipHere" data-toggle="tooltip" data-placement="right" title="Business Ads"> </span> <span class="date"><i class=" icon-clock"> </i> '+row.updateTime+' </span>  <span class="category"> </span> <span class="item-location"><i class="fa fa-map-marker"> '+   row.companyAddress+'</i>  </span> </span> </div>'+
       '<hr>'+
        inventories+'<br>'+indicators+'<br>'+


       ' </div>'+
        '  <div class="slide-footer hidden">'+
        '        <span class="pull-right buttons">'+
        '         <button class="btn btn-sm btn-default"><i class="fa fa-fw fa-eye"></i> Show</button>'+
        '    <button class="btn btn-sm btn-primary"><i class="fa fa-fw fa-shopping-cart"></i> Buy</button>'+
        '    </span>'+
        '    </div>';

    }

*/
    function supplyCompanyInfoFormatter(value, row, index) {


        var warehouseInfo = "";

        warehouseInfo = "堆场名称：" + row.warehouseStatistic.name +"\n" +
                "当前正在装车： " +row.warehouseStatistic.countShipmentsLoading + "\n" +
                "当前等待装车：" + row.warehouseStatistic.countShipmentsCreated+ "\n" ;



        return  '                <div class=" carousel-row" data-trigger="hover" title="'+row.companyDesc+ '" data-content="'+ warehouseInfo+'" >'+
                ' <div class=" slide-row">'+
                ' <div id="carousel-1" class="carousel slide slide-carousel" data-ride="carousel">'+
                '  <!-- Indicators -->'+
        '      <!-- Wrapper for slides -->'+

        '          <div class="item active">'+
        '           <img src="logo.png" alt="Image">'+
        '          </div>'+

        '   </div>'+
        '    <div class="slide-content">'+
        '          <h4><a href=" '+ row.companyUrl + '"> '+ row.companyName+'<a></h4>'+
        '    <p>'+

        '    </p>'+
        '  </div>'+

        '    </div>';

    }


    function supplyInfoFormatter(value, row, index) {




        var List = row.qualityItems;
        var personString = "";
        for(var student in List){ //第二层循环取list中的对象
            personString += "<strong>"+List[student].qualityItemName +" "+List[student].exp+ " "+List[student].value+"</strong> |";
        }


        return  " <h3><a class='' href='"+row.url+"'>"+row.coalCategory+" - "+row.granularity+"- <strong>￥"+row.price+"</strong></a></h3>" +
         "       <p class='muted'>地址：<strong>"+row.deliveryPlace+"</strong></p>"+
        "<p class='muted'>发布时间："+row.createdDateString+"<a href='#' class='underline'>Cars, Vans &amp; Motorbikes</a></p>"+
        "<p>"+row.qualityContent+"</p>"+

                "  <p class='ad-description'>"+
                personString +

                " </p>";

    }

    function refresh() {
      //  $('#role-table').bootstrapTable('refresh');
        // $('#capacity-table').bootstrapTable('refresh');
        $('#companies-table').bootstrapTable('refresh');


    }

    function handleResponse(original) {
        var res = {};
        res.rows = original.content;
        res.total = original.totalElements;
       // alert(JSON.stringify(original));
        return res;
    }

function reconciliationOperationFormatter(value, row, index) {


    return   '<strong><a href="'+ row.url + '">操作</a></strong>';



}

$(function(){

    $('.selectpicker').selectpicker();



    $('.searchBtn').bind('click', function(){
        refresh();

    });






})
</script>

</html>