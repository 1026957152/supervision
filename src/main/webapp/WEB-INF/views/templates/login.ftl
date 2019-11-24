<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>榆林煤  用户登录</title>
    <link href="${rc.contextPath}/components/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="${rc.contextPath}/js/jquery/jquery.js"></script>
    <script src="${rc.contextPath}/components/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>




</head>
<body>
<div class="container" style="margin-bottom:60px; margin-top:20px;max-width:1200px">

    <h1 class="page-header">
        <small>  <img class="" src="${rc.contextPath}/images/logo_header.png" style="width:150px; ;">    <strong><a href="#"></a></strong> fuck 统一认证 </small>

    </h1>
    <div class=" col-md-5  col-md-offset-3 " id="register-container">

        <ul class="nav nav-tabs " id="ajaxTabs" role="tablist">

            <li role="presentation" class="active"><a href="#companies" aria-controls="capitalHistory" role="tab"
                                                      data-toggle="tab">密码登录 <span class="badge"></span></a></li>

            <li role="presentation" class=""><a href="#sms" aria-controls="capitalHistory" role="tab"
                                                      data-toggle="tab">短信登录 <span class="badge"></span></a></li>


<#--            <li role="presentation" class=""><a href="#active" aria-controls="account" role="tab"
                                                data-toggle="tab">激活员工帐号<span class="badge"></span></a></li>-->
            <li role="presentation" class=""><a href="#wechat" aria-controls="account" role="tab"
                                                data-toggle="tab">微信登录<span class="badge"></span></a></li>
            <li role="presentation" class=""><a href="#account" aria-controls="account" role="tab"
                                                data-toggle="tab">注册帐号<span class="badge"></span></a></li>

        </ul>

        <div  class="tab-content">

            <div class="tab-pane active" id="companies">
                <div class="box-body box-profile " style="margin-top:5%;">


                    <form method="post" id="login_form" action="${rc.contextPath}/login" role="login">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<#--
                        <input type="" name="url" value="${url}"/>
-->

                        <fieldset>

                            <div class="form-group">
                                <input type="" name="username" id="phone" placeholder="请输入邮箱"
                                       class="form-control "/>
                            </div>
                            <div class="form-group">
                                <input type="password" name="password" class="form-control " id="password"
                                       placeholder="请输入密码"/>
                            </div>

                            <div class="form-group">
                                <div class="row">
                                    <div class="col-md-6">
                                        记住我: <input type="checkbox" name="remember-me" />
                                    </div>

                                </div>
                            </div>
                                    <#if openId??>
                                                                    <input  name="openId" class="form-control "type="hidden" value="${openId!''}"/>

                                                                            <div class="form-group">
                                                                                <div class="row">
                                                                                    <div class="col-md-6">
                                                                                        绑定微信: <input type="checkbox" name="bind-me" />
                                                                                    </div>

                                                                                </div>
                                                                            </div>

                                    <#else>

                                    </#if>


                        <#if error??>
                            <div class="form-group has-error" id="msg">
                                <span class="help-block" id="serverMsg">${error!''}</span>
                            </div>
                        </#if>





                            <div class="form-group">
                                <button type="submit"  class="btn  btn-primary btn-block">登录
                                </button>
                            </div>

                        </fieldset>
                    </form>


                </div>


            </div>

            <div class="tab-pane " id="sms">
                <div class="box-body box-profile " style="margin-top:5%;">


                    <form method="post" id="sms_login_form" action="${rc.contextPath}/health" role="login">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input type="hidden" class="form-control  " name="sessionId" id="sessionId"  value="" placeholder="sessionId">
<#--
                        <input type="" name="url" value="${url}"/>
-->

                        <fieldset>

                            <div class="form-group">
                                <input type="" name="phone" id="smsphone" placeholder="请输入手机号"
                                       class="form-control "/>
                            </div>


                            <div class="form-group has-feedback">


                                <button type="button" class="btn btn-info "   id="tryGetSMSCodeBtn" ref="${get_verification_code_Url}" data-toggle="modal" data-target="#myModal">获得短语验证码</button>

                            </div>



                            <div class="form-group has-feedback">
                                <div class="row">
                                    <div class="col-md-6 col-xs-5">


                                        <input class="form-control input-validation-error"  id="smsCode" data-val="true" placeholder="短语验证码"  name="smsCode" type="text" >


                                    </div>


                                </div>
                            </div>


                            <div class="form-group">
                                <div class="row">
                                    <div class="col-md-6">
                                        记住我: <input type="checkbox" name="remember-me" />
                                    </div>

                                </div>
                            </div>



                                    <#if openId??>
                                                                    <input  name="openId" class="form-control "type="hidden" value="${openId!''}"/>

                                                                            <div class="form-group">
                                                                                <div class="row">
                                                                                    <div class="col-md-6">
                                                                                        绑定微信: <input type="checkbox" name="bind-me" />
                                                                                    </div>

                                                                                </div>
                                                                            </div>

                                    <#else>

                                    </#if>
                        <#if error??>
                            <div class="form-group has-error" id="msg">
                                <span class="help-block" id="serverMsg">${error!''}</span>
                            </div>
                        </#if>





                            <div class="form-group">
                                <button type="submit" id="submit_phone" class="btn  btn-primary btn-block">登录
                                </button>
                            </div>

                            <script type="text/javascript">

                                $("#tryGetSMSCodeBtn").attr("disabled", true);
                                $("#submit_phone").attr("disabled", true);

                                $("#smsphone").keyup(function () {
                                    var phone_len = $("#smsphone").val().trim().length;

                                    if (phone_len < 11) {
                                        //  $("#valid_failed").text("");
                                    } else if (phone_len > 10) {

                                        $("#form_phone").val($("#phone").val());
                                        //    $("#valid_failed").text("验证码错误");
                                        $("#tryGetSMSCodeBtn").prop("disabled", false);


                                    }
                                });


                                $("#tryGetSMSCodeBtn").click(function() {

                                    var data = {
                                    };

                                    data['${_csrf.parameterName}'] = "${_csrf.token}";
                                    data['phone'] = $("#smsphone").val();
                                    data['activeCode'] = "{userCreateForm.mobile!''}";

                                    $.post($(this).attr('ref'), data,function(result) {
                                        //  alert(JSON.stringify(result));

                                        if (result.status) {

                                            $("#sessionId").val(result.uuid);
                                            alert("验证码，已发送到您的手机，请查收");
                                            sendCount();
                                        } else {
                                            alert("验证码发送错误，"+result.message);

                                        }
                                    })

                                });

                                var count,counts=60;
                                function sendCount(){
                                    count = counts;
                                    $("#tryGetSMSCodeBtn").addClass("disabled");
                                    $("#tryGetSMSCodeBtn").removeClass("hidden");

                                    //$btn.html();
                                    var timer = setInterval(function () {
                                        if(count == 0){
                                            clearInterval(timer);
                                            $("#tryGetSMSCodeBtn").removeClass("disabled");
                                            $("#tryGetSMSCodeBtn").html('重新请输入验证码');
                                        }else{
                                            $("#tryGetSMSCodeBtn").addClass("disabled");
                                            count--;
                                            $("#tryGetSMSCodeBtn").html("剩余"+count+"秒")
                                            $("#tryGetSMSCodeBtn").attr("data-complete-text","test"+count);
                                            console.log(count);
                                        }
                                    },1000);
                                }







                                $("#smsCode").keyup(function () {

                                    var code_len = $("#smsCode").val().trim().length;
                                    if (code_len < 4) {
                                    } else if (code_len > 3) {

                                        $("#submit_phone").prop("disabled", false);

                                    }
                                });


                            </script>

                        </fieldset>
                    </form>


                </div>


            </div>

            <div class="tab-pane " id="account">
                <div class="" style="margin-top:5%;">


                    <a href="${registerByPhoneUrl}" class="btn-primary btn btn-lg"> 手机号 注册 </a>


                </div>

            </div>
<#--
            <div class="tab-pane " id="active">
                <div class="" style="margin-top:5%;">

                    <a href="${registerUrl}" class="btn-primary btn btn-lg"> 员工帐号激活 </a>


                </div>

            </div>
-->
            <div class="tab-pane " id="wechat">
                <div class="" style="margin-top:5%;">


                    <h1>hello! <label th:text="${name}"></label>${name}</h1>
                    <a  href="${oauthUrl!'--'}">点击扫码登录${oauthUrl!'--'}</a>

                </div>

            </div>



        </div>



        </div>
</div>




</body>
</html>