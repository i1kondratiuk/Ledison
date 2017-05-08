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
                console.log(response);
                $("#reg-form").empty();
                $("#reg-form").html("<h4>User <b>" + response.username + "</b> was successfully created</h4>");
            },
            error: function () {
                console.log("error!");
            },
        });
    });
});