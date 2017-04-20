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

        console.log(opts);
        return opts;
    }

    function updateProducts(opts) {
        $.ajax({
            type: "POST",
            // url: "/product/productList/all/1",
            url: "/a",
            data: JSON.stringify(opts),
            contentType: 'text/plain',
            timeout: 100000,
            success: function (data) {
                console.log("SUCCESS: ", data);
            },
            error: function (e) {
                console.log("ERROR: ", e);
            },
        });
    }


    // updateProducts(getProductFilterOptions());
});
