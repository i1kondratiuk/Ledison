<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Detail</h1>

            <p class="lead">Here is the detail information of the product:</p>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/images/${product.productId}.jpg" />" alt="image" style="width:70%"/>
                </div>
                <div class="col-md-5">
                    <h3>${product.productName}</h3>
                    <p><strong>Manufacturer</strong>: ${product.productManufacturer.productManufacturerName}</p>
                    <p><strong>Category</strong>: ${product.productCategory}</p>
                    <p>${product.productPrice} USD</p>

                    <br/>

                    <c:set var = "urlBack" scope="page" value="/product/productList/all" />
                    <c:set var = "urlAddItem" scope="page" value="/rest/cart/add/${product.productId}" />
                    <sec:authorize var="loggedIn" access="isAuthenticated()"/>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <c:set var="urlBack" scope="page" value="/admin/productInventory" />
                    </sec:authorize>

                    <p>
                        <a href="<c:url value = "${urlBack}" />" class="btn btn-default">Back</a>
                        <sec:authorize access="hasRole('ROLE_USER')">
                            <a href="<spring:url value="${urlAddItem}" />" class="btn btn-warning btn-large"><span class="glyphicon glyphicon-shopping-cart"></span> Order Now</a>
                            <sec:authorize access="!hasRole('ROLE_ADMIN')">
                                <a href="<spring:url value="/customer/cart" />" class="btn btn-default"><span class="glyphicon glyphicon-hand-right"></span> View Cart</a>
                            </sec:authorize>
                        </sec:authorize>
                    </p>

                </div>
            </div>
        </div>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>