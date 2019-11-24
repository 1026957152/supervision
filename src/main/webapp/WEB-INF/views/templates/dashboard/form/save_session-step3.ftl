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
        <li class="active"><strong></strong>总结建立回顾</li>
    </ol>



        <div class="tabpanel">
            <form action="session?step3" method="post"  id="myform">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                <fieldset id="success_tip" class="" style="">

                    <table class="table">
                        <caption>确认信息</caption>
                        <thead>
                        <tr>
                            <th>名称</th>
                            <th>值</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>企业名称</td>
                            <td>Bangalore</td>
                        </tr>
                        <tr>
                            <td>企业类型</td>
                            <td>Mumbai</td>
                        </tr>

                        <tr>
                            <td>公司地址</td>
                            <td>Mumbai</td>
                        </tr>
                        </tbody>
                    </table>


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


                        <div class="col-xs-12">
                            <ul class="list-inline pull-right">

                                <li><a type="" href="${pre_url}" class="btn btn-default btn-block btn-flat">上一步</a></li>
                                <li> <button type="submit" id="submitBtn_" class="btn btn-primary btn-block btn-flat">确立注册</button></li>
                            </ul>
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
                                        window.location.href = data.url;
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