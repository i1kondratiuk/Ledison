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
        var products = data.content;
        $.each(products, function (i, product) {
            console.log(i);
            drawProduct(product);
        });
        function drawProduct(product) {
            var className = "col-xs-6 col-sm-4";
            $('#products').append($('<div>', {
                class: className,
                text: product
            }).html('<a href=""><div class="thumbnail">' +
                '<img src="images/' +
                product.productId + '.jpg" width="400" alt="' +
                product.productName + product.productId + '"/><div class="caption"><h3><a href="">' +
                product.productName + '</a></h3><span style="font-size: 24px;">' +
                product.productPrice + '</span><a href="#" class="btn btn-success pull-right">Купити' +
                '<i class="fa fa-cart-plus" aria-hidden="true"></i></a></div></div></a>'));
        }
    }

    // updateProducts(getProductFilterOptions());
});
