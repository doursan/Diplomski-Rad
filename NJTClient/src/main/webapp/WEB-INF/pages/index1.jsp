<%-- 
    Document   : index
    Created on : Aug 14, 2018, 12:22:32 AM
    Author     : Dusan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>Who Does Your Car</title>
        <meta name="description" content="MAK moto">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <style type="text/css">
        body{
            padding-top: 40px;
        }
        .jumbotron{
            margin-top: 20px;
            margin-left: 50px;
            margin-right: 50px;
            background-image: url("/NJTClient/pages/slike/vfr.jpg");
            background-size: cover;
            min-height: 350px;
            border-radius: 21px;
        }
        .opis {
            color: #FF6666;
            opacity: 0.4;
        }
        .logout {
            position: absolute;
            top: 0px;
            right: -600px;
        }
    </style>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top" id="my-navbar">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="" class="navbar-brand">MAK moto</a>
                </div>
                <div class="collapse navbar-collapse" id="navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="login.php">About us</a></li>
                        <li><a href="login.php">Gallery</a></li>
                        <li><a href="login.php">Our service</a></li>
                        <li><a href="login.php">Contact us</a></li>
                        <li><a href="login.php">Admin</a></li>
                        <li><a href="logout.php" class="logout">Logout</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="jumbotron">
            <div class="container">
                <!--	<img src="/NJTClient/pages/slike/vfr.jpg" width="1450" height="750"> -->
                <img src="/NJTClient/pages/slike/mak1.png" width = "320" height = "120">
                <div class="opis"><p><h2>Ovde ce pisati nesto o tome koliko ste najbolji i tako to</h2></p>
                </div>
            </div>
        </div>
        <div id="greska"></div>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3">
                    <div id="imaginary_container"> 
                        <div class="input-group stylish-input-group">
                            <input type="text" class="form-control" id="search" placeholder="Search by city">
                            <span class="input-group-addon">	                        
                                <a href="#search" id ="searchButtonUser"><span class="glyphicon glyphicon-search" style="color:#0000FF"></span></a>                          
                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-6 col-sm-offset-3" id="suggest"></div><br/>
            <table class="tabela table table-striped table-inverse" id="tabela">
                <thead>
                    <tr>
                        <th scope="col">City</th>
                        <th scope="col">State</th>
                        <th scope="col">Distance</th>
                        <th scope="col">Price</th>
                    </tr>
                </thead>
                <tbody class ="redovi">
                    <?php
                    foreach($resultSveDest as $red) {			  			
                    ?>
                    <tr>
                        <td><?php echo $red->grad; ?></td> 
                        <td><?php echo $red->drzava; ?></td>
                        <td><?php echo $red->km; ?></td>
                        <td><?php echo $red->cena; ?></td>
                    </tr>
                    <?php
                    }
                    ?>
                </tbody>
            </table>
            <!-- <div class="btn-group">
                    <a href="" class="btn btn-lg btn-default">Add</a>
                    <a href="" class="btn btn-lg btn-default">Update/Delete</a>
            </div> -->

        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script src="/NJTClient/WEB-INF/pages/js/global.js"></script>
    </body>
</html>
