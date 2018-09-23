<%-- 
    Document   : update_car_form
    Created on : Sep 19, 2018, 12:22:20 AM
    Author     : Dusan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
            function populateFields(carId) {
                <c:forEach var="car" items="${user_cars}">
                        var id = <c:out value="${car.getId()}"/>;
                    if (id == carId) {
                        document.getElementById("registration").value = "<c:out value="${car.getRegistration()}"/>";
                        document.getElementById("color").value = "<c:out value="${car.getColor()}"/>";
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
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <form class="save_car" action="/NJTClient/controller" method="POST">
                        <input type="hidden" name="action" value="update_car" />       
                        <div class="form-row align-items-center justify-content-center">
                            <div class="form-group col-md-3">
                                <label for="cars">Select a car you wish to update</label> 
                                <select class="form-control sacuvaj" name="cars" id="cars" onchange="populateFields(this.value)"> 
                                    <option selected>Select a car</option>
                                    <c:forEach var="car" items="${user_cars}">
                                        <option value="${car.getId()}">${car.getRegistration()}</option>                                        
                                    </c:forEach>
                                </select>
                            </div>
                        </div>    
                        <div class="form-row align-items-center justify-content-center">
                            <div class="form-group col-md-3">
                                <label for="registration">Update Registration</label>
                                <input type="text" class="form-control" name="registration" id="registration" placeholder="Registration Number">
                            </div>
                        </div>
                        <div class="form-row align-items-center justify-content-center">
                            <div class="form-group col-md-3">
                                <label for="color">Update Color</label>
                                <input type="text" class="form-control" name="color" id="color"  placeholder="Color">
                            </div>
                        </div>
                        <br>
                        <input type="submit" class="primary-btn text-uppercase" value="Update Car"/>     
                    </form>                      
                </div>
            </div>
        </div>
        <br>
        <br>
        <br>        
    </body>
</html>
