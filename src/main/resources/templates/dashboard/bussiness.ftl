

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Bootstrap 101: Learn Bootstrap in 60 minutes by Bootstrapious.com</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="robots" content="all,follow">
    <link href="${rc.contextPath}/components/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${rc.contextPath}/components/bootstrap-select/css/bootstrap-select.min.css" rel="stylesheet">

    <link href="${rc.contextPath}/components/bootstrap_table/bootstrap-table.min.css" rel="stylesheet">


    <script src="${rc.contextPath}/js/jquery/jquery.js" type="text/javascript"></script>
    <script src="${rc.contextPath}/components/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

    <script type="text/javascript" src="${rc.contextPath}/components/bootstrap_table/bootstrap-table.min.js"></script>
    <script type="text/javascript" src="${rc.contextPath}/components/bootstrap_table/bootstrap-table-zh-CN.min.js"></script>
    <script type="text/javascript" src="${rc.contextPath}/components/bootstrap-select/js/bootstrap-select.min.js"></script>

</head>
<body>
<div class="container">




        <h1 class="page-header">
            <small>业务管理</small>



        </h1>




        <div class="col-lg-6" id="companies">



            <div id="bussiness_toolbar" class=" " >

                <button id="setPrimaryBtn" type="button" class="btn btn-primary"  >
                    设置主营业务
                </button>
            <#---->


                <script type="text/javascript">


                    $("#setPrimaryBtn").click(function() {
                        var row =  $('#bussiness-table').bootstrapTable('getSelections');

                        if (row != '') {
                            $('#setPrimaryModal').modal();

                            $('#bussinessId').val(row[0].id);

                        }
                    });




                </script>


            </div>


            <table class=" table-striped" id="bussiness-table" data-url="${buessinessUrl}" data-toggle="table" data-classes="table table-hover"   data-method="GET"
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
                   data-toolbar="#bussiness_toolbar">
                <thead>
                <tr>

                    <th data-field="state" data-checkbox="true"></th>

                    <th data-field="createDate">时间</th>
                    <th data-field="name">name</th>



                    <th data-field="status" >状态</th>
                    <th data-field="primary" >主营业务</th>

                    <th data-field="description" >描述</th>


                    <th data-field=""  data-formatter="operationFormatter">操作</th>

                </tr>
                </thead>
            </table>

        </div>
        <div class="col-lg-6" id="companies">

            <div id="toolbar" class=" " >

                <button id="setReportPageBtn" type="button" class="btn btn-primary"  >
                    添加业务类型
                </button>
<#---->


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
                        var row =  $('#readyBussiness-table').bootstrapTable('getSelections');

                        if (row != '') {
                            $('#openBussinessModal').modal();

                            alert(JSON.stringify(row[0].id));

                            $('#bussinessType').val(row[0].id);

                        }
                    });




                </script>


            </div>


            <table class=" table-striped" id="readyBussiness-table" data-url="${readyBuessinessUrl}" data-toggle="table" data-classes="table table-hover"   data-method="GET"
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


                    <th data-field="companyName | senderCompanyName"  data-formatter="operationFormatter">操作</th>

                </tr>
                </thead>
            </table>

        </div>

                            <div id="setPrimaryModal" class="modal fade" role="dialog">
        <div id="login-overlay" class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">设置主营业务</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="well">

                                <form id="primaryModalForm"   novalidate="novalidate" action="${primaryUrl}">
                                    <input  id="bussinessId" type="" placeholder="Username" class="type " name="id" value=""  >
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>



                                    <div class="form-group">
                                        <label for="username" class="control-label">版面</label>

                                        <select class="selectpicker" <#--data-max-options="2" --> id="arrivalStation" name="primary" class="form-control" placeholder="特征">
                                                                <#list primaryEnum as primary>
                                                                    <option value="${primary.text}" >${primary.text}--${primary.text!''}</option>

                                                                </#list>
                                        </select>


                                    </div>



                                </form>

                            </div>


                        </div>
                    </div>




                </div>
                <div class="modal-footer">
                    <button id="primaryModalFormBtn"  type="buttom" data-dismiss="modal"   class="btn btn-primary ">确定</button>

                    <script  type="text/javascript">

                        $("#primaryModalFormBtn").click(function() {
                            alert($('#primaryModalForm').serialize());

                            var req = $.ajax({
                                url:  $('#primaryModalForm').attr('action'),
                                type: 'post',
                                data:  $('#primaryModalForm').serialize(),
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
                            <div id="openBussinessModal" class="modal fade" role="dialog">
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

                                <form id="openBussinessModalForm"   novalidate="novalidate" action="${openBussinessUrl}">
                                    <input  id="bussinessType" type="" placeholder="Username" class="type " name="type" value=""  >
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                                    <div class="form-group">
                                        <label for="username" class="control-label">毛重</label>
                                        <input style="margin-bottom: 15px;" type="" placeholder="毛重" class="name form-control input-lg" name="grossWeight" value=""  >


                                        <span class="help-block"></span>
                                    </div>


                                    <div class="form-group">
                                        <label for="username" class="control-label">版面</label>

                                        <select class="selectpicker" <#--data-max-options="2" --> id="arrivalStation" name="pageUuid" class="form-control" placeholder="特征">
                                        <#--                         <#list reportPages as feature>
                                        <option value="${feature.uuid}" >${feature.uuid}--${feature.name!''}--${feature.description!''}</option>

                                    </#list>-->
                                        </select>


                                        <span class="help-block"></span>
                                    </div>



                                </form>

                            </div>


                        </div>
                    </div>




                </div>
                <div class="modal-footer">
                    <button id="openBussinessModalFormBtn"  type="buttom" data-dismiss="modal"   class="btn btn-primary ">确定</button>

                    <script  type="text/javascript">

                        $("#openBussinessModalFormBtn").click(function() {
                            alert($('#openBussinessModalForm').serialize());

                            var req = $.ajax({
                                url:  $('#openBussinessModalForm').attr('action'),
                                type: 'post',
                                data:  $('#openBussinessModalForm').serialize(),
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
<script type="text/javascript">

    function queryParams(params) {
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


    function handleResponse(original) {
        var res = {};
        res.rows = original.content;
        res.total = original.totalElements;
        // alert(JSON.stringify(original));
        return res;
    }

    function operationFormatter(value, row, index) {


        return   '<strong><a href="'+ row.url + '">操作</a></strong>';



    }
</script>

</body>
</html>
