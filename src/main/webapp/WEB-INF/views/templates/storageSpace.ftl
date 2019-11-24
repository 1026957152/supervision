<#--<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />-->

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>个人中心 提货单 </title>

    <link href="${rc.contextPath}/components/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <link href="${rc.contextPath}/components/bootstrap-select/css/bootstrap-select.min.css" rel="stylesheet">
    <script src="${rc.contextPath}/js/jquery/jquery.js" type="text/javascript"></script>
    <script src="${rc.contextPath}/components/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<div class="container" style="margin-bottom:80px; margin-top:10px">
<ol class="breadcrumb">
    <li class="active">堆场管理</li>
    <li class="active">装车信息</li>
</ol>

<div class="row">


<#if deliveryOrderMap??>
<div class="col-lg-6">



<div class="">



    <table class="table" data-show-header="false">
        <thead>
        <tr>
            <th colspan="">基本信息</th>
            <th>${deliveryOrder.no}</th>
        </tr>

        </thead>
        <tbody>

        <tr>
            <td class="active">状态：</td>
            <td colspan="3">

                <#if deliveryOrder.status =="Valid">

                    有效
                <#else>
                    无效
                </#if>
            </td>
        </tr>

            <#if deliveryOrder.status =="Valid">
            <tr>
                <td class="active">提货密码</td>
                <td colspan="3"><strong>${deliveryOrder.accessCode!''}</strong></td>
            </tr>
            </#if>
        <tr>
            <td class="active">贸易商</td>
            <td colspan="3"><a href="${deliveryOrder.distributorUrl!''}">${deliveryOrder.companyName!''}</a></td>
        </tr>







        <tr>
            <td class="active">货物：</td>
            <td><a href="${deliveryOrder.productUrl!''}" > ${deliveryOrder.productName!''}</a></td>
        </tr>

        <tr>
            <td class="active">建立时间</td>
            <td colspan="3">{deliveryOrder.createDate}</td>
        </tr>



        <tr>
            <th>车辆信息</th>
            <th></th>
        </tr>



        <tr id="tr-id-1" class="tr-class-1">
            <td id="td-id-1" class="td-class-1 success">
                车牌号
            </td>
            <td>${deliveryOrder.plateNumber!''}</td>
        </tr>


        <tr id="tr-id-1" class="tr-class-1">
            <td id="td-id-1" class="td-class-1 success">
                类型
            </td>
            <td>${deliveryOrder.vehicleType!'未定义'}</td>
        </tr>


        <tr>
            <th>司机信息</th>
            <th></th>
        </tr>




        <tr id="tr-id-1" class="tr-class-1">
            <td id="td-id-1" class="td-class-1 success">
                名字
            </td>
            <td><a href=""> ${deliveryOrder.carrierName!'---'}</a></td>
        </tr>

        <tr id="tr-id-1" class="tr-class-1">
            <td id="td-id-1" class="td-class-1 success">
                电话
            </td>
            <td><a href="tel:${deliveryOrder.carrierPhone!''}">${deliveryOrder.carrierPhone!''}</a>
            </td>
        </tr>


        <tr>
            <th>装货情况</th>
            <th></th>
        </tr>

        <tr id="tr-id-1" class="tr-class-1">
            <td id="td-id-1" class="td-class-1 success">
                状态
            </td>
            <td> ${deliveryOrder.operationStatus!'---'}</td>
        </tr>

        <tr id="tr-id-1" class="tr-class-1">
            <td id="td-id-1" class="td-class-1 success">
                入场时间
            </td>
            <td>${deliveryOrder.boundTime!'--'}
            </td>
        </tr>

        <tr id="tr-id-1" class="tr-class-1">
            <td id="td-id-1" class="td-class-1 success">
                离场时间
            </td>
            <td>${deliveryOrder.outboundTime!'--'}
            </td>
        </tr>

        <tr id="tr-id-1" class="tr-class-1">
            <td id="td-id-1" class="td-class-1 success">
                皮重/净重
            </td>
            <td>${deliveryOrder.tareWeight!'--'}/${deliveryOrder.netWeight!'--'}
            </td>
        </tr>

        </tbody>
    </table>



</div>


<label>扫一扫微信获得信息 </label>

<div class="thumbnail">
    <img src="${qrcodeUrl!'/logo.png'}">
</div>

    <#if verification??>

    <table  class="table table-condensed">
        <thead>
        <tr>
            <th>验证信息</th>
            <th></th>


        </tr>
        </thead>
        <tbody>
        <tr  >
            <td class="active">揽货验证密码：</td>
            <td >    <input type="text" id="demandNum" name="demandNum"  placeholder="测试-揽货密码" value="${verification.code}"/></td>
        </tr>
        <tr>
            <td class="active">验证二维码</td>
            <td>


                <script type="text/javascript" src="/qrcode.js"></script>
                <input id="text" type="text" value="${qrcodeContent!''}" style="width:80%" />
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

                        /*                           if (!elText.value) {
                                                       alert("Input a text");
                                                       elText.focus();
                                                       return;
                                                   }*/

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
            </td>
        </tr>
        </tbody>
    </table>
    </#if>

</div>
<#else>
<div class="col-lg-12">
    <form id="longitudeLatitudeForm" class="navbar-form" role="search" action="{getUrl}">
        <input  type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <div class="form-group">
        <input class="input-lg" type="text" class="form-control" name="code" placeholder="" value="">
    </div>
<#--            <div class="form-group">
                <input type="text" class="form-control" name="latitude" placeholder="latitude 纬度" value="${destinationLatAndLng.bd09Lat!''}">
            </div>-->
    <button id="longitudeLatitudeFormFormBtn" type="button" class="btn btn-primary  btn-lg">提取</button>
</form>

    <script  type="text/javascript">

        $("#longitudeLatitudeFormFormBtn").click(function() {
            alert($('#longitudeLatitudeForm').serialize());
            var req = $.ajax({
                url:  $('#longitudeLatitudeForm').attr('action'),
                type: 'POST',
                data:  $('#longitudeLatitudeForm').serialize(),
            });
            req.done(function (data) {
                alert("成功:"+data.message);

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

</#if>
<div class="col-lg-6">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">面板标题</h3>
        </div>
        <div class="panel-body">
            <tr>
                <th>分销商账户信息</th>
                <th></th>
            </tr>
            <tr>
                <td class="active">可用余额</td>
                <td colspan="3"><a href="${deliveryOrder.inventoryUrl!''}">${deliveryOrder.advancedPaymentAmount!''}</a></td>
            </tr>
            <tr>
                <td class="active">库存</td>
                <td colspan="3"><a href="${deliveryOrder.distributorUrl!''}">${deliveryOrder.inventory!''}</a></td>
            </tr>
        </div>
    </div>


    <button id="addBtn" type="button" class="btn btn-primary btn-lg hidden"  data-toggle="modal" data-target="#addLineModal">
        录入皮重
    </button>

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

</div>


</div>





<script type="text/javascript">
    function queryParams(params) {
        params.page = params.pageNumber - 1;
        params.size = params.pageSize;
        var status = $.trim($("#status").val());


        if (status) {
            params.status = status;
        }

        return params;
    }


    function handleResponse(original) {
        var res = {};
        res.rows = original.content;
        res.total = original.totalElements;

        return res;
    }




</script>
</body>
</html>