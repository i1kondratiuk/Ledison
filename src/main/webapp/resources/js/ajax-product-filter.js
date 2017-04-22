$(document).ready(function () {

    init();

    function init() {
        var opts = [];
        opts.push('page' + ":" + 1);
        updateProducts(opts);
    }

    var $checkboxes = $("input:checkbox");
    $checkboxes.on("change", function () {
        var opts = getProductFilterOptions();
        updateProducts(opts);
    });

    function getProductFilterOptions() {
        var opts = [];
        $checkboxes.each(function () {
            if (this.checked) {
                opts.push(this.name + ":" + this.value);
            }
        });

        return opts;
    }


    var initCounter = 0;
    function updateProducts(opts) {
        initCounter++;
        $.ajax({
            type: "POST",
            url: "/",
            data: JSON.stringify(opts),
            contentType: 'text/plain',
            timeout: 50000,
            success: function (data) {
                console.log("SUCCESS: ", data);
                displayProducts(data);
                $('#pagination').twbsPagination({
                    startPage: 1,
                    first: '<i class="fa fa-chevron-left"></i><i class="fa fa-chevron-left"></i>',
                    prev: '<i class="fa fa-chevron-left"></i>',
                    next: '<i class="fa fa-chevron-right"></i>',
                    last: '<i class="fa fa-chevron-right"></i><i class="fa fa-chevron-right"></i>',
                    totalPages: data.totalPages,
                    visiblePages: 7,
                    onPageClick: function (event, page) {
                        var opts = [];
                        opts.push('page' + ":" + page);
                        if (initCounter > 0) updateProducts(opts);
                        $('#page-content').text('Page ' + page);
                    }
                });
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
            drawProduct(product);
        });

        function drawProduct(product) {
            var className = "col-xs-6 col-sm-4";
            var imagePath = "/images/" + product.productId + ".jpg";
            $('#products').append($('<div>', {
                class: className,
                text: product
            }).html('<a href=""><div class="thumbnail">' +
                '<img src="' + imagePath + '" id="productImg" width="400" alt="' +
                product.productName + product.productId + '"/><div class="caption"><h3 style="margin-top: 0"><a href="">' +
                product.productName + '</a></h3><span style="font-size: 24px;">' +
                product.productPrice + '</span><a href="#" class="btn btn-success pull-right">Купити' +
                '<i class="fa fa-cart-plus" aria-hidden="true"></i></a></div></div></a>'));
        }
    }

    // updateProducts(getProductFilterOptions());
});
