$(document).ready(function () {

    var box = $(".box-1");

    var boxNumber = 1;
    setInterval(function () {
        if (boxNumber <= 10) {
            $(".box-" + boxNumber).animate({
                marginLeft: -box.width()
            }, 1000);
            boxNumber++;
        }
    }, 5000);

});