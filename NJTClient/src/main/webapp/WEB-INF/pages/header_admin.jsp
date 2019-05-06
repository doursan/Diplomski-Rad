<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : template
    Created on : Sep 3, 2018, 11:53:57 PM
    Author     : Dusan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">    
    <body>
        <header id="header" id="home">
            <div class="container header-top">
                <div class="row">
                    <div class="col-6 top-head-left"> 			
                    </div>
                    <div class="col-6 top-head-right">
                        <ul>
                            <li><a href="#">Hello, ${logged_user.getUsername()}</a></li>
                        </ul>
                    </div>			  			
                </div>
            </div>
            <div class="container">
                <div class="row align-items-center justify-content-between d-flex">
                    <div id="logo">
                        <a href="index.html"><img src="img/logo.png" alt="" title="" /></a>
                    </div>
                    <nav id="nav-menu-container">
                        <ul class="nav-menu">
                            <li class="menu-active">
                                <a href="
                                   <c:url value="/controller">
                                       <c:param name="action" value="index_admin"></c:param>
                                   </c:url>">Home</a></li>
                            <li class="menu-has-children"><a href="#">CAR PARTS</a>
                                <ul>
                                    <li><a href=" 
                                           <c:url value="/controller">
                                               <c:param name="action" value="add_part"></c:param>
                                           </c:url> ">Add a Car Part</a></li>
                                    <li><a href=" 
                                           <c:url value="/controller">
                                               <c:param name="action" value="change_part"></c:param>
                                           </c:url> ">Change a Car Part</a></li>
                                    <li><a href=" 
                                           <c:url value="/controller">
                                               <c:param name="action" value="delete_part"></c:param>
                                           </c:url> ">Delete a Car Part</a></li>
                                </ul>
                            </li>
                            <li class="menu-has-children"><a href="#">Services</a>
                                <ul>
                                    <li><a href=" 
                                           <c:url value="/controller">
                                               <c:param name="action" value="add_service"></c:param>
                                           </c:url> ">Add a Service</a></li>
                                    <li><a href=" 
                                           <c:url value="/controller">
                                               <c:param name="action" value="change_service"></c:param>
                                           </c:url> ">Change a Service</a></li>
                                    <li><a href=" 
                                           <c:url value="/controller">
                                               <c:param name="action" value="delete_service"></c:param>
                                           </c:url> ">Delete a Service</a></li>
                                </ul>
                            </li>
                            <li class="menu-has-children"><a href="#">Repairs</a>
                                <ul class = "dropdown-menu multi-level">
                                    <li><a href=" 
                                           <c:url value="/controller">
                                               <c:param name="action" value="create_repair"></c:param>
                                           </c:url> ">Create New Repair</a></li>  
                                    <li><a href=" 
                                           <c:url value="/controller">
                                               <c:param name="action" value="change_repair"></c:param>
                                           </c:url> ">Change a Repair</a></li>
                                    <li><a href=" 
                                           <c:url value="/controller">
                                               <c:param name="action" value="finish_repair"></c:param>
                                           </c:url> ">Finish a Repair</a></li>
                                    <li><a href=" 
                                           <c:url value="/controller">
                                               <c:param name="action" value="delete_repair"></c:param>
                                           </c:url> ">CANCEL a Repair</a></li>
                                </ul>
                            </li>    
                            <li class="menu-active">
                                <a href="
                                   <c:url value="/controller">
                                       <c:param name="action" value="logout"></c:param>
                                   </c:url>">Logout</a></li>                            
                        </ul>
                    </nav><!-- #nav-menu-container -->		    		
                </div>
            </div>
        </header><!-- #header -->       
    </body>
</html>
