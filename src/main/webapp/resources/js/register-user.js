$(document).ready(function () {
    var user = {};
    $('#addUser').click(function () {
        var username = $("#username").val();
        var password = $('#password').val();
        console.log(username + " " + password);
        user.username = username;
        user.password = password;
        console.log(user);
        var jUser = JSON.stringify(user);
        console.log(jUser);

        $.ajax({
            url: '/addUser',
            type: 'POST',
            data: jUser,
            contentType: 'application/json',
            success: function (response) {
                if (response.code == 400) {
                    $("#error").text(response.msg);
                } else if (response.code == 200){
                    $("#reg-form").empty();
                    $("#success").html("User <b>" + response.result.username + "</b> was successfully created");
                }
            },
            error: function (e) {
                console.log("ERROR: ", e);
                console.log(e);
            },
        });
    });
});