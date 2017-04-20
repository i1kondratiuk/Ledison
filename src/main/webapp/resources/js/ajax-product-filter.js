$(document).ready(function () {

    console.log("Hello from filter");

    var $checkboxes = $("input:checkbox");
    $checkboxes.on("change", function () {

        var opts = getProductFilterOptions();
        console.log(JSON.stringify(opts));

        updateProducts(opts);
    });

    function getProductFilterOptions() {
        var opts = [];
        $checkboxes.each(function () {
            if (this.checked) {
                opts.push(this.name + ":" + this.value);
            }
        });
        return opts;
    }

    function updateProducts(opts) {
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/product/productList/all/1",
            data: JSON.stringify(opts),
            dataType: 'json',
            timeout: 100000,
            success: function (data) {
                console.log("SUCCESS: ", data);
            },
            error: function (e) {
                console.log("ERROR: ", e);
            },
        });
    }


    updateProducts();
});
