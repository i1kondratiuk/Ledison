<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Edit Product</h1>


            <p class="lead">Please update the product information here:</p>
        </div>

        <form:form action="/admin/product/editProduct" method="post" modelAttribute="product" enctype="multipart/form-data">

            <form:hidden path="productId" value="${product.productId}"/>

        <div class="form-group">
            <label for="name">Name</label>
            <form:errors path="productName" cssStyle="color:#ff0000;"/>
            <form:input path="productName" id="name" class="form-control" value="${product.productName}"/>
        </div>

        <div class="form-group">
            <label for="category">Category</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="ledBulbs"/>Світлодіодні
                лампи</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                             value="ledLuminaires"/>Світильники</label>
        </div>

        <div class="form-group">
            <label for="price">Price</label>
            <form:errors path="productPrice" cssStyle="color:#ff0000;"/>
            <form:input path="productPrice" id="price" class="form-control" value="${product.productPrice}"/>
        </div>

        <div class="form-group">
            <label for="unitInStock">Unit In Stock</label>
            <form:errors path="unitInStock" cssStyle="color:#ff0000;"/>
            <form:input path="unitInStock" id="unitInStock" class="form-control" value="${product.unitInStock}"/>
        </div>

        <div class="form-group">
            <label for="manufacturer">Manufacturer</label>
            <form:input path="productManufacturer" id="manufacturer" class="form-control"
                        value="${product.productManufacturer}"/>
        </div>

        <div class="input-group image-preview">
            <input type="text" class="form-control image-preview-filename" disabled="disabled">
            <span class="input-group-btn">
                    <button type="button" class="btn btn-default image-preview-clear" style="display:none;">
                        <span class="glyphicon glyphicon-remove"></span> Clear
                    </button>
                    <div class="btn btn-default image-preview-input">
                        <span class="glyphicon glyphicon-folder-open"></span>
                        <span class="image-preview-input-title">Browse</span>
                        <form:input id="productImage" path="productImage" type="file"
                                    accept="image/png, image/jpg, image/jpeg, image/gif" name="productImage"/>
                    </div>
                </span>
        </div>

        <br/><br/>

        <input type="submit" value="submit" class="btn btn-default">
        <a href="/admin/productInventory" class="btn btn-default">Cancel</a>

        </form:form>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>