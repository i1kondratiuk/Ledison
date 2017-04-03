<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>

            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1">
                <title>Ledison</title>

                <link href="../resources/css/bootstrap.css" rel="stylesheet" />
                <link href="../resources/css/style.css" rel="stylesheet">
                <link href="../resources/css/font-awesome.css" rel="stylesheet">

                <!-- Angular.JS -->
                <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
                <!-- JQuery -->
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

                <script src="../resources/js/bootstrap.js"></script>
            </head>

            <body>
                <div class="navbar navbar-default navbar-fixed-top">
                    <div class="container">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#responsive-menu"><span
                    class="sr-only">Пункти</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span></button>
                            <a class="navbar-brand" href="home.jsp">LEDISON</a></div>
                        <div class="collapse navbar-collapse" id="responsive-menu">
                            <ul class="nav navbar-nav">
                                <li class="dropdown"><a class="dropdowm-toggle" href="#" data-toggle="dropdown">Каталог <b
                        class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Пункт 1</a></li>
                                        <li><a href="#">Пункт 2</a></li>
                                        <li><a href="#">Пункт 3</a></li>
                                        <li class="divider"></li>
                                        <li><a href="#">Пункт 4</a></li>
                                    </ul>
                                </li>
                                <form action="" class="navbar-form navbar-left">
                                    <div class="form-group">
                                        <input type="text" class="form-control hidden" placeholder="000 000 00 00" value=""></div>
                                    <button type="submit" class="btn btn-default"><i class="fa fa-phone"></i> Передзвоніть мені</button>
                                </form>


                                <li>
                                    <form action="" class="navbar-form navbar-left">
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Search" value=""></div>
                                        <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                                    </form>
                                </li>
                                <li>

                                </li>
                                <li class="hidden-sm"><a href="#">Про компанію</a></li>
                            </ul>
                            <div class="navbar-form navbar-right">
                                <a href="login.jsp" class="btn btn-default"><i class="fa fa-sign-in"></i> Вхід/Реєстрація</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="after-nav-divider"></div>
