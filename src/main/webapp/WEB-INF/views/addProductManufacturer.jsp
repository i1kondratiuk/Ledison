<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="/WEB-INF/views/template/header.jsp" %>
<div class="container">
    <hr>
    <div class="col-lg-8 col-xs-12 col-md-6 col-lg-offset-2 col-md-offset-3 col-sm-8">
        <div class="page-header">
            <h1>Add Product Manufacturer</h1>
            <p class="lead">Fill the below information to add a product manufacturer:</p>
        </div>

        <form:form method="POST" action="/admin/product/addProductManufacturer" modelAttribute="productManufacturer">

            <div class="form-group">
                <label for="productManufacturerName">Назва</label>
                <form:errors path="productManufacturerName" cssStyle="color:#ff0000;"/>
                <form:input path="productManufacturerName" id="productManufacturerName" class="form-control"/>
            </div>
            <br>
            <input type="submit" value="Submit" class="btn btn-default">
            <a href="<spring:url value="/admin/product//editProduct/${productId}" />" class="btn btn-default">Cancel</a>
        </form:form>
        <br>
    </div>
</div>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>