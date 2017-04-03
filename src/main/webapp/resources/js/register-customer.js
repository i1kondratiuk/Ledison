$(document).ready(function () {
    console.log("hello");
    var customer = {};

    $("#registerCustomer").click(function () {
        var customerName = $("#customerName").val();
        var customerSurname = $("#customerSurname").val();
        var customerEmail = $("#customerEmail").val();
        var customerPhone = $("#customerPhone").val();

        customer.customerName = customerName;
        customer.customerSurname = customerSurname;
        customer.customerEmail = customerEmail;
        customer.customerPhone = customerPhone;

        var jCustomer = JSON.stringify(customer);

        $.ajax({
            url: '/createCustomer',
            type: 'POST',
            data: jCustomer,
            contentType: 'application/json',
            success: function (response) {
                console.log(response);
            },
            error: function () {
                alert("error!")
            },
        });
    });
});