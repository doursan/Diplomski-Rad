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
                        <input type="hidden" name="action" value="sell_car" />       
                        <div class="form-row align-items-center justify-content-center">
                            <div class="form-group col-md-3">
                                <label for="cars">Select a car you wish to Sell</label> 
                                <select class="form-control sacuvaj" name="cars" id="cars"> 
                                    <option selected>Select a car</option>
                                    <c:forEach var="car" items="${user_cars}">
                                        <option value="${car.getId()}">${car.getRegistration()}</option>                                        
                                    </c:forEach>
                                </select>
                            </div>
                        </div>   
                        <br>  
                        <div class="form-row align-items-center justify-content-center">
                            <div class="form-group col-md-3">
                                <label for="buyer">Buyer Username</label>
                                <input type="text" class="form-control" name="buyer" id="buyer" placeholder="Enter Buyer's Username here">
                            </div>
                        </div>
                        <br> 
                        <br>   
                        <br>  
                        <input type="submit" class="primary-btn text-uppercase" value="Sell Car"/>     
                    </form>                      
                </div>
            </div>
        </div>
        <br>
        <br>        
    </body>
</html>
