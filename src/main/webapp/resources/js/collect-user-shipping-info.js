$(document).ready(function () {
    var user = {};
    var shippingAddress = {};
    $('#collectCustomerInfo').click(function () {
        var firstName = $("#firstName").val();
        var lastName = $('#lastName').val();
        var email = $('#email').val();
        var phone = $('#phone').val();

        var shippingStreet = $('#shippingStreet').val();
        var shippingApartmentNumber = $('#shippingApartmentNumber').val();
        var shippingCity = $('#shippingCity').val();
        var shippingState = $('#shippingState').val();
        var shippingCountry = $('#shippingCountry').val();

        user.firstName = firstName;
        user.lastName = lastName;
        user.email = email;
        user.phone = phone;

        shippingAddress.shippingStreet = shippingStreet;
        shippingAddress.shippingApartmentNumber = shippingApartmentNumber;
        shippingAddress.shippingCity = shippingCity;
        shippingAddress.shippingState = shippingState;
        shippingAddress.shippingCountry = shippingCountry;

        console.log(user);
        console.log(shippingAddress);
        var jUserAndShippingAddress = JSON.stringify(user + shippingAddress);
        console.log(jUserAndShippingAddress);

        $.ajax({
            url: '/order/',
            type: 'POST',
            data: jUserAndShippingAddress,
            contentType: 'application/json',
            success: function (response) {
                console.log(response);
                $("#reg-form").empty();
                $("#reg-form").text("User " + response.username + " was successfully created");
            },
            error: function () {
                console.log("error!");
            },
        });
    });
});