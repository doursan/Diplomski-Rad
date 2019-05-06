<%-- 
    Document   : login1
    Created on : Aug 16, 2018, 10:25:50 PM
    Author     : Dusan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Who Does Your Car</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <link rel="stylesheet" href="/NJTClient/pages/css/login1.css" type="text/css">
        <script src="/NJTClient/pages/js/easing.min.js"></script>			
        <script src="/NJTClient/pages/js/hoverIntent.js"></script>
        <script src="/NJTClient/pages/js/superfish.min.js"></script>	
        <script src="/NJTClient/pages/js/jquery.ajaxchimp.min.js"></script>
        <script src="/NJTClient/pages/js/jquery.magnific-popup.min.js"></script>	
        <script src="/NJTClient/pages/js/owl.carousel.min.js"></script>			
        <script src="/NJTClient/pages/js/jquery.sticky.js"></script>
        <script src="/NJTClient/pages/js/jquery.nice-select.min.js"></script>	
        <script src="/NJTClient/pages/js/waypoints.min.js"></script>
        <script src="/NJTClient/pages/js/jquery.counterup.min.js"></script>					
        <script src="/NJTClient/pages/js/parallax.min.js"></script>		
        <script src="/NJTClient/pages/js/mail-script.js"></script>	
        <script src="/NJTClient/pages/js/main.js"></script>
        <script src="/NJTClient/pages/js/vendor/bootstrap.min.js"></script>			
        <<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.18/sl-1.3.0/datatables.min.css"/>
        <script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.18/sl-1.3.0/datatables.min.js"></script>
        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
        <script src="/NJTClient/pages/js/vendor/jquery-2.2.4.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script type="text/javascript" src="/NJTClient/pages/js/login1.js"></script>

        <script type="text/javascript">

            $(document).ready(function () {
                if ('${invalid_shop}') {
                    document.getElementById("register-form-link").click();
                    document.getElementById("register-shop").click();
                    validateUser('${shop.getUsername()}', 'username', 'username-shop');
                    validateUser('${shop.getEmail()}', 'email', 'email-shop');
                    validateUser('${shop.getNaziv()}', 'shop-naziv', 'shop-naziv');
                    validateUser('${shop.getPib()}', 'pib', 'pib');
                    validateUser('${shop.getMaticni()}', 'maticni', 'maticni');
                }
                
                if ('${invalid_client}') {
                    document.getElementById("register-form-link").click();
                    document.getElementById("register-customer").click();
                    validateUser('${client.getUsername()}', 'username', 'username-customer');
                    validateUser('${client.getEmail()}', 'email', 'email-customer');
                    validateUser('${client.getIme()}', 'ime', 'ime-customer');
                    validateUser('${client.getPrezime()}', 'prezime', 'prezime-customer');
                    validateUser('${client.getJmbg()}', 'jmbg', 'jmbg');
                }

            });

            function validateUser(value, attribute, id) {
                var div = '#validation-' + id;
                $.post("/NJTClient/controller", {value: value, attribute: attribute, action: 'ajax_validate_user'}, function (data) {
                    $(div).html(data);
                });
            }

            function confirmPassword(value, user, id) {
                var div = '#validation-' + id;
                password = document.getElementById(user).value;
                compare = value.localeCompare(password);
                if (compare === 0) {
                    $(div).html('<span class=\"glyphicon glyphicon-ok\" style=\"color:green\"></span>');
                } else {
                    $(div).html('<span class=\"glyphicon glyphicon-remove\" style=\"color:red\"></span>');
                }
            }
        </script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <div class="panel panel-login">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-6">
                                    <a href="#" class="active" id="login-form-link">Login</a>
                                </div>
                                <div class="col-xs-6">
                                    <a href="#" id="register-form-link">Register</a>
                                </div>
                            </div>
                            <hr>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <form id="login-form" action="/NJTClient/controller" method="post" role="form" style="display: block;">
                                        <input type="hidden" name="action" value="login" />
                                        <div class="form-group">
                                            <input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value="">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password">
                                        </div>
                                        <div id="errorMessage">
                                            ${errorMessage}
                                        </div>
                                        <hr>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-sm-6 col-sm-offset-3">
                                                    <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Log In">
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                    <form id="register-form" action="https://phpoll.com/register/process" method="post" role="form" style="display: none;">
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-sm-6 col-sm-offset-3">
                                                    <input type="button" name="register-submit" id="register-shop" tabindex="4" class="form-control btn btn-register" value="Register as a Shop">
                                                    <hr>
                                                </div>
                                                <div class="col-sm-6 col-sm-offset-3">
                                                    <input type="button" name="register-submit" id="register-customer" tabindex="4" class="form-control btn btn-login" value="Register as a Customer">
                                                </div>
                                            </div>
                                        </div>                                
                                    </form>
                                    <form id="register-form-shop" action="/NJTClient/controller" method="post" role="form" style="display: none;">
                                        <input type="hidden" name="action" value="register" />
                                        <div id="errorMessage" style="text-align:center">
                                            <h4>${message_shop}</h4>
                                        </div>
                                        <br/>
                                        <div class="form-row align-items-center justify-content-center">
                                            <div class="form-group">
                                                <input type="text" name="username" id="username-shop" tabindex="1" class="form-control" placeholder="Username (At least 5 characters long)" value="${shop.getUsername()}" onkeyup="validateUser(this.value, this.name, this.id)">
                                            </div>
                                            <div class="form-group col-sm-4">
                                                <div id="validation-username-shop" style="text-align:justify"></div>
                                            </div>
                                        </div>
                                        <div class="form-row align-items-center justify-content-center">
                                            <div class="form-group">
                                                <input type="email" name="email" id="email-shop" tabindex="1" class="form-control" placeholder="Email Address" value="${shop.getEmail()}" onkeyup="validateUser(this.value, this.name, this.id)">
                                            </div>
                                            <div class="form-group col-sm-4">
                                                <div id="validation-email-shop" style="text-align:justify"></div>
                                            </div>
                                        </div>
                                        <div class="form-row align-items-center justify-content-center">
                                            <div class="form-group">
                                                <input type="text" name="shop-naziv" id="shop-naziv" tabindex="2" class="form-control" placeholder="Naziv radionice" value="${shop.getNaziv()}" onkeyup="validateUser(this.value, this.name, this.id)">
                                            </div>
                                            <div class="form-group col-sm-4">
                                                <div id="validation-shop-naziv" style="text-align:justify"></div>
                                            </div>
                                        </div>
                                        <div class="form-row align-items-center justify-content-center">
                                            <div class="form-group">
                                                <input type="text" name="pib" id="pib" tabindex="2" class="form-control" placeholder="Pib radionice" value="${shop.getPib()}" onkeyup="validateUser(this.value, this.name, this.id)">
                                            </div>
                                            <div class="form-group col-sm-4">
                                                <div id="validation-pib" style="text-align:justify"></div>
                                            </div>
                                        </div>
                                        <div class="form-row align-items-center justify-content-center">
                                            <div class="form-group">
                                                <input type="text" name="maticni" id="maticni" tabindex="2" class="form-control" placeholder="Maticni broj radionice" value="${shop.getMaticni()}" onkeyup="validateUser(this.value, this.name, this.id)">
                                            </div>
                                            <div class="form-group col-sm-4">
                                                <div id="validation-maticni" style="text-align:justify"></div>
                                            </div>
                                        </div>
                                        <div class="form-row align-items-center justify-content-center">
                                            <div class="form-group">
                                                <input type="password" name="password" id="password-shop" tabindex="2" class="form-control" placeholder="Password" onkeyup="validateUser(this.value, this.name, this.id)">
                                            </div>
                                            <div class="form-group col-sm-4">
                                                <div id="validation-password-shop" style="text-align:justify"></div>
                                            </div>
                                        </div>
                                        <div class="form-row align-items-center justify-content-center">
                                            <div class="form-group">
                                                <input type="password" name="confirm-password" id="confirm-password-shop" tabindex="2" class="form-control" placeholder="Confirm Password" onkeyup="confirmPassword(this.value, 'password-shop', this.id)">
                                            </div>
                                            <div class="form-group col-sm-4">
                                                <div id="validation-confirm-password-shop" style="text-align:justify"></div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-sm-6 col-sm-offset-3">
                                                    <input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Register Now">
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                    <form id="register-form-customer" action="/NJTClient/controller" method="post" role="form" style="display: none;">
                                        <input type="hidden" name="action" value="register" />
                                        <div class="form-row align-items-center justify-content-center">
                                            <div class="form-group">
                                                <input type="text" name="username" id="username-customer" tabindex="1" class="form-control" placeholder="Username  (At least 5 characters long)" value="${client.getUsername()}" onkeyup="validateUser(this.value, this.name, this.id)">
                                            </div>
                                            <div class="form-group col-sm-4">
                                                <div id="validation-username-customer" style="text-align:justify"></div>
                                            </div>
                                        </div>
                                        <div class="form-row align-items-center justify-content-center">
                                            <div class="form-group">
                                                <input type="email" name="email" id="email-customer" tabindex="1" class="form-control" placeholder="Email Address" value="${client.getEmail()}" onkeyup="validateUser(this.value, this.name, this.id)">
                                            </div>
                                            <div class="form-group col-sm-4">
                                                <div id="validation-email-customer" style="text-align:justify"></div>
                                            </div>
                                        </div>
                                        <div class="form-row align-items-center justify-content-center">
                                            <div class="form-group">
                                                <input type="text" name="ime" id="ime-customer" tabindex="2" class="form-control" placeholder="Ime" value="${client.getIme()}" onkeyup="validateUser(this.value, this.name, this.id)">
                                            </div>
                                            <div class="form-group col-sm-4">
                                                <div id="validation-ime-customer" style="text-align:justify"></div>
                                            </div>
                                        </div>
                                        <div class="form-row align-items-center justify-content-center">
                                            <div class="form-group">
                                                <input type="text" name="prezime" id="prezime-customer" tabindex="2" class="form-control" placeholder="Prezime" value="${client.getPrezime()}" onkeyup="validateUser(this.value, this.name, this.id)">
                                            </div>
                                            <div class="form-group col-sm-4">
                                                <div id="validation-prezime-customer" style="text-align:justify"></div>
                                            </div>
                                        </div>
                                        <div class="form-row align-items-center justify-content-center">
                                            <div class="form-group">
                                                <input type="text" name="jmbg" id="jmbg" tabindex="2" class="form-control" placeholder="JMBG" value="${client.getJmbg()}" onkeyup="validateUser(this.value, this.name, this.id)">
                                            </div>
                                            <div class="form-group col-sm-4">
                                                <div id="validation-jmbg" style="text-align:justify"></div>
                                            </div>
                                        </div>
                                        <div class="form-row align-items-center justify-content-center">
                                            <div class="form-group">
                                                <input type="password" name="password" id="password-customer" tabindex="2" class="form-control" placeholder="Password" onkeyup="validateUser(this.value, this.name, this.id)">
                                            </div>
                                            <div class="form-group col-sm-4">
                                                <div id="validation-password-customer" style="text-align:justify"></div>
                                            </div>
                                        </div>
                                        <div class="form-row align-items-center justify-content-center">
                                            <div class="form-group">
                                                <input type="password" name="confirm-password" id="confirm-password-customer" tabindex="2" class="form-control" placeholder="Confirm Password" onkeyup="confirmPassword(this.value, 'password-customer', this.id)">
                                            </div>
                                            <div class="form-group col-sm-4">
                                                <div id="validation-confirm-password-customer" style="text-align:justify"></div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-sm-6 col-sm-offset-3">
                                                    <input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-login" value="Register Now">
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
