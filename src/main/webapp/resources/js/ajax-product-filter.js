$(document).ready(function () {


    $("#price-range").slider({});
    init();

    var min = $('#price-range').data('slider').options.value[0];
    var max = $('#price-range').data('slider').options.value[1];
    $('#min-price').text(min);
    $('#max-price').text(max).addClass('pull-right');

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

    $("#price-range-section").on('click', function () {
        doRequest();
    });

    function doRequest() {
        checker = true;
        var opts = [];
        opts.push('page' + ":" + '1');

        var min = rangeParse($('#price-range').val(), ",")[0];
        var max = rangeParse($('#price-range').val(), ",")[1];
        var name = $("#price-range").attr("name");

        $('#min-price').text(min);
        $('#max-price').text(max).addClass('pull-right');
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
                if (this.value.includes('-')) {
                    opts.push(this.name + "-" + rangeParse(this.value, '-')[0]);
                    opts.push(this.name + "-" + rangeParse(this.value, '-')[1]);
                } else if (!this.name.toLocaleLowerCase().includes('id') && $.isNumeric(this.value)) {
                    opts.push(this.name + "=" + this.value);
                } else {
                    opts.push(this.name + ":" + this.value);
                }
            }
        });

        return opts;
    }

    function rangeParse(value, splitBy) {
        var range = value.split(splitBy);
        return range.concat(range);
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
                if (data.toString() === "") {
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
        let products = data.content;
        $.each(products, function (i, product) {
            drawProduct(product);
        });

        function drawProduct(product) {
            let imagePath = "/images/" + product.productId + ".jpg";
            let viewProductUrl = "/product/viewProduct/" + product.productId;
            let addToCartUrl = "/rest/cart/add/" + product.productId;

            let div1 = $("<div/>").addClass("col-xs-6 col-sm-4");
            let div2 = $("<div/>").addClass('thumbnail');
            let a1 = $("<a/>").attr('href', viewProductUrl);
            let img = $("<img/>").addClass('white-border').attr('src', imagePath).attr('width', 400).attr('alt', product.productName + product.productId);
            let div3 = $("<div/>").addClass('caption');
            let h3 = $("<h4/>").attr('style', 'margin-top: 0').height(50);
            let a2 = $("<a/>").text(product.productName).attr('href', viewProductUrl);
            let span = $("<span/>").text(product.productPrice).attr('style', 'font-size: 24px');
            let a3 = $("<a/>").addClass('btn btn-success pull-right button-buy').text("Buy").attr('href', addToCartUrl);
            let i = $("<i/>").addClass('fa fa-cart-plus').attr('aria-hidden', 'true');

            div1.append(div2);
            div2.append(a1.append(img), div3);
            div3.append(h3.append(a2), span, a3.append(i));

            $('#products').append(
                div1.append(div2.append(div3))
            );
        }
    }
});