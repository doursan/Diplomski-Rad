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
            $(document).ready(function () {
                var table = $('#changeRepair').DataTable({
                    "columns": [
                        {"width": "0%"},
                        {"width": "20%"},
                        {"width": "20%"},
                        {"width": "20%"},
                        {"width": "20%"},
                        {"width": "20%"}
                    ]
                });

                var drops = document.getElementsByName("changeRepair_length");
                var drop = drops[0];
                drop.classList.remove("custom-select");

                table.on('click', 'tbody tr', function () {
                    var tabela = document.getElementById("changeRepair");
                    var index = document.getElementById("rowIndex").value;
                    if (index) {
                        tabela.rows[index].style.backgroundColor = "black";
                    }
                    $("#submit_update_repair").prop('disabled', false);
                    $(this).css('background', '#ff0000');
                    $(this).css('color', '#ffffff');
                    $(this).css('opacity', '0.34');
                    document.getElementById("rowIndex").value = this.rowIndex;
                    document.getElementById("update_repair_id").value = tabela.rows[this.rowIndex].cells[0].innerHTML;
                    location.href = "#";
                    location.href = "#submit_update_repair";
                });
            });
        </script>
    </head>
    <body>
        <label>Select a Repair you wish to Update</label> 
        <br>
        <br>  
        <table id="changeRepair" class="table dataTabele table-striped" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <th class="th-sm" style="display:none;">Id
                    </th>
                    <th class="th-sm">Registration
                    </th>
                    <th class="th-sm">Service
                    </th>
                    <th class="th-sm">Kilometers
                    </th>
                    <th class="th-sm">Owner
                    </th>
                    <th class="th-sm">Price
                    </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="repair" items="${repairs}" varStatus="loop">
                    <tr>
                        <td style="display:none;">${repair.getId()}</td>
                        <td>${repair.getCar().getRegistration()}</td>
                        <td>${repair.getService().getName()}</td>
                        <td>${repair.getKilometers()}</td>
                        <td>${repair.getCar().getOwner().getUsername()}</td>
                        <td>${repair.getPrice()}</td>
                    </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <th class="th-sm" style="display:none;">Id
                    </th>
                    <th class="th-sm">Registration
                    </th>
                    <th class="th-sm">Service
                    </th>
                    <th class="th-sm">Kilometers
                    </th>
                    <th class="th-sm">Owner
                    </th>
                    <th class="th-sm">Price
                    </th>
                </tr>
            </tfoot>
        </table>  
        <br>
        <br>     
        <br> 
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <form class="save_car" action="/NJTClient/controller" method="POST">
                        <input type="hidden" name="action" value="update_repair_select" />  
                        <input type="hidden" name="repair_id" id="update_repair_id" value="" />  
                        <input type="hidden" name="rowIndex" id="rowIndex" value="" />   
                        <br/>
                        <br/>
                        <input type="submit" id="submit_update_repair" class="primary-btn text-uppercase" value="Update Repair" disabled/> 
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
