<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="/WEB-INF/views/template/header.jsp" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add Product</h1>
            <p class="lead">Fill the below information to add a product:</p>
        </div>

        <form:form method="POST" action="/admin/product/addProduct" modelAttribute="product">

        <div class="form-group">
            <label for="productName">Назва</label>
            <form:errors path="productName" cssStyle="color:#ff0000;"/>
            <form:input path="productName" id="productName" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="productCategory">Категорія</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="productCategory" value="ledBulbs"/>Світлодіодні лампи</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="productCategory" value="ledLuminaires"/>Світильники</label>
        </div>

        <div class="form-group">
            <label for="productManufacturer">Виробник</label>
            <form:errors path="productManufacturer" cssStyle="color:#ff0000;"/>
            <form:input path="productManufacturer" id="productManufacturer" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="productPrice">Ціна</label>
            <form:errors path="productPrice" cssStyle="color:#ff0000;"/>
            <form:input path="productPrice" id="productPrice" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="capType">Тип цоколя</label>
            <label class="checkbox-inline"><form:radiobutton path="capType" id="capType" value="E27"/>E27</label>
            <label class="checkbox-inline"><form:radiobutton path="capType" id="capType" value="E14"/>E14</label>
            <label class="checkbox-inline"><form:radiobutton path="capType" id="capType" value="E40"/>E40</label>
            <label class="checkbox-inline"><form:radiobutton path="capType" id="capType" value="G4"/>G4</label>
            <label class="checkbox-inline"><form:radiobutton path="capType" id="capType" value="G9"/>G9</label>
            <label class="checkbox-inline"><form:radiobutton path="capType" id="capType" value="GU5.3"/>GU5.3</label>
            <label class="checkbox-inline"><form:radiobutton path="capType" id="capType" value="T8"/>T8</label>
        </div>

        <div class="form-group">
            <label for="glowColor">Колір світіння</label>
            <label class="checkbox-inline"><form:radiobutton path="glowColor" id="glowColor" value="neutralWhite"/>Нейтральний білий</label>
            <label class="checkbox-inline"><form:radiobutton path="glowColor" id="glowColor" value="coolWhite"/>Холодний білий</label>
            <label class="checkbox-inline"><form:radiobutton path="glowColor" id="glowColor" value="warmWhite"/>Теплий білий</label>
        </div>

        <div class="form-group">
            <label for="lampShape">Форма лампи</label>
            <label class="checkbox-inline"><form:radiobutton path="lampShape" id="lampShape" value="A60"/>A60 (груша)</label>
            <label class="checkbox-inline"><form:radiobutton path="lampShape" id="lampShape" value="A65"/>A65 (груша)</label>
            <label class="checkbox-inline"><form:radiobutton path="lampShape" id="lampShape" value="C37"/>C37 (свічка)</label>
            <label class="checkbox-inline"><form:radiobutton path="lampShape" id="lampShape" value="C110"/>C110</label>
            <label class="checkbox-inline"><form:radiobutton path="lampShape" id="lampShape" value="C120"/>C120</label>
            <label class="checkbox-inline"><form:radiobutton path="lampShape" id="lampShape" value="C140"/>C140</label>
            <label class="checkbox-inline"><form:radiobutton path="lampShape" id="lampShape" value="G45"/>G45 (куля)</label>
            <label class="checkbox-inline"><form:radiobutton path="lampShape" id="lampShape" value="G95"/>G95 (куля)</label>
            <label class="checkbox-inline"><form:radiobutton path="lampShape" id="lampShape" value="HW"/>HW</label>
            <label class="checkbox-inline"><form:radiobutton path="lampShape" id="lampShape" value="R63"/>R63 (гриб)</label>
        </div>

        <div class="form-group">
            <label for="power">Потужність, W</label>
            <form:errors path="power" cssStyle="color:#ff0000;"/>
            <form:input path="power" id="power" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="operatingVoltage">Робоча напруга, V</label>
            <label class="checkbox-inline"><form:radiobutton path="operatingVoltage" id="operatingVoltage" value="175-250"/>175-250</label>
            <label class="checkbox-inline"><form:radiobutton path="operatingVoltage" id="operatingVoltage" value="220"/>220</label>
            <label class="checkbox-inline"><form:radiobutton path="operatingVoltage" id="operatingVoltage" value="198-242"/>198-242</label>
        </div>

        <div class="form-group">
            <label for="diffuserType">Тип розсіювача</label>
            <label class="checkbox-inline"><form:radiobutton path="diffuserType" id="diffuserType" value="frosted"/>Матовий (Frosted)</label>
            <label class="checkbox-inline"><form:radiobutton path="diffuserType" id="diffuserType" value="clear"/>Прозорий (Clear)</label>
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

        <div class="form-group">
            <label class="control-label" for="productImage">Завантажити зображення</label>
            <form:input path="productImage" id="productImage" class="form-control"/>
        </div>

        <%--<div class="form-group">--%>
            <%--<label class="control-label" for="productImage">Завантажити зображення</label>--%>
            <%--<form:input path="productImage" id="productImage" type="file" class="form:input-large"/>--%>
        <%--</div>--%>

        <br>

        <input type="submit" value="submit" class="btn btn-default">
        <a href="<spring:url value="/admin/productInventory" />" class="btn btn-default">Cancel</a>

        </form:form>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>