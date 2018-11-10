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
                        <input type="hidden" name="action" value="save_part" />       
                        <div class="form-row align-items-center justify-content-center">
                            <div class="form-group col-md-3">
                                <label for="cars">Part Name</label> 
                                <input type="text" class="form-control" name="name" id="name" placeholder="Enter Name of the Part here">
                            </div>
                        </div>   
                        <br>  
                        <div class="form-row align-items-center justify-content-center">
                            <div class="form-group col-md-3">
                                <label for="buyer">Part Price in Euros</label>
                                <input type="text" class="form-control" name="price" id="price" placeholder="Enter Price of the Part here">
                            </div>
                        </div>
                        <br> 
                        <br>   
                        <br>  
                        <input type="submit" class="primary-btn text-uppercase" value="Save Car Part"/>     
                    </form>                      
                </div>
            </div>
        </div>
        <br>
        <br>        
    </body>
</html>
