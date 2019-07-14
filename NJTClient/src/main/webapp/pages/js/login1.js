$(function () {

    $('#login-form-link').click(function (e) {
        $("#login-form").delay(100).fadeIn(100);
        $("#register-form").fadeOut(100);
        $("#register-form-shop").fadeOut(100);
        $("#register-form-customer").fadeOut(100);
        $('#register-form-link').removeClass('active');
        $(this).addClass('active');
        $("#errorMessage").innerHTML = "";
        e.preventDefault();
    });
    $('#register-form-link').click(function (e) {
        $("#register-form").delay(100).fadeIn(100);
        $("#login-form").fadeOut(100);
        $("#register-form-shop").fadeOut(100);
        $("#register-form-customer").fadeOut(100);
        $('#login-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });
    $('#register-shop').click(function (e) {
        $("#register-form-shop").delay(100).fadeIn(100);
        $("#register-form").fadeOut(100);
        $('#register-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });
    $('#register-customer').click(function (e) {
        $("#register-form-customer").delay(100).fadeIn(100);
        $("#register-form").fadeOut(100);
        $('#lregister-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });
    $('#shop-naziv').keyup(function (e) {
        $.post("/NJTClient/controller", {value: this.value, attribute: 'email', action: 'ajax_validate_user'}, function (data) {
            $('#suggestions').html(data);
        });
        e.preventDefault();
    });
});
