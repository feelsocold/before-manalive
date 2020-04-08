$(document).on("click", ".login-btn", function(e){
    e.preventDefault();

    var email = $("#user-email").val();
    var password = $("#user-password").val();

    $.ajax({
        type : 'post',
        url : '/loginCheck',
        data : {"email" : email, "password" : password },
        success : function(result, status, xhr){
            alert(result);
        },
        error : function(xhr, status, er) {

        }
    })

});