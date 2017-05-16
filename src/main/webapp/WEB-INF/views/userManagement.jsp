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
                <th></th>
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
                    <td>
                        <c:choose>
                            <c:when test="${user.authority == 'ROLE_ADMIN'}">
                                <a href="<spring:url value="user/editUser/${user.id}/ROLE_USER" />">
                                        ${user.authority.name}
                                </a> </c:when>
                            <c:otherwise>
                                <a href="<spring:url value="user/editUser/${user.id}/ROLE_ADMIN" />">
                                        ${user.authority.name}
                                </a>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <a href="<spring:url value="" />">
                            <span class="glyphicon glyphicon-info-sign"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>

</html>