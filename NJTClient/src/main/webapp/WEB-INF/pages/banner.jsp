<%-- 
    Document   : banner
    Created on : Sep 4, 2018, 12:24:45 AM
    Author     : Dusan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
    </head>
    <body>
        <!-- start banner Area -->
        <section class="banner-area relative" id="home">	
            <div class="overlay overlay-bg"></div>
            <div class="container">
                <div class="row d-flex align-items-center justify-content-center">
                    <div class="about-content col-lg-12">
                        <jsp:include page="${banner_page}"></jsp:include>
                    </div>											
                </div>
            </div>
        </section>
        <!-- End banner Area -->	
    </body>
</html>
