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
    <div class="col-md-12  col-md-offset-0 " id="register-container">
    <ol class="breadcrumb">
        <li class="active"><strong></strong>建立地址信息</li>
    </ol>



        <div class="tabpanel">
            <ul class="nav nav-tabs " id="ajaxTabs" role="tablist">

                <li role="presentation " class="active"><a href="#editCompanyInfo" aria-controls="account" role="tab"
                                                           data-toggle="tab">建立地址信息 <span class="badge"></span></a></li>

            </ul>


            <div  class="tab-content">

                <div class="tab-pane active" id="editCompanyInfo">
                    <div class="" style="margin-top:5%;">

           <#--         <div class="col-lg-6">-->
                        <form id="companyEditForm" class="form-horizontal " role="form" action="?step2" method="post">

                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<#--                            <div class="form-group">
                                <label for="initialAmount" class="col-lg-2 control-label">名称</label>
                                <div class="col-lg-6">

                                    <input type="text" class="form-control" id="name" name="name"  placeholder="名称" value="name">


                                </div>
                            </div>-->


                            <fieldset id="city_china">



                                <input type="hidden" id="province" name="province" placeholder="省" value="">
                                <input type="hidden"  id="city" name="city" placeholder="市" value="">
                                <input type="hidden"  id="district" name="county" placeholder="县" value="">
                                <input type="hidden"  id="street" name="town" placeholder="镇" value="">
                                <input type="hidden"  id="streetNumber" name="village" placeholder="详细地址" value="">



                            </fieldset>
                            <div class="form-group">
                                <label for="initialQuantity" class="col-lg-2 control-label">地址</label>
                                <div  class="col-lg-10 form-inline" role="form">

                                    <!-- 省下拉框 -->
                                    <select class="form-control " id="provinceList" name="provinceId">
                                    </select>

                                    <!-- 市下拉框 -->
                                    <select class="form-control " id="cityList" name="cityId">
                                    </select>

                                    <!-- 区下拉框 -->
                                    <select class="form-control " id="districtList" name="countyId">
                                    </select>

                                    <!-- 区下拉框 -->
                                    <select class="form-control " id="townList" name="townId">
                                    </select>

                                    <!-- 村下拉框 -->
                                    <select class="form-control " id="villageList" name="villageId">
                                    </select>



                                    <script>

                                        //请求基础地址
                                        var baseUrl = "";

                                        //初始化
                                        $(function () {
                                            getProvince();
                                        });




                                        //依据国家id获取对应的省列表
                                        function getProvince() {
                                            var provinceUrl = baseUrl + "${getProvince}";
                                            //获取省json数据



                                            $.getJSON(provinceUrl, function (data) {
                                                if (data.provinceList.length != 0) {
                                                    resetSelect("province","city", "district","town","village");

                                                    //迭代省json数据
                                                    /*                alert("getProvinceByCountry"+JSON.stringify(data));*/
                                                    $.each(data.provinceList, function (index, value) {
                                                        //添加一个下拉选择项
                                                        $("#provinceList").append("<option value='" + value.PROVINCE_ID + "'>" + value.PROVINCE_NAME + "</option>");
                                                    })
                                                } else {
                                                    //没有相关省信息
                                                }
                                            })
                                        }


                                        //依据国家id获取对应的省列表
                                        function getProvinceByCountry(countryId) {
                                            var provinceUrl = baseUrl + "${getProvinceByCountry}";
                                            //获取省json数据



                                            $.getJSON(provinceUrl, { "countryId": countryId }, function (data) {
                                                if (data.provinceList.length != 0) {
                                                    //迭代省json数据
                                                    /*                alert("getProvinceByCountry"+JSON.stringify(data));*/
                                                    $.each(data.provinceList, function (index, value) {
                                                        //添加一个下拉选择项
                                                        $("#provinceList").append("<option value='" + value.PROVINCE_ID + "'>" + value.PROVINCE_NAME + "</option>");
                                                    })
                                                } else {
                                                    //没有相关省信息
                                                }
                                            })
                                        }

                                        //依据省id获取对应的市列表
                                        function getCityByProvince(provinceId) {
                                            var cityUrl = baseUrl + "${getCityByProvince}";
                                            //获取市json数据
                                            $.getJSON(cityUrl, { "provinceId": provinceId }, function (data) {
                                                /*            alert(JSON.stringify(data));*/
                                                if (data.cityList.length != 0) {
                                                    //迭代市json数据
                                                    $.each(data.cityList, function (index, value) {
                                                        //添加一个下拉选择项
                                                        $("#cityList").append("<option value='" + value.CITY_ID + "'>" + value.CITY_NAME + "</option>");
                                                    })
                                                } else {
                                                    //没有相关市信息
                                                }
                                            })
                                        }

                                        //获取对应市下面的县和区
                                        function getDistrictByCity(cityId) {
                                            var districtUrl = baseUrl + "${getDistrictByCity}";
                                            //获取市json数据
                                            $.getJSON(districtUrl, { "cityId": cityId }, function (data) {
                                                if (data.districtList.length != 0) {
                                                    //迭代县json数据
                                                    $.each(data.districtList, function (index, value) {
                                                        //添加一个下拉选择项
                                                        $("#districtList").append("<option value='" + value.DISTRICT_ID + "'>" + value.DISTRICT_NAME + "</option>");
                                                    })
                                                } else {
                                                    //没有相关县信息
                                                }
                                            })
                                        }

                                        //获取对应市下面的县和区
                                        function getTownByCounty(countyId) {
                                            var districtUrl = baseUrl + "${getTownByCounty}";
                                            //获取市json数据
                                            $.getJSON(districtUrl, { "countyId": countyId }, function (data) {
                                                if (data.townList.length != 0) {
                                                    //迭代县json数据
                                                    $.each(data.townList, function (index, value) {
                                                        //添加一个下拉选择项
                                                        $("#townList").append("<option value='" + value.TOWN_ID + "'>" + value.TOWN_NAME + "</option>");
                                                    })
                                                } else {
                                                    //没有相关县信息
                                                }
                                            })
                                        }

                                        //获取对应市下面的县和区
                                        function getVillageByTown(townId) {
                                            var villageUrl = baseUrl + "${getVillageByTown}";
                                            //获取市json数据
                                            $.getJSON(villageUrl, { "townId": townId }, function (data) {
                                                if (data.villageList.length != 0) {
                                                    //迭代县json数据
                                                    $.each(data.villageList, function (index, value) {
                                                        //添加一个下拉选择项
                                                        $("#villageList").append("<option value='" + value.VILLAGE_ID + "'>" + value.VILLAGE_NAME + "</option>");
                                                    })
                                                } else {
                                                    //没有相关县信息
                                                }
                                            })
                                        }



                                        //省列表下拉框发生改变时
                                        $("#provinceList").change(function () {
                                            //重置市区
                                            resetSelect( null, "city", "district","town","village");
                                            //获取下拉框选中项的value属性值
                                            var provinceId = $("#provinceList").val();
                                            //获取对应国家下面的省列表
                                            getCityByProvince(provinceId);
                                        });

                                        //市列表下拉框发生改变时
                                        $("#cityList").change(function () {
                                            //重置区
                                            resetSelect( null, null, "district","town","village");
                                            //获取下拉框选中项的value属性值
                                            var cityId = $("#cityList").val();
                                            //获取对应国家下面的省列表
                                            getDistrictByCity(cityId);
                                        });


                                        //市列表下拉框发生改变时
                                        $("#districtList").change(function () {
                                            //重置区
                                            resetSelect(null, null,null,"town","village");
                                            //获取下拉框选中项的value属性值
                                            var countyId = $("#districtList").val();
                                            //获取对应国家下面的省列表
                                            getTownByCounty(countyId);
                                        });

                                        //市列表下拉框发生改变时
                                        $("#townList").change(function () {
                                            //重置区
                                            resetSelect( null, null,null,null,"village");
                                            //获取下拉框选中项的value属性值
                                            var townId = $("#townList").val();
                                            //获取对应国家下面的省列表
                                            getVillageByTown(townId);
                                        });
                                        $("#villageList").change(function () {
                                            $("#province").val($("#provinceList option:selected").text());
                                            $("#city").val($("#cityList option:selected").text());
                                            $("#district").val($("#districtList option:selected").text());
                                            $("#street").val($("#townList option:selected").text());
                                            $("#streetNumber").val($("#villageList option:selected").text());

                                        });


                                        //重置国家省市区控件
                                        function resetSelect(province, city, district,town,village) {

                                            if (province) {
                                                //清除省列表
                                                resetSelectByLabelId("provinceList", "请选择省");
                                            }
                                            if (city) {
                                                //清除市列表
                                                resetSelectByLabelId("cityList", "请选择市");
                                            }
                                            if (district) {
                                                //清除县列表
                                                resetSelectByLabelId("districtList", "请选择县/区");
                                            }

                                            if (town) {
                                                //清除县列表
                                                resetSelectByLabelId("townList", "请选择镇");
                                            }

                                            if (village) {
                                                //清除县列表
                                                resetSelectByLabelId("villageList", "请选择乡/村");
                                            }
                                        }

                                        //依据标签id重置
                                        function resetSelectByLabelId(labelId, message) {
                                            $("#" + labelId + " option").remove();
                                            $("#" + labelId).append("<option value='-1'>" + message + "</option>");
                                        }

                                        //重置所有控件
                                        function resetAll() {
                                            //初始化
                                            getProvince();
                                        }

                                        //获取国家id
                                        function getCountryId() {
                                            return $("#countryList").val();
                                        }

                                        //获取省id
                                        function getProvinceId() {
                                            return $("#provinceList").val();
                                        }

                                        //获取市id
                                        function getCityId() {
                                            return $("#cityList").val();
                                        }

                                        //获取区id
                                        function getDistrictId() {
                                            return $("#districtList").val();
                                        }
                                        function getTownId() {
                                            return $("#townList").val();
                                        }
                                    </script>


                                </div>

                            </div>


                            <div class="col-xs-12">


                                    <ul class="list-inline pull-right">

                                        <li><a type="" href="{pre_url}" class="btn btn-default btn-block btn-flat">上一步</a></li>
                                        <li><button id="companyEditFormBtn" type="submit" class="btn btn-primary ">下一步</button></li>
                                    </ul>
                            </div>



                            </div>


                        </form>

                    </div>

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

    </div>


    </div>

</div>

</body>
</html>