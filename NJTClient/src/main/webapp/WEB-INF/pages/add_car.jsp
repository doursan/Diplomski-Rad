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
                    validateCar('${car.getRegistration()}', "registration", "car-registration");
                    validateCar('${car.getVin()}', "vin", "car-vin");
                    validateCar('${car.getColor()}', "color", "car-color");
                    
                    var brand_id = '${brand_id}';
                    var model_id = '${model_id}';
                    var engine_id = '${engine_id}';
                    var production_year = '${production_year}';
                    
                        for (var i = 0; i < document.getElementById("car_brands").length; i++) {
                            if (document.getElementById("car_brands").options[i].value === brand_id) {
                                document.getElementById("car_brands").selectedIndex = i;
                            }
                        }             
                        
                        populateModels(brand_id);
                        for (var i = 0; i < document.getElementById("car_models").length; i++) {
                            if (document.getElementById("car_models").options[i].value === model_id) {
                                document.getElementById("car_models").selectedIndex = i;
                            }
                        }
                        
                        populateEngines(model_id);
                        for (var i = 0; i < document.getElementById("engines").length; i++) {
                            if (document.getElementById("engines").options[i].value === engine_id) {
                                document.getElementById("engines").selectedIndex = i;
                            }
                        }
                        
                         for (var i = 0; i < document.getElementById("production_year").length; i++) {
                            if (document.getElementById("production_year").options[i].value === production_year) {
                                document.getElementById("production_year").selectedIndex = i;
                            }
                        }
                }
            });
            
            function populateModels(brandId) {
                var select = document.getElementById("car_models");
                select.options.length = 1;
            <c:forEach var="brand" items="${car_brands}">
                var id = <c:out value="${brand.getId()}"/>;
                if (id == brandId) {
                <c:forEach var="model" items="${brand.getCarBrandModelList()}">
                    select.options[select.options.length] = new Option("${model.getName()}", "${model.getId()}");
                </c:forEach>
                }
            </c:forEach>
            }
            function populateEngines(modelId) {
                var brandSelect = document.getElementById("car_brands");
                var brandId = brandSelect.options[brandSelect.selectedIndex].value;
                var select = document.getElementById("engines");
                select.options.length = 1;
            <c:forEach var="brand" items="${car_brands}">
                var bId = <c:out value="${brand.getId()}"/>;
                if (bId == brandId) {
                <c:forEach var="model" items="${brand.getCarBrandModelList()}">
                    var id = <c:out value="${model.getId()}"/>;
                    if (id == modelId) {
                    <c:forEach var="modelEngine" items="${model.getModelEngineList()}">
                        select.options[select.options.length] = new Option("${modelEngine.getEngine().getName()}", "${modelEngine.getId()}");
                    </c:forEach>
                    }
                </c:forEach>
                }
            </c:forEach>
            }

            function validateCar(value, attribute, id) {
                var div = '#validation-' + id;
                $.post("/NJTClient/controller", {value: value, attribute: attribute, action: 'ajax_validate_car', perform: 'add_car'}, function (data) {
                    $(div).html(data);
                });
            }
        </script>
    </head>
    <body>

        <jsp:include page="header.jsp"></jsp:include> 

            <section class="banner-area relative" id="home">	
                <div class="overlay overlay-bg"></div>
                <div class="container">
                    <div class="row d-flex align-items-center justify-content-center">
                        <div class="about-content col-lg-12">
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-12">
                                        <form class="save_car" action="/NJTClient/controller" method="POST">
                                            <input type="hidden" name="action" value="save_car" />
                                            <input type="hidden" name="model_engine" value="" />
                                            <br/>
                                            <h3 class="poruka">${message}</h3>
                                            <br/>
                                            <div class="form-row align-items-center justify-content-center">
                                                <label for="vin">VIN</label>
                                            </div>
                                            <div class="form-row align-items-center justify-content-center">
                                                <div class="form-group col-sm-1"></div>
                                                <div class="form-group col-md-5">
                                                    <input type="text" class="form-control" name="vin" id="car-vin" placeholder="Vehicle Identification Number" value="${car.getVin()}" onkeyup="validateCar(this.value, this.name, this.id)">
                                                </div>
                                                <div class="form-group col-sm-1">
                                                    <div id="validation-car-vin" style="text-align:justify"></div>
                                                </div>
                                            </div>
                                            <div class="form-row align-items-center justify-content-center">
                                                <label for="registration">Registration</label>
                                            </div>
                                            <div class="form-row align-items-center justify-content-center">
                                                <div class="form-group col-sm-1"></div>
                                                <div class="form-group col-md-5">
                                                    <input type="text" class="form-control" name="registration" id="car-registration"  placeholder="Registration Number" value="${car.getRegistration()}" onkeyup="validateCar(this.value, this.name, this.id)">
                                                </div>
                                                <div class="form-group col-sm-1">
                                                    <div id="validation-car-registration" style="text-align:justify"></div>
                                                </div>
                                            </div>
                                             <div class="form-row align-items-center justify-content-center">
                                                <label for="color">Color</label>
                                            </div>
                                            <div class="form-row align-items-center justify-content-center">
                                                <div class="form-group col-sm-1"></div>
                                                <div class="form-group col-md-3">
                                                    <input type="text" class="form-control" name="color" id="car-color"  placeholder="Color of a car" value="${car.getColor()}" onkeyup="validateCar(this.value, this.name, this.id)">
                                                </div>
                                                <div class="form-group col-sm-1">
                                                    <div id="validation-car-color" style="text-align:justify"></div>
                                                </div>
                                            </div>
                                            <div class="form-row align-items-center justify-content-center">
                                                <div class="form-group col-md-2">
                                                    <label for="car_brands">Car Brand</label> 
                                                    <select class="form-control sacuvaj" name="car_brands" id="car_brands" onchange="populateModels(this.value)"> 
                                                        <option selected disabled>Select brand</option>
                                                    <c:forEach var="brandOption" items="${car_brands}">
                                                        <option value="${brandOption.getId()}">${brandOption.getName()}</option>                                        
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>    
                                        <div class="form-row align-items-center justify-content-center">
                                            <div class="form-group col-md-2">
                                                <label for="production_year">Car Model</label> 
                                                <select class="form-control sacuvaj" name="car_models" id="car_models" onchange="populateEngines(this.value)"> 
                                                    <option selected disabled>Select model</option>
                                                </select>
                                            </div>
                                        </div>  
                                        <div class="form-row align-items-center justify-content-center">
                                            <div class="form-group col-md-2">
                                                <label for="engines">Engine</label> 
                                                <select class="form-control sacuvaj" name="engines" id="engines"> 
                                                    <option selected disabled>Select engine</option>                                    
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-row align-items-center justify-content-center">
                                            <div class="form-group col-md-2">
                                                <label for="production_year">Production Year</label> 
                                                <select class="form-control sacuvaj" name="production_year" id="production_year" >                                   
                                                    <% for (int i = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR); i >= 1900; i--) {%>
                                                    <option><%=i%></option>
                                                    <% }%>
                                                </select>
                                            </div>
                                        </div>
                                        <br>
                                        <input type="submit" class="primary-btn text-uppercase" value="Save Car"/>     
                                    </form>                      
                                </div>
                            </div>
                        </div>
                        <br>
                        <br>
                        <br>  
                    </div>											
                </div>
            </div>
        </section>        
    </body>
</html>
