<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">

        <div class="container">
            <div class="page-header  text-center">
                <h1>Register Customer</h1>

                <p class="lead  text-center">Please fill in your information below to continue ordering:</p>
            </div>

            <div class="col-lg-3 col-md-3 col-sm-2"></div>
            <div class="col-lg-6 col-md-6 col-sm-8">

                <div id="reg-form">
                    <h3>Basic Info:</h3>
                    <div class="form-group">
                        <label for="firstName">First Name</label>
                        <input id="firstName" name="firstName" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="lastName">Last Name</label>
                        <input id="lastName" name="lastName" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input id="email" name="email" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone</label>
                        <input id="phone" name="phone" class="form-control"/>
                    </div>
                    <br/>


                    <h3>Shipping Address:</h3>
                    <div class="form-group">
                        <label for="shippingStreet">Street Name</label>
                        <input id="shippingStreet" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="shippingApartmentNumber">Apartment Number</label>
                        <input id="shippingApartmentNumber" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="shippingCity">City</label>
                        <input id="shippingCity" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="shippingState">State</label>
                        <input id="shippingState" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="shippingCountry">Country</label>
                        <input id="shippingCountry" class="form-control"/>
                    </div>
                    <br/><br/>

                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button id="collectCustomerInfo" class="btn btn-success">Confirm</button>
                </div>

            </div>
            <div class="col-lg-3 col-md-3 col-sm-2"></div>

        </div>

    </div>
</div>
<script src="/resources/js/collect-user-shipping-info.js">
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
                url: '/order/' + ${cartId},
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
</script>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>