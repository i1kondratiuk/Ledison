<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container">
    <hr>
    <div class="col-lg-8 col-xs-12 col-md-6 col-lg-offset-2 col-md-offset-3 col-sm-8">
        <form:form action="/admin/product/editProduct" method="post" modelAttribute="product"
                   enctype="multipart/form-data">

            <form:hidden path="productId" value="${product.productId}"/>
            <div class="page-header col-md-12">
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-4">
                    <img class="white-border" src="<c:url value="/images/${product.productId}.jpg" />" alt="image"
                         style="width: 100%"/>
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
                </div>
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-8" style="margin-top: 10%">
                    <h1>Edit Product</h1>
                    <p class="lead">Please update the product information here:</p>
                </div>

            </div>


            <br>
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
                    <option class="hidden" value="${product.productManufacturer.productManufacturerId}">
                            ${product.productManufacturer.productManufacturerName}
                    </option>
                    <c:forEach items="${productManufacturers}" var="productManufacturer">
                        <c:set var="currentProductManufacturerId" value="${product.productManufacturer.productManufacturerId}"/>
                        <c:set var="otherProductManufacturerId" value="${productManufacturer.productManufacturerId}"/>
                        <c:if test="${currentProductManufacturerId ne otherProductManufacturerId}">
                            <option value="${productManufacturer.productManufacturerId}">
                                    ${productManufacturer.productManufacturerName}
                            </option>
                        </c:if>
                    </c:forEach>
                </select>
                <a href="/admin/product/addProductManufacturer/${product.productId}" class="pull-right">
                    Add new product manufacturer
                </a>
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
                <c:forEach items="${lampShapes}" var="lampShape">
                    <label class="checkbox-inline">
                        <form:radiobutton path="lampShape" id="lampShape" value="${lampShape}"/>${lampShape.name}
                    </label>
                </c:forEach>
            </div>

            <div class="form-group">
                <label for="recommended">Recommended</label>
                <form:checkbox path="recommended" id="recommended"/>
            </div>

            <div class="form-group">
                <label for="power">Потужність, W</label>
                <select id="power" name="powerId" class="selectpicker">
                    <option class="hidden" value="${product.power.powerId}">
                            ${product.power.power}
                    </option>
                    <c:forEach items="${powers}" var="power">
                        <c:set var="currentPower" value="${product.power.power}"/>
                        <c:set var="otherPower" value="${power.power}"/>
                        <c:if test="${currentPower ne otherPower}">
                            <option value="${power.powerId}">
                                    ${power.power}
                            </option>
                        </c:if>
                    </c:forEach>
                </select>
                <a href="/admin/product/addPower/${product.productId}" class="pull-right">Add new power value</a>
            </div>

            <div class="form-group">
                <label for="operatingVoltage">Робоча напруга, V</label>
                <form:errors path="operatingVoltage" cssStyle="color:#ff0000;"/>
                <form:input path="operatingVoltage" id="operatingVoltage" class="form-control"/>
            </div>

            <div class="form-group">
                <label for="diffuserType">Тип розсіювача</label>
                <c:forEach items="${diffuserType}" var="diffuserType">
                    <label class="checkbox-inline">
                        <form:radiobutton path="diffuserType" id="diffuserType" value="${diffuserType}"/>${diffuserType.name}
                    </label>
                </c:forEach>
            </div>

            <div class="form-group">
                <label for="serviceLife">Термін служби, год</label>
                <form:errors path="serviceLife" cssStyle="color:#ff0000;"/>
                <form:input path="serviceLife" id="serviceLife" class="form-control"/>
            </div>

            <div class="form-group">
                <label for="warrantyPeriod">Гарантійний термін, м</label>
                <select id="warrantyPeriod" name="warrantyPeriodId" class="selectpicker">
                    <option class="hidden" value="${product.warrantyPeriod.warrantyPeriodId}">
                            ${product.warrantyPeriod.warrantyPeriod}
                    </option>
                    <c:forEach items="${warrantyPeriods}" var="warrantyPeriod">
                        <c:set var="currentWarrantyPeriod" value="${product.warrantyPeriod.warrantyPeriod}"/>
                        <c:set var="otherWarrantyPeriod" value="${warrantyPeriod.warrantyPeriod}"/>
                        <c:if test="${currentWarrantyPeriod ne otherWarrantyPeriod}">
                            <option value="${warrantyPeriod.warrantyPeriodId}">
                                    ${warrantyPeriod.warrantyPeriod}
                            </option>
                        </c:if>
                    </c:forEach>
                </select>
                <a href="/admin/product/warranty" class="pull-right">Add new warranty
                    period value</a>
            </div>

            <div class="form-group">
                <label for="unitsInStock">Кількість на залишку, шт</label>
                <form:errors path="unitsInStock" cssStyle="color:#ff0000;"/>
                <form:input path="unitsInStock" id="unitsInStock" class="form-control"/>
            </div>

            <br>

            <input type="submit" value="Submit" class="btn btn-default">
            <a href="<spring:url value="/admin/productInventory" />" class="btn btn-default">Cancel</a>

        </form:form>
        <br>
    </div>
</div>
<%@ include file="/WEB-INF/views/template/footer.jsp" %>