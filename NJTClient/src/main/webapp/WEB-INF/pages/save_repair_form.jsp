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
            function populatePriceAndName(serviceId) {
            <c:forEach var="service" items="${services}">
                var id = <c:out value="${service.getId()}"/>;
                if (id == serviceId) {
                    document.getElementById("service_name").value = "${service.getName()}";
                    if ("${service.getPrice()}" != "0.0") {
                        document.getElementById("price").value = "${service.getPrice()}";
                    } else {
                        document.getElementById("price").value = "Price not available!";
                    }
                }
            </c:forEach>
            }
            function populateName(carPartId) {
            <c:forEach var="carPart" items="${car_parts}">
                var id = <c:out value="${carPart.getId()}"/>;
                if (id == carPartId) {
                    document.getElementById("part_name").value = "${carPart.getName()}";
                }
            </c:forEach>
            }
        </script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h2 class="poruka">${message}</h2>
                    <br/>
                    <form class="save_car" action="/NJTClient/controller" method="POST">
                        <input type="hidden" name="action" value="add_repair_item" />   
                        <input type="hidden" name="type"  value="service" />        
                        <input type="hidden" name="service_name" id="service_name" value="" />  
                        <h3 class="white">Select a Service you wish to Add</h3>   
                        <br/>
                        <div class="form-row align-items-center justify-content-center">
                            <div class="form-group col-md-3">
                                <label for="services"> Service</label> 
                                <select class="form-control sacuvaj" name="services" id="services" onchange="populatePriceAndName(this.value)"> 
                                    <option selected>Select a Service</option>
                                    <c:forEach var="service" items="${services}">
                                        <option value="${service.getId()}">${service.getName()}</option>                                        
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group col-md-3">
                                <label for="amount">Amount</label>
                                <input type="text" class="form-control" name="amount" id="amount" placeholder="Amount">
                            </div>
                            <div class="form-group col-md-3">
                                <label for="amount">Price per unit</label>
                                <input type="text" class="form-control" name="price" id="price" placeholder="Price" readonly>
                            </div>
                            <br/>
                        </div>
                        <input type="submit" class="btn btn-warning btn-sm text-uppercase" value="Add Service"/> 
                    </form>
                    <br/>
                    <form class="save_car" action="/NJTClient/controller" method="POST">
                        <br/>
                        <h3 class="white">Select a Car Part you wish to Add</h3>   
                        <br/>
                        <input type="hidden" name="action" value="add_repair_item" />        
                        <input type="hidden" name="type" value="carPart" />               
                        <input type="hidden" name="part_name" id="part_name" value="" />    
                        <div class="form-row align-items-center justify-content-center">
                            <div class="form-group col-md-3">
                                <label for="services">Car Part</label> 
                                <select class="form-control sacuvaj" name="parts" id="parts" onchange="populateName(this.value)"> 
                                    <option selected>Select a car part</option>
                                    <c:forEach var="part" items="${car_parts}">
                                        <option value="${part.getId()}">${part.getName()}</option>                                        
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group col-md-3">
                                <label for="amount">Amount</label>
                                <input type="text" class="form-control" name="amount" id="amount" placeholder="Amount">
                            </div>
                            <div class="form-group col-md-3">
                                <label for="amount">Price per unit (Optional)</label>
                                <input type="text" class="form-control" name="price" id="price" placeholder="Price">
                            </div>
                        </div>
                        <input type="submit" class="btn btn-warning btn-sm text-uppercase" value="Add Car Part"/> 
                    </form>                        
                    <br/>
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
                    <form class="save_car" action="/NJTClient/controller" method="POST">
                        <input type="hidden" name="action" value="save_repair" />  
                        <h3 class="white">Car Information</h3>   
                        <br/>
                        <div class="form-row align-items-center justify-content-center">
                            <div class="form-group col-md-3">
                                <label for="amount">Registration</label>
                                <input type="text" class="form-control" name="registration" id="registration" placeholder="Registration">
                            </div>
                            <div class="form-group col-md-3">
                                <label for="amount">Current Kilometers</label>
                                <input type="text" class="form-control" name="kilometers" id="kilometers" placeholder="Kilometers">
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <br/>
                        <input type="submit" class="primary-btn text-uppercase" value="Create Repair"/>     
                    </form> 
                </div>
            </div>
        </div>  
    </body>
</html>
