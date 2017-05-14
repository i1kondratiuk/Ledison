<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer Management Page</h1>

            <p class="lead">Customer Management Page</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Username</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Enabled</th>
                <th>User role</th>
            </tr>
            </thead>
            <c:forEach items="${userList}" var="user">
                <tr>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td>${user.phone}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.enabled}</td>
                    <td>${user.authority}
                        <c:choose>
                            <c:when test="${user.authority == 'ROLE_ADMIN'}">
                                <a href="<spring:url value="user/editUser/${user.id}/ROLE_USER" />">
                                    <span class="glyphicon glyphicon-pencil"></span>
                                </a>                            </c:when>
                            <c:otherwise>
                                <a href="<spring:url value="user/editUser/${user.id}/ROLE_ADMIN" />">
                                    <span class="glyphicon glyphicon-pencil"></span>
                                </a>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <script>
            $(function () {
                $('[data-toggle="tooltip"]').tooltip();
                $('[data-toggle="popover"]').popover();
            });
        </script>
    </div>
</div>
</body>

</html>