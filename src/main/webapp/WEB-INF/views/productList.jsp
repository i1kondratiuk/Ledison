<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container">
    <div id="filter" class="col-md-3 col-lg-3 col-lg-3">
        <br>
        <div class="panel-group" id="accordion">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#brand">Бренд</a>
                    </h4>
                </div>
                <div id="brand" class="panel-collapse collapse in">
                    <div name="brand" class="panel-body">
                        <c:forEach items="${productManufacturers}" var="productManufacturer">
                            <input type="checkbox" name="productManufacturerId"
                                   value="${productManufacturer.productManufacturerId}"/> ${productManufacturer.productManufacturerName}
                            <br>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#capType">Тип цоколя</a>
                    </h4>
                </div>
                <div id="capType" class="panel-collapse collapse in">
                    <div class="panel-body">
                        <c:forEach items="${capTypes}" var="capType">
                            <input type="checkbox" name="capType"
                                   value="${capType}"/> ${capType}
                            <br>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#glowColor">Колір світіння</a>
                    </h4>
                </div>
                <div id="glowColor" class="panel-collapse collapse">
                    <div class="panel-body">
                        <c:forEach items="${glowColors}" var="glowColor">
                            <input type="checkbox" name="capType"
                                   value="${glowColor.glowColorName}"/> ${glowColor.glowColorName}
                            <br>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#lampShape">Форма лампи</a>
                    </h4>
                </div>
                <div id="lampShape" class="panel-collapse collapse">
                    <div class="panel-body">
                        <table class="table">
                            <tr>
                                <td><a href="#">Sub-Item 1</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">Sub-Item 2</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">Sub-Item 3</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">Sub-Item 4</a></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#power">Потужність, W</a>
                    </h4>
                </div>
                <div id="power" class="panel-collapse collapse">
                    <div class="panel-body">
                        <table class="table">
                            <tr>
                                <td><a href="#">Sub-Item 1</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">Sub-Item 2</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">Sub-Item 3</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">Sub-Item 4</a></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#operatingVoltage">Робоча напруга,
                            V</a>
                    </h4>
                </div>
                <div id="operatingVoltage" class="panel-collapse collapse">
                    <div class="panel-body">
                        <table class="table">
                            <tr>
                                <td><a href="#">Sub-Item 1</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">Sub-Item 2</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">Sub-Item 3</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">Sub-Item 4</a></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#diffuserType">Тип розсіювача</a>
                    </h4>
                </div>
                <div id="diffuserType" class="panel-collapse collapse">
                    <div class="panel-body">
                        <table class="table">
                            <tr>
                                <td><a href="#">Sub-Item 1</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">Sub-Item 2</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">Sub-Item 3</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">Sub-Item 4</a></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#serviceLife">Термін служби, год</a>
                    </h4>
                </div>
                <div id="serviceLife" class="panel-collapse collapse">
                    <div class="panel-body">
                        <table class="table">
                            <tr>
                                <td><a href="#">Sub-Item 1</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">Sub-Item 2</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">Sub-Item 3</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">Sub-Item 4</a></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#warrantyPeriod">Гарантійний термін,
                            м</a>
                    </h4>
                </div>
                <div id="warrantyPeriod" class="panel-collapse collapse">
                    <div class="panel-body">
                        <table class="table">
                            <tr>
                                <td><a href="#">Sub-Item 1</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">Sub-Item 2</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">Sub-Item 3</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">Sub-Item 4</a></td>
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