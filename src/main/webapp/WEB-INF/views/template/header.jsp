<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Ledison</title>
    <%--Bootstrap--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/9.8.0/css/bootstrap-slider.min.css">

    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/jquery.slick/1.6.0/slick.css"/>
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/jquery.slick/1.6.0/slick-theme.css"/>

    <link href="/resources/css/style.css" rel="stylesheet">

    <%--font-awesome--%>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/9.8.0/css/bootstrap-slider.min.css" rel="stylesheet">
    <!-- JQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <%-- twbsPagination --%>
    <script src="/resources/js/esimakin-twbs-pagination/jquery.twbsPagination.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="/resources/js/image-preview-input.js"></script>

    <script src="/resources/js/search.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/9.8.0/bootstrap-slider.min.js"></script>
    <script src="/resources/js/jquery-autocomplete/jquery.autocomplete.min.js"></script>

</head>

<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#responsive-menu">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/home">LEDISON</a>
        </div>
        <div class="collapse navbar-collapse" id="responsive-menu">
            <div class="nav navbar-nav">
                <li class="dropdown"><a class="dropdowm-toggle" href="#" data-toggle="dropdown"><b
                        class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="/product/productList/all">Каталог</a></li>
                        <li><a href="#">Передзвоніть мені</a></li>
                        <li><a href="#">Зворотній зв’язок</a></li>
                        <li><a href="#">Новинки індустрії</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Про компанію</a></li>
                    </ul>
                </li>
            </div>
            <div class="panel-heading col-lg-3 col-md-4 col-sm-5">
                <div class="input-group">
                    <div>
                        <label for="autocomplete"></label>
                        <input class="form-control" type="text" name="product" id="autocomplete" placeholder="Search"/>
                    </div>
                </div>
            </div>
            <div class="navbar-form navbar-right">
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <a href="/admin" class="btn btn-default">Admin</a>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_USER')">
                    <a href="/customer/profile">
                        <sec:authentication property="principal.username"></sec:authentication>
                    </a>
                </sec:authorize>
                <sec:authorize var="loggedIn" access="isAuthenticated()"/>
                <c:choose>
                    <c:when test="${loggedIn}">
                        <a href="/logout" class="btn btn-info"><i class="icon-signout"></i> Logout</a>
                    </c:when>
                    <c:otherwise>
                        <a href="/login" class="btn btn-primary"><i class="icon-signin"></i> Login/Registration</a>
                        <a href="/rest/cart" class="btn btn-danger">
                            <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                            <span id="restCartItemsQuantity"></span>
                        </a>
                    </c:otherwise>
                </c:choose>
                <sec:authorize access="hasRole('ROLE_USER')">
                    <a href="/customer/cart" class="btn btn-danger">
                        <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                        <span id="customerCartItemsQuantity"></span>
                    </a>
                </sec:authorize>
            </div>
        </div>
    </div>
</div>
<div class="after-divider"></div>
<div style="background: black" id="results"></div>