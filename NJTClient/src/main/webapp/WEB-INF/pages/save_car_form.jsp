<%-- 
    Document   : save_car_form
    Created on : Sep 8, 2018, 7:01:35 PM
    Author     : Dusan
--%>

<%@page import="com.wdyc.njtws.services.CarBrandDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <form class="save_car">
                        <div class="form-row align-items-center justify-content-center">
                            <div class="form-group col-md-5">
                                <label for="vin">VIN</label>
                                <input type="text" class="form-control" id="vin" placeholder="Vehicle Identification Number">
                            </div>
                        </div>
                        <div class="form-row align-items-center justify-content-center">
                            <div class="form-group col-md-5">
                                <label for="registration">Registration</label>
                                <input type="text" class="form-control" id="registration"  placeholder="Registration Number">
                            </div>
                        </div>
                        <div class="form-row align-items-center justify-content-center">
                            <div class="form-group col-md-2">
                                <label for="production_year">Production Year</label> 
                                <select class="form-control sacuvaj" id="production_year" >                                   
                                    <% for (int i = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR); i >= 1900; i--) {%>
                                    <option><%=i%></option>
                                    <% }%>
                                </select>
                            </div>
                        </div>  
                        <div class="form-row align-items-center justify-content-center">
                            <div class="form-group col-md-2">
                                <label for="car_brands">Car Brand</label> 
                                <select class="form-control sacuvaj" id="car_brands"> 
                                    <option selected disabled>Select a brand</option>
                                    <c:forEach var="brand" items="${car_brands}">
                                        <option value="${brand}" onclick="<% CarBrandDTO choice = (CarBrandDTO) request.getAttribute("brand"); %>">${brand.getName()}</option>                                        
                                    </c:forEach>
                                </select>
                            </div>
                        </div>    
                        <div class="form-row align-items-center justify-content-center">
                            <div class="form-group col-md-2">
                                <label for="production_year">Production Year</label> 
                                <select class="form-control sacuvaj" id="production_year" >    
                                    <c:forEach var="model" items="${choice.getCarBrandModelList()}">
                                        <option>${model.getName()}</option>                                        
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Sign in</button>
                    </form>                      
                </div>
            </div>
        </div>
        <br>
        <br>
        <br>
    </body>
</html>
