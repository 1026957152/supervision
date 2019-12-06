<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <title>榆林煤 手机号注册</title>
    <link href="${rc.contextPath}/components/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <script src="${rc.contextPath}/js/jquery/jquery.js" type="text/javascript"></script>
    <script src="${rc.contextPath}/components/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        $(document).ajaxSend(function(e, xhr, options) {
            xhr.setRequestHeader(header, token);
        });
    </script>
</head>

<body>




<div class="container"  style="margin-bottom:60px; margin-top:20px;max-width:1200px">
    <div class=" col-md-5  col-md-offset-3 " id="register-container">
        <ol class="breadcrumb">


            <li class="active"><strong>第一步</strong> 填写手机号 帐号</li>


        </ol>
        <div class=" " >
            <div class="register-logo">
            </div>

            <div class="box-body box-profile " >





                    <form action="" method="post"  id="myform" role="form"  enctype="multipart/form-data">




                        <fieldset id="default_tip" class="">



                            <div class="form-group has-feedback">


                                <input type="text" class="form-control input-lg " id="phone" name="phone" placeholder="手机号" >


                                <span class="glyphicon glyphicon-user form-control-feedback"></span>
                            </div>


                            <div class="form-group has-feedback hidden">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-xs-6">

                                        <input type="text" class="form-control  " name="checkCode" id="checkCode" placeholder="请输入验证码" value="" <#--onClick="loadCheckCode()"-->>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-xs-6">
                                        <img id="imgCheckCode"  alt="" src="${captcha_register_url}"/>
                                        看不清?<a a href="javascript:" <#-- href="#" -->class="changeCheckCode" rel="external nofollow">换一张</a>
                                        <p id="valid_failed"></p>
                                    </div>


                                </div>
                            </div>

                            <div class="form-group has-feedback">


                                <button type="button" class="btn btn-info "   id="tryGetSMSCodeBtn" ref="${command_send_phone_get_verification_code_Url}" data-toggle="modal" data-target="#myModal">获得短语验证码</button>

                            </div>

                            <span class="button-checkbox">
						        <button type="button" class="btn hidden" data-color="info" tabindex="7">I Agree</button>
                                <input type="checkbox" name="t_and_c" id="t_and_c" class="hidden" value="1">
					        </span>

                            <div class="form-group has-feedback hidden">


                                <input type="text" class="form-control  " name="checkCode" id="uuid"  value="" >

                            </div>

                        </fieldset>

                    </form>





                <div class="form-group has-feedback">
                    <div class="row">
                        <div class="col-md-6 col-xs-5">


                            <input class="form-control input-validation-error"  id="smsCode" data-val="true" placeholder="短语验证码"  name="activeCode" type="text" >


                        </div>


                    </div>
                </div>

                <button type="button" id="submit_phone" ref="${command_reset_phone_register_with_verification_code_Url}" class="btn btn-primary bt-lg "  >确定</button>
                <script type="text/javascript">

                    $("#tryGetSMSCodeBtn").attr("disabled", true);
                    $("#submit_phone").attr("disabled", true);

                    $("#phone").keyup(function () {
                        var phone_len = $("#phone").val().trim().length;

                        if (phone_len < 11) {
                            //  $("#valid_failed").text("");
                        } else if (phone_len > 10) {

                            $("#form_phone").val($("#phone").val());
                            //    $("#valid_failed").text("验证码错误");
                            $("#tryGetSMSCodeBtn").prop("disabled", false);


                        }
                    });


                    var $btn = $("#tryGetSMSCodeBtn");
                    $("#tryGetSMSCodeBtn").click(function() {

                      //  alert("ddddddd");
                        var data = {
                        };

                        data['${_csrf.parameterName}'] = "${_csrf.token}";
                        data['userId'] = $("#phone").val();
                        data['activeCode'] = "{userCreateForm.mobile!''}";

                        $.post($(this).attr('ref'), data,function(result) {
                              //  alert(JSON.stringify(result));

                            if (result.status) {

                                $("#uuid").val(result.uuid);
                                alert("验证码，已发送到您的手机，请查收");
                                sendCount();
                            } else {
                                alert("验证码发送错误，"+result.message);

                            }
                        })

                    });

                </script>

            </div>

        </div>


    </div>

</div>


<script type="text/javascript">
    $(function () {



        $(".changeCheckCode").bind('click',function(){
            var imgCheckCode = $("#imgCheckCode");
            var imgSrc = imgCheckCode.attr("src");
            imgCheckCode.attr("src",changeImgUrl(imgSrc));
        });

        function changeImgUrl(url){
            var timestamp = (new Date()).valueOf();
            var changeUrl = url.substring(0,17);
            if((url.indexOf("&")>=0)){
                changeUrl = url + "×tamp=" + timestamp;
            }else{
                changeUrl = url + "&timestamp=" + timestamp;
            }
            return changeUrl;
        }



    });















    function loadCheckCode(){
        document.getElementById('imgCheckCode').style.display='block';
    }
    var    codeLength = 4;
    function verify_code (){
        var req = $.ajax({
            type: 'post',
            url: '${do_verify_url}',
            data: {checkCode: $('#checkCode').val()}
        });
        req.done(function (data) {
            if (data) {

                alert("返回成功");
                return true;


            }  else {

                alert(data.message);
                return false;
            }
        });

        alert("墨梅晚会");
        return true;


    }


    $("#checkCode").keyup(function () {
        var code_len = $("#checkCode").val().trim().length;
        if (code_len < codeLength) {
            $("#valid_failed").text("");
        } else if (code_len > codeLength) {
            $("#valid_failed").text("验证码错误");
            $("#tryGetSMSCodeBtn").attr("disabled", true);
        } else {
            //  alert("测试含税"+verify_code());

            var req = $.ajax({
                type: 'get',
                url: '${do_verify_url}',
                data: {checkCode: $('#checkCode').val()}
            });
            req.done(function (data) {
                if (data) {
                    //  alert("验证成功");
                    $("#valid_failed").text("验证成功,已发送验证短信，请查收");
                    //    $("#tryGetSMSCodeBtn").attr("disabled", false);

                    sendSMS();
                } else {

                    $("#valid_failed").text("验证码错误");
                }
            });

        }
    });








    var count,counts=60;
    function sendCount(){
        count = counts;
        $btn.addClass("disabled");
        $btn.removeClass("hidden");

        //$btn.html();
        var timer = setInterval(function () {
            if(count == 0){
                clearInterval(timer);
                $btn.removeClass("disabled");
                $btn.html('重新请输入验证码');
            }else{
                $btn.addClass("disabled");
                count--;
                $btn.html("剩余"+count+"秒");
                $btn.attr("data-complete-text","test"+count);
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



    $("#submit_phone").bind('click',function(){
/*
        alert("验证码，已发送到您的手机，请查收"+　$("#uuid").val());
*/

        var data = {
        };

        data['${_csrf.parameterName}'] = "${_csrf.token}";
        data['smsCode'] = $("#smsCode").val();
        data['sessionUuid'] =  $("#uuid").val();

        $.post($(this).attr('ref'), data,function(result) {

            if (result.status) {
             //   alert(result.message);
                //激活成功
                window.location.href = result.link;

                //$('#open-account-request-table').bootstrapTable('refresh');
            } else {
                alert(result.message);
            }
        })


    });



</script>

</body>


</html>