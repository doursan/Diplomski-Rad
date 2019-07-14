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
        <<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.18/sl-1.3.0/datatables.min.css"/>
        <script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.18/sl-1.3.0/datatables.min.js"></script>
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

            function populatePriceAndName(serviceId) {
            <c:forEach var="service" items="${services}">
                var id = <c:out value="${service.getId()}"/>;
                if (id == serviceId) {
                    document.getElementById("service_name").value = "${service.getName()}";
                    if ("${service.getPrice()}" != "0.0") {
                        document.getElementById("service-price").value = "${service.getPrice()}";
                    } else {
                        document.getElementById("service-price").value = "Price not available!";
                    }
                }
            </c:forEach>
            }
            function populateName(carPartId) {
            <c:forEach var="carPart" items="${car_parts}">
                var id = <c:out value="${carPart.getId()}"/>;
                if (id == carPartId) {
                    document.getElementById("part_name").value = "${carPart.getName()}";
                    if ("${carPart.getPrice()}" != "0.0") {
                        document.getElementById("part_price").value = "${carPart.getPrice()}";
                    }
                }
            </c:forEach>
            }
            function finish(value) {
                document.getElementById("repair-registration").value = value;
                validateRepair(value, "registration", "repair-registration");
                $('#suggestions').html("");
            }
            function suggestRegistrations(reg) {
                $.post("/NJTClient/controller", {registration: reg, action: 'ajax_reg_autocomplete'}, function (data) {
                    $('#suggestions').html(data);
                });
            }
            $(document).ready(function () {
                $('#createRepair').on('page.dt', function () {
                    location.href = "#";
                    location.href = "#test_test";
                }).DataTable({
                    "columns": [
                        {"width": "10%"},
                        {"width": "18%"},
                        {"width": "18%"},
                        {"width": "18%"},
                        {"width": "18%"},
                        {"width": "18%"}
                    ]
                });
                var drops = document.getElementsByName("createRepair_length");
                var drop = drops[0];
                drop.classList.remove("custom-select");

                if ('${invalid_item}') {
                    if ('${type}' === 'service') {
                        validateRepair('${service_item.getAmount()}', 'amount', 'service-amount');

                        var service_id = '${service_id}';
                        for (var i = 0; i < document.getElementById("services").length; i++) {
                            if (document.getElementById("services").options[i].value === service_id) {
                                document.getElementById("services").selectedIndex = i;
                                document.getElementById("service_name").value = '${service_name}';
                            }
                        }

                        location.href = "#";
                        location.href = "#service-title";
                    } else {
                        validateRepair('${part_item.getAmount()}', 'amount', 'part-amount');
                        validateRepair('${part_item.getPricePerUnit()}', 'part_price', 'part_price');

                        var part_id = '${part_id}';
                        for (var i = 0; i < document.getElementById("services").length; i++) {
                            if (document.getElementById("parts").options[i].value === part_id) {
                                document.getElementById("parts").selectedIndex = i;
                                document.getElementById("part_name").value = '${part_name}';
                            }
                        }
                        location.href = "#";
                        location.href = "#car-part-title";
                    }
                }

                if ('${invalid_repair}') {
                    validateRepair('${registration}', 'registration', 'repair-registration');
                    validateRepair('${kilometers}', 'kilometers', 'repair-kilometers');
                    location.href = "#";
                    location.href = "#repair-title";
                }
            });

            function validateRepair(value, attribute, id) {
                var div = '#validation-' + id;
                $.post("/NJTClient/controller", {value: value, attribute: attribute, action: 'ajax_validate_repair', perform: 'add_repair'}, function (data) {
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
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-12">
                                        <h2 class="poruka">ADD REPAIR</h2>
                                        <br/>
                                        <form class="save_car" action="/NJTClient/controller" method="POST">
                                            <input type="hidden" name="action" value="add_repair_item" />   
                                            <input type="hidden" name="type"  value="service" />  
                                            <input type="hidden" name="from"  value="create_repair" />         
                                            <input type="hidden" name="service_name" id="service_name" value="" />  
                                            <h3 class="white" id="service-title">Select a Service you wish to Add</h3>   
                                            <br/>
                                            <div class="form-row align-items-center justify-content-center">
                                                <div class="form-group col-md-0">
                                                    <div style="text-align:justify; width:25px;"></div>
                                                </div>
                                                <div class="form-group col-md-3">
                                                    <label for="services">Service</label> 
                                                </div> 
                                                <div class="form-group col-md-0">
                                                    <div style="text-align:justify; width:25px;"></div>
                                                </div>
                                                <div class="form-group col-md-3">
                                                    <label for="amount">Amount</label>
                                                </div> 
                                                <div class="form-group col-md-0">
                                                    <div style="text-align:justify; width:25px;"></div>
                                                </div>
                                                <div class="form-group col-md-3">
                                                    <label for="amount">Price per unit</label>
                                                </div> 
                                                <div class="form-group col-md-0">
                                                    <div style="text-align:justify; width:25px;"></div>
                                                </div>
                                            </div>
                                            <div class="form-row align-items-center justify-content-center">
                                                <div class="form-group col-md-0">
                                                    <div style="text-align:justify; width:25px;"></div>
                                                </div>
                                                <div class="form-group col-md-3">
                                                    <select class="form-control sacuvaj" name="services" id="services" onchange="populatePriceAndName(this.value)"> 
                                                        <option selected>Select a Service</option>
                                                    <c:forEach var="service" items="${services}">
                                                        <option value="${service.getId()}">${service.getName()}</option>                                        
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="form-group col-md-0">
                                                <div style="text-align:justify; width:25px;"></div>
                                            </div>
                                            <div class="form-group col-md-3">
                                                <input type="text" class="form-control" name="amount" id="service-amount" placeholder="Amount" value="${service_item.getAmount()}" onkeyup="validateRepair(this.value, this.name, this.id)">
                                            </div>
                                            <div class="form-group col-md-0">
                                                <div id="validation-service-amount" style="text-align:justify; width:25px;"></div>
                                            </div>
                                            <div class="form-group col-md-3">
                                                <input type="text" class="form-control" name="price" id="service-price" placeholder="Price" value="${service_item.getPricePerUnit()}" readonly>
                                            </div>
                                            <div class="form-group col-md-0">
                                                <div style="text-align:justify; width:25px;"></div>
                                            </div>
                                            <br/>
                                        </div>
                                        <input type="submit" class="btn btn-warning btn-sm text-uppercase" value="Add Service"/> 
                                    </form>
                                    <br/>
                                    <h4 class="poruka">${message_service}</h4>
                                    <br/>
                                    <form class="save_car" action="/NJTClient/controller" method="POST">
                                        <br/>
                                        <br/>                                        
                                        <h3 class="white" id="car-part-title">Select a Car Part you wish to Add</h3>   
                                        <br/>
                                        <input type="hidden" name="action" value="add_repair_item" />        
                                        <input type="hidden" name="type" value="carPart" />        
                                        <input type="hidden" name="from"  value="create_repair" />            
                                        <input type="hidden" name="part_name" id="part_name" value="" />    
                                        <div class="form-row align-items-center justify-content-center">
                                            <div class="form-group col-md-0">
                                                <div style="text-align:justify; width:25px;"></div>
                                            </div>
                                            <div class="form-group col-md-3">
                                                <label for="services">Car Part</label> 
                                            </div> 
                                            <div class="form-group col-md-0">
                                                <div style="text-align:justify; width:25px;"></div>
                                            </div>
                                            <div class="form-group col-md-3">
                                                <label for="amount">Amount</label>
                                            </div> 
                                            <div class="form-group col-md-0">
                                                <div style="text-align:justify; width:25px;"></div>
                                            </div>
                                            <div class="form-group col-md-3">
                                                <label for="amount">Price per unit (Optional)</label>
                                            </div> 
                                            <div class="form-group col-md-0">
                                                <div style="text-align:justify; width:25px;"></div>
                                            </div>
                                        </div>
                                        <div class="form-row align-items-center justify-content-center">
                                            <div class="form-group col-md-0">
                                                <div style="text-align:justify; width:25px;"></div>
                                            </div>
                                            <div class="form-group col-md-3">
                                                <select class="form-control sacuvaj" name="parts" id="parts" onchange="populateName(this.value)"> 
                                                    <option selected>Select a car part</option>
                                                    <c:forEach var="part" items="${car_parts}">
                                                        <option value="${part.getId()}">${part.getName()}</option>                                        
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="form-group col-md-0">
                                                <div style="text-align:justify; width:25px;"></div>
                                            </div>
                                            <div class="form-group col-md-3">
                                                <input type="text" class="form-control" name="amount" id="part-amount" placeholder="Amount" value="${part_item.getAmount()}" onkeyup="validateRepair(this.value, this.name, this.id)">
                                            </div>
                                            <div class="form-group col-md-0">
                                                <div id="validation-part-amount" style="text-align:justify; width:25px;"></div>
                                            </div>
                                            <div class="form-group col-md-3">
                                                <input type="text" class="form-control" name="part_price" id="part_price" placeholder="Price" value="${part_item.getPricePerUnit()}" onkeyup="validateRepair(this.value, this.name, this.id)">
                                            </div>
                                            <div class="form-group col-md-0">
                                                <div id="validation-part_price" style="text-align:justify; width:25px;"></div>
                                            </div>
                                            <br/>
                                        </div>                                        
                                        <input type="submit" id='test_test' class="btn btn-warning btn-sm text-uppercase" value="Add Car Part"/> 
                                    </form>                        
                                    <br/>
                                    <h4 class="poruka">${message_part}</h4>
                                    <br/>
                                    <br/>
                                    <br/>
                                    <table id="createRepair" class="table dataTabele table-striped" cellspacing="0" width="100%">
                                        <thead>
                                            <tr>
                                                <th scope="col">#</th>
                                                <th scope="col">Name</th>
                                                <th scope="col">Price per unit</th>
                                                <th scope="col">Amount</th>
                                                <th scope="col">Price</th>
                                                <th scope="col">Delete</th>
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
                                                    <td>
                                                        <a href=" 
                                                           <c:url value="/controller">
                                                               <c:param name="action" value="remove_item"></c:param>
                                                               <c:param name="from" value="create_repair"></c:param>
                                                               <c:param name="rowNumber" value="${item.getRowNumber()}"></c:param>
                                                           </c:url> ">&#10008</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    <hr/>
                                    <h4 class="poruka">Total: ${repair.getPrice()}</h4>
                                    <br/>
                                    <br/>
                                    <br/>
                                    <form class="save_car" action="/NJTClient/controller" method="POST">
                                        <input type="hidden" name="action" value="save_repair" />  
                                        <h3 class="white" id="repair-title">Car Information</h3>   
                                        <br/>
                                        <div class="form-row align-items-center justify-content-center">
                                            <div class="form-group col-md-0">
                                                <div style="text-align:justify; width:25px;"></div>
                                            </div>
                                            <div class="form-group col-md-3">
                                                <label for="registration">Registration</label> 
                                            </div> 
                                            <div class="form-group col-md-0">
                                                <div style="text-align:justify; width:25px;"></div>
                                            </div>
                                            <div class="form-group col-md-3">
                                                <label for="repair-kilometers">Current Kilometers</label>
                                            </div> 
                                            <div class="form-group col-md-0">
                                                <div style="text-align:justify; width:25px;"></div>
                                            </div>
                                        </div>
                                        <div class="form-row align-items-center justify-content-center">
                                            <div class="form-group col-md-0">
                                                <div style="text-align:justify; width:25px;"></div>
                                            </div>
                                            <div class="form-group col-md-3">
                                                <input type="text" class="form-control" name="registration" id="repair-registration" placeholder="Registration" value="${registration}" onkeyup="suggestRegistrations(this.value); validateRepair(this.value, this.name, this.id)">
                                            </div>
                                            <div class="form-group col-md-0">
                                                <div id="validation-repair-registration" style="text-align:justify; width:25px;"></div>
                                            </div>
                                            <div class="form-group col-md-3">
                                                <input type="text" class="form-control" name="kilometers" id="repair-kilometers" placeholder="Kilometers" value="${kilometers}" onkeyup="validateRepair(this.value, this.name, this.id)">
                                            </div>
                                            <div class="form-group col-md-0">
                                                <div id="validation-repair-kilometers" style="text-align:justify; width:25px;"></div>
                                            </div>
                                        </div>
                                        <div class="form-row align-items-center justify-content-center">
                                            <div class="form-group col-md-0">
                                                <div style="text-align:justify; width:25px;"></div>
                                            </div>
                                            <div class="form-group col-md-3">
                                                <div id="suggestions"></div>
                                            </div>
                                            <div class="form-group col-md-0">
                                                <div style="text-align:justify; width:25px;"></div>
                                            </div>
                                            <div class="form-group col-md-3"></div>
                                            <div class="form-group col-md-0">
                                                <div style="text-align:justify; width:25px;"></div>
                                            </div>
                                        </div>
                                        <br/>
                                        <h3 class="poruka">${message_repair}</h3>
                                        <br/>
                                        <br/>
                                        <input type="submit" class="primary-btn text-uppercase" value="Create Repair"/>     
                                    </form> 
                                </div>
                            </div>
                        </div>  
                    </div>											
                </div>
            </div>
        </section>        
    </body>
</html>
