

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


    <div class="col-l">
    </div>
    <div class="well">
        <a href="/swagger-ui.html" class="btn-success btn-lg">待上线接口测试</a>


    </div>
    <div role="tabpanel">
        <ul class="nav nav-tabs" role="tablist">


            <li role="presentation" class="active"><a href="#indexes" aria-controls="coalDeals" role="tab"
                                       data-toggle="tab">统计指标编码，完成率<span class="label label-success">${indexRate}</span></a></li>
            <li role="presentation"><a href="#apis" aria-controls="coalDeals" role="tab"
                                       data-toggle="tab">API，完成率<span class="label label-success">${rate}</span></a></li>
            <li role="presentation"><a href="#rates" aria-controls="rates" role="tab"
                                       data-toggle="tab">rates，完成率<span class="label label-success">${rate}</span></a></li>

            <li role="presentation"><a href="#idea" aria-controls="idea" role="tab"
                                       data-toggle="tab">设计思路</a></li>


        </ul>
        <div class="tab-content">

            <div role="tabpanel" class="tab-pane active" id="indexes">
                <div class="row col-lg-12" style="">
                    <section class="">
                        <table class="table table-striped">
                            <caption>基本的表格布局</caption>
                            <thead>
                            <tr>
                                <th>名称</th>

                                <th>是否完成</th>
                                <th>城市</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list statisticalIndexCodeEnums as category >
                                <tr>
                                    <td>${category.displayValue}</td>

                                    <td>

                                        <#if category.completed>
                                            <span class="label label-success">成功标签</span>

                                        <#else>
                                            <span class="label label-default">默认标签</span>

                                        </#if>

                                    </td>
                                    <td>${category.id}</td>
                                    <td><a href="${category.url}">json返回</a></td>
                                </tr>

                            </#list>

                            </tbody>
                        </table>

                    </section>

                </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="apis">
                <div class="row col-lg-12" style="">
                    <section class="">
                        <table class="table table-striped">
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
                            <#list apis as api >
                                <tr>
                                    <td>${api.服务编号}</td>
                                    <td>${api.服务名称}</td>
                                    <td>${api.服务地址}</td>
                                    <td>
                                        <#if api.是否完成>
                                            <span class="label label-success">成功标签</span>

                                        <#else>
                                            <span class="label label-default">默认标签</span>

                                        </#if>

                                    </td>
                                </tr>

                            </#list>

                            </tbody>
                        </table>

                    </section>

                </div>
            </div>
            <div role="tabpanel" class="tab-pane " id="rates">
                <div class="row col-lg-12" style="">
                    <section class="">
                        <table class="table table-striped">
                            <caption>基本的表格布局</caption>
                            <thead>
                            <tr>
                                <th>名称</th>

                                <th>是否完成</th>
                                <th>城市</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list rates as category >
                                <tr>
                                    <td>${category.displayValue}</td>

                                    <td>

  <#--                                      <#if category.completed>
                                            <span class="label label-success">成功标签</span>

                                        <#else>
                                            <span class="label label-default">默认标签</span>

                                        </#if>-->

                                    </td>
                                    <td>${category.id}</td>
                                    <td><a href="${category.url}">json返回</a></td>
                                </tr>

                            </#list>

                            </tbody>
                        </table>

                    </section>

                </div>
            </div>


            <div role="tabpanel" class="tab-pane" id="idea">
                <div class="row col-lg-12" style="padding-top: 10px;>


                    <section class=">
                        <table  class="table table-striped table-bordered">
                            <thead>
                            <tr>
                                <th>名称</th>
                                <th>内容</th>

                            </tr>
                            </thead>
                            <tbody>

                                <tr>
                                    <td>设计思路</td>
                                    <td>
                                        根据状态表（table)和流水表(stream)推导出任意时刻的状态,进而进行当时的信息统计
                                    </td>

                                </tr>
                                <tr>
                                    <td>设计的库表</td>
                                    <td>


                                        <#list ideas as api >
                                            <table class="table">
<#--
                                                <caption>根据状态表（table)和流水表(stream)推导出任意时刻的状态,进而进行当时的信息统计</caption>
-->
                                                <thead>
                                                <tr>
                                                    <th>服务编号</th>
                                                    <th>服务名称</th>

                                                </tr>
                                                </thead>
                                                <tbody>
                                                <#assign  keys=api?keys/>
                                                <#list  keys as key>
                                                    <tr>
                                                        <td>流水表:${key}</td>

                                                        <td>

                                                            <table class="table">
                                                                <thead>
                                                                <tr>
                                                                    <th>表名称</th>
                                                                    <th></th>

                                                                </tr>
                                                                </thead>
                                                                <tbody>
                                                                <#list  api[key] as flow>
                                                                    <tr>


                                                                        <td>${flow}</td>

                                                                        <td>
                                                                        </td>

                                                                    </tr>
                                                                </#list>
                                                                </tbody>
                                                            </table>


                                                        </td>

                                                    </tr>

                                                </#list>


                                                </tbody>
                                            </table>
                                        </#list>

                                    </td>

                                </tr>
                                <tr>
                                    <td>设计思路</td>
                                    <td>

                                        <#list metadatas as metadata >


                                            ${metadata.table_name}
                                            ${metadata.columnName}

                                        </#list>

                                    </td>

                                </tr>

                            </tbody>
                        </table>





                    </section>

                </div>
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
