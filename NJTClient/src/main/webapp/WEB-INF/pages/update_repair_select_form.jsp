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
                        <input type="hidden" name="action" value="update_repair_select" />       
                        <div class="form-row align-items-center justify-content-center">
                            <div class="form-group col-md-3">
                                <label for="repairs">Select Repair you wish to Update</label> 
                                <select class="form-control sacuvaj" name="repairs" id="repairs"> 
                                    <option selected>Select a repair</option>
                                    <c:forEach var="repair" items="${active_repairs}">
                                        <option value="${repair.getId()}">${repair}</option>                                        
                                    </c:forEach>
                                </select>
                            </div>
                        </div> 
                        <br/>
                        <br/>
                        <br/>
                        <input type="submit" class="primary-btn text-uppercase" value="Update Repair"/>     
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
