

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
    <script type="text/javascript">
        function logout(params) {
            alert("aaaa");
            var req = {
                method: 'DELETE',
                url: "oauth/token"
            };
            $http(req).then(
                    function(data){
                        $cookies.remove("access_token");
                        window.location.href="login";
                    },function(){
                        console.log("error");
                    }
            );
        }
    </script>

</head>
<body>
<div class="container" style="margin-bottom:60px; margin-top:20px">


    <nav class="navbar navbar-default" role="navigation">

        <div class="navbar-header">
            <button type="button " class="navbar-toggle btn-primary" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

            <span class="navbar-brand" ><b></b> 榆林住房公积金省监管平台接入  ${version}</span>

        </div>

        </nav>




    <div class="row col-lg-12">
        <div class="col-md-8 ">
            <select class="selectpicker" id="orderInventoryId" name="tax"   placeholder="">

                <#list E统计周期编码s as category >
                    <option value="${category.id}">  ${category.id!''}  ${category.displayValue!''} </option>
                </#list>

            </select>

        </div>
        <div class="col-md-8 ">
            <select class="selectpicker" id="orderInventoryId" name="tax"   placeholder="">

                <#list E_银行编码_HEnums as category >
                    <option value="${category.id}">  ${category.id!''}  ${category.displayValue!''} </option>
                </#list>
            </select>

        </div>



        <div class="col-md-8 ">
            住建部编码_单位经济类型Enums
            <select class="selectpicker" id="orderInventoryId" name="tax"   placeholder="">

                <#list 住建部编码_单位经济类型Enums as category >
                    <option value="${category.id}">  ${category.id!''}  ${category.displayValue!''} </option>
                </#list>

            </select>

        </div>

        <div class="col-md-8 ">
            E_住建部编码_收入水平Enums
            <select class="selectpicker" id="orderInventoryId" name="tax"   placeholder="">

                <#list E_住建部编码_收入水平Enums as category >
                    <option value="${category.id}">  ${category.id!''}  ${category.displayValue!''} </option>
                </#list>

            </select>

        </div>

        <div class="col-md-8 ">
            E_住建部编码_购房面积Enums
            <select class="selectpicker" id="orderInventoryId" name="tax"   placeholder="">

                <#list E_住建部编码_购房面积Enums as category >
                    <option value="${category.id}">  ${category.id!''}  ${category.displayValue!''} </option>
                </#list>

            </select>

        </div>

    </div>

    <div class="col-lg-12">
        <hr>
    </div>
    <div class="col-lg-12">


        <div role="tabpanel">
            <ul class="nav nav-tabs" role="tablist">


                <li role="presentation" class="active"><a href="#indexes" aria-controls="coalDeals" role="tab"
                                                          data-toggle="tab">更新明细</a></li>
<#--                <li role="presentation"><a href="#apis" aria-controls="coalDeals" role="tab"
                                           data-toggle="tab">API</a></li>-->

            </ul>
            <div class="tab-content">

                <div role="tabpanel" class="tab-pane active" id="indexes">
                    <div class="row col-lg-12" style="">
                        <div class="fade modal" id="roleModal">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                        <h2 class="modal-title" id="myModalLabel">权限分配</h2>
                                    </div>
                                    <div class="modal-body">
                                        <form id="roleModalForm" class="form-horizontal">
                                            <fieldset>

                                                <input   class="control-form" id="employeeId" name="id"  >
                                                <input type="hidden" name="{_csrf.parameterName}" value="{_csrf.token}"/>



                                                <div class="form-group">
                                                    <label class="col-md-4 control-label" for="prependedtext">角色</label>
                                                    <div class="col-md-8">
                                                        <select id="" class="selectpicker" name="userType" data-style="btn-primary">
                   <#--                                     <#list userType as type>
                                                            <option value="${type.id}" >${type.id}${type.displayValue}</option>
                                                        </#list>-->
                                                        </select>
                                                    </div>

                                                </div>



                                            </fieldset>
                                        </form>


                                    </div>
                                    <div class="modal-footer">
                                        <div class="form-group">
                                            <label class="col-md-4 control-label" for="prependedtext"></label>
                                            <button id="roleModalFormBtn"  ref="${updateImmediatelyUrl}" class="btn btn-primary"  data-dismiss="modal">
                                                <i class="fa fa-fw fa-save"></i>确定</button>
                                        </div>
                                        <script >
                                            $("#roleModalFormBtn").bind('click', function(e){


                                                alert($('#roleModalForm').serialize());
                                                var req = $.ajax({
                                                    url:  $(this).attr('ref'),
                                                    type: 'POST',
                                                    data: $('#roleModalForm').serialize(),
                                                });
                                                req.done(function (data) {
                                                    if (data.status) {
                                                        //  window.location.reload(true);
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
                        <div class="fade modal" id="createEmployeeModal">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                        <h2 class="modal-title" id="myModalLabel">新建员工</h2>
                                    </div>
                                    <div class="modal-body">

                                        <form id="userForm" class="form-horizontal" role="form" action="${historyImmediatelyUrl}"
                                              method="post">
                                            <input type="hidden" name="{_csrf.parameterName}" value="{_csrf.token}"/>

                                            <#--                                         <div class="form-group">
                                                                                         <label for="userName" class="col-lg-3 control-label">姓</label>

                                                                                         <div class="col-lg-6">
                                                                                             <input type="text" class="form-control" id="family_name" name="familyName">
                                                                                         </div>
                                                                                     </div>
                                                                                     <div class="form-group">
                                                                                         <label for="userName" class="col-lg-3 control-label">名</label>

                                                                                         <div class="col-lg-6">
                                                                                             <input type="text" class="form-control" id="given_name" name="givenName">
                                                                                         </div>
                                                                                     </div>-->
                                            <div class="form-group">
                                                <label for="userName" class="col-lg-3 control-label">备注</label>

                                                <div class="col-lg-6">
                                                    <input type="text" class="form-control" id="note" name="note">
                                                </div>
                                            </div>
                                            <#--                                 <div class="form-group">
                                                                                 <label for="email" class="col-lg-3 control-label">邮箱</label>

                                                                                 <div class="col-lg-6">
                                                                                     <input type="text" class="form-control" id="emailAddress" name="emailAddress">
                                                                                 </div>
                                                                             </div>-->
                                            <#--

                                                                                     <div class="form-group">
                                                                                         <label for="phone" class="col-lg-3 control-label">手机号</label>

                                                                                         <div class="col-lg-6">
                                                                                             <input type="text" class="form-control" id="phone" name="phone">
                                                                                         </div>
                                                                                     </div>

                                                                                     <div class="form-group">
                                                                                         <label for="pwd" class="col-lg-3 control-label">密码</label>

                                                                                         <div class="col-lg-6">
                                                                                             <input type="text" class="form-control" id="pwd" name="pwd">
                                                                                         </div>
                                                                                     </div>
                                            -->


                                            <div class="form-group">
                                                <label class="col-lg-3 control-label" for="prependedtext">角色</label>
                                                <div class="col-lg-6">
                                                    <select id="" class="selectpicker" name="userType" data-style="btn-primary" >



                                                    </select>
                                                </div>

                                            </div>


                                            <div class="form-group">
                                                <label class="col-lg-3 control-label" for="prependedtext"></label>
                                                <div class="col-lg-6">                                         <div class="checkbox">
                                                        <label>
                                                            <input type="checkbox" name="createInvitedCode" value="createInvitedCode">建立邀请码
                                                        </label>
                                                    </div>
                                                </div>

                                            </div>





                                        </form>


                                    </div>
                                    <div class="modal-footer">
                                        <div class="form-group ">
                                            <label for="userRole" class="col-lg-3 control-label"></label>

                                            <div class="col-lg-6">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                                <button id="userModalSave" ref="${historyImmediatelyUrl}" type="button" class="btn btn-primary" data-dismiss="modal">保存</button>

                                                <script type="text/javascript">

                                                    $("#userModalSave").click(function () {
                                                        alert("dddd"+JSON.stringify($('#userForm').serialize()))
                                                        var req = $.ajax({

                                                            url: $(this).attr('ref'),
                                                            type: 'post',
                                                            data: $('#userForm').serialize(),
                                                            type: 'post',
                                                            /*    data: {
                                                                    familyName: $("#family_name").val(),
                                                                    givenName: $("#given_name").val(),

                                                                    userName: $("#userName").val(),
                                                                    emailAddress: $("#emailAddress").val(),
                                                                    pwd: $("#pwd").val(),
                                                                    userRole: $("input[name='userRole']:checked").val(),
                                                                    ispublic:$("input[name='ispublic']:checked").val()
                                                                }*/
                                                        });
                                                        req.done(function (data) {
                                                            if (data.status) {

                                                                $('#role-table').bootstrapTable('refresh');
                                                            }else{
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
                        <div class="fade modal" id="generateInvitedCodeModal">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                        <h2 class="modal-title" id="myModalLabel">新建邀请码</h2>
                                    </div>
                                    <div class="modal-body">
                                        <form id="generateInvitedCodeForm" class="form-horizontal">
                                            <fieldset>

                                                <input style="margin-bottom: 15px;" type="hidden" class="userId" id="userId" name="id"  >
                                                <input type="hidden" name="{_csrf.parameterName}" value="{_csrf.token}"/>
                                                <div class="form-group">
                                                    <label class="col-md-4 control-label" for="prependedtext">目标全局ID</label>
                                                    <div class="col-md-8">
                                                        <input   class="control-form" id="objectId" name="objectId"  >
                                                    </div>

                                                </div>

                                                <div class="form-group">
                                                    <label class="col-md-4 control-label" for="prependedtext">选择状态</label>
                                                    <div class="col-md-8">
                                                        <select id="schoolno" class="selectpicker" name="roleIds" data-style="btn-primary">


                                                        </select>
                                                    </div>

                                                </div>



                                            </fieldset>
                                        </form>


                                    </div>
                                    <div class="modal-footer">
                                        <div class="form-group">
                                            <label class="col-md-4 control-label" for="prependedtext"></label>
                                            <button id="generateInvitedCodeFormBtn"  ref="{generateInvitedCodeUrl}" class="btn btn-primary"  data-dismiss="modal">
                                                <i class="fa fa-fw fa-save"></i>增加</button>
                                        </div>
                                        <script >
                                            $("#generateInvitedCodeFormBtn").bind('click', function(e){

                                                alert("aaaaaaaaaaaaaaaaaaa");
                                                var req = $.ajax({
                                                    url:  $(this).attr('ref'),
                                                    type: 'PUT',
                                                    data: $('#generateInvitedCodeForm').serialize(),
                                                });
                                                req.done(function (data) {
                                                    if (data.status) {
                                                        //  window.location.reload(true);
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


                        <div id="bussiness_toolbar" class="" >


                            <button id="roleBtn" type="button" class="btn btn-primary">
                                <i class="">立即更新</i>
                            </button>

                            <button id="createEmployeeBtn" type="button" class="btn btn-primary" data-toggle="modal" data-target="#createEmployeeModal">
                                生成历史
                            </button>


                            <button id="generateInvitedCodeBtn" type="button" class="btn btn-primary">
                                <i class="">新建要求码</i>
                            </button>
                            <script type="text/javascript">
                                $("#generateInvitedCodeBtn").click(function() {

                                    var row =  $('#employee-table').bootstrapTable('getSelections');

                                    if (row != '') {
                                        $('#generateInvitedCodeModal').modal();

                                        alert(JSON.stringify(row[0].id));
                                        $('#objectId').val(row[0].id);

                                        // transition_action_refresh();
                                        //  getschoolList(row[0].id);


                                    }

                                });
                                $("#generateInvitedCodeBtn").click(function() {
                                    alert("saaaaaaaaaaa");
                                    $('#generateInvitedCodeModal').modal();
                                });
                            </script>
                            <script type="text/javascript">
                                $("#roleBtn").click(function() {

                                    var row =  $('#employee-table').bootstrapTable('getSelections');

                                    if (row != '') {
                                        $('#roleModal').modal();
                                        alert(JSON.stringify(row[0].id));
                                        $('#employeeId').val(row[0].id);


                                    }

                                });



                            </script>


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
                            <script type="text/javascript">
                                $("#createRemoteBtn").click(function() {

                                    alert("createRemoteBtn");
                                    var row =  $('#role-table').bootstrapTable('getSelections');
                                    alert(JSON.stringify(row[0]));

                                    if (row != '') {
                                        //  $('#schoolno').val('').selectpicker('refresh');

                                        $('#createRemoteModal').modal();

                                        alert(JSON.stringify(row[0].id));
                                        $('#createRemoteModalForm .userId').val(row[0].id);

                                        // transition_action_refresh();
                                        //  getschoolList(row[0].id);


                                    }

                                });
                            </script>

                        </div>

                        <table class=" table-striped" id="bussiness-table" data-url="${streamUrl}" data-toggle="table" data-classes="table table-hover"   data-method="GET"
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
                               data-toolbar="#bussiness_toolbar">
                            <thead>
                            <tr>

                                <th data-field="state" data-checkbox="true"></th>

                                <th data-field="createDate">时间</th>
                                <th data-field="indexNo">name</th>



                                <th data-field="status" >状态</th>
                                <th data-field="description" >描述</th>
                                <th data-field="beginDateTime" >分析开始实际</th>
                                <th data-field="endDateTime" >分析结束实际</th>
                                <th data-field="duration" >处理用时</th>


                                <th data-field="beginDate" >数据结开始时间</th>
                                <th data-field="endDate" >数据结束时间</th>

                                <th data-field="modifyDate" >更新时间</th>
                                <th data-field="createDate" >建立时间</th>

                                <th data-field=""  data-formatter="operationFormatter">操作</th>

                            </tr>
                            </thead>
                        </table>




                    </div>
                </div>
<#--
                <div role="tabpanel" class="tab-pane" id="apis">
                    <div class="row col-lg-12" style="">
                        <section class="">
                            <table class="table">
                                <caption>基本的表格布局</caption>
                                <thead>
                                <tr>
                                    <th>服务编号</th>
                                    <th>服务名称</th>
                                    <th>服务地址</th>
                                    <th>是否完成</th>
                                </tr>
                                </thead>
                                <tbody>

                                </tbody>
                            </table>

                        </section>

                    </div>
                </div>
-->

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
