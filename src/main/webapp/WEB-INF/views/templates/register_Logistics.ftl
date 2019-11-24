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
        <li class="active"><strong>第二步</strong> 建立物流公司 帐号信息</li>
    </ol>
        <div class="" style="margin-top:5%;">

            <div class="register-box  style="margin-top:25%;">



            <div class="box-body box-profile">
                <p class="login-box-msg"></p>

                <form action="${registerUserUrl}" method="post"  id="myform">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <fieldset id="success_tip" class="" style="">

                        <div class="form-group has-feedback">
                            <input type="text" class="form-control " name="nickName" id="userName" placeholder="名称" value="">

                            <span class="glyphicon glyphicon-user form-control-feedback"></span>
                        </div>
                        <div class="form-group has-feedback">
                            <input type="text" class="form-control " name="password" id="password" placeholder="密码" value="">

                            <span class="glyphicon glyphicon-user form-control-feedback"></span>
                        </div>
                        <div class="form-group has-feedback">
                            <input type="text" class="form-control " name="companyName" id="userName" placeholder="供应商" value="">

                            <span class="glyphicon glyphicon-user form-control-feedback"></span>
                        </div>


                        <div class="form-group has-error" id="msg">
                            <span class="help-block hidden" id="serverMsg">{msg!''}</span>
                        </div>
                        <div class="row">
                            <div class="col-xs-6">
                                <div class="">
                                    <label>
                                        <div class="icheckbox_square-blue" aria-checked="false"  aria-disabled="false"  value="agree"></div><input type="checkbox" name="" >
                                        我同意  <a href="#" data-toggle="modal" data-target="#t_and_c_m">条款</a>

                                    </label>
                                </div>
                            </div>



                            <div class="col-xs-6">
                                <button type="button" id="submitBtn" class="btn btn-primary btn-block btn-flat">---注册</button>
                            </div>

                            <script  type="text/javascript">



                                $("#submitBtn").click(function() {


                                    alert($('#myform').serialize());
                                    var req = $.ajax({
                                        url:  $('#myform').attr('action'),
                                        type: 'post',
                                        data:  $('#myform').serialize(),
                                    });
                                    req.done(function (data) {
                                        alert("成功:"+data.message);

                                        if (data.status) {
                                            alert("成功:"+data.message);
                                            $('#loading').modal('hide');
                                            window.location.href = data.link;
                                        } else {

                                            alert(data.message);
                                            $('#loading').modal('hide');

                                        }
                                    });
                                });
                            </script>
                        </div>

                    </fieldset>





                </form>


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

    </div>


    </div>

</div>

</body>
</html>