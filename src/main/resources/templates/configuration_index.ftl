<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>榆林煤 配置  ${no}</title>
    <link href="${rc.contextPath}/components/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${rc.contextPath}/components/bootstrap-select/css/bootstrap-select.min.css" rel="stylesheet">

    <script src="${rc.contextPath}/js/jquery/jquery.js" type="text/javascript"></script>
   <script src="${rc.contextPath}/components/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>


</head>

<body>
<div class="container" style="margin-bottom:80px; margin-top:10px ">
<h1 class="page-header">
    <small>配置</small> ${no}
</h1>


    <div class="row "  >


        <div class="col-sm-12">
        <ul class="nav nav-tabs" id="ajaxTabs" role="tablist">
            <li class="active"><a href="#companies" data-url="ajax/2.html" role="tab" data-toggle="tab" aria-expanded="false"><strong>统计项目</strong> <span class="badge"></span></a></li>
            <li class=""><a href="#transfer" data-url="ajax/2.html" role="tab" data-toggle="tab" aria-expanded="false"><strong>包含元素</strong> <span class="badge"></span></a></li>
            <li class=""><a href="#statistic" data-url="ajax/2.html" role="tab" data-toggle="tab" aria-expanded="false"><strong>统计数据</strong> <span class="badge"></span></a></li>
            <li class=""><a href="#open_acount_producer" data-url="ajax/2.html" role="tab" data-toggle="tab" aria-expanded="false"><strong>开户煤矿</strong> <span class="badge"></span></a></li>

            <li class=""><a href="#reportPage" data-url="ajax/2.html" role="tab" data-toggle="tab" aria-expanded="false"><strong>版面配置</strong> <span class="badge"></span></a></li>

        </ul>
             <div  class="tab-content" style="padding-top: 10px;padding-bottom: 10px">


                    <div class="tab-pane active" id="companies">

                        <div id="toolbar" class=" " >

                            <button id="addBtn" type="button" class="btn btn-primary"  data-toggle="modal" data-target="#addLineModal">
                                新建统计项目
                            </button>
                            <button id="setReportPageBtn" type="button" class="btn btn-primary"  >
                                设置展示版面
                            </button>



                            <script type="text/javascript">


                                function refresh() {
                                    $('#station-table').bootstrapTable('refresh');
                                }

                                function selectedRow_() {
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

                                $("#setReportPageBtn").click(function() {
                                    var row =  $('#instance-table').bootstrapTable('getSelections');

                                    if (row != '') {
                                        $('#setReportPageModal').modal();
                                        alert(JSON.stringify(row[0].uuid));
                                        $('#setReportPageModalForm .uuid').val(row[0].uuid);

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

                                <th data-field="page" >版面</th>

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
                             <option value="" >空</option>

                         <#if porformanceObjects??>
                             <#list porformanceObjects as feature>

                                 <option value="${feature.id}" >${feature.id!''}--${feature.name!''}</option>

                             </#list>
                         </#if>

                         </select>

                         <button id="addBtn" type="button" class="btn btn-primary"  data-toggle="modal" data-target="#addItemModal">
                             添加元素
                         </button>

                         <button id="deleteBtn" ref="${deleteElementUrl}" type="button" class="btn btn-primary"  >
                             删除元素
                         </button>


                     <#-- <button id="addBtn" type="button" class="btn btn-primary"  data-toggle="modal" data-target="#addLineModal">
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
                             $("#deleteBtn").click(function() {
                                 var row =  $('#object-item-table').bootstrapTable('getSelections');

                                 if (row != '') {

                                     alert(JSON.stringify(row[0]));
                             /*        $('#instanceId').val(row[0].id);*/
                                     var req = $.ajax({
                                         url: $(this).attr('ref') ,
                                         type: 'post',
                                         data:  {
                                             objectId: row[0].id

                                         }
                                     });
                                     req.done(function (data) {
                                         if (data.status) {
                                             alert("成功:"+data.message);
                                             window.location.reload(true);
                                         } else {
                                             alert(data.message);
                                         }
                                     });

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
                    <div class="tab-pane  " id="statistic">

                        <div id="reconciliation_toolbar" class="hidden" >

                            <select class="selectpicker" data-max-options="2"  id="feature" name="feature" class="form-control" placeholder="开户分销商">

                            <#if distributors??>
                                <#list distributors as feature>
                                    <option value="${feature.id}" >${feature.id!''}--${feature.displayName!''}</option>

                                </#list>
                            </#if>

                            </select>


                            <button id="createReconciliationBtn" type="button" class="btn btn-primary " >
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
                 <div class="tab-pane  " id="reportPage">


                     <div id="report_page_toolbar" class="" >
<#--
                         <select class="selectpicker" data-max-options="2"  id="producer_selectpicker" name="producers" class="form-control" placeholder="开户分销商">


                                <#list producers as feature>
                                    <option value="${feature.no}" >${feature.no!''}--${feature.name!''}</option>

                                </#list>

                         </select>-->


                         <button id="createReportPageBtn" type="button" class="btn btn-primary " >
                             新建版面
                         </button>

                         <button id="redirectReportPageBtn" type="button" class="btn btn-primary"  >
                             设置当前展示版面
                         </button>

                     <#--                     <button id="addBtn" type="button" class="btn btn-primary"  data-toggle="modal" data-target="#addLineModal">
                                              添加
                                          </button>-->

                         <script type="text/javascript">

                             $("#createReportPageBtn").click(function() {
                                 $('#createReportPageModal').modal();
                             });

                             $("#redirectReportPageBtn").click(function() {
                                 var row =  $('#report-page-table').bootstrapTable('getSelections');

                                 if (row != '') {
                                     $.post( "${focuseCommandUrl}", { 'uuid': row[0].uuid }, function( data ) {
                                         console.log( data.name ); // John
                                         console.log( data.time ); // 2pm
                                     }, "json");

/*                                     $('#createReportPageModal').modal();
                                     alert(JSON.stringify(row[0]));
                                     $('#instanceId').val(row[0].id);*/
                                 }
                             });

                         </script>
                     </div>

                     <table class=" table-striped" id="report-page-table" data-url="${reportPageUrl}" data-toggle="table" data-classes="table table-hover"   data-method="GET"
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
                            data-toolbar="#report_page_toolbar">
                         <thead>
                         <tr>




                             <th data-field="state" data-checkbox="true"></th>
                             <th data-field="uuid" >uuid</th>

                             <th data-field="seq" >序号</th>

                             <th data-field="name" >类型</th>


                             <th data-field="status" >状态</th>
                             <th data-field="no"  data-formatter="reconciliationOperationFormatter">操作</th>



                         </tr>
                         </thead>
                     </table>

                 </div>
                 <div class="tab-pane  " id="open_acount_producer">


                     <div id="open_acount_producer_toolbar" class="" >

                         <select class="selectpicker" data-max-options="2"  id="producer_selectpicker" name="producers" class="form-control" placeholder="开户分销商">


                                <#list producers as feature>
                                    <option value="${feature.no}" >${feature.no!''}--${feature.name!''}</option>

                                </#list>

                         </select>


<#--                         <button id="_createReportPageBtn" type="button" class="btn btn-primary " >
                             新建版面
                         </button>

                         <button id="_redirectReportPageBtn" type="button" class="btn btn-primary"  >
                             设置当前展示版面
                         </button>-->

                     <#--                     <button id="addBtn" type="button" class="btn btn-primary"  data-toggle="modal" data-target="#addLineModal">
                                              添加
                                          </button>-->

                         <script type="text/javascript">

                             $("#_createReportPageBtn").click(function() {
                                 $('#createReportPageModal').modal();
                             });

                             $("#_redirectReportPageBtn").click(function() {
                                 var row =  $('#report-page-table').bootstrapTable('getSelections');

                                 if (row != '') {
                                     $.post( "${focuseCommandUrl}", { 'uuid': row[0].uuid }, function( data ) {
                                         console.log( data.name ); // John
                                         console.log( data.time ); // 2pm
                                     }, "json");

                                     /*                                     $('#createReportPageModal').modal();
                                                                          alert(JSON.stringify(row[0]));
                                                                          $('#instanceId').val(row[0].id);*/
                                 }
                             });

                         </script>
                     </div>

                     <table class=" table-striped" id="inventory-table" data-url="${inventoryForProducerUrl}" data-toggle="table" data-classes="table table-hover"   data-method="GET"
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
                            data-toolbar="#open_acount_producer_toolbar">
                         <thead>
                         <tr>




                             <th data-field="state" data-checkbox="true"></th>
                             <th data-field="uuid" >uuid</th>

                             <th data-field="coalType" >coalType</th>

                             <th data-field="granularity" >类型</th>


                             <th data-field="status" >状态</th>
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

                                    <select class="selectpicker" id="departureStation" name="departureStation" class="form-control" placeholder="特征">
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

    <div id="setReportPageModal" class="modal fade" role="dialog">
        <div id="login-overlay" class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">设置版面</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="well">

                                <form id="setReportPageModalForm"   novalidate="novalidate" action="${involvePageUrl}">
                                    <input  id="instanceId" type="" placeholder="Username" class="uuid " name="uuid" value=""  >

                                    <div class="form-group">
                                        <label for="username" class="control-label">毛重</label>
                                        <input style="margin-bottom: 15px;" type="" placeholder="毛重" class="name form-control input-lg" name="grossWeight" value=""  >


                                        <span class="help-block"></span>
                                    </div>


                                    <div class="form-group">
                                        <label for="username" class="control-label">版面</label>

                                        <select class="selectpicker" <#--data-max-options="2" --> id="arrivalStation" name="pageUuid" class="form-control" placeholder="特征">
                                    <#list reportPages as feature>
                                        <option value="${feature.uuid}" >${feature.uuid}--${feature.name!''}--${feature.description!''}</option>

                                    </#list>
                                        </select>


                                        <span class="help-block"></span>
                                    </div>



                                </form>

                            </div>


                        </div>
                    </div>




                </div>
                <div class="modal-footer">
                    <button id="setReportPageModalFormBtn"  type="buttom" data-dismiss="modal"   class="btn btn-primary ">确定</button>

                    <script  type="text/javascript">

                        $("#setReportPageModalFormBtn").click(function() {
                            alert($('#setReportPageModalForm').serialize());

                            var req = $.ajax({
                                url:  $('#setReportPageModalForm').attr('action'),
                                type: 'post',
                                data:  $('#setReportPageModalForm').serialize(),
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
<#--
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
-->

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

    <div id="createReportPageModal" class="modal fade" role="dialog">
        <div id="login-overlay" class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">新建版面</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="well">

                                <form id="createReportPageModalForm"   novalidate="novalidate" action="${createReportPage}">

                                    <div class="form-group">
                                        <label for="username" class="control-label">名称</label>
                                        <input style="margin-bottom: 15px;" type="" placeholder="名称" class="name form-control input-lg" name="name" value=""  >


                                        <span class="help-block"></span>
                                    </div>



                                </form>

                            </div>


                        </div>
                    </div>




                </div>
                <div class="modal-footer">
                    <button id="createReportPageModalFormBtn"  type="buttom" data-dismiss="modal"   class="btn btn-primary ">确定</button>

                    <script  type="text/javascript">

                        $("#createReportPageModalFormBtn").click(function() {
                            alert($('#createReportPageModalForm').serialize());

                            var req = $.ajax({
                                url:  $('#createReportPageModalForm').attr('action'),
                                type: 'post',
                                data:  $('#createReportPageModalForm').serialize(),
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
                                <input  type="" placeholder="Username" class="objectId" name="objectId" value=""  >
<#--
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
-->



                                <div class="form-group">
                                    <label for="username" class="control-label">库存编号</label>
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

        $('#addItemModalForm .objectId').val(selected);

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

        var feature = $.trim($("#object-selectpicker").val());

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

        var  companyNo= $.trim($("#producer_selectpicker").val());
        if (companyNo) {
            params.no = companyNo;
        }

        if (sender) {
            params.q = sender;
        }
        //alert(JSON.stringify(sender))
        return params;
    }



    function companyInfoFormatter(value, row, index) {


        return   '<strong><a href="'+ row.distributorUrl + '">' + row.distributor  + '</a></strong>';



    }

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

    $('#producer_selectpicker').on('change', function(){
        var selected = $(this).find("option:selected").val();
        $('#inventory-table').bootstrapTable('refresh');
    });







})
</script>

</html>