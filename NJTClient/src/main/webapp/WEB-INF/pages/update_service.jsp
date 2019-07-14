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
            $(document).ready(function () {
                var table = $('#changeService').DataTable({
                    "columns": [
                        {"width": "1%"},
                        {"width": "33%"},
                        {"width": "33%"},
                        {"width": "33%"}
                    ]
                });

                if ('${invalid}') {
                    var tabela = document.getElementById("changeService");
                    validateService('${service.getName()}', "name", "service-name");
                    validateService('${service.getPrice()}', "price", "service-price");
                    validateService('${service.getHours()}', "hours", "service-hours");
                    $("#submit_update_service").prop('disabled', false);
                    tabela.rows['${index}'].style.backgroundColor = "#ff0000";
                    tabela.rows['${index}'].style.color = "#ffffff";
                    tabela.rows['${index}'].style.opacity = "0.34";
                    document.getElementById("rowIndex").value = '${index}';

                    location.href = "#";
                    location.href = "#service-hours";
                }

                var drops = document.getElementsByName("changeService_length");
                var drop = drops[0];
                drop.classList.remove("custom-select");

                table.on('click', 'tbody tr', function () {

                    var tabela = document.getElementById("changeService");
                    var index = document.getElementById("rowIndex").value;
                    var name = tabela.rows[this.rowIndex].cells[1].innerHTML;
                    var hours = tabela.rows[this.rowIndex].cells[2].innerHTML;
                    var price = tabela.rows[this.rowIndex].cells[3].innerHTML;

                    validateService(name, 'name', 'service-name');
                    validateService(hours, 'hours', 'service-hours');
                    validateService(price, 'price', 'service-price');

                    if (index) {
                        tabela.rows[index].style.backgroundColor = "black";
                    }
                    $("#submit_update_service").prop('disabled', false);
                    $(this).css('background', '#ff0000');
                    $(this).css('color', '#ffffff');
                    $(this).css('opacity', '0.34');
                    document.getElementById("rowIndex").value = this.rowIndex;
                    document.getElementById("update_service_id").value = tabela.rows[this.rowIndex].cells[0].innerHTML;
                    document.getElementById("service-name").value = name;
                    document.getElementById("service-hours").value = hours;
                    document.getElementById("service-price").value = price;
                    location.href = "#";
                    location.href = "#service-name";
                });
            });

            function validateService(value, attribute, id) {
                var div = '#validation-' + id;
                $.post("/NJTClient/controller", {value: value, attribute: attribute, action: 'ajax_validate_service', perform: 'update'}, function (data) {
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
                            <label>Select a Service you wish to Update</label> 
                            <br>
                            <br>  
                            <table id="changeService" class="table dataTabele table-striped" cellspacing="0" width="100%">
                                <thead>
                                    <tr>
                                        <th class="th-sm" style="display:none;">Id
                                        </th>
                                        <th class="th-sm">Name
                                        </th>
                                        <th class="th-sm">Hours
                                        </th>
                                        <th class="th-sm">Price
                                        </th>   
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="service" items="${services}" varStatus="loop">
                                    <tr>
                                        <td style="display:none;">${service.getId()}</td>
                                        <td>${service.getName()}</td>
                                        <td>${service.getHours()}</td>
                                        <td>${service.getPrice()}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <th class="th-sm" style="display:none;">Id
                                    </th>
                                    <th class="th-sm">Name
                                    </th>
                                    <th class="th-sm">Hours
                                    </th>
                                    <th class="th-sm">Price
                                    </th>   
                                </tr>
                            </tfoot>
                        </table>    
                        <br>
                        <br>            
                        <br>
                        <br> 
                        <div class="container">
                            <div class="row">
                                <div class="col-md-12">
                                    <form class="save_car" action="/NJTClient/controller" method="POST">
                                        <input type="hidden" name="action" value="update_service" />  
                                        <input type="hidden" name="service_id" id="update_service_id" value="${service.getId()}" />  
                                        <input type="hidden" name="rowIndex" id="rowIndex" value="" />  
                                        <br>  
                                        <div class="form-row align-items-center justify-content-center">
                                            <label for="name">Service Name</label> 
                                        </div>   
                                        <div class="form-row align-items-center justify-content-center">
                                            <div class="form-group col-sm-1"></div>
                                            <div class="form-group col-md-3">
                                                <input type="text" class="form-control" name="name" id="service-name" placeholder="Enter Name of the Service here" value="${service.getName()}" onkeyup="validateService(this.value, this.name, this.id)">
                                            </div>
                                            <div class="form-group col-sm-1">
                                                <div id="validation-service-name" style="text-align:justify"></div>
                                            </div>
                                        </div>  
                                        <br>  
                                        <div class="form-row align-items-center justify-content-center">
                                            <label for="hours">Hours required</label> 
                                        </div>   
                                        <div class="form-row align-items-center justify-content-center">
                                            <div class="form-group col-sm-1"></div>
                                            <div class="form-group col-md-3">
                                                <input type="text" class="form-control" name="hours" id="service-hours" placeholder="Enter required number of Hours here" value="${service.getHours()}" onkeyup="validateService(this.value, this.name, this.id)">
                                            </div>
                                            <div class="form-group col-sm-1">
                                                <div id="validation-service-hours" style="text-align:justify"></div>
                                            </div>
                                        </div> 
                                        <br/>
                                        <div class="form-row align-items-center justify-content-center">
                                            <label for="hours">Service Price in Euros (€)</label> 
                                        </div>   
                                        <div class="form-row align-items-center justify-content-center">
                                            <div class="form-group col-sm-1"></div>
                                            <div class="form-group col-md-3">
                                                <input type="text" class="form-control" name="price" id="service-price" placeholder="Enter Price of the Service here" value="${service.getPrice()}" onkeyup="validateService(this.value, this.name, this.id)">
                                            </div>
                                            <div class="form-group col-sm-1">
                                                <div id="validation-service-price" style="text-align:justify"></div>
                                            </div>
                                        </div>                                      
                                        <br> 
                                        <h3 id="poruka" class="poruka">${message}</h3>
                                        <br>   
                                        <br>  
                                        <input type="submit" id="submit_update_service" class="primary-btn text-uppercase" value="Update Service" disabled/>     
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
