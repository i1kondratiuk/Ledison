$(document).ready(function () {
    $('#autocomplete').autocomplete({
        serviceUrl: '/products/autocomplete',
        paramName: 'query',
        transformResult: function (response) {
            var json_text = JSON.parse(response);
            console.log(json_text);
            return {
                suggestions: $.map(json_text, function (item) {
                    return {value: item.productName, data: item.productId};
                })
            };
        },
        onSelect: function (suggestion) {
            window.location.href = '/product/viewProduct/' + suggestion.data;
        }
    });
});