$(document).ready(function () {

    init();
    $("#price-range").slider({});

    function init() {
        var opts = [];
        opts.push('page' + ":" + '1');
        updateProducts(opts);
    }

    var checker = true;

    var $checkboxes = $("input:checkbox, #price-range");
    $checkboxes.on("change", function () {
        checker = true;
        var opts = [];
        opts.push('page' + ":" + '1');
        var min = $('#price-range').data('slider').options.value[0];
        var max = $('#price-range').data('slider').options.value[1];
        var name = $("#price-range").attr("name");
        opts.push(name + "-" + min);
        opts.push(name + "-" + max);
        opts.push(getProductFilterOptions());
        $('#pagination').twbsPagination('destroy');
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

    function updateProducts(opts) {
        $.ajax({
            type: "POST",
            url: "/",
            data: JSON.stringify(opts),
            contentType: 'text/plain',
            timeout: 100000,
            success: function (data) {
                console.log("SUCCESS: ", data);
                if (data.toString() == "") {
                    nothingFound();
                    console.log("Nothing Found!");
                } else {
                    displayProducts(data);
                    doPagination(data);
                }
            },
            error: function (e) {
                console.log("ERROR: ", e);
            },
        });
    }

    function doPagination(data) {
        $('#pagination').twbsPagination({
            first: '<i class="fa fa-chevron-left"></i><i class="fa fa-chevron-left"></i>',
            prev: '<i class="fa fa-chevron-left"></i>',
            next: '<i class="fa fa-chevron-right"></i>',
            last: '<i class="fa fa-chevron-right"></i><i class="fa fa-chevron-right"></i>',
            totalPages: data.totalPages,
            visiblePages: 7,
            onPageClick: function (event, page) {
                var opts = [];
                opts.push('page' + ':' + page);
                var filterOpts = getProductFilterOptions();
                if (filterOpts != null) {
                    opts.push(filterOpts);
                }
                if (checker == false) {
                    checker = false;
                    updateProducts(opts);
                } else checker = false;
            }
        });
    }

    $('#pagination').twbsPagination('destroy');

    function nothingFound() {
        $('#products').empty();
        $('#products').html('<h1 class="text-center text-danger">Nothing Found!</h>');
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
            var viewProduct = "/product/viewProduct/" + product.productId;
            var addToCart = "/rest/cart/add/" + product.productId;
            $('#products').append($('<div>', {
                class: className,
                text: product
            }).html('<a href="' + viewProduct + '"><div class="thumbnail">' +
                '<img src="' + imagePath + '" width="400" alt="' +
                product.productName + product.productId + '"/><div class="caption"><h3 style="margin-top: 0"><a href="' + viewProduct + '">' +
                product.productName + '</a></h3><span style="font-size: 24px;">' +
                product.productPrice + '</span><a href="' + addToCart + '" class="btn btn-success pull-right">Купити' +
                '<i class="fa fa-cart-plus" aria-hidden="true"></i></a></div></div></a>'));
        }
    }
});