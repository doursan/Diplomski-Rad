<%-- 
    Document   : sell_car_form
    Created on : Sep 23, 2018, 2:20:37 PM
    Author     : Dusan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">

            $(document).ready(function () {
                $('#updateRepair').on('page.dt', function () {
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
                var drops = document.getElementsByName("updateRepair_length");
                var drop = drops[0];
                drop.classList.remove("custom-select");
                
                if ('${invalid_item}') {
                    if ('${type}' === 'service') {
                        validateRepair('${item.getAmount()}', 'amount', 'service-amount');

                        var service_id = '${service_id}';
                        for (var i = 0; i < document.getElementById("services").length; i++) {
                            if (document.getElementById("services").options[i].value === service_id) {
                                document.getElementById("services").selectedIndex = i;
                            }
                        }

                        location.href = "#";
                        location.href = "#service-title";
                    } else {
                        validateRepair('${item.getAmount()}', 'amount', 'part-amount');
                        validateRepair('${item.getPricePerUnit()}', 'part_price', 'part_price');

                        var part_id = '${part_id}';
                        for (var i = 0; i < document.getElementById("services").length; i++) {
                            if (document.getElementById("parts").options[i].value === part_id) {
                                document.getElementById("parts").selectedIndex = i;
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

            function validateRepair(value, attribute, id) {
                var div = '#validation-' + id;
                $.post("/NJTClient/controller", {value: value, attribute: attribute, action: 'ajax_validate_repair'}, function (data) {
                    $(div).html(data);
                });
            }
        </script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h2 class="poruka">${message}</h2>
                    <h2 class="poruka">UPDATE REPAIR</h2>
                    <br/>
                    <form class="save_car" action="/NJTClient/controller" method="POST">
                        <input type="hidden" name="action" value="add_repair_item" />   
                        <input type="hidden" name="type"  value="service" />        
                        <input type="hidden" name="from"  value="update_repair" />        
                        <input type="hidden" name="service_name" id="service_name" value="${service_name}" />  
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
                        <input type="hidden" name="from"  value="update_repair" />           
                        <input type="hidden" name="part_name" id="part_name" value="${part_name}" />   
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
                        <input type="submit" id="test_test" class="btn btn-warning btn-sm text-uppercase" value="Add Car Part"/> 
                    </form>                        
                    <br/>
                    <h4 class="poruka">${message_part}</h4>
                    <br/>
                    <br/>
                    <br/>
                    <form class="save_car" action="/NJTClient/controller" method="POST">
                        <table id="updateRepair" class="table dataTabele table-striped" cellspacing="0" width="100%">
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
                                        <td><a href=" 
                                               <c:url value="/controller">
                                                   <c:param name="action" value="remove_item"></c:param>
                                                   <c:param name="from" value="update_repair"></c:param>
                                                   <c:param name="rowNumber" value="${item.getRowNumber()}"></c:param>
                                               </c:url> ">&#10008</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </form>
                    <hr/>
                    <h4 class="poruka">Total: ${repair.getPrice()}</h4>
                    <br/>
                    <br/>
                    <br/>
                    <form class="save_car" action="/NJTClient/controller" method="POST">
                        <input type="hidden" name="action" value="update_repair" />  
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
                                <input type="text" class="form-control" name="registration" id="registration" placeholder="${repair.getCar().getRegistration()}" readonly>
                            </div>
                            <div class="form-group col-md-0">
                                <div style="text-align:justify; width:25px;"></div>
                            </div>
                            <div class="form-group col-md-3">
                                <input type="text" class="form-control" name="kilometers" id="repair-kilometers" value="${repair.getKilometers()}" onkeyup="validateRepair(this.value, this.name, this.id)">
                            </div>
                            <div class="form-group col-md-0">
                                <div id="validation-repair-kilometers" style="text-align:justify; width:25px;"></div>
                            </div>
                        </div>                        
                        <br/>
                        <h3 class="poruka">${message_repair}</h3>
                        <br/>
                        <br/>
                        <input type="submit" class="primary-btn text-uppercase" value="Update Repair"/>     
                    </form> 
                </div>
            </div>
        </div>  
    </body>
</html>
