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
    <link href="${rc.contextPath}/components/bootstrap_table/bootstrap-table.min.css" rel="stylesheet">

    <script src="${rc.contextPath}/js/jquery/jquery.js" type="text/javascript"></script>
    <script src="${rc.contextPath}/components/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

    <script type="text/javascript" src="${rc.contextPath}/components/bootstrap_table/bootstrap-table.min.js"></script>
    <script type="text/javascript" src="${rc.contextPath}/components/bootstrap_table/bootstrap-table-zh-CN.min.js"></script>
    <script type="text/javascript" src="${rc.contextPath}/components/bootstrap-select/js/bootstrap-select.min.js"></script>

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
            alert(JSON.stringify(original));
            return res;
        }


    </script>

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
        <li role="presentation" class=""><a href="#basicInfo" aria-controls="account" role="tab"
                                            data-toggle="tab">修改个人信息 <span class="badge"></span></a></li>
<#--

        <li role="presentation" class=""><a href="#configuration" aria-controls="configuration" role="tab"
                                            data-toggle="tab">配置信息 <span class="badge"></span></a></li>
-->
        <li role="presentation" class=""><a href="#configuration" aria-controls="configuration" role="tab"
                                            data-toggle="tab">配置信息 <span class="badge"></span></a></li>
    </ul>


    <div  class="tab-content">

    <div class="tab-pane active" id="companies">


    <div class="row" style="padding-top: 10px;padding-bottom: 10px">
        <div class="col-lg-6">
            <div class="panel panel-default">
                <div class="panel-heading">基本信息</div>
                <div class="panel-body">
                    <ul class="list-group">
<#--                        <li class="list-group-item">名称：<a href="${company.url}">${company.name}</a></li>
                        <li class="list-group-item">编号： ${company.no!''}</li>
                        <li class="list-group-item">类型：${company.type}</li>
                        <li class="list-group-item">状态：${company.status}</li>
                        <li class="list-group-item">经营状态：${company.businessStatus!''}</li>

                        <li class="list-group-item">全局编号：${company.id}</li>


                        <#if address??>
                                                  <li class="list-group-item">地址：${address.provinceCityCountyTownVillage!'?'}</li>
                        <li class="list-group-item">经纬度：${address.lng!'?'} ${address.lat!'?'}</li>
                        </#if>-->




                    </ul>
                </div>

            </div>
        </div>

    </div>











    </div>
    <div class="tab-pane " id="account">
    <div class="row" style="padding-top: 10px;padding-bottom: 10px">
        <div class="col-lg-6">
            <ul class="list-group">


                <li class="list-group-item">昵称：${user.nickName!''}</li>

                <li class="list-group-item">姓：${user.familyName!''}</li>
                <li class="list-group-item">名：${user.givenName!''}</li>

                <li class="list-group-item">姓名：${user.realName!''}</li>
                <li class="list-group-item">性别：${user.gender!''}</li>

                <li class="list-group-item">编号： ${user.userNo!''}</li>

                <li class="list-group-item">电话： ${user.phone!''}</li>

                <li class="list-group-item">

                    <#if veixin_server>
                                         <#if user.isBindingWeixin>
                        已经绑定微信
                        <button id="unBindWeixinBtn" type="button" class="btn btn-primary" >
                            解除绑定
                        </button>

                        <script type="text/javascript">

                            $("#unBindWeixinBtn").click(function() {
                                var data = {
                                };

                                data['${_csrf.parameterName}'] = "${_csrf.token}";
                                $.post("${unBindWeixinUrl}", data,function(data,status) {
                                    if (data.status) {
                                        alert("解绑成功");

                                        window.location.reload();

                                        $('#be-trader-request-table').bootstrapTable('refresh');
                                    } else {
                                        alert(data);
                                    }
                                });
                            })


                        </script>

                                         <#else>
                                         <#--                                 微信扫一扫 绑定帐号
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
                                      -->

                                         </#if>


                        <#else>

                        微信服务异常
                    </#if>





                </li>





            </ul>
        </div>
</div>
    </div>


        <div class="tab-pane " id="basicInfo">

            <div class="col-lg-6">
                <form id="userForm" class="form-horizontal" role="form" action="${command_edit_url}" enctype="multipart/form-data" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <table class="table" data-show-header="false">
                        <colgroup>
                            <col class="" style="width:20%;" span="1"/>
                            <col class="" style="width:20%;" span="1"/>



                        </colgroup>
                        <thead>

                        <tr>
                            <th ></th>
                            <th></th>


                        </tr>
                        </thead>
                        <tbody>


                        <tr >
                            <td class="active"><strong>昵称:</strong></td>


                            <td><input type="text" class="form-control  " id="nickName" name="nickName"
                                       placeholder="昵称" value="${user.nickName!''}">

                            </td>
                        </tr>




                        <tr >
                            <td class="active"><strong>姓:</strong></td>
                            <td>                      <input type="text" class="form-control " id="familyName" name="familyName"
                                                             placeholder="姓" value="${user.familyName!''}">
                            </td>
                        </tr>
                        <tr >
                            <td class="active"><strong>名:</strong></td>
                            <td><input type="text" class="form-control  " id="givenName" name="givenName"
                                       placeholder="名" value="${user.givenName!''}">
                            </td>
                        </tr>

                        <tr >
                            <td class="active"><strong>性别:</strong></td>
                            <td>   <label class="radio-inline ">
                                <input type="radio" name="gender" id="gender1" value="男"
                                   <#if user.gender?? && user.gender = '男'>checked="true" </#if>> 男
                            </label>
                                <label class="radio-inline ">
                                    <input type="radio" name="gender" id="gender2" value="女"
                                       <#if user.gender?? && user.gender = '女'>checked="true" </#if>> 女
                                </label>
                            </td>
                        </tr>
                        <tr >
                            <td class="active"><strong>手机:</strong></td>
                            <td>
                                <p class="form-control">${user.phone!''}</p>

                                <button id="changePhoneBtn" type="button" class="btn btn-default">
                                    <i class="glyphicon glyphicon-pencil">更新</i>
                                </button>


                                <script type="text/javascript">
                                    $("#changePhoneBtn").click(function() {
                                        $('#changePhoneModal').modal();

                                        // var row = selectedRow();

                                    });


                                </script>
                            </td>
                        </tr>
                        <tr >
                            <td class="active"><strong>部门:</strong></td>
                            <td>                            <input type="text" class="form-control " id="department" name="department"
                                                                   placeholder="部门" value="${user.department!''}">
                            </td>
                        </tr>
                        <tr >
                            <td class="active"><strong>职位:</strong></td>
                            <td>                            <input type="text" class="form-control " id="position" name="position"
                                                                   placeholder="职位" value="${user.position!''}">
                            </td>
                        </tr>
                        <tr >
                            <td class="active"><strong>备注:</strong></td>
                            <td>                           <textarea class="form-control " id="note" name="note" rows="3">${user.note!''}</textarea>
                            </td>
                        </tr>

                        <tr >

<#--                            <td class="active"><strong>头像:</strong></td>
                            <td>                        <#if user.userImage??>
                            <img src="${user.userImage}" width="200" height="200" >
                            </#if>

                                <button id="createImageBtn" type="button" class="btn btn-default">
                                    <i class="glyphicon glyphicon-pencil">更新</i>
                                </button>


                                <script type="text/javascript">
                                    $("#createImageBtn").click(function() {
                                        $('#addImageModal').modal();

                                        // var row = selectedRow();

                                    });


                                </script>
                            </td>-->
                        </tr>


                        </tbody>
                    </table>




                    <div class="col-lg-12 text-center">
                        <button id="submitBtn" type="button" class="btn btn-primary ">保存</button>


                        <button id="reset" type="reset" class="btn btn-default ">取消</button>

                        <script  type="text/javascript">

                            $("#submitBtn").click(function() {
           /*                     alert($('#userForm').serialize());*/
                                var req = $.ajax({
                                    url:  $('#userForm').attr('action'),
                                    type: 'put',
                                    data:  $('#userForm').serialize(),
                                });
                                req.done(function (data) {
                          /*          alert("成功:"+data.message);*/

                                    if (data.status) {
                                        alert("成功:"+data.message);

                                        window.location.reload(true);// = data.link;
                                    } else {
                                        alert(data.message);
                                    }
                                });
                            });
                        </script>
                    </div>
                </form>

            </div>

        </div>




<#--
        <div role="tabpanel" class="tab-pane " id="configuration">

            <div class="" >
                <div class="" id="configuration_toolbar">
                    <a class="btn btn-default " id="completeFeeBtn"   ref="{completeFeeUrl}"> <i class="fa fa-certificate"></i> <span>完善费用设置</span> </a>
                    <a class="btn btn-default " id="addFeeBtn"   ref="{addFeeUrl}"> <i class="fa fa-certificate"></i> <span>增加费用类型</span> </a>
                    <script type="text/javascript">
                        $("#completeFeeBtn").click(function() {
                            var row =  $('#fee-table').bootstrapTable('getSelections');

                            if (row != '') {
                                $('#completeFeeModal').modal();
                                //alert(JSON.stringify(row[0]));
                                $('#completeFeeModalFormId').val(row[0].id);
                                $('#completeFeeModalFormDescription').val(row[0].id +" "+
                                        row[0].type+" "+
                                        row[0].pricingStrategy+" ");


                            }
                        });

                        $("#addFeeBtn").click(function() {
                            var row =  $('#fee-table').bootstrapTable('getSelections');
                            $('#addFeeModal').modal();
                            //alert(JSON.stringify(row[0]));
                            $('#addFeeModalFormId').val(row[0].id);
                            $('#addFeeModalFormDescription').val(row[0].id +" "+
                                    row[0].type+" "+
                                    row[0].pricingStrategy+" ");
                        });


                    </script>

                </div>

                <table class="table-striped" id="configuration-table" data-url="${configurationUrl}" data-toggle="table" data-classes="table table-hover"   data-method="GET"
                       data-content-type="orderExecutionView/x-www-form-urlencoded; charset=UTF-8"
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
                       data-toolbar="#configuration_toolbar"
                >
                    <thead>
                    <tr>

                        <th data-field="state" data-checkbox="true"></th>

                        <th data-field="createDate">创建时间</th>
                        <th data-field="tax">是否含税</th>
                        <th data-field="type">名称</th>
                        <th data-field="pricingStrategy">成本策略</th>


                        <th data-field="amount">金额</th>
                        <th data-field="status">状态</th>
                        <th data-field="" data-formatter="paymentOperationFormatter">操作</th>
                    </tr>
                    </thead>
                </table>


            </div>


        </div>
-->
        <div role="tabpanel" class="tab-pane " id="configuration">

            <div class="" >
                <div class="" id="configuration_toolbar">
                    <a class="btn btn-default " id="completeFeeBtn"   ref="{completeFeeUrl}"> <i class="fa fa-certificate"></i> <span>完善费用设置</span> </a>
                    <a class="btn btn-default " id="addFeeBtn"   ref="{addFeeUrl}"> <i class="fa fa-certificate"></i> <span>增加费用类型</span> </a>
                    <script type="text/javascript">
                        $("#completeFeeBtn").click(function() {
                            var row =  $('#fee-table').bootstrapTable('getSelections');

                            if (row != '') {
                                $('#completeFeeModal').modal();
                                //alert(JSON.stringify(row[0]));
                                $('#completeFeeModalFormId').val(row[0].id);
                                $('#completeFeeModalFormDescription').val(row[0].id +" "+
                                        row[0].type+" "+
                                        row[0].pricingStrategy+" ");


                            }
                        });

                        $("#addFeeBtn").click(function() {
                            var row =  $('#fee-table').bootstrapTable('getSelections');
                            $('#addFeeModal').modal();
                            //alert(JSON.stringify(row[0]));
                            $('#addFeeModalFormId').val(row[0].id);
                            $('#addFeeModalFormDescription').val(row[0].id +" "+
                                    row[0].type+" "+
                                    row[0].pricingStrategy+" ");
                        });


                    </script>

                </div>


                <table class="table-striped" id="configuration-table" data-url="${employeeUrl}" data-toggle="table" data-classes="table table-hover"   data-method="GET"
                       data-content-type="orderExecutionView/x-www-form-urlencoded; charset=UTF-8"
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
                       data-toolbar="#configuration_toolbar"

                       data-search="true"
                       data-show-refresh="true">

                    <thead>
                    <tr>

                        <th data-field="state" data-checkbox="true"></th>

                        <th data-field="createDate">创建时间</th>



                        <th data-field="type">类型</th>
                        <th data-field="status">状态</th>
                        <th data-field="" data-formatter="paymentOperationFormatter">操作</th>
                    </tr>
                    </thead>
                </table>



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

/*
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
*/
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

/*
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
*/
                        </script>

                    </div>
                </div>




            </div>
        </div>
    </div>
</div>

    <div id="completeFeeModal" class="modal fade" role="dialog">
        <div id="login-overlay" class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">完善费用设置</h4>
                </div>
                <form id="completeFeeModalForm" class="form-horizontal" role="" action="{completeFeeUrl}" method="get">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input class="hidden" name="id" id="completeFeeModalFormId" value=""/>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="control-label col-md-2">费用类型</label>

                            <div class="col-md-8 ">
                                <input class="form-control" name="" id="completeFeeModalFormDescription" value=""/>



                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-2">价格策略</label>

                            <div class="col-md-8 ">
                            <select class="selectpicker" id="orderInventoryId" name="pricingStrategy"   placeholder="">
                                                           <#if taxInclusiveExclusiveEnums??>
                            <#list pricingStrategyEnums as inventory>
                                <option value="${inventory.id}">  ${inventory.id!''}  ${inventory.displayValue!''} </option>

                            </#list>    </#if>
                                </select>


                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-2">是否含税</label>

                            <div class="col-md-8 ">
                                <select class="selectpicker" id="orderInventoryId" name="tax"   placeholder="">
                                               <#if taxInclusiveExclusiveEnums??>
                            <#list taxInclusiveExclusiveEnums as inventory>
                                <option value="${inventory.id}">  ${inventory.id!''}  ${inventory.displayValue!''} </option>

                            </#list>
                                               </#if>
                                </select>

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-2">费用状态</label>

                            <div class="col-md-8 ">
                                <select class="selectpicker" id="orderInventoryId" name="status"   placeholder="">
                                    <#if feeStatusEnums??>
                                                                <#list feeStatusEnums as inventory>
                                <option value="${inventory.id}">  ${inventory.id!''}  ${inventory.displayValue!''} </option>

                                                                </#list>
                                    </#if>

                                </select>

                            </div>
                        </div>


                        <div class="form-group">
                            <label class="control-label col-md-2">费用</label>

                            <div class="col-md-8 ">
                                <input class="form-control" name="amount"  value=""/>
                            </div>
                        </div>


                    </div>
                    <div class="modal-footer">


                        <div class="btn-toobar">
                            <button id="completeFeeModalFormBtn" type="button"  class="btn btn-primary  ">确定</button>
                            <button type="button" class="btn btn-default " data-dismiss="modal" >取消</button>
                        </div>


                        <script >
                            $("#completeFeeModalFormBtn").bind('click', function(e){
                                alert($('#completeFeeModalForm').serialize());

                                var req = $.ajax({
                                    url:  $('#completeFeeModalForm').attr('action'),
                                    type: 'POST',
                                    data: $('#completeFeeModalForm').serialize(),
                                });
                                req.done(function (data) {
                                    alert("json" + JSON.stringify(data));
                                    if (data.status) {
                                        $('#fee-table').bootstrapTable('refresh');

                                    } else {
                                        alert(data.message);
                                    }
                                });
                            });


                        </script>


                    </div>
                </form>

            </div>
        </div>
    </div>

    <div id="addFeeModal" class="modal fade" role="dialog">
        <div id="login-overlay" class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">添加费用类型</h4>
                </div>
                <form id="addFeeModalForm" class="form-horizontal" role="" action="{addFeeUrl}" method="get">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div class="modal-body">

                        <div class="form-group">
                            <label class="control-label col-md-2">费用</label>

                            <div class="col-md-8 ">
                                <input class="form-control" name="amount"  value=""/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">选择库存商品</label>
                            <div class="col-md-9 ">
                                <select class="selectpicker" id="orderInventoryId" name="type"   placeholder="">
                                        <#if feeStatusEnums??>
                            <#list feesTypeEnums as inventory>
                                <option value="${inventory.id}">  ${inventory.id!''}  ${inventory.displayValue!''} </option>

                            </#list>
                                        </#if>
                                </select>
                            </div>
                        </div>

                    </div>
                    <div class="modal-footer">

                        <div class="btn-toobar">
                            <button id="addFeeModalFormBtn" type="button"  class="btn btn-primary  ">确定</button>
                            <button type="button" class="btn btn-default " data-dismiss="modal" >取消</button>
                        </div>


                        <script >
                            $("#addFeeModalFormBtn").bind('click', function(e){
                                alert($('#addFeeModalForm').serialize());

                                var req = $.ajax({
                                    url:  $('#addFeeModalForm').attr('action'),
                                    type: 'POST',
                                    data: $('#addFeeModalForm').serialize(),
                                });
                                req.done(function (data) {
                                    alert("json" + JSON.stringify(data));
                                    if (data.status) {
                                        $('#fee-table').bootstrapTable('refresh');

                                    } else {
                                        alert(data.message);
                                    }
                                });
                            });


                        </script>


                    </div>
                </form>

            </div>
        </div>
    </div>






</body>
</html>