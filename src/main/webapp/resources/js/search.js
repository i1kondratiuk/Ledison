$(document).ready(function () {
    $(function () {
        $("#autocomplete").autocomplete({
            source: function (request, response) {
                $.ajax({
                    url: "/product/search",
                    type: "POST",
                    data: {term: request.term},

                    dataType: "json",

                    success: function (data) {
                        console.log(data);
                        response($.map(data, function (v, i) {
                            return {
                                label: v.productName,
                                value: v.productId
                            };
                        }));
                    }
                });
            }
        });
    });
});