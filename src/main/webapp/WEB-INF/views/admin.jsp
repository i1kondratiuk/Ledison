<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administrator page</h1>

            <p class="lead">This is the administrator page!</p>
        </div>

        <h3>
            <a href="/admin/productInventory">Product Inventory</a>
        </h3>

        <p>Here you can view, check and modify the product inventory!</p>

        <br/><br/>

        <h3>
            <a href="/admin/customer">Customer Management</a>
        </h3>

        <p>Here you can view the customer information!</p>

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