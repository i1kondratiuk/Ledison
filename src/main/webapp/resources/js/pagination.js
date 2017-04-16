onSelect: function (page) {

    Spinner.spin();

    $.ajax({
        "url": '/data.php?start=' + this.slice[0] + '&end=' + this.slice[1] + '&page=' + page,
        "success": function (data) {
            Spinner.stop();
            // content replace
        }
    });
}