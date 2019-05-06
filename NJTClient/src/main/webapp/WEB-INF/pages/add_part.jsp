<%-- 
    Document   : add_car
    Created on : Sep 4, 2018, 12:42:55 AM
    Author     : Dusan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">
    <head>
        <!-- Mobile Specific Meta -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Favicon-->
        <link rel="shortcut icon" href="/NJTClient/pages/img/fav.png">
        <!-- Author Meta -->
        <meta name="author" content="codepixer">
        <!-- Meta Description -->
        <meta name="description" content="">
        <!-- Meta Keyword -->
        <meta name="keywords" content="">
        <!-- meta character set -->
        <meta charset="UTF-8">
        <!-- Site Title -->
        <title>Who Does Your Car</title>

        <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet"> 
        <!--
        CSS
        ============================================= -->
        <link rel="stylesheet" href="/NJTClient/pages/css/linearicons.css">
        <link rel="stylesheet" type="text/css" href="/NJTClient/pages/css/font-awesome.min.css">
        <link rel="stylesheet" href="/NJTClient/pages/css/bootstrap.css">
        <link rel="stylesheet" href="/NJTClient/pages/css/magnific-popup.css">
        <link rel="stylesheet" href="/NJTClient/pages/css/nice-select.css">					
        <link rel="stylesheet" href="/NJTClient/pages/css/animate.min.css">
        <link rel="stylesheet" href="/NJTClient/pages/css/owl.carousel.css">
        <link rel="stylesheet" type="text/css" href="/NJTClient/pages/css/main.css">
        <link type="text/css" rel="stylesheet" href="http://fakedomain.com/smilemachine/html.css" />
        <script src="/NJTClient/pages/js/vendor/jquery-2.2.4.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="/NJTClient/pages/js/vendor/bootstrap.min.js"></script>			
        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
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
        
        <script type="text/javascript">

            $(document).ready(function () {
                if ('${invalid}') {
                    validatePart('${car_part.getName()}', "name", "part-name");
                    validatePart('${car_part.getPrice()}', "price", "part-price");
                }
            });

            function validatePart(value, attribute, id) {
                var div = '#validation-' + id;
                $.post("/NJTClient/controller", {value: value, attribute: attribute, action: 'ajax_validate_part', perform: 'add'}, function (data) {
                    $(div).html(data);
                });
            }
        </script>
    </head>
    <body>

        <jsp:include page="header_admin.jsp"></jsp:include> 

            <section class="banner-area relative" id="home">	
                <div class="overlay overlay-bg"></div>
                <div class="container">
                    <div class="row d-flex align-items-center justify-content-center">
                        <div class="about-content col-lg-12">
                            <br>  
                            <br>
                            <br>  
                            <br>
                            <br>            
                            <br>
                            <br> 
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-12">
                                        <form class="save_car" action="/NJTClient/controller" method="POST">
                                            <input type="hidden" name="action" value="save_part" />       
                                            <div class="form-row align-items-center justify-content-center">
                                                <label for="name">Part Name</label> 
                                            </div>   
                                            <div class="form-row align-items-center justify-content-center">
                                                <div class="form-group col-sm-1"></div>
                                                <div class="form-group col-md-3">
                                                    <input type="text" class="form-control" name="name" id="part-name" placeholder="Enter Name of the Part here" value="${car_part.getName()}" onkeyup="validatePart(this.value, this.name, this.id)">
                                            </div>
                                            <div class="form-group col-sm-1">
                                                <div id="validation-part-name" style="text-align:justify"></div>
                                            </div>
                                        </div>   
                                        <br>  
                                        <div class="form-row align-items-center justify-content-center">
                                            <label for="buyer">Part Price in Euros (€)</label>
                                        </div>
                                        <div class="form-row align-items-center justify-content-center">
                                            <div class="form-group col-sm-1"></div>
                                            <div class="form-group col-md-3">
                                                <input type="text" class="form-control" name="price" id="part-price" placeholder="Enter Price of the Part here" value="${car_part.getPrice()}" onkeyup="validatePart(this.value, this.name, this.id)">
                                            </div>
                                            <div class="form-group col-sm-1">
                                                <div id="validation-part-price" style="text-align:justify"></div>
                                            </div>
                                        </div>
                                        <br> 
                                        <h3 class="poruka">${message}</h3>
                                        <br>   
                                        <br>  
                                        <input type="submit" class="primary-btn text-uppercase" value="Save Car Part"/>     
                                    </form>                      
                                </div>
                            </div>
                        </div>
                        <br>
                        <br>       
                    </div>											
                </div>
            </div>
        </section>	
    </body>
</html>
