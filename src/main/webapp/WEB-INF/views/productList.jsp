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
                        <input name="brand" type="checkbox" value="LG"/><label>LG</label><br>
                        <input name="brand" type="checkbox" value="Samsung"/><label>Sony</label><br>
                        <input name="brand" type="checkbox" value="Philips"/><label>Philips</label><br>
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
                        <input type="checkbox" name="capType" value="E27"/><label>E27</label><br>
                        <input type="checkbox" name="capType" value="E14"/><label>E14</label><br>
                        <input type="checkbox" name="capType" value="G4"/><label>G4</label><br>
                        <input type="checkbox" name="capType" value="G9"/><label>G9</label><br>
                        <input type="checkbox" name="capType" value="GU5.3"/><label>GU5.3</label><br>
                        <input type="checkbox" name="capType" value="T8"/><label>T8</label><br>
                    </div>
                </div>
            </div>
            <%--<div class="panel panel-default">--%>
            <%--<div class="panel-heading">--%>
            <%--<h4 class="panel-title">--%>
            <%--<a data-toggle="collapse" data-parent="#accordion" href="#price">Ціна</a>--%>
            <%--</h4>--%>
            <%--</div>--%>
            <%--&lt;%&ndash;<div id="price" class="panel-collapse collapse">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<div class="panel-body">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<table class="table">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<td><a href="#">Sub-Item 1</a> <span class="label label-success">$ 1320</span></td>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<td><a href="#">Sub-Item 2</a></td>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<td><a href="#">Sub-Item 1</a></td>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<td><a href="#">Sub-Item 1</a></td>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</table>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
            <%--</div>--%>

            <%--<div class="panel panel-default">--%>
            <%--<div class="panel-heading">--%>
            <%--<h4 class="panel-title">--%>
            <%--<a data-toggle="collapse" data-parent="#accordion" href="#glowColor">Колір світіння</a>--%>
            <%--</h4>--%>
            <%--</div>--%>
            <%--<div id="glowColor" class="panel-collapse collapse">--%>
            <%--<div class="panel-body">--%>
            <%--<table class="table">--%>
            <%--<tr>--%>
            <%--<td><a href="#">Sub-Item 1</a></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td><a href="#">Sub-Item 2</a> <span class="label label-info">5</span></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td><a href="#">Sub-Item 2</a></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td><a href="#">Sub-Item 3</a></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td><a href="#">Sub-Item 4</a></td>--%>
            <%--</tr>--%>
            <%--</table>--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--<div class="panel panel-default">--%>
            <%--<div class="panel-heading">--%>
            <%--<h4 class="panel-title">--%>
            <%--<a data-toggle="collapse" data-parent="#accordion" href="#lampShape">Форма лампи</a>--%>
            <%--</h4>--%>
            <%--</div>--%>
            <%--<div id="lampShape" class="panel-collapse collapse">--%>
            <%--<div class="panel-body">--%>
            <%--<table class="table">--%>
            <%--<tr>--%>
            <%--<td><a href="#">Sub-Item 1</a></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td><a href="#">Sub-Item 2</a></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td><a href="#">Sub-Item 3</a></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td><a href="#">Sub-Item 4</a></td>--%>
            <%--</tr>--%>
            <%--</table>--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--<div class="panel panel-default">--%>
            <%--<div class="panel-heading">--%>
            <%--<h4 class="panel-title">--%>
            <%--<a data-toggle="collapse" data-parent="#accordion" href="#power">Потужність, W</a>--%>
            <%--</h4>--%>
            <%--</div>--%>
            <%--<div id="power" class="panel-collapse collapse">--%>
            <%--<div class="panel-body">--%>
            <%--<table class="table">--%>
            <%--<tr>--%>
            <%--<td><a href="#">Sub-Item 1</a></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td><a href="#">Sub-Item 2</a></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td><a href="#">Sub-Item 3</a></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td><a href="#">Sub-Item 4</a></td>--%>
            <%--</tr>--%>
            <%--</table>--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--<div class="panel panel-default">--%>
            <%--<div class="panel-heading">--%>
            <%--<h4 class="panel-title">--%>
            <%--<a data-toggle="collapse" data-parent="#accordion" href="#operatingVoltage">Робоча напруга,--%>
            <%--V</a>--%>
            <%--</h4>--%>
            <%--</div>--%>
            <%--<div id="operatingVoltage" class="panel-collapse collapse">--%>
            <%--<div class="panel-body">--%>
            <%--<table class="table">--%>
            <%--<tr>--%>
            <%--<td><a href="#">Sub-Item 1</a></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td><a href="#">Sub-Item 2</a></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td><a href="#">Sub-Item 3</a></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td><a href="#">Sub-Item 4</a></td>--%>
            <%--</tr>--%>
            <%--</table>--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--<div class="panel panel-default">--%>
            <%--<div class="panel-heading">--%>
            <%--<h4 class="panel-title">--%>
            <%--<a data-toggle="collapse" data-parent="#accordion" href="#diffuserType">Тип розсіювача</a>--%>
            <%--</h4>--%>
            <%--</div>--%>
            <%--<div id="diffuserType" class="panel-collapse collapse">--%>
            <%--<div class="panel-body">--%>
            <%--<table class="table">--%>
            <%--<tr>--%>
            <%--<td><a href="#">Sub-Item 1</a></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td><a href="#">Sub-Item 2</a></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td><a href="#">Sub-Item 3</a></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td><a href="#">Sub-Item 4</a></td>--%>
            <%--</tr>--%>
            <%--</table>--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--<div class="panel panel-default">--%>
            <%--<div class="panel-heading">--%>
            <%--<h4 class="panel-title">--%>
            <%--<a data-toggle="collapse" data-parent="#accordion" href="#serviceLife">Термін служби, год</a>--%>
            <%--</h4>--%>
            <%--</div>--%>
            <%--<div id="serviceLife" class="panel-collapse collapse">--%>
            <%--<div class="panel-body">--%>
            <%--<table class="table">--%>
            <%--<tr>--%>
            <%--<td><a href="#">Sub-Item 1</a></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td><a href="#">Sub-Item 2</a></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td><a href="#">Sub-Item 3</a></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td><a href="#">Sub-Item 4</a></td>--%>
            <%--</tr>--%>
            <%--</table>--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--<div class="panel panel-default">--%>
            <%--<div class="panel-heading">--%>
            <%--<h4 class="panel-title">--%>
            <%--<a data-toggle="collapse" data-parent="#accordion" href="#warrantyPeriod">Гарантійний термін,--%>
            <%--м</a>--%>
            <%--</h4>--%>
            <%--</div>--%>
            <%--<div id="warrantyPeriod" class="panel-collapse collapse">--%>
            <%--<div class="panel-body">--%>
            <%--<table class="table">--%>
            <%--<tr>--%>
            <%--<td><a href="#">Sub-Item 1</a></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td><a href="#">Sub-Item 2</a></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td><a href="#">Sub-Item 3</a></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td><a href="#">Sub-Item 4</a></td>--%>
            <%--</tr>--%>
            <%--</table>--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--</div>--%>
        </div>
    </div>
    <div class="container">
        <div class="col-md-9 col-lg-9">
            <div id="products" class="row">
                <%--<c:forEach items="${products}" var="product">--%>
                    <%--<div class="col-xs-6 col-sm-4">--%>
                        <%--<a href="">--%>
                            <%--<div class="thumbnail">--%>
                                <%--<img src="/images/${product.productId}.jpg" width="400" alt="${product.productName} ${product.productId}"/>--%>
                                <%--<div class="caption">--%>
                                    <%--<h3><a href="">${product.productName}</a></h3>--%>
                                    <%--<span style="font-size: 24px;">${product.productPrice}</span>--%>
                                    <%--<a href="#" class="btn btn-success pull-right">Купити--%>
                                        <%--<i class="fa fa-cart-plus" aria-hidden="true"></i></a>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</a>--%>
                    <%--</div>--%>
                <%--</c:forEach>--%>
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