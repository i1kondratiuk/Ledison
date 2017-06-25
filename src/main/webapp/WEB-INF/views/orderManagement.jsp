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
                <th>Time</th>
                <th>Total Price</th>
                <th>Status</th>
            </tr>
            </thead>
            <c:forEach items="${customerOrders}" var="customerOrder">
                <tr>
                    <td>${customerOrder.user.username}</td>
                    <td>${customerOrder.user.firstName} ${customerOrder.user.lastName}</td>
                    <td>${customerOrder.customerOrderId}</td>
                    <td>${customerOrder.orderDate}</td>
                    <td>${customerOrder.orderTime}</td>
                    <td>${customerOrder.cart.grandTotal}</td>
                    <td>
                        <div class="dropdown">
                            <a id="dLabel" role="button" data-toggle="dropdown" class="btn btn-default"
                               data-target="dropdownMenu">${customerOrder.status.name} <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
                                <c:forEach items="${orderStatuses}" var="orderStatus">
                                    <li>
                                        <a href="/admin/orders/changeOrderStatus/${customerOrder.customerOrderId}/${orderStatus}">
                                            <c:set var="orderStatus" value="${orderStatus}"/>
                                            <c:set var="customerOrderStatus" value="${customerOrder.status}"/>
                                            <c:if test="${orderStatus ne customerOrderStatus}">
                                                ${orderStatus.name}
                                            </c:if>
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>

</html>