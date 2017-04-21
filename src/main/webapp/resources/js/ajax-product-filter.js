$(document).ready(function () {

    console.log("Hello from filter");

    var $checkboxes = $("input:checkbox");
    $checkboxes.on("change", function () {

        var opts = getProductFilterOptions();
        console.log(JSON.stringify(opts));

        updateProducts(opts);
    });

    function getProductFilterOptions() {
        var opts = [];
        $checkboxes.each(function () {
            if (this.checked) {
                opts.push(this.name + ":" + this.value);
            }
        });

        console.log(opts);
        return opts;
    }

    function updateProducts(opts) {
        $.ajax({
            type: "POST",
            url: "/",
            data: JSON.stringify(opts),
            contentType: 'text/plain',
            timeout: 50000,
            success: function (data) {
                console.log("SUCCESS: ", data);
                displayProducts(data)
            },
            error: function (e) {
                console.log("ERROR: ", e);
            },
        });
    }

    function displayProducts(data) {
        $('#products').empty();
        $.each(data.content, function (i, product) {
            console.log(i);
            drawProduct(product);
        });
        function drawProduct(product) {
            var className = "col-xs-6 col-sm-4";
            $('#products').append($('<div>', {
                    class: className,
                    text: product
                })
            );
        }
    }

    // updateProducts(getProductFilterOptions());
});
