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
                                        <div class="form-group">
                                            <input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value="">
                                        </div>
                                        <div class="form-group">
                                            <input type="email" name="email" id="email" tabindex="1" class="form-control" placeholder="Email Address" value="">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="shop-naziv" id="shop-naziv" tabindex="2" class="form-control" placeholder="Naziv radionice">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="pib" id="pib" tabindex="2" class="form-control" placeholder="Pib radionice">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="maticni" id="maticni" tabindex="2" class="form-control" placeholder="Maticni broj radionice">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" name="confirm-password" id="confirm-password" tabindex="2" class="form-control" placeholder="Confirm Password">
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
                                        <div class="form-group">
                                            <input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value="">
                                        </div>
                                        <div class="form-group">
                                            <input type="email" name="email" id="email" tabindex="1" class="form-control" placeholder="Email Address" value="">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="ime" id="ime" tabindex="2" class="form-control" placeholder="Ime">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="prezime" id="prezime" tabindex="2" class="form-control" placeholder="Prezime">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="jmbg" id="jmbg" tabindex="2" class="form-control" placeholder="JMBG">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" name="confirm-password" id="confirm-password" tabindex="2" class="form-control" placeholder="Confirm Password">
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
        <script type="text/javascript" src="/NJTClient/pages/js/login1.js"></script>
    </body>
</html>
