<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="col-lg-4 col-md-3 col-sm-2"></div>
    <div class="col-lg-4 col-md-6 col-sm-8">
        <div class="page-header">
            <h1>Register Customer</h1>

            <p class="lead">Please fill in your information below:</p>
        </div>

        <form:form action="/registerCustomer" method="post" modelAttribute="user">

        <h3>Basic Info:</h3>

        <div class="form-group">
            <label for="firstName">First Name</label>
            <form:errors path="firstName" cssStyle="color: #ff0000"/>
            <form:input path="firstName" id="firstName" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="lastName">Last Name</label>
            <form:errors path="lastName" cssStyle="color: #ff0000"/>
            <form:input path="lastName" id="lastName" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <span style="color: #ff0000">${emailMsg}</span>
            <form:errors path="email" cssStyle="color: #ff0000"/>
            <form:input path="email" id="email" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="phone">Phone</label>
            <form:errors path="phone" cssStyle="color: #ff0000"/>
            <form:input path="phone" id="phone" class="form-control"/>
        </div>
        <br/>

        <h3>Shipping Address:</h3>

        <div class="form-group">
            <label for="shippingStreet">Street Name</label>
            <form:errors path="shippingAddress.streetName" cssStyle="color: #ff0000"/>
            <form:input path="shippingAddress.streetName" id="shippingStreet" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="shippingApartmentNumber">Apartment Number</label>
            <form:errors path="shippingAddress.apartmentNumber" cssStyle="color: #ff0000"/>
            <form:input path="shippingAddress.apartmentNumber" id="shippingApartmentNumber" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="shippingCity">City</label>
            <form:errors path="shippingAddress.city" cssStyle="color: #ff0000"/>
            <form:input path="shippingAddress.city" id="shippingCity" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="shippingState">State</label>
            <form:errors path="shippingAddress.state" cssStyle="color: #ff0000"/>
            <form:input path="shippingAddress.state" id="shippingState" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="shippingCountry">Country</label>
            <form:errors path="shippingAddress.country" cssStyle="color: #ff0000"/>
            <form:input path="shippingAddress.country" id="shippingCountry" class="form-control"/>
        </div>

        <br/><br/>

        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/" />" class="btn btn-default">Cancel</a>

        </form:form>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>