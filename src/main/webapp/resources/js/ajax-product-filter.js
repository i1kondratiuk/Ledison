$(document).ready(function () {



    var query;
    function addSelectAttribute(attribute) {
               query += attribute;
    }
        var data =
            'brand='+brand+
            '&price='+price+
            '&capType='+capType+
            '&glowColor='+glowColor+
            '&lampShape='+lampShape+
            '&power='+power+
            '&operatingVoltage='+operatingVoltage+
            '&diffuserType='+diffuserType+
            '&serviceLife='+serviceLife+
            '&warrantyPeriod='+warrantyPeriod;

        $.ajax({
            url: '${pageContext.servletContext.contextPath}/product/productList/filter',
            type: 'POST',
            data: data,
            async: true,
            success: function(response) {
                $('.filter').remove();

                $.each(response, function() {
                    $('#brand').append('<div class="panel-body"><tr><input type="checkbox" name="brand" value="${brand.brandName}"></tr></div>');
                });
            }
        });


        $("#btn-save").click(function (event) {

            var data = {};
            data["brand"] = $("#brand").val();
            data["price"] = $("#price").val();
            data["capType"] = $("#capType").val();
            data["glowColor"] = $("#glowColor").val();
            data["lampShape"] = $("#lampShape").val();
            data["power"] = $("#power").val();
            data["operatingVoltage"] = $("#operatingVoltage").val();
            data["diffuserType"] = $("#diffuserType").val();
            data["serviceLife"] = $("#serviceLife").val();
            data["warrantyPeriod"] = $("#warrantyPeriod").val();

            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "/path-to/hosting/save",
                data: JSON.stringify(data),
                dataType: 'json',
                timeout: 600000,
                success: function (data) {
                    $('.filter').remove();

                    $.each(data.brand, function(index, item) {
                        $('#brand').append('<div class="panel-body"><tr><input type="checkbox" name="brand" value="${brand.brandName}"></tr></div>');
                    });
                    //...
                },
                error: function (e) {
                    $("#btn-save").prop("disabled", false);
                    //...
                }
            });


        });

    });