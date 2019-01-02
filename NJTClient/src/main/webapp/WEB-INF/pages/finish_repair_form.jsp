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
                    <h2 class="poruka">FINISH</h2>
                    <br/>
                    <br/>
                    <form class="save_car" action="/NJTClient/controller" method="POST">
                        <input type="hidden" name="action" value="finish_repair" />  
                        <div class="form-row align-items-center justify-content-center">
                            <div class="form-group col-md-3">
                                <label for="repairs">Select Repair you wish to Finish</label> 
                                <select class="form-control sacuvaj" name="repairs" id="repairs" onchange="this.form.submit()"> 
                                    <option selected>Select a repair</option>
                                    <c:forEach var="repair" items="${active_repairs}">
                                        <option value="${repair.getId()}">${repair}</option>                                        
                                    </c:forEach>
                                </select>
                            </div>
                        </div> 
                    </form>
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
                    <h3 class="white">Car Information</h3>   
                    <br/>
                    <div class="form-row align-items-center justify-content-center save_car">
                        <div class="form-group col-md-3">
                            <label for="amount">Registration</label>
                            <input type="text" class="form-control" name="registration" id="registration" placeholder="Select a repair" value="${repair.getCar().getRegistration()}" readonly>
                        </div>
                        <div class="form-group col-md-3">
                            <label for="amount">Current Kilometers</label>
                            <input type="text" class="form-control" name="kilometers" id="kilometers" placeholder="Select a repair" value="${repair.getKilometers()}" readonly>
                        </div>
                    </div>
                    <br/>
                    <br/>
                    <form class="save_car" action="/NJTClient/controller" method="POST">    
                        <input type="hidden" name="action" value="deactivate_repair" />                  
                        <input type="hidden" name="repair_id" value="${repair.getId()}" />                  
                        <input type="submit" class="primary-btn text-uppercase" value="Finish Repair"/>     
                        <br/>
                        <br/>
                        <br/>
                        <br/>
                        <br/>
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
