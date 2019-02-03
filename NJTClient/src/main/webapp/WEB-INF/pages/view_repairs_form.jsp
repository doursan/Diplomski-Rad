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
                    <h2 class="poruka">Finished Repairs</h2>
                    <br/>                   
                    <br/>
                    <br/>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Date</th>
                                <th scope="col">Kilometers</th>
                                <th scope="col">Price</th>
                                <th scope="col">Car Registration</th>
                                <th scope="col">Shop</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="repair" items="${repairs}" varStatus="loop">
                                <tr>
                                    <td>${repair.getDatum()}</td>
                                    <td>${repair.getKilometers()}</td>
                                    <td>${repair.getPrice()}</td>
                                    <td>${repair.getCar().getRegistration()}</td>
                                    <td>${repair.getShop().getUsername()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <br/>
                    <br/>  
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <h1 class="poruka">${message}</h1>
                </div>
            </div>
        </div>
        <br>
        <br>        
    </body>
</html>
