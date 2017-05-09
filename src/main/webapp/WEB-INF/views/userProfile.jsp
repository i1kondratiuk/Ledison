<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Profile</h1>

            <p class="lead">Your Profile Info</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Username</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Name</th>
                <th>Surname</th>
            </tr>
            </thead>
            <tr>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
            </tr>
        </table>

        <div class="page-header">
            <h1>Orders</h1>

            <p class="lead">Your Orders</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Order</th>
                <th>Date</th>
                <th>Total Price</th>
                <th>Status</th>
            </tr>
            </thead>
            <tr>
                <td>${user.order.customerOrderId}</td>
                <td></td>
                <td>${user.order.cart.grandTotal}</td>
                <td></td>
            </tr>
        </table>
    </div>
</div>
</body>

</html>