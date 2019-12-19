

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

<div class="container" style="margin-bottom:60px; margin-top:20px;max-width:1200px">
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

    <h1 class="page-header">
        <small>     <strong><a href="#"></a></strong> H_1_3_监管主要指标查询_指标明细查询 </small>

    </h1>

    <div class=" col-lg-4" style="">
        <section class="">
            <form class="form-horizontal" role="form">
                <div class="form-group">
                    <label for="firstname" class="col-sm-2 control-label">统计指标编码</label>
                    <div class="col-sm-10">

                        <select class="selectpicker" id="indexSelect" name="tax"   placeholder="">

                            <#list statisticalIndexCodeEnums as category >
                                <option value="${category.指标编码}">  ${category.指标编码}  ${category.指标名称} </option>
                            </#list>

                        </select>

                    </div>
                </div>
                <div class="form-group">
                    <label for="lastname" class="col-sm-2 control-label">统计周期编码</label>
                    <div class="col-sm-10">
                        <select class="selectpicker" id="orderInventoryId" name="tax"   placeholder="">

                            <#list E统计周期编码s as category >
                                <option value="${category.id}">  ${category.id!''}  ${category.displayValue!''} </option>
                            </#list>

                        </select>

                    </div>
                </div>




                <div class="form-group">
                    <label for="lastname" class="col-sm-2 control-label">住建部编码_单位经济类型</label>
                    <div class="col-sm-10">
                        <select class="selectpicker" id="orderInventoryId" name="tax"   placeholder="">

                            <#list 住建部编码_单位经济类型Enums as category >
                                <option value="${category.id}">  ${category.id!''}  ${category.displayValue!''} </option>
                            </#list>

                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="lastname" class="col-sm-2 control-label">住建部编码_收入水平</label>
                    <div class="col-md-10">

                        <select class="selectpicker" id="orderInventoryId" name="tax"   placeholder="">

                            <#list E_住建部编码_收入水平Enums as category >
                                <option value="${category.id}">  ${category.id!''}  ${category.displayValue!''} </option>
                            </#list>

                        </select>

                    </div>
                </div>
                <div class="form-group">
                    <label for="lastname" class="col-sm-2 control-label">住建部编码_收入水平</label>
                    <div class="col-md-10">

                        <select class="selectpicker" id="orderInventoryId" name="tax"   placeholder="">

                            <#list E_住建部编码_购房面积Enums as category >
                                <option value="${category.id}">  ${category.id!''}  ${category.displayValue!''} </option>
                            </#list>

                        </select>

                    </div>
                </div>
                <div class="form-group">
                    <label for="lastname" class="col-sm-2 control-label">银行编码</label>
                    <div class="col-md-10">
                        <select class="selectpicker" id="bankSelect" name="tax"   placeholder="">

                            <#list E_银行编码_HEnums as category >
                                <option value="${category.id}">  ${category.id!''}  ${category.displayValue!''} </option>
                            </#list>
                        </select>

                    </div>
                </div>


            </form>
        </section>

    </div>



    <div class="col-lg-7">


<#--

        <text class="text-danger">{{ .Note}}</text>
-->

<#--

        <table class="table">

            <tbody>

            <tr class="h">
                <th width="200"> 编码</th>
                <th width="200">名称 </th>
                <th>URL</th>
                <th>说明</th>
                <th>状态</th>
            </tr>



            <tr>
                <td>{{.No}}</td>
                <td>{{.Name}}</td>
                <td>{{.Url}}</td>
                <td>{{.Desc}}</td>
                <td>{{.Status}}</td>

            </tr>

            </tbody>
        </table>



        <p class=MsoNormal><b style='mso-bidi-font-weight:normal'><span
                        style='font-size:13.0pt;mso-bidi-font-size:14.0pt;font-family:仿宋_GB2312'>参数说明：<span
                            lang=EN-US></span></span></b></p>
        <table class="table">

            <tbody>
            <tr class="h">
                <th width="200"> 接口参数</th>
                <th>中文描述</th>
                <th>数据类型</th>
                <th>输入/输出</th>
                <th>是否入参</th>


                <th>说明</th>
            </tr>
            {{range .Params}}
            <tr>
                <td>{{.Param}}</td>
                <td>{{.Desc}}</td>
                <td>{{.Type}}</td>
                <td>{{.Inout}}</td>
                <td>{{.IsInvolve}}</td>
                <td>{{.Remark}}</td>

            </tr>
            {{end}}


            </tbody>
        </table>
-->



        <p>
            PostUrl<br>
            <textarea class="form-control" id="post_url" name="deblock_udid" rows="1" style="min-width: 90%">${url}</textarea>
            <br>
            PostDate<br>
            <textarea class="form-control" id="post_data" name="deblock_udid" rows="3" style="min-width: 90%">{"zjbzxbm":""}</textarea>
            <br>
            <button type="button" id="btn_{{.No}}" class="btn btn-primary">查找</button>

            <script>
                // 获取按钮
                // var obtn_{{.No}} = document.getElementById('btn_{{.No}}')
                //  var deblock_udid = document.getElementById('deblock_udid_{{.No}}')
                ;
                // 添加点击事件
                document.getElementById('btn_{{.No}}').onclick = function () {
                    //   alert($('#post_url_{{.No}}').val())
                    // 和服务端交互, 创建ajax对象来交互
                    var xhr = new XMLHttpRequest()
                    xhr.open('post', $('#post_url').val(),true)
                   xhr.setRequestHeader("Content-Type","application/json;");  //用POST的时候一定要有这句
                    xhr.send($('#post_data').val())
                    document.getElementById('btn_{{.No}}').disabled=true
                    document.getElementById('btn_{{.No}}').innerText = "耐心等待...."
                    xhr.onreadystatechange = function () {
                        if (xhr.readyState == 4) {
                            document.getElementById('btn_{{.No}}').disabled=false
                            document.getElementById('btn_{{.No}}').innerText = "查找"
                            if (xhr.status == 200) {
                                // console.log(xhr.responseText)
                                // 将其转化为js对象

                                obj = JSON.parse(xhr.responseText)
                                //  $("#response").val(JSON.stringify(obj));
                                // var jsonObj = JSON.stringify(JSON.parse(obj), null, 4);
                                // $("#response").val(JSON.stringify(obj));
                                //   $("#response").html(JSON.stringify(obj));
                                //alert(JSON.stringify(obj))
                                // document.getElementsByTagName("pre_{{.No}}")[0].innerHTML = JSON.stringify(obj, null, 2);

                                document.getElementById("response_{{.No}}").innerHTML = JSON.stringify(obj, null, 2);


                                /*                 ouser.value = obj.name
                                                 olevel.value = obj.level
                                                 omoney.value = obj.money
                                                 oyear.value = obj.year*/
                            }
                        }
                    }
                }
            </script>
            <br>

            <br>
            <!-- 提供额外的视觉效果，标识一组按钮中的原始动作 -->




            2. 成功返回后，即可获取到用户数据：<br>
        </p>


        <div class="code">

            <pre><code id="response_{{.No}}"></code></pre>



        </div>

        <p>
            3. 返回数据说明：<br>

        </p>


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
    $('#indexSelect').on('hidden.bs.select', function (e) {
        var selectedItem = $('#indexSelect').val();
        var bankSelectedItem = $('#bankSelect').val();

        var map={zjbzxbm: "lily", target:selectedItem, aaaa:bankSelectedItem}
        // do something...
       // selectedServices = $.map($(this).find("option:selected"), function(o) { return o["label"]; });
      //  alert($(this).val());
        //var map = new Map();
     //   var map={zjbzxbm: "lily", target:$(this).val()}
       // map.set("key",);
      //  alert(JSON.stringify(map));
        $('#post_data').val(JSON.stringify(map));
     //   alert("aaaaaaaaaaaaaaaaa")
    });
    $('#bankSelect').on('hidden.bs.select', function (e) {
        var selectedItem = $('#indexSelect').val();
        var bankSelectedItem = $('#bankSelect').val();

        var map={zjbzxbm: "lily", target:selectedItem, aaaa:bankSelectedItem}
        // map.set("key",);
        //  alert(JSON.stringify(map));
        $('#post_data').val(JSON.stringify(map));
        //   alert("aaaaaaaaaaaaaaaaa")
    });


    function operationFormatter(value, row, index) {


        return   '<strong><a href="'+ row.url + '">操作</a></strong>';



    }




</script>
</body>
</html>
