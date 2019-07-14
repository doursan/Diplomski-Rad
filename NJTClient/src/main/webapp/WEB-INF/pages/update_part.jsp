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
                var table = $('#changeCarPart').DataTable({
                    "columns": [
                        {"width": "0%"},
                        {"width": "50%"},
                        {"width": "50%"}
                    ]
                });
                
                if ('${invalid}') {
                    var tabela = document.getElementById("changeCarPart");
                    validatePart('${car_part.getName()}', "name", "part-name");
                    validatePart('${car_part.getPrice()}', "price", "part-price");
                    $("#submit_update_part").prop('disabled', false);
                    tabela.rows['${index}'].style.backgroundColor = "#ff0000";
                    tabela.rows['${index}'].style.color = "#ffffff";
                    tabela.rows['${index}'].style.opacity = "0.34";
                    document.getElementById("rowIndex").value = '${index}';
                    
                    location.href = "#";
                    location.href = "#part-name";
                }
                
                var drops = document.getElementsByName("changeCarPart_length");
                var drop = drops[0];
                drop.classList.remove("custom-select");

                table.on('click', 'tbody tr', function () {
                    
                    var tabela = document.getElementById("changeCarPart");
                    var index = document.getElementById("rowIndex").value;
                    var name = tabela.rows[this.rowIndex].cells[1].innerHTML;
                    var price = tabela.rows[this.rowIndex].cells[2].innerHTML;
                    
                    validatePart(name, "name", "part-name");
                    validatePart(price, "price", "part-price");
                    
                    if (index) {
                        tabela.rows[index].style.backgroundColor = "black";
                    }
                    $("#submit_update_part").prop('disabled', false);
                    $(this).css('background', '#ff0000');
                    $(this).css('color', '#ffffff');
                    $(this).css('opacity', '0.34');
                    document.getElementById("rowIndex").value = this.rowIndex;
                    document.getElementById("update_part_id").value = tabela.rows[this.rowIndex].cells[0].innerHTML;
                    document.getElementById("part-name").value = name;
                    document.getElementById("part-price").value = price;
                    location.href = "#";
                    location.href = "#part-name";
                });
            });

            function validatePart(value, attribute, id) {
                var div = '#validation-' + id;
                $.post("/NJTClient/controller", {value: value, attribute: attribute, action: 'ajax_validate_part', perform: 'update'}, function (data) {
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
                            <label>Select a Part you wish to Update</label> 
                            <br>
                            <br>  
                            <table id="changeCarPart" class="table dataTabele table-striped" cellspacing="0" width="100%">
                                <thead>
                                    <tr>
                                        <th class="th-sm" style="display:none;">Id
                                        </th>
                                        <th class="th-sm">Name
                                        </th>
                                        <th class="th-sm">Price
                                        </th>   
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="car_part" items="${car_parts}" varStatus="loop">
                                    <tr>
                                        <td style="display:none;">${car_part.getId()}</td>
                                        <td>${car_part.getName()}</td>
                                        <td>${car_part.getPrice()}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <th class="th-sm" style="display:none;">Id
                                    </th>
                                    <th class="th-sm">Name
                                    </th>
                                    <th class="th-sm">Price
                                    </th>   
                                </tr>
                            </tfoot>
                        </table>
                        <div class="container">
                            <div class="row">
                                <div class="col-md-12">
                                    <form class="save_car" action="/NJTClient/controller" method="POST">
                                        <input type="hidden" name="action" value="update_part" />   
                                        <input type="hidden" name="part_id" id="update_part_id" value="${car_part.getId()}" />  
                                        <input type="hidden" name="rowIndex" id="rowIndex" value="" />  
                                        <br>  
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
                                        <input type="submit" id="submit_update_part" class="primary-btn text-uppercase" value="Update Car Part" disabled/>     
                                    </form> 
                                    <br/>
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
