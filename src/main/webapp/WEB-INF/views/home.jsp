<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="template/header.jsp"/>

<div class="container">
    <div class="col-md-4 col-lg-4 col-lg-4">
        <ul class="col-menu">
            <li class="col-menu-item"><a href="/product/productList/all">Сatalogue</a></li>
            <li class="col-menu-item"><a href="#">Call Back</a></li>
            <li class="col-menu-item"><a href="#">Feedback</a></li>
            <li class="col-menu-item"><a href="#">Industry News</a></li>
            <li class="col-menu-item"><a href="#">About the Сompany</a></li>
        </ul>
    </div>
    <div class="container">
        <div class="col-md-8 col-lg-8">
            <div class="row">
                <div class="col-xs-12" id="slider">
                    <!-- Top part of the slider -->
                    <div class="row">
                        <div id="carousel-bounding-box">
                            <div class="carousel slide" id="carousel">
                                <!-- Carousel items -->
                                <ol class="carousel-indicators">
                                    <li class="active" data-target="#carousel" data-slide-to="0"></li>
                                    <li data-target="#carousel" data-slide-to="1"></li>
                                    <li data-target="#carousel" data-slide-to="2"></li>
                                </ol>
                                <div class="carousel-inner">
                                    <div class="active item" data-slide-number="0">
                                        <img src="/resources/images/0.jpg">
                                        <div class="carousel-caption">
                                            <h3>Hello!</h3>
                                            <p>How are you?</p>
                                        </div>
                                    </div>

                                    <div class="item" data-slide-number="1">
                                        <img src="/resources/images/1.jpg">
                                        <div class="carousel-caption">
                                            <h3>Welcome!</h3>
                                            <p>The BEST bulbs</p>
                                        </div>
                                    </div>

                                    <div class="item" data-slide-number="2">
                                        <img src="/resources/images/2.jpg">
                                        <div class="carousel-caption">
                                            <h3>Hello!</h3>
                                            <p>LED</p>
                                        </div>
                                    </div>

                                </div><!-- Carousel nav -->
                                <a class="left carousel-control" href="#carousel" role="button" data-slide="prev">
                                    <span class="glyphicon glyphicon-chevron-left"></span>
                                </a>
                                <a class="right carousel-control" href="#carousel" role="button" data-slide="next">
                                    <span class="glyphicon glyphicon-chevron-right"></span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div><!--/Slider-->
            </div>
        </div>
    </div>
    <br>
    <div class="container text-center">
        <div class="col-sm-4 col-md-4 col-lg-4">
            <div class="well well-bottom">
                <a href="/delivery">
                    <div class="item-img">
                        <img src="../../resources/images/delivery.png" alt="" class="img-responsive"
                             style="padding: 0% 10%;">
                    </div>
                    <h2 class="well-element">Delivery</h2>
                </a>
            </div>

        </div>
        <div class="col-sm-4 col-md-4 col-lg-4">
            <div class="well well-bottom">
                <a href="/warranty">
                    <div class="item-img">
                        <img src="../../resources/images/warranty.png" alt="" class="img-responsive">
                    </div>
                    <h2 class="well-element">Warranty</h2>
                </a>
            </div>
        </div>
        <div class="col-sm-4 col-md-4 col-lg-4">
            <div class="well well-bottom">
                <a href="/discount">
                    <div class="item-img">
                        <img src="../../resources/images/discount.png" alt="" class="img-responsive">
                    </div>
                    <h2 class="well-element">Discount</h2>
                </a>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <br>
                <div class="tabs">
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#tab-1" data-toggle="tab">Most Popular</a></li>
                        <li><a href="#tab-2" data-toggle="tab">Recommended</a></li>
                    </ul>
                    <div class="tab-content">
                        <div id="tab-1" class="tab-pane fade in active">
                            <div class="row">
                                <div class="col-xs-6 col-sm-3">
                                    <div class="thumbnail"><img src="http://placehold.it/400x400" alt="">
                                        <div class="caption">
                                            <h3><a href="#">Post</a></h3>
                                            <p>text text text text text text text text text</p> <a href="#"
                                                                                                   class="btn btn-success">More
                                            <i class="fa fa-arrow-right"></i></a></div>
                                    </div>
                                </div>
                                <div class="col-xs-6 col-sm-3">
                                    <div class="thumbnail"><img src="http://placehold.it/400x400" alt="">
                                        <div class="caption">
                                            <h3><a href="#">Post</a></h3>
                                            <p>text text text text text text text</p> <a href="#"
                                                                                         class="btn btn-success">More
                                            <i class="fa fa-arrow-right"></i></a></div>
                                    </div>
                                </div>
                                <div class="col-xs-6 col-sm-3">
                                    <div class="thumbnail"><img src="http://placehold.it/400x400" alt="">
                                        <div class="caption">
                                            <h3><a href="#">Post</a></h3>
                                            <p>text text text text text text text text text</p> <a href="#"
                                                                                                   class="btn btn-success">More
                                            <i class="fa fa-arrow-right"></i></a></div>
                                    </div>
                                </div>
                                <div class="col-xs-6 col-sm-3">
                                    <div class="thumbnail"><img src="http://placehold.it/400x400" alt="">
                                        <div class="caption">
                                            <h3><a href="#">Post</a></h3>
                                            <p>text text text text text text text text text</p> <a href="#"
                                                                                                   class="btn btn-success">More
                                            <i class="fa fa-arrow-right"></i></a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div id="tab-2" class="tab-pane fade">
                            <div id="recommended-products" class="row">
                                <div class="panel-body">
                                    <c:forEach items="${recommendedProducts}" var="product">
                                        ${product.name}
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="/resources/js/product-slider.js"></script>
    <script src="/resources/js/carousel.js"></script>

    <jsp:include page="template/footer.jsp"/>
