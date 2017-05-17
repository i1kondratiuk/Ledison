$(document).ready(function () {
    $(function () {
        function doAutocomplete(availableTags) {
            $('#searchString').autocomplete({
                source: availableTags
            });
        };

        $('#searchString').keyup(function (e) {
            clearTimeout($.data(this, 'timer'));
            if (e.keyCode == 13)
                search(true);
            else
                $(this).data('timer', setTimeout(search, 500));
        });
        function search(force) {
            var existingString = $("#searchString").val();
            if (!force && existingString.length < 2) return;
            $.ajax({
                contentType: 'application/json',
                url: "/product/search",
                type: 'POST',
                data: existingString,
                success: function (response) {
                    console.log(response);
                    var availableTags = [];
                    response.forEach(function (item, i, arr) {
                        console.log(arr[i].productName);
                        availableTags.push(arr[i].productName);
                    });
                    doAutocomplete(availableTags);
                },
                error: function (e) {
                    console.log("ERROR: ", e);
                },
            })
                .done(function (data) {
                    console.log("Search Completed!");
                });
        }
    });
});