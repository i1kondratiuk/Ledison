<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Cart</h1>
                    <p>All the selected products in your shopping cart</p>
                </div>
            </div>
        </section>

        <section class="container">
            <div>
                <div>
                    <a href="<spring:url value="/rest/cart/removeAll" />" class="btn btn-danger pull-left"><span
                            class="glyphicon glyphicon-remove-sign"></span> Clear Cart</a>
                    <a href="<spring:url value="/order/${cart.cartId}" />" class="btn btn-success pull-right"><span
                            class="glyphicon glyphicon-shopping-cart"></span> Check out</a>
                </div>

                <br/><br/><br/>

                <table class="table table-hover">
                    <tr>
                        <th>Product</th>
                        <th>Unit Price</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${cart.cartItems}" var="cartItem">
                        <tr>
                            <td>${cartItem.product.productName}</td>
                            <td>${cartItem.product.productPrice}</td>
                            <td>${cartItem.quantity}</td>
                            <td>${cartItem.totalPrice}</td>
                            <td><a href="#" class="label label-danger">
                                <span class="glyphicon glyphicon-remove"></span>remove</a></td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <th></th>
                        <th></th>
                        <th>${cartQuantityTotal}</th>
                        <th>${cart.grandTotal}</th>
                        <th></th>
                    </tr>
                </table>

                <a href="<spring:url value="/product/productList/all" />" class="btn btn-default">Continue Shopping</a>
            </div>
        </section>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>