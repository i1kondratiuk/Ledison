<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="template/header.jsp"/>
<div class="container">
    <div class="col-md-3 col-lg-3 col-lg-3">
        <br>
        <div class="panel-group" id="accordion">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#brand">Бренд</a>
                    </h4>
                </div>
                <div id="brand" class="panel-collapse collapse in">
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
                                <td><a href="#">Sub-Item 4</a> <span class="badge">99</span></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#price">Ціна</a>
                    </h4>
                </div>
                <div id="price" class="panel-collapse collapse">
                    <div class="panel-body">
                        <table class="table">
                            <tr>
                                <td><a href="#">Sub-Item 1</a> <span class="label label-success">$ 1320</span></td>
                            </tr>
                            <tr>
                                <td><a href="#">Sub-Item 2</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">Sub-Item 1</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">Sub-Item 1</a></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#capType">Тип цоколя</a>
                    </h4>
                </div>
                <div id="capType" class="panel-collapse collapse">
                    <div class="panel-body">
                        <table class="table">
                            <tr>
                                <td><a href="#">Sub-Item 1</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">Sub-Item 2</a> <span class="label label-info">5</span></td>
                            </tr>
                            <tr>
                                <td><a href="#">Sub-Item 3</a></td>
                            </tr>
                            <tr>
                                <td><a href="#" class="text-danger">
                                    Sub-Item 4</a></td>
                            </tr>
                        </table>
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
            <div class="row">
                <c:forEach items="${products}" var="product">
                    <div class="col-xs-6 col-sm-4">
                        <a href="">
                            <div class="thumbnail">
                                <img src="http://placehold.it/300x240" alt="">
                                <div class="caption">
                                    <h3><a href="">${product.productName}</a></h3>
                                    <span style="font-size: 24px;">${product.productPrice}</span>
                                    <a href="#" class="btn btn-success pull-right">Купити <i class="fa fa-cart-plus"
                                                                                             aria-hidden="true"></i></a>
                                </div>
                            </div>
                        </a>
                    </div>
                </c:forEach>
            </div>
            <nav class="text-center">
                <ul class="pagination pagination-sm">
                    <li class="disabled"><a href="#"><i class="fa fa-chevron-left"></i> <i
                            class="fa fa-chevron-left"></i> </a></li>
                    <li class="disabled"><a href="#"><i class="fa fa-chevron-left"></i> </a></li>
                    <li class="active"><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li>
                        <a href="#"> <i class="fa fa-chevron-right"></i> </a>
                    </li>
                    <li>
                        <a href="#"> <i class="fa fa-chevron-right"></i> <i class="fa fa-chevron-right"></i> </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>

</div>

<br>
<%@ include file="/WEB-INF/views/template/footer.jsp" %>