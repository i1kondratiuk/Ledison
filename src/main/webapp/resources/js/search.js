// $(document).ready(function () {
//     $(function () {
//         $('#searchString').keyup(function (e) {
//             clearTimeout($.data(this, 'timer'));
//             if (e.keyCode == 13)
//                 search(true);
//             else
//                 $(this).data('timer', setTimeout(search, 500));
//         });
//
//         function search(force) {
//             var existingString = $("#searchString").val();
//             if (!force && existingString.length < 2) return;
//             $.ajax({
//                 contentType: 'application/json',
//                 url: "/product/search",
//                 type: 'POST',
//                 data: existingString,
//                 success: function (response) {
//                     console.log(response);
//                     doAutocomplete(response);
//                 },
//                 error: function (e) {
//                     console.log("ERROR: ", e);
//                 },
//             })
//                 .done(function (data) {
//                     console.log("Search Completed!");
//                 });
//         }
//
//         function doAutocomplete(response) {
//             var availableTags = [];
//             response.forEach(function (item, i, arr) {
//                 availableTags.push(arr[i].productName);
//             });
//             $('#searchString').html();
//         };
//
//     });
// });
// $(document).ready(function () {
//     $("#searchString").click(function () {
//         $("#x").removeClass('hide');
//     });
//
//     $(".list-group-item").hover(function () {
//         $(this, ".list-group-item").css('background-color', 'rgba(172, 172, 172, 0.11)');
//     }, function () {
//         $(this, ".list-group-item").css('background-color', 'white');
//     });
//
//     $("#searchString").on("trigger", function () {
//         if ($("#searchString").val() == '') {
//             $('#autocompleteTest').empty();
//         }
//         return false;
//     });
//
//     $('#searchString').keyup(function (e) {
//         clearTimeout($.data(this, 'timer'));
//         if (e.keyCode == 13)
//             search(true);
//         else
//             $(this).data('timer', setTimeout(search, 500));
//     });
//
//     function search(force) {
//         var existingString = $("#searchString").val();
//         if (!force && existingString.length < 2) return;
//         $.ajax({
//             contentType: 'application/json',
//             url: "/product/search",
//             type: 'POST',
//             data: existingString,
//             success: function (response) {
//                 console.log(response);
//                 doAutocomplete(response);
//             },
//             error: function (e) {
//                 console.log("ERROR: ", e);
//             },
//         })
//             .done(function (data) {
//                 console.log("Search Completed!");
//             });
//     }
//
//     function doAutocomplete(response) {
//         var availableTags = [];
//         response.forEach(function (item, i, arr) {
//             availableTags.push(arr[i].productName);
//         });
//         $('#searchString').autocomplete({
//             search: function (event, ui) {
//                 $('#autocompleteTest').empty();
//                 $("#x").removeClass('hide')
//             },
//             close: function () {
//                 if ($('#searchString').val() == '') {
//                     $('#autocompleteTest').empty();
//                 }
//                 $("#x").addClass('hide')
//             },
//             minLength: 1,
//             source: availableTags
//         }).data('ui-autocomplete')._renderItem = function (ul, item) {
//             return $('<div/>')
//                 .data('ui-autocomplete-item', item)
//                 .append("<li class='list-group-item'> <div class='row'> <div class='col-md-12'> <div class='media-left media-middle'> <a href='#'> <img class='media-object img-circle' src='http://placehold.it/40x40'> </a> </div> <div id='center'>" + item.value + "<div id='center' class='material-switch pull-right'> <input id='" + item.value + "' name='someSwitchOption001i' type='checkbox'/> <label for='" + item.value + "' class='label-primary'></label> </div> </div> </div> </div> </li>")
//                 .appendTo($('#autocompleteTest'));
//         };
//         $("#x").on("click", function () {
//             $("#searchString").val('');
//         })
//     };
// });

$(document).ready(function () {

    $('#w-input-search').autocomplete({
        serviceUrl: '/product/search',
        paramName: "tagName",
        delimiter: ",",
        transformResult: function (response) {

            return {
                //must convert json to javascript object before process
                suggestions: $.map($.parseJSON(response), function (item) {
                    console.log(item.productName);
                    return {value: item.productName, data: item.productId};
                })

            };

        }

    });

});
