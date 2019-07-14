<%-- 
    Document   : sell_car
    Created on : Sep 23, 2018, 2:17:12 PM
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
                var table = $('#sellCar').DataTable({
                    "columns": [
                        {"width": "0.6%"},
                        {"width": "14.2%"},
                        {"width": "14.2%"},
                        {"width": "14.2%"},
                        {"width": "14.2%"},
                        {"width": "14.2%"},
                        {"width": "14.2%"},
                        {"width": "14.2%"}
                    ]
                });

                if ('${invalid}') {
                    var tabela = document.getElementById("sellCar");
                    validateBuyer('${buyer}');
                    $("#submit_sell_car").prop('disabled', false);
                    tabela.rows['${index}'].style.backgroundColor = "#ff0000";
                    tabela.rows['${index}'].style.color = "#ffffff";
                    tabela.rows['${index}'].style.opacity = "0.34";
                    document.getElementById("rowIndex").value = '${index}';

                    location.href = "#";
                    location.href = "#buyer";
                }


                var drops = document.getElementsByName("sellCar_length");
                var drop = drops[0];
                drop.classList.remove("custom-select");

                table.on('click', 'tbody tr', function () {
                    var tabela = document.getElementById("sellCar");
                    var index = document.getElementById("rowIndex").value;
                    if (index) {
                        tabela.rows[index].style.backgroundColor = "black";
                    }
                    $("#submit_sell_car").prop('disabled', false);
                    $(this).css('background', '#ff0000');
                    $(this).css('color', '#ffffff');
                    $(this).css('opacity', '0.34');
                    document.getElementById("rowIndex").value = this.rowIndex;
                    document.getElementById("sell_car_id").value = tabela.rows[this.rowIndex].cells[0].innerHTML;
                    location.href = "#";
                    location.href = "#buyer";
                });
            });

            function finish(value) {
                document.getElementById("buyer").value = value;
                $('#suggestions').html("");
            }

            function validateBuyer(value) {
                $.post("/NJTClient/controller", {value: value, attribute: 'buyer', action: 'ajax_validate_user'}, function (validate) {
                    console.log(validate);
                    $('#validation-buyer').html(validate);
                });
            }

            function suggestBuyers(buy) {
                validateBuyer(buy);
                $.post("/NJTClient/controller", {buyer: buy, action: 'ajax_buy_autocomplete'}, function (data) {
                    $('#suggestions').html(data);
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
                            <br>  
                            <label>Select a Car you wish to Sell</label> 
                            <br>
                            <br>  
                            <table id="sellCar" class="table dataTabele table-striped" cellspacing="0" width="100%">
                                <thead>
                                    <tr>
                                        <th class="th-sm" style="display:none;">Id
                                        </th>
                                        <th class="th-sm">Vin
                                        </th>
                                        <th class="th-sm">Registration
                                        </th>   
                                        <th class="th-sm">Production Year
                                        </th>
                                        <th class="th-sm">Color
                                        </th>  
                                        <th class="th-sm">Brand
                                        </th>
                                        <th class="th-sm">Model
                                        </th>  
                                        <th class="th-sm">Engine
                                        </th>  
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="car" items="${user_cars}" varStatus="loop">
                                    <tr>
                                        <td style="display:none;">${car.getId()}</td>
                                        <td>${car.getVin()}</td>
                                        <td>${car.getRegistration()}</td>
                                        <td>${car.getProductionYear()}</td>
                                        <td>${car.getColor()}</td>
                                        <td>${car.getModelEngine().getModel().getCarBrand().getName()}</td>
                                        <td>${car.getModelEngine().getModel().getName()}</td>
                                        <td>${car.getModelEngine().getEngine().getName()}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <th class="th-sm" style="display:none;">Id
                                    </th>
                                    <th class="th-sm">Vin
                                    </th>
                                    <th class="th-sm">Registration
                                    </th>   
                                    <th class="th-sm">Production Year
                                    </th>
                                    <th class="th-sm">Color
                                    </th>  
                                    <th class="th-sm">Brand
                                    </th>
                                    <th class="th-sm">Model
                                    </th>  
                                    <th class="th-sm">Engine
                                    </th>  
                                </tr>
                            </tfoot>
                        </table>
                        <div class="container">
                            <div class="row">
                                <div class="col-md-12">
                                    <form class="save_car" action="/NJTClient/controller" method="POST">
                                        <input type="hidden" name="action" value="sell_car" />       
                                        <input type="hidden" name="car_id" id="sell_car_id" value="" />  
                                        <input type="hidden" name="rowIndex" id="rowIndex" value="" />   
                                        <br>  
                                        <div class="form-row align-items-center justify-content-center">
                                            <div class="form-group col-md-0">
                                                <div style="text-align:justify; width:25px;"></div>
                                            </div>
                                            <div class="form-group col-md-3">
                                                <label for="buyer">Buyer Username</label>
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
                                                <input type="text" class="form-control" name="buyer" id="buyer" placeholder="Enter Buyer's Username here" value="${buyer}" onkeyup="suggestBuyers(this.value)">
                                            </div>
                                            <div class="form-group col-md-0">
                                                <div id="validation-buyer" style="text-align:justify; width:25px;"></div>
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
                                        </div>
                                        <br> 
                                        <h4 class="poruka">${message}</h4>
                                        <br>   
                                        <br>  
                                        <input type="submit" id="submit_sell_car" class="primary-btn text-uppercase" value="Sell Car" disabled />     
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