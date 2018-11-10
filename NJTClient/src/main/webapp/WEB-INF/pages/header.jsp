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
            <hr>
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
                                       <c:param name="action" value="home"></c:param>
                                   </c:url>">Home</a></li>	
                            <li class="menu-has-children"><a href="#">YOUR CARS</a>
                                <ul>
                                    <li><a href=" 
                                           <c:url value="/controller">
                                               <c:param name="action" value="add_car"></c:param>
                                           </c:url> ">Add a Car</a></li>
                                    <li><a href=" 
                                           <c:url value="/controller">
                                               <c:param name="action" value="update_car_page"></c:param>
                                           </c:url> ">Update a Car</a></li>
                                    <li><a href=" 
                                           <c:url value="/controller">
                                               <c:param name="action" value="sell_car_page"></c:param>
                                           </c:url> ">Sell a Car</a></li>
                                </ul>
                            </li>
                            <li><a href="service.html">Service</a></li>
                            <li><a href="team.html">Team</a></li>
                            <li><a href="price.html">Price</a></li>
                            <li><a href="blog-home.html">Blog</a></li>	
                            <li><a href="contact.html">Contact</a></li>	
                            <li class="menu-has-children"><a href="">Pages</a>
                                <ul>
                                    <li><a href="blog-single.html">blog Single</a></li>
                                    <li><a href="elements.html">Elements</a></li>
                                </ul>
                            </li>			          
                        </ul>
                    </nav><!-- #nav-menu-container -->		    		
                </div>
            </div>
        </header><!-- #header -->       
    </body>
</html>
