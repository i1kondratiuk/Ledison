$(document).ready(function () {
    $('#autocomplete').autocomplete({
        serviceUrl: '/products/autocomplete',
        paramName: 'query',
        transformResult: function(response) {
            console.log(response);
            return {
                suggestions: $.map(response.myData, function(dataItem) {
                    return { value: dataItem.valueField, data: dataItem.dataField };
                })
            };
        },
        onSelect: function (suggestion) {
            alert('You selected: ' + suggestion.value + ', ' + suggestion.data);
        }
    });

    // source: function (request, response) {
    //     jQuery.get("usernames.action", {
    //         query: request.term
    //     }, function (data) {
    //         // assuming data is a JavaScript array such as
    //         // ["one@abc.de", "onf@abc.de","ong@abc.de"]
    //         // and not a string
    //         response(data);
    //     });
    // },
    // minLength: 3
});