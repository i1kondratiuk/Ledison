$(document).ready(function () {
    $('#autocomplete').autocomplete({
        serviceUrl: '/products/autocomplete',
        paramName: 'query',
        transformResult: function (response) {
            var json_text = JSON.parse(response);
            return {
                suggestions: $.map(json_text, function (dataItem) {
                    return {value: dataItem, data: dataItem};
                })
            };
        },
        onSelect: function (suggestion) {
            $('#autocomplete').val(suggestion.value);
            jQuery.get("/product/productList/all/search/" + $('#autocomplete').val());
        }
    });
});