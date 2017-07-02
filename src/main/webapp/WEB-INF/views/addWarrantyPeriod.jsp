<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="/WEB-INF/views/template/header.jsp" %>
<div class="container">
    <hr>
    <div class="col-lg-8 col-xs-12 col-md-6 col-lg-offset-2 col-md-offset-3 col-sm-8">
        <div class="page-header">
            <h1>Add Warranty Period</h1>
            <p class="lead">Fill the below information to add a product manufacturer:</p>
        </div>

        <form:form method="POST" action="/admin/product/warranty" modelAttribute="warrantyPeriod">

            <div class="form-group">
                <label for="warrantyPeriod">Warranty Period, m</label>
                <form:errors path="warrantyPeriod" cssStyle="color:#ff0000;"/>
                <form:input path="warrantyPeriod" id="warrantyPeriodId" class="form-control"/>
            </div>
            <br>
            <input type="submit" value="Submit" class="btn btn-default">
            <button class="btn btn-default" onclick="goBack()">Go Back</button>
            <script>
                function goBack() {
                    window.history.back();
                }
            </script>
        </form:form>
        <br>
    </div>
</div>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>