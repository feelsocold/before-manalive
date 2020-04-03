// window.onload = function() {
//     var social_reg_btn = document.getElementById('Social-Register-Btn');
//
//     social_reg_btn.onclick = function() {
//         e.preventDefaultEvents();
//         alert("클릭");
//     }
// }

$(document).ready(function() {

    var formObj = $("form");

    $('.reg-btn').on("click", function(e){
        e.preventDefault();
        var operation = $(this).data("oper");

        if(operation == 'social') {
            document.getElementById("oper").value = operation;
        }
        formObj.submit();
    })
})
