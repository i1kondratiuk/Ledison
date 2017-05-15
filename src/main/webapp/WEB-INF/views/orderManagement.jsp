<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Orders Management Page</h1>

            <p class="lead">Orders Management Page</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Username</th>
                <th>Customer</th>
                <th>Order</th>
                <th>Date</th>
                <th>Total Price</th>
                <th>Status</th>
            </tr>
            </thead>
            <c:forEach items="${customerOrders}" var="customerOrder">
                <tr>
                    <td>${customerOrder.user.username}</td>
                    <td>${customerOrder.user.firstName} ${customerOrder.user.lastName}</td>
                    <td>${customerOrder.user.order.customerOrderId}</td>
                    <td></td>
                    <td>${customerOrder.user.order.cart.grandTotal}</td>
                    <td></td>
                </tr>
            </c:forEach>
        </table>

    </div>
</div>
</body>

</html>