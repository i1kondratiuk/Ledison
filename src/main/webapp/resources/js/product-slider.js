$(document).ready(function () {

    $.ajax({
        type: "POST",
        url: "/recommended",
        contentType: 'text/plain',
        success: function (data) {
            console.log("SUCCESS:", data);
                displayProducts(data);
        },
        error: function (e) {
            console.log("ERROR: ", e);
        },
    });

    function displayProducts(data) {
        $('#recommended-products').empty();
        $.each(data, function (i, product) {
            drawProduct(product);
        });

        function drawProduct(product) {
            let className = "col-xs-6 col-sm-3";
            let imagePath = "/images/" + product.productId + ".jpg";
            let viewProductUrl = "/product/viewProduct/" + product.productId;
            let addToCartUrl = "/rest/cart/add/" + product.productId;

            let div1 = $("<div/>").attr('class', className);
            let div2 = $("<div/>").addClass('thumbnail');
            let a1 = $("<a/>").attr('href', viewProductUrl);
            let img = $("<img/>").addClass('white-border').attr('src', imagePath).attr('width', 400).attr('alt', product.productName + product.productId);
            let div3 = $("<div/>").addClass('caption');
            let h3 = $("<h3/>").attr('style', 'margin-top: 0');
            let a2 = $("<a/>").text(product.productName).attr('href', viewProductUrl);
            let span = $("<span/>").text(product.productPrice).attr('style', 'font-size: 24px');
            let a3 = $("<a/>").addClass('btn btn-success pull-right').text("Buy").attr('href', addToCartUrl);
            let i = $("<i/>").addClass('fa fa-cart-plus').attr('aria-hidden', 'true');

            div1.append(div2);
            div2.append(a1.append(img), div3);
            div3.append(h3.append(a2), span, a3.append(i));

            $('#recommended-products').append(
                div1.append(div2.append(div3))
            );
        }
    }
});