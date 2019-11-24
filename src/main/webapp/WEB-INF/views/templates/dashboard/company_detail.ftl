

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
    <script type="text/javascript" src="${rc.contextPath}/js/qrcode.js"></script>

</head>
<body>
<div class="container">
    <nav class="navbar navbar-default" role="navigation">

        <div class="navbar-header">
            <button type="button " class="navbar-toggle btn-primary" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
          <a class="navbar-brand" href="{searchUrl!''}"><img class="" src="${rc.contextPath}/images/logo_header.png" style="width:90px; ;"></a>

            <span class="navbar-brand" ><b></b> 统一认证</span>

        </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">


        </ul>


        <ul class="nav navbar-nav pull-right">


            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><#if user??>${user.userName}</#if> <#if company??> ${company.companyName!''}/${company.companyNo!''} </#if> <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="${userUrl}">我的账户</a></li>

                    <li class="divider"></li>
                    <li>



                    <#--
                                        <button onClick="logout()" class="btn-link ">退出</button>
                    -->
                    </li>
                    <li class="divider"></li>
                </ul>
            </li>

        </ul>


    </nav>

    <div class="col-sm-10 col-md-10">
        <input id="text" type="hidden" value="${permanentQrcode.content!'我啊你你'}" style="width:80%" />


        <div >

            <div id="qrcode_div" ></div>
            微信扫一扫 关注 货源信息88888888888888888888888888888888888888888

        </div>


        <script type="text/javascript">


            var qrcode = new QRCode(document.getElementById("qrcode_div"), {
                width : 200,
                height : 200,
                //useSVG: true
            });
            /*                   var qrcode1 = new QRCode(document.getElementById("qrcode_1") );
                               qrcode1.makeCode(elText);
       */

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


    <section class="">

        <div class="col-sm-2 col-md-2">

            <ul class="list-group">
                <li class="list-group-item">系统ID: {employee.uuid}</li>
                <li class="list-group-item">职工编号：{employee.no}</li>
            </ul>


            <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne"><span class="glyphicon glyphicon-folder-close">
                            </span>Content</a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse in">
                        <div class="panel-body">
                            <table class="table">
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-pencil text-primary"></span><a href="http://www.jquery2dotnet.com">员工管理</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-flash text-success"></span><a href="http://www.jquery2dotnet.com">合作管理</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-file text-info"></span><a href="http://www.jquery2dotnet.com">报表管理</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-comment text-success"></span><a href="http://www.jquery2dotnet.com">财务管理</a>
                                        <span class="badge">42</span>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
<#--                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo"><span class="glyphicon glyphicon-th">
                            </span>Modules</a>
                        </h4>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse">
                        <div class="panel-body">
                            <table class="table">
                                <tr>
                                    <td>
                                        <a href="http://www.jquery2dotnet.com">产品</a> <span class="label label-success">$ 320</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="http://www.jquery2dotnet.com">库存</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="http://www.jquery2dotnet.com">Shipments</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="http://www.jquery2dotnet.com">Tex</a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree"><span class="glyphicon glyphicon-user">
                            </span>Account</a>
                        </h4>
                    </div>
                    <div id="collapseThree" class="panel-collapse collapse">
                        <div class="panel-body">
                            <table class="table">
                                <tr>
                                    <td>
                                        <a href="http://www.jquery2dotnet.com">Change Password</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="http://www.jquery2dotnet.com">Notifications</a> <span class="label label-info">5</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="http://www.jquery2dotnet.com">Import/Export</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-trash text-danger"></span><a href="http://www.jquery2dotnet.com" class="text-danger">
                                        Delete Account</a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour"><span class="glyphicon glyphicon-file">
                            </span>Reports</a>
                        </h4>
                    </div>
                    <div id="collapseFour" class="panel-collapse collapse">
                        <div class="panel-body">
                            <table class="table">
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-usd"></span><a href="http://www.jquery2dotnet.com">Sales</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-user"></span><a href="http://www.jquery2dotnet.com">Customers</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-tasks"></span><a href="http://www.jquery2dotnet.com">Products</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-shopping-cart"></span><a href="http://www.jquery2dotnet.com">Shopping Cart</a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>-->
            </div>
        </div>
        <div class="col-sm-10 col-md-10">
            <input id="text_company" type="hidden" value="${companyPermanentQrcode.content!'我啊你你'}" style="width:80%" />


            <div align="center">

                <div id="qrcode_company_div" ></div>
                微信扫一扫 关注 公司 货源信息

            </div>


            <script type="text/javascript">


                var qrcode_company_div = new QRCode(document.getElementById("qrcode_company_div"), {
                    width : 200,
                    height : 200,
                    //useSVG: true
                });
                /*                   var qrcode1 = new QRCode(document.getElementById("qrcode_1") );
                                   qrcode1.makeCode(elText);
           */

                function qrcode_company_divmakeCode () {
                    var elText = document.getElementById("text_company");

                    if (!elText.value) {
                        alert("Input a text");
                        elText.focus();
                        return;
                    }

                    qrcode_company_div.makeCode(elText.value);






                }

                qrcode_company_divmakeCode();


            </script>

            <section class="">

                <div class="col-lg-12">
                    <h1 class="page-header">




                        <a href="${companyUrl!''}"><strong>${company.name!'---'}</strong> ${company.no!'---'}</a>
                    </h1>
                </div>
                <div class="col-lg-12" id="companies">




                <#--                       系统ID: ${employee.uuid}<br>
                                               职工编号：${employee.no}
                -->
                    <div id="bussiness_toolbar" class=" " >

                    <#--                  <button id="setPrimaryBtn" type="button" class="btn btn-primary"  >
                                          设置主营业务
                                      </button>-->

                        <a href="${bussinessUrl}" type="button" class="btn btn-primary"  >
                            业务设置
                        </a>
                        <a href="{employeeUrl}" type="button" class="btn btn-primary" >员工管理</a>
                    <#---->


                        <div class="btn-group">
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                其他 <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <li>
                                    <a id="addBtn" href="#" type="button" class=""  data-toggle="modal" data-target="#terminateModal">
                                        终止雇佣关系
                                    </a>


                                </li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                            </ul>
                        </div>
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

                <div id="terminateModal" class="modal fade" role="dialog">
                    <div id="login-overlay" class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                                <h4 class="modal-title" id="myModalLabel">终止关系</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <div class="well">

                                            <form id="terminateModalForm"   novalidate="novalidate" action="${terminateUrl}">
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
                                <button id="terminateModalFormBtn"  type="buttom" data-dismiss="modal"   class="btn btn-primary ">确定</button>

                                <script  type="text/javascript">

                                    $("#terminateModalFormBtn").click(function() {
                                        alert($('#terminateModalForm').serialize());

                                        var req = $.ajax({
                                            url:  $('#terminateModalForm').attr('action'),
                                            type: 'PUT',
                                            data:  $('#terminateModalForm').serialize(),
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

            </section>



        </div>




    </section>



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
