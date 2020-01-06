<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@attribute name="content" fragment="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LogIn</title>

        <link href="${pageContext.request.contextPath}/pub/css/bootstrap-3.3.7/bootstrap.min.css" rel="stylesheet"/>
        <script src="${pageContext.request.contextPath}/pub/js/jquery/jquery-1.12.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/pub/js/bootstrap-3.3.7/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <% String accessDenied = (String)request.getAttribute("accessDenied");
                        if (accessDenied != null) { %>
                            <div class="alert alert-danger" role="alert">
                                ${accessDenied}
                            </div>
                        <% } %>
                </div>
            </div>
            <jsp:invoke fragment="content"/>
        </div>
    </body>
</html>
