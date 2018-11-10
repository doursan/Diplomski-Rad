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
            function populateHoursAndPrice(serviceId) {
            <c:forEach var="service" items="${services}">
                var id = <c:out value="${service.getId()}"/>;
                if (id == serviceId) {
                    if ("${service.getPrice()}" != "0.0") {
                        document.getElementById("price").value = "${service.getPrice()}".concat(" €");
                    } else {
                        document.getElementById("price").value = "Price not available!";                        
                    }
                    if ("${service.getHours()}" != "0.0") {
                        document.getElementById("hours").value = "${service.getHours()}";
                    } else {
                        document.getElementById("hours").value = "Hours not available!";                        
                    }
                }
            </c:forEach>
            }
        </script>
    </head>
    <body>
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
                        <input type="hidden" name="action" value="remove_service" />       
                        <div class="form-row align-items-center justify-content-center">
                            <div class="form-group col-md-3">
                                <label for="services">Select a Service you wish to Delete</label> 
                                <select class="form-control sacuvaj" name="services" id="services" onchange="populateHoursAndPrice(this.value)"> 
                                    <option selected>Select a service</option>
                                    <c:forEach var="service" items="${services}">
                                        <option value="${service.getId()}">${service.getName()}</option>                                        
                                    </c:forEach>
                                </select>
                            </div>
                        </div>   
                        <br>  
                        <div class="form-row align-items-center justify-content-center">
                            <div class="form-group col-md-3">
                                <label for="hours">Hours Required</label>
                                <input type="text" class="form-control" name="hours" id="hours" placeholder="Hours Required" readonly>
                            </div>
                        </div>
                        <div class="form-row align-items-center justify-content-center">
                            <div class="form-group col-md-3">
                                <label for="price">Service Price</label>
                                <input type="text" class="form-control" name="price" id="price" placeholder="Service Price" readonly>
                            </div>
                        </div>
                        <br> 
                        <br>   
                        <br>  
                        <input type="submit" class="primary-btn text-uppercase" value="Delete Service"/>     
                    </form> 
                    <br/>
                    <h1 class="poruka">${message}</h1>
                </div>
            </div>
        </div>
        <br>
        <br>        
    </body>
</html>
