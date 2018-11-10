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
            function populatePrice(partId) {
            <c:forEach var="part" items="${car_parts}">
                var id = <c:out value="${part.getId()}"/>;
                if (id == partId) {
                    if ("${part.getPrice()}") {
                        document.getElementById("price").value = "${part.getPrice()}".concat(" €");
                    } else {
                        document.getElementById("price").value = "There is No Price for this Part!";                        
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
                        <input type="hidden" name="action" value="remove_part" />       
                        <div class="form-row align-items-center justify-content-center">
                            <div class="form-group col-md-3">
                                <label for="parts">Select a Part you wish to Delete</label> 
                                <select class="form-control sacuvaj" name="parts" id="parts" onchange="populatePrice(this.value)"> 
                                    <option selected>Select a car part</option>
                                    <c:forEach var="part" items="${car_parts}">
                                        <option value="${part.getId()}">${part.getName()}</option>                                        
                                    </c:forEach>
                                </select>
                            </div>
                        </div>   
                        <br>  
                        <div class="form-row align-items-center justify-content-center">
                            <div class="form-group col-md-3">
                                <label for="price">Part Price</label>
                                <input type="text" class="form-control" name="price" id="price" placeholder="Part Price" readonly>
                            </div>
                        </div>
                        <br> 
                        <br>   
                        <br>  
                        <input type="submit" class="primary-btn text-uppercase" value="Delete Car Part"/>     
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
