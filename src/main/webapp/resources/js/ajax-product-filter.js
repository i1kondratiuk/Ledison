$(document).ready(function () {

    init();
    $("#price-range").slider({});

    function init() {
        var opts = [];
        opts.push('page' + ":" + '1');
        updateProducts(opts);
    }

    var checker = true;

    var $checkboxes = $("input:checkbox");
    $checkboxes.on("change", function () {
        doRequest();
    });

    $("#price-range").on("change", function () {
        doRequest();
    });

    function doRequest() {
        checker = true;
        var opts = [];
        opts.push('page' + ":" + '1');
        var range = $('#price-range').val().split(',');
        range = range.concat(range);
        var min = range[0];
        var max = range[1];
        var name = $("#price-range").attr("name");
        opts.push(name + "-" + min);
        opts.push(name + "-" + max);
        opts.push(getProductFilterOptions());
        $('#pagination').twbsPagination('destroy');
        updateProducts(opts);
    }

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
            timeout: 10000,
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
            var viewProductUrl = "/product/viewProduct/" + product.productId;
            var addToCartUrl = "/rest/cart/add/" + product.productId;

            var div1 = $("<div/>").attr('class', className);
            var a1 = $("<a/>").attr('href', viewProductUrl);
            var div2 = $("<div/>").addClass('thumbnail');
            var img = $("<img/>").attr('src', imagePath).attr('width', 400).attr('alt', product.productName + product.productId);
            var div3 = $("<div/>").addClass('caption');
            var h3 = $("<h3/>").attr('style', 'margin-top: 0');
            var a2 = $("<a/>").text(product.productName).attr('href', viewProductUrl);
            var span = $("<span/>").text(product.productPrice).attr('style', 'font-size: 24px');
            var a3 = $("<a/>").addClass('btn btn-success pull-right').text("Buy").attr('href', addToCartUrl);
            var i = $("<i/>").addClass('fa fa-cart-plus').attr('aria-hidden', 'true');

            div1.append(a1.append(div2));
            div2.append(img, div3);
            div3.append(h3.append(a2), span, a3.append(i));

            $('#products').append(
                div1.append(div2.append(div3))
            );
        }
    }
});