function dengu() {
    var username = $("#username").val();
    var password = $("#password").val();
    var yanzhengma = $("#yanzhengma").val();
    $.post("login",{username:username,password:password,yanzhengma:yanzhengma},
        function (data) {
            alert(data.msg);
        },"json");
}