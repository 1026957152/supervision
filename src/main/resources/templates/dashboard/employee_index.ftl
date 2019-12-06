<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>榆林煤 员工管理</title>
    <link href="${rc.contextPath}/components/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${rc.contextPath}/components/bootstrap-select/css/bootstrap-select.min.css" rel="stylesheet">
    <link href="${rc.contextPath}/components/bootstrap_table/bootstrap-table.min.css" rel="stylesheet">

    <script src="${rc.contextPath}/js/jquery/jquery.js" type="text/javascript"></script>
   <script src="${rc.contextPath}/components/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

</head>

<body>
<div class="container" style="margin-bottom:80px; margin-top:10px ">


    <h1 class="page-header">
        <small>员工管理</small>
    </h1>



    <div class="row "  style="">


        <div class="col-sm-12">

            <div class="t">

                <ul class="nav nav-tabs add-tabs" id="ajaxTabs" role="tablist">
                    <li class="active"><a href="#companies" data-url="ajax/2.html" role="tab" data-toggle="tab" aria-expanded="false">员工 <span class="badge"></span></a></li>

                    <li class=""><a href="#addCompanies" data-url="ajax/2.html" role="tab" data-toggle="tab" aria-expanded="false">添加员工 <span class="badge"></span></a></li>
<#--
                    <li class=""><a href="#invitationCode" data-url="ajax/2.html" role="tab" data-toggle="tab" aria-expanded="false">员工邀请码 <span class="badge"></span></a></li>
-->

                </ul>
            </div>
             <div  class="tab-content">


                 <div class="tab-pane active" id="companies">
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
                                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>



                                                <div class="form-group">
                                                    <label class="col-md-4 control-label" for="prependedtext">角色</label>
                                                    <div class="col-md-8">
                                                        <select id="" class="selectpicker" name="userType" data-style="btn-primary" ">
                                                            <#list userType as type>
                                                                <option value="${type.id}" >${type.id}${type.displayValue}</option>
                                                            </#list>
                                                        </select>
                                                    </div>

                                                </div>



                                            </fieldset>
                                        </form>


                                    </div>
                                    <div class="modal-footer">
                                        <div class="form-group">
                                            <label class="col-md-4 control-label" for="prependedtext"></label>
                                            <button id="roleModalFormBtn"  ref="${applyRoleUrl}" class="btn btn-primary"  data-dismiss="modal">
                                                <i class="fa fa-fw fa-save"></i>确定</button>
                                        </div>
                                        <script >
                                            $("#roleModalFormBtn").bind('click', function(e){


                                                alert($('#roleModalForm').serialize());
                                                var req = $.ajax({
                                                    url:  $(this).attr('ref'),
                                                    type: 'PUT',
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

                                     <form id="userForm" class="form-horizontal" role="form" action="${addCompanyUserUrl}"
                                           method="post">
                                         <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

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
                                                 <select id="" class="selectpicker" name="userType" data-style="btn-primary" ">
                        <#list userType as type>

                                                            <option value="${type.id}" >${type.id}${type.displayValue}</option>


                        </#list>


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

<#--
                                         <div class="form-group ">
                                             <label for="userRole" class="col-lg-3 control-label">角色</label>

                                             <div class="col-lg-6">

                        <#list userType as type>
                            <label class="radio-inline">
                                <input type="radio" name="userType"  value="${type.id}" checked="true"> ${type.id}${type.displayValue}
                            </label>
                        </#list>

                                             </div>
                                         </div>

-->



                                     </form>


                                 </div>
                                 <div class="modal-footer">
                                     <div class="form-group ">
                                         <label for="userRole" class="col-lg-3 control-label"></label>

                                         <div class="col-lg-6">
                                             <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                             <button id="userModalSave" ref="${addCompanyUserUrl}" type="button" class="btn btn-primary" data-dismiss="modal">保存</button>

                                             <script type="text/javascript">

                                                 $("#userModalSave").click(function () {
                                                     alert("dddd"+JSON.stringify($('#userForm').serialize()));
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
                                                             alert("");

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
                                             <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                             <div class="form-group">
                                                 <label class="col-md-4 control-label" for="prependedtext">目标全局ID</label>
                                                 <div class="col-md-8">
                                                     <input   class="control-form" id="objectId" name="objectId"  >
                                                 </div>

                                             </div>

                                             <div class="form-group">
                                                 <label class="col-md-4 control-label" for="prependedtext">选择状态</label>
                                                 <div class="col-md-8">
                                                     <select id="schoolno" class="selectpicker" name="roleIds" data-style="btn-primary" ">


                                                     </select>
                                                 </div>

                                             </div>



                                         </fieldset>
                                     </form>


                                 </div>
                                 <div class="modal-footer">
                                     <div class="form-group">
                                         <label class="col-md-4 control-label" for="prependedtext"></label>
                                         <button id="generateInvitedCodeFormBtn"  ref="${generateInvitedCodeUrl}" class="btn btn-primary"  data-dismiss="modal">
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


                        <div id="toolbar" class="" >
                            <button id="createRemoteBtn" type="button" class="btn btn-primary hidden">
                                <i class="">建立远程帐号</i>
                              </button>

                            <button id="deleteBtn_" type="button" class="btn btn-primary hidden" >
                                添加
                            </button>



                            <button id="roleBtn" type="button" class="btn btn-primary">
                                <i class="">权限分配</i>
                            </button>

                            <button id="createEmployeeBtn" type="button" class="btn btn-primary" data-toggle="modal" data-target="#createEmployeeModal">
                                新建员工
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

                        <table class=" table-striped" id="employee-table" data-url="${employeeUrl}" data-toggle="table" data-classes="table table-hover"   data-method="GET"
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
                               data-toolbar="#toolbar"
                        >
                            <thead>
                            <tr>
                                <th data-field="state" data-radio="true"></th>
                                <th data-field="no">员工编号</th>
                                <th data-field="nickName">昵称</th>
                                <th data-field="phone">电话号</th>
                                <th data-field="realName">姓名</th>
                                <th data-field="familyName">姓</th>
                                <th data-field="givenName">名</th>

                                <th data-field="gender">性别</th>
<#--
                                <th data-field="userId">登陆ID</th>-->
                                <th data-field="role"  data-formatter="roleInfoFormatter">角色</th>
                                <th data-field="status">状态</th>
                                <th data-field="id">Id</th>

                                <th data-field="" data-formatter="operationFormatter">操作</th>
                                <th data-field="employmentRelationship">绑定状态</th>


                            </tr>
                            </thead>
                        </table>
                        <div class="fade modal" id="createRemoteModal">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                        <h2 class="modal-title" id="myModalLabel">建立远程帐号</h2>
                                    </div>
                                    <div class="modal-body">
                                        <form id="createRemoteModalForm" class="form-horizontal">
                                            <fieldset>

                                                <input style="margin-bottom: 15px;" type="" class="userId" id="userId" name="id"  >
                                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>


                                                <div class="form-group">
                                                    <label class="col-md-4 control-label" for="prependedtext">选择状态</label>
                                                    <div class="col-md-8">
                                                        <select id="schoolno" class="selectpicker" name="roleIds" data-style="btn-primary" ">


                                                        </select>
                                                    </div>

                                                </div>

                                                <div class="form-group">
                                                    <label class="col-md-4 control-label" for="prependedtext"></label>
                                                    <button id="createRemoteModalFormBtn"  ref="{createRemoteEmployeeUrl}" class="btn btn-primary"  data-dismiss="modal">
                                                        <i class="fa fa-fw fa-save"></i>增加</button>
                                                </div>

                                            </fieldset>
                                        </form>
                                        <script >
                                            $("#createRemoteModalFormBtn").bind('click', function(e){

                                                var req = $.ajax({
                                                    url:  $(this).attr('ref'),
                                                    type: 'POST',
                                                    data: $('#createRemoteModalForm').serialize(),
                                                });
                                                req.done(function (data) {
                                                    if (data.status) {
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
                 <div class="tab-pane " id="addCompanies">







                 </div>
                 <div class="tab-pane" id="invitationCode" >

                     <div id="invitation-toolbar" class="" >


                     </div>

                     <table class=" table-striped" id="invitationCode-table" data-url="${invitedCodeUrl}" data-toggle="table" data-classes="table table-hover"   data-method="GET"
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
                            data-toolbar="#invitation-toolbar"
                     >
                         <thead>
                         <tr>



                             <th data-field="state" data-radio="true"></th>
                             <th data-field="code">code</th>
                             <th data-field="objectId">objectId</th>

                             <th data-field="companyNo">companyNo</th>
                             <th data-field="itemType">itemType</th>
                             <th data-field="status">status</th>
                             <th data-field="id">Id</th>

                             <th data-field="id" data-formatter="operationFormatter">操作</th>

                         </tr>
                         </thead>
                     </table>

                 </div>


             </div>



        </div>




    </div>


<#--
<div id="addLineModal" class="modal fade" role="dialog">
    <div id="login-overlay" class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">添加员工</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12">
                        <form id="addLineModalForm"   novalidate="novalidate" action="${command_create_url}">

                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

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
-->

<div id="editLineModal" class="modal fade" role="dialog">
    <div id="login-overlay" class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">添加员工</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12">
                        <form id="editLineModalForm"   novalidate="novalidate" action="${command_edit_url}">
                            <input style="margin-bottom: 15px;" type="" placeholder="Username" class="id hidden" name="id" value=""  >
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                            <div class="form-group">
                                <label for="username" class="control-label">名称</label>
                                <input style="margin-bottom: 15px;" type="" placeholder="Username" class="name form-control" name="name" value=""  >


                                <span class="help-block"></span>
                            </div>

                            <div class="form-group">
                                <label for="username" class="control-label">邮编</label>
                                <input style="margin-bottom: 15px;" type="" placeholder="Username" class="postalCode form-control" name="postalCode" value=""  >
                                <span class="help-block"></span>
                            </div>

                            <div class="form-group">
                                <label for="username" class="control-label">描述</label>
                                <input style="margin-bottom: 15px;" type="" placeholder="Username" class="description form-control" name="description" value=""  >
                                <span class="help-block"></span>
                            </div>



                            <div class="form-group">
                                <label for="username" class="control-label">特征</label>

                                <select class="selectpicker" data-max-options="2"  id="feature" name="feature" class="form-control" placeholder="特征">

                                <#if featuresEnum??>
                                    <#list featuresEnum as feature>
                                        <option value="${feature.id}" >${feature.id!''}--${feature.displayName!''}</option>

                                    </#list>
                                </#if>

                                </select>



                                </select>
                                <span class="help-block"></span>
                            </div>


                            <button id="editLineModalFormBtn"  type="buttom" data-dismiss="modal"   class="btn btn-primary ">确定</button>
                        </form>
                        <script  type="text/javascript">

                            $("#editLineModalFormBtn").click(function() {
                                alert($('#editLineModalForm').serialize());

                                var req = $.ajax({
                                    url:  $('#editLineModalForm').attr('action'),
                                    type: 'put',
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






</body>
<script type="text/javascript" src="${rc.contextPath}/components/bootstrap_table/bootstrap-table.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/components/bootstrap_table/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/components/bootstrap-select/js/bootstrap-select.min.js"></script>

<script>

    function roleInfoFormatter(value, row, index) {
        var List = row.roles;

        var personString = "";
        for(var student in List){ //第二层循环取list中的对象
            personString +='【'+List[student].name+'】<br>';
        }
        return    '<div class="">' + personString

                +
                '</div>';

    }

</script>
<script type="text/javascript">
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
        //alert(JSON.stringify(sender))
        return params;
    }



    function ompanyInfoFormatter(value, row, index) {


        return  ' <div class="img-comment-list">  <div  class="comment-img"  > <img class="" src="'+row.companyLogoUrl+'"/> </div>'+
                ' <div class="comment-text">'+
                '<strong><a href="'+ row.companyUrl + '">' + row.companyName  + '</a></strong>'+
                '<p class="">@'+ row.inventoryCounty + '</p> '+
                '</div>'+
                ' </div>';



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

$(function(){

    $('.selectpicker').selectpicker();



    $('.searchBtn').bind('click', function(){
        refresh();

    });






})
</script>

</html>