<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Ledison</title>
    <%--Bootstrap--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="/resources/css/style.css" rel="stylesheet">
    <%--font-awesome--%>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- JQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <%-- twbsPagination --%>
    <script src="/resources/js/esimakin-twbs-pagination/jquery.twbsPagination.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="/resources/js/image-preview-input.js"></script>
    <script src="/resources/js/register-user.js"></script>
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
            <form action="" class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Пошук" value="">
                    <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                </div>
            </form>
            <div class="navbar-form navbar-right">
                <a href="/admin"> Адміністратор </a>
                <a href="/login" class="btn btn-primary"><i class="fa fa-sign-in"></i> Вхід/Реєстрація</a>
                <a href="/cart" class="btn btn-danger"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a>
            </div>
        </div>
    </div>
</div>
<div class="after-divider"></div>