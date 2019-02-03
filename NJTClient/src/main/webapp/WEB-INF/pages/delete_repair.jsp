<%-- 
    Document   : add_car
    Created on : Sep 4, 2018, 12:42:55 AM
    Author     : Dusan
--%>

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
                                        <h2 class="poruka">DELETE</h2>
                                        <br/>
                                        <br/>
                                        <form class="save_car" action="/NJTClient/controller" method="POST">
                                            <input type="hidden" name="action" value="delete_repair" />  
                                            <div class="form-row align-items-center justify-content-center">
                                                <div class="form-group col-md-3">
                                                    <label for="repairs">Select Repair you wish to Delete</label> 
                                                    <select class="form-control sacuvaj" name="repairs" id="repairs" onchange="this.form.submit()"> 
                                                        <option selected>Select a repair</option>
                                                        <c:forEach var="repair" items="${repairs}">
                                                        <option value="${repair.getId()}">${repair}</option>                                        
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div> 
                                    </form>
                                    <br/>
                                    <br/>
                                    <br/>
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col">#</th>
                                                <th scope="col">Name</th>
                                                <th scope="col">Price per unit</th>
                                                <th scope="col">Amount</th>
                                                <th scope="col">Price</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="item" items="${items}" varStatus="loop">
                                            <tr>
                                                <td>${item.getRowNumber()}</td>
                                                <td>${item.getName()}</td>
                                                <td>${item.getPricePerUnit()}</td>
                                                <td>${item.getAmount()}</td>
                                                <td>${item.getPrice()}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <br/>
                                    <br/>
                                    <h3 class="white">Car Information</h3>   
                                    <br/>
                                    <div class="form-row align-items-center justify-content-center save_car">
                                        <div class="form-group col-md-3">
                                            <label for="amount">Registration</label>
                                            <input type="text" class="form-control" name="registration" id="registration" placeholder="Select a repair" value="${repair.getCar().getRegistration()}" readonly>
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="amount">Current Kilometers</label>
                                            <input type="text" class="form-control" name="kilometers" id="kilometers" placeholder="Select a repair" value="${repair.getKilometers()}" readonly>
                                        </div>
                                    </div>
                                    <br/>
                                    <br/>
                                    <form class="save_car" action="/NJTClient/controller" method="POST">    
                                        <input type="hidden" name="action" value="remove_repair" />                  
                                        <input type="hidden" name="repair_id" value="${repair.getId()}" />                  
                                        <input type="submit" class="primary-btn text-uppercase" value="Delete Repair"/>     
                                        <br/>
                                        <br/>
                                        <br/>
                                        <br/>
                                        <br/>
                                    </form> 
                                    <br/>
                                    <h1 class="poruka">${message}</h1>
                                </div>
                            </div>
                        </div>
                        <br>
                        <br>        
                    </div>											
                </div>
            </div>
        </section>

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
    </body>
</html>
