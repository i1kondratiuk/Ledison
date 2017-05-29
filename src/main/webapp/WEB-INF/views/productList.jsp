<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container">
    <div id="filter" class="col-md-3 col-lg-3 col-lg-3">
        <br>
        <div class="panel-group">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" href="#productPrice">Price, UAH</a>
                    </h4>
                </div>
                <div id="productPrice" class="panel-collapse collapse in">
                    <div class="panel-body">
                        <b id="min-price"></b><b id="max-price"></b>
                        <span id="price-range-section">
                            <input id="price-range" name="productPrice" type="text" class="span2" value=""
                                   data-slider-min="0"
                                   data-slider-max="500" data-slider-step="1" data-slider-value="[10,300]"/>
                        </span>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" href="#brand">Product Manufacturer</a>
                    </h4>
                </div>
                <div id="brand" class="panel-collapse collapse in">
                    <div name="brand" class="panel-body">
                        <c:forEach items="${productManufacturers}" var="productManufacturer">
                            <input type="checkbox" id="${productManufacturer.productManufacturerName}"
                                   name="productManufacturerId" value="${productManufacturer.productManufacturerId}"/>
                            <label for="${productManufacturer.productManufacturerName}">${productManufacturer.productManufacturerName}</label>
                            <br>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" href="#glowColor">Glow Color</a>
                    </h4>
                </div>
                <div id="glowColor" class="panel-collapse collapse in">
                    <div class="panel-body">
                        <c:forEach items="${glowColors}" var="glowColor">
                            <input type="checkbox" id="${glowColor.name}" name="glowColor" value="${glowColor}"/>
                            <label for="${glowColor.name}">${glowColor.name}</label>
                            <br>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" href="#capType">Cap Type</a>
                    </h4>
                </div>
                <div id="capType" class="panel-collapse collapse in">
                    <div class="panel-body">
                        <c:forEach items="${capTypes}" var="capType">
                            <input type="checkbox" id="${capType.name}" name="capType" value="${capType}"/>
                            <label for="${capType.name}">${capType.name}</label>
                            <br>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" href="#lampShape">Lamp Shape</a>
                    </h4>
                </div>
                <div id="lampShape" class="panel-collapse collapse">
                    <div class="panel-body">
                        <c:forEach items="${lampShapes}" var="lampShape">
                            <input type="checkbox" id="${lampShape.name}" name="lampShape" value="${lampShape}"/>
                            <label for="${lampShape.name}">${lampShape.name}</label>
                            <br>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" href="#power">Power, W</a>
                    </h4>
                </div>
                <div id="power" class="panel-collapse collapse">
                    <div name="power" class="panel-body">
                        <c:forEach items="${powers}" var="power">
                            <input type="checkbox" id="${power.power}" name="powerId"
                                   value="${power.powerId}"/>
                            <label for="${power.power}">${power.power}</label>
                            <br>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" href="#operatingVoltage">Operating Voltage,
                            V</a>
                    </h4>
                </div>
                <div id="operatingVoltage" class="panel-collapse collapse">
                    <div class="panel-body">
                        <c:forEach items="${operatingVoltages}" var="operatingVoltage">
                            <input type="checkbox" id="${operatingVoltage.name}" name="operatingVoltage"
                                   value="${operatingVoltage.name}"/>
                            <label for="${operatingVoltage.name}">${operatingVoltage.name}</label>
                            <br>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" href="#diffuserType">Diffuser Type</a>
                    </h4>
                </div>
                <div id="diffuserType" class="panel-collapse collapse">
                    <div class="panel-body">
                        <c:forEach items="${diffuserType}" var="diffuserType">
                            <input type="checkbox" id="${diffuserType.name}" name="diffuserType"
                                   value="${diffuserType}"/>
                            <label for="${diffuserType.name}">${diffuserType.name}</label>
                            <br>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" href="#warrantyPeriod">Warranty Period, m</a>
                    </h4>
                </div>
                <div id="warrantyPeriod" class="panel-collapse collapse">
                    <div class="panel-body">
                        <table class="table">
                            <tr>
                                <td><a href="#">Sub-Item 1</a></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="col-md-9 col-lg-9">
            <div id="products" class="row">
            </div>
            <nav class="text-center">
                <ul id="pagination" class="pagination-lg"></ul>
            </nav>
        </div>
    </div>
</div>
<br>
<script src="/resources/js/ajax-product-filter.js"></script>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>