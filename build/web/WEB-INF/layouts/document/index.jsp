<%-- 
    Document   : index
    Created on : Jun 2, 2019, 1:05:57 PM
    Author     : dzmitry
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>

        <link href="${pageContext.request.contextPath}/pub/css/bootstrap-3.3.7/bootstrap.min.css" rel="stylesheet"/>
        <script src="${pageContext.request.contextPath}/pub/js/jquery/jquery-1.12.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/pub/js/bootstrap-3.3.7/bootstrap.min.js"></script>
    </head>
    <body>        
        <div class="container">
            <div class="row">
                <div class="col-md-12">

                </div>
            </div>
            <div class="row">
                <div class="col-md-2 col">
                    <%@ include file="../blocks/menu.jsp" %>
                </div>
                <div class="col-md-10">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="row">
                                <%@ include file="buttons.jsp" %>
                            </div>
                        </div>
                    </div>
                    <div class="row">

                        <div class="col-md-12">
                            <%@ include file="content.jsp" %>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
