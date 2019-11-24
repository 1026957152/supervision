<#import "/spring.ftl" as spring>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>榆林煤 注册</title>
    <link href="${rc.contextPath}/components/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="${rc.contextPath}/js/jquery/jquery.js"></script>
    <script src="${rc.contextPath}/components/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>


</head>

<body>


<div class="container" style="margin-bottom:60px; margin-top:20px">
    <div class="col-md-5  col-md-offset-3 " id="register-container">
    <ol class="breadcrumb">
        <li class="active"><strong>第二步</strong> 建立雇佣关系</li>
    </ol>

<#--
        <button id="" type="button" class="btn btn-primary"  data-toggle="modal" data-target="#establishModal">
            建立关系
        </button>-->
        <div class="row">
            <div class="col-xs-12">
                <div class="well">

                    <form id="terminateModalForm"   novalidate="novalidate" action="${establishEmployeeUrl}">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

     <#--                                               <div class="form-group has-feedback">
                                                        <input type="text" class="form-control " name="nickName" id="nickName" placeholder="昵称" value="">

                                                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                                    </div>-->


                                                    <div class="form-group has-feedback">
                                                        <label for="username" class="control-label">企业编号</label>
                                                        <input type="text" class="form-control " name="companyNo" id="companyNo" placeholder="企业编号" value="">

                                                    </div>
                        <div class="form-group">
                            <label for="username" class="control-label">邀请吗</label>
                            <input class="form-control" name="code" />
                        </div>

                    <#--
                                                        <div class="form-group">
                                                            <label for="username" class="control-label">版面</label>
                                                            <select class="selectpicker" &lt;#&ndash;data-max-options="2" &ndash;&gt; id="arrivalStation" name="primary" class="form-control" placeholder="特征">
                                                                                    <#list primaryEnum as primary>
                                                                                        <option value="${primary.text}" >${primary.text}--${primary.text!''}</option>
                                                                                    </#list>
                                                            </select>


                                                        </div>
                    -->



                    </form>
                    <button id="terminateModalFormBtn"  type="buttom" data-dismiss="modal"   class="btn btn-primary pull-right">确定</button>

                    <script  type="text/javascript">

                        $("#terminateModalFormBtn").click(function() {
                            alert($('#terminateModalForm').serialize());

                            var req = $.ajax({
                                url:  $('#terminateModalForm').attr('action'),
                                type: 'post',
                                data:  $('#terminateModalForm').serialize(),
                            });
                            req.done(function (data) {
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


            </div>
        </div>



        <div class="modal fade" id="t_and_c_m" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title" id="myModalLabel">Terms & Conditions</h4>
                    </div>
                    <div class="modal-body">
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">I Agree</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->

        <div id="establishModal" class="modal fade" role="dialog">
            <div id="login-overlay" class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title" id="myModalLabel">建立关系</h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="well">

                                    <form id="terminateModalForm"   novalidate="novalidate" action="${establishEmployeeUrl}">
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                                        <div class="form-group">
                                            <label for="username" class="control-label">邀请吗</label>
                                            <input class="form-control" name="code" />
                                        </div>

                                    <#--
                                                                        <div class="form-group">
                                                                            <label for="username" class="control-label">版面</label>
                                                                            <select class="selectpicker" &lt;#&ndash;data-max-options="2" &ndash;&gt; id="arrivalStation" name="primary" class="form-control" placeholder="特征">
                                                                                                    <#list primaryEnum as primary>
                                                                                                        <option value="${primary.text}" >${primary.text}--${primary.text!''}</option>
                                                                                                    </#list>
                                                                            </select>


                                                                        </div>
                                    -->



                                    </form>

                                </div>


                            </div>
                        </div>




                    </div>
                    <div class="modal-footer">

                    </div>
                </div>
            </div>
        </div>


    </div>


    </div>

</div>

</body>
</html>