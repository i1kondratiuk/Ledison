<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Inventory Page</h1>
            <p class="lead">Product Inventory Page:</p>
            <div>
                <a href="<spring:url value="/admin/product/addProduct" />" class="btn btn-primary">Add Product</a>
            </div>
            <br>
            <table class="table table-striped table-hover">
                <thead>
                <tr class="bg-success">
                    <th>Photo</th>
                    <th>Name</th>
                    <th>Category</th>
                    <th>Manufacturer</th>
                    <th>Price</th>
                    <th>Recommended</th>
                    <th>Units in Stock</th>
                    <th></th>
                </tr>
                </thead>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td><img src="/images/${product.productId}.jpg" height="100" alt="${product.productId}.jpg"/>
                        </td>
                        <td>${product.productName}</td>
                        <td>${product.productCategory}</td>
                        <td>${product.productManufacturer.productManufacturerName}</td>
                        <td>${product.productPrice} USD</td>
                        <td>
                            <c:if test="${product.recommended == true}">
                                Yes
                            </c:if>
                        </td>
                        <td>${product.unitsInStock}</td>
                        <td>
                            <a href="<spring:url value="/product/viewProduct/${product.productId}" />">
                                <span class="glyphicon glyphicon-info-sign"></span>
                            </a>
                            <a href="<spring:url value="/admin/product/deleteProduct/${product.productId}" />">
                                <span class="glyphicon glyphicon-remove"></span>
                            </a>
                            <a href="<spring:url value="/admin/product/editProduct/${product.productId}" />">
                                <span class="glyphicon glyphicon-pencil"></span>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>
</div>
</body>

</html>