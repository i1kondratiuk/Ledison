<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Ledison</title>

    <link href="../../resources/css/bootstrap.css" rel="stylesheet"/>
    <link href="../../resources/css/style.css" rel="stylesheet">
    <link href="../../resources/css/font-awesome.css" rel="stylesheet">

    <!-- Angular.JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <!-- JQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

    <script src="../../resources/js/bootstrap.js"></script>
</head>

<body>
<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#responsive-menu"><span
                    class="sr-only">Пункти</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span></button>
            <a class="navbar-brand" href="home">LEDISON</a></div>
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
                <li>
                    <form action="" class="navbar-form navbar-left">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search" value=""></div>
                        <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                    </form>
                </li>
                <li>
                    <form action="" class="navbar-form navbar-left">
                        <div class="form-group">
                            <input type="text" class="form-control hidden" placeholder="000 000 00 00" value=""></div>
                        <button type="submit" class="btn btn-default"><i class="fa fa-phone"></i> Передзвоніть мені
                        </button>
                    </form>
                </li>
                <li class="hidden-sm"><a href="#">Про компанію</a></li>
            </ul>
            <form action="" class="navbar-form navbar-right hidden-sm hidden-md">
                <div class="form-group hidden">
                    <input type="text" class="form-control" placeholder="E-mail" value=""></div>
                <div class="form-group">
                    <input type="text" class="form-control hidden" placeholder="Password" value=""></div>
                <button type="submit" class="btn hidden"><i class="fa fa-sign-in"></i> Вхід/Реєстрація</button>
            </form>
            <div class="navbar-form navbar-right">
                <a href="login" class="btn btn-default"><i class="fa fa-sign-in"></i> Вхід/Реєстрація</a>
            </div>
        </div>
    </div>
</div>
<div class="after-divider"></div>
<div class="container-wrapper">
    <div class="container">

        <div class="container">
            <div class="page-header  text-center">
                <h1>Register Customer</h1>

                <p class="lead  text-center">Please fill in your information below:</p>
            </div>

            <div class="col-lg-3 col-md-3 col-sm-2"></div>
            <div class="col-lg-6 col-md-6 col-sm-8">

                <div id="reg-form">
                    <h3>Basic Info:</h3>
                    <div class="form-group">
                        <label for="customerName">First Name</label>
                        <input id="customerName" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="customerSurname">Last Name</label>
                        <input id="customerSurname" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="customerEmail">Email</label>
                        <input id="customerEmail" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="customerPhone">Phone</label>
                        <input id="customerPhone" class="form-control"/>
                    </div>
                    <br/>

                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button id="collectCustomerInfo" class="btn btn-success">Confirm</button>
                </div>

            </div>
            <div class="col-lg-3 col-md-3 col-sm-2"></div>

        </div>

    </div>
</div>
<footer class="footer">
    <div class="container text-center">
        <hr/>
        <div class="row">
            <div class="col-lg-12">
                <div class="col-md-3">
                    <ul class="nav nav-pills nav-stacked">
                        <li><a href="#">About us</a></li>
                        <li><a href="#">Blog</a></li>
                    </ul>
                </div>
                <div class="col-md-3">
                    <ul class="nav nav-pills nav-stacked">
                        <li><a href="#">Founder</a></li>
                        <li><a href="#">Manufacturers</a></li>
                    </ul>
                </div>
                <div class="col-md-3">
                    <ul class="nav nav-pills nav-stacked">
                        <li><a href="#">Web analytics</a></li>
                        <li><a href="#">Presentations</a></li>
                    </ul>
                </div>
                <div class="col-md-3">
                    <ul class="nav nav-pills nav-stacked">
                        <li><a href="#">Product Help</a></li>
                        <li><a href="#">About Product</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col-lg-12">
                <ul class="nav nav-pills nav-justified">
                    <li><a href="/">© 2017 Ivan Kondratiuk</a></li>
                    <li><a href="#">Terms of Service</a></li>
                    <li><a href="#">Privacy</a></li>
                </ul>
            </div>
        </div>
    </div>
</footer>
<br>
<div class="modal fade" id="modal-1">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal"><i class="fa fa-close"></i></button>
                <h4 class="modal-title">Modal title</h4>
            </div>
            <div class="modal-body">
                <p>Modal window</p>
            </div>
            <div class="modal-footer">
                <button class="btn btn-danger" type="button" data-dismiss="modal">Dismiss</button>
            </div>
        </div>
    </div>
</div>
<script src="../../resources/js/collect-customer-info.js"></script>
</body>

</html>