<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="/WEB-INF/views/template/header.jsp" %>
<div class="container">
    <hr>
    <div class="col-lg-8 col-xs-12 col-md-6 col-lg-offset-2 col-md-offset-3 col-sm-8">
        <div class="page-header">
            <h1>Add Product</h1>
            <p class="lead">Fill the below information to add a product:</p>
        </div>

        <form:form method="POST" action="/admin/product/addProduct" modelAttribute="product"
                   enctype="multipart/form-data">

            <div class="form-group">
                <label for="productName">Назва</label>
                <form:errors path="productName" cssStyle="color:#ff0000;"/>
                <form:input path="productName" id="productName" class="form-control"/>
            </div>

            <div class="form-group">
                <label for="productCategory">Категорія</label>
                <label class="checkbox-inline">
                    <form:radiobutton path="productCategory" id="productCategory"
                                      value="ledBulbs"/>Світлодіодні лампи</label>
                <label class="checkbox-inline">
                    <form:radiobutton path="productCategory" id="productCategory"
                                      value="ledLuminaires"/>Світильники</label>
            </div>

            <div class="form-group">
                <label for="productManufacturer">Виробник</label>
                <select id="productManufacturer" name="productManufacturerId" class="selectpicker">
                    <c:forEach items="${productManufacturers}" var="productManufacturer">
                        <option value="${productManufacturer.productManufacturerId}"> ${productManufacturer.productManufacturerName}
                        </option>
                    </c:forEach>
                </select>
                <a href="/admin/product/addProductManufacturer" class="pull-right">Add new product manufacturer</a>
            </div>

            <div class="form-group">
                <label for="productPrice">Ціна</label>
                <form:errors path="productPrice" cssStyle="color:#ff0000;"/>
                <form:input path="productPrice" id="productPrice" class="form-control"/>
            </div>

            <div class="form-group">
                <label for="capType">Тип цоколя</label>
                <c:forEach items="${capTypes}" var="capType">
                    <label class="checkbox-inline">
                        <form:radiobutton path="capType" id="capType" value="${capType}"/>${capType.name}
                    </label>
                </c:forEach>
                <br>
            </div>

            <div class="form-group">
                <label for="glowColor">Колір світіння</label>
                <c:forEach items="${glowColors}" var="glowColor">
                    <label class="checkbox-inline">
                        <form:radiobutton path="glowColor" id="glowColor" value="${glowColor}"/>${glowColor.name}
                    </label>
                </c:forEach>
            </div>

            <div class="form-group">
                <label for="lampShape">Форма лампи</label>
                <label for="glowColor">Колір світіння</label>
                <c:forEach items="${lampShapes}" var="lampShape">
                    <label class="checkbox-inline">
                        <form:radiobutton path="lampShape" id="lampShape" value="${lampShape}"/>${lampShape.name}
                    </label>
                </c:forEach>
            </div>

            <div class="form-group">
                <label for="power">Потужність, W</label>
                <form:errors path="power" cssStyle="color:#ff0000;"/>
                <form:input path="power" id="power" class="form-control"/>
            </div>

            <div class="form-group">
                <label for="operatingVoltage">Робоча напруга, V</label>
                <label class="checkbox-inline"><form:radiobutton path="operatingVoltage" id="operatingVoltage"
                                                                 value="175-250"/>175-250</label>
                <label class="checkbox-inline"><form:radiobutton path="operatingVoltage" id="operatingVoltage"
                                                                 value="220"/>220</label>
                <label class="checkbox-inline"><form:radiobutton path="operatingVoltage" id="operatingVoltage"
                                                                 value="198-242"/>198-242</label>
            </div>

            <div class="form-group">
                <label for="diffuserType">Тип розсіювача</label>
                <label class="checkbox-inline"><form:radiobutton path="diffuserType" id="diffuserType"
                                                                 value="frosted"/>Матовий
                    (Frosted)</label>
                <label class="checkbox-inline"><form:radiobutton path="diffuserType" id="diffuserType"
                                                                 value="clear"/>Прозорий
                    (Clear)</label>
            </div>

            <div class="form-group">
                <label for="serviceLife">Термін служби, год</label>
                <form:errors path="serviceLife" cssStyle="color:#ff0000;"/>
                <form:input path="serviceLife" id="serviceLife" class="form-control"/>
            </div>

            <div class="form-group">
                <label for="warrantyPeriod">Гарантійний термін, м</label>
                <form:errors path="warrantyPeriod" cssStyle="color:#ff0000;"/>
                <form:input path="warrantyPeriod" id="warrantyPeriod" class="form-control"/>
            </div>

            <div class="form-group">
                <label for="unitInStock">Кількість на залишку, шт</label>
                <form:errors path="unitInStock" cssStyle="color:#ff0000;"/>
                <form:input path="unitInStock" id="unitInStock" class="form-control"/>
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

            <br>

            <input type="submit" value="Submit" class="btn btn-default">
            <a href="<spring:url value="/admin/productInventory" />" class="btn btn-default">Cancel</a>

        </form:form>
        <br>
    </div>
</div>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>