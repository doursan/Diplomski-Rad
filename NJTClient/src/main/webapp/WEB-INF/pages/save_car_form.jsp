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
        <script type="text/javascript">
            function populateModels(brandId) {
                var select = document.getElementById("car_models");
                select.options.length = 1;
            <c:forEach var="brand" items="${car_brands}">
                var id = <c:out value="${brand.getId()}"/>;
                if (id == brandId) {
                <c:forEach var="model" items="${brand.getCarBrandModelList()}">
                    select.options[select.options.length] = new Option("${model.getName()}", "${model.getId()}");
                </c:forEach>
                }
            </c:forEach>
            }
            function populateEngines(modelId) {
                var brandSelect = document.getElementById("car_brands");
                var brandId = brandSelect.options[brandSelect.selectedIndex].value;
                var select = document.getElementById("engines");
                select.options.length = 1;
                <c:forEach var="brand" items="${car_brands}">
                    var bId = <c:out value="${brand.getId()}"/>;
                    if (bId == brandId) {
                        <c:forEach var="model" items="${brand.getCarBrandModelList()}">
                            var id = <c:out value="${model.getId()}"/>;
                            if (id == modelId) {
                                <c:forEach var="modelEngine" items="${model.getModelEngineList()}">
                                    select.options[select.options.length] = new Option("${modelEngine.getEngine().getName()}", "${modelEngine.getId()}");
                                </c:forEach>
                            }
                        </c:forEach>
                    }
            </c:forEach>
            }
        </script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <form class="save_car" action="/NJTClient/controller" method="POST">
                        <input type="hidden" name="action" value="save_car" />
                        <input type="hidden" name="model_engine" value="" />
                        <div class="form-row align-items-center justify-content-center">
                            <div class="form-group col-md-5">
                                <label for="vin">VIN</label>
                                <input type="text" class="form-control" name="vin" id="vin" placeholder="Vehicle Identification Number">
                            </div>
                        </div>
                        <div class="form-row align-items-center justify-content-center">
                            <div class="form-group col-md-5">
                                <label for="registration">Registration</label>
                                <input type="text" class="form-control" name="registration" id="registration"  placeholder="Registration Number">
                            </div>
                        </div>
                        <div class="form-row align-items-center justify-content-center">
                            <div class="form-group col-md-2">
                                <label for="car_brands">Car Brand</label> 
                                <select class="form-control sacuvaj" name="car_brands" id="car_brands" onchange="populateModels(this.value)"> 
                                    <option selected>Select brand</option>
                                    <c:forEach var="brandOption" items="${car_brands}">
                                        <option value="${brandOption.getId()}">${brandOption.getName()}</option>                                        
                                    </c:forEach>
                                </select>
                            </div>
                        </div>    
                        <div class="form-row align-items-center justify-content-center">
                            <div class="form-group col-md-2">
                                <label for="production_year">Car Model</label> 
                                <select class="form-control sacuvaj" name="car_models" id="car_models" onchange="populateEngines(this.value)"> 
                                    <option selected>Select model</option>
                                </select>
                            </div>
                        </div>  
                        <div class="form-row align-items-center justify-content-center">
                            <div class="form-group col-md-2">
                                <label for="engines">Engine</label> 
                                <select class="form-control sacuvaj" name="engines" id="engines"> 
                                    <option selected>Select engine</option>                                    
                                </select>
                            </div>
                        </div>
                        <div class="form-row align-items-center justify-content-center">
                            <div class="form-group col-md-2">
                                <label for="production_year">Production Year</label> 
                                <select class="form-control sacuvaj" name="production_year" id="production_year" >                                   
                                    <% for (int i = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR); i >= 1900; i--) {%>
                                    <option><%=i%></option>
                                    <% }%>
                                </select>
                            </div>
                        </div>
                        <br>
                        <input type="submit" class="primary-btn text-uppercase" value="Save Car"/>     
                    </form>                      
                </div>
            </div>
        </div>
        <br>
        <br>
        <br>        
    </body>
</html>
