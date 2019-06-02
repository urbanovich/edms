<%-- 
    Document   : index
    Created on : Jun 1, 2019, 2:34:39 PM
    Author     : dzmitry
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <div class="row">
                <div class="col-lg-4"></div>
                <div class="col-lg-4">
                    <form action="${pageContext.request.contextPath}/login" method="post">
                        <div class="form-group">
                            <label for="login">Логин:</label>
                            <input type="login" class="form-control" name="login" id="login" placeholder="Логин">
                        </div>
                        <div class="form-group">
                            <label for="password">Пароль:</label>
                            <input type="password" class="form-control" name="password" id="password" placeholder="Password">
                        </div>
                        <div class="checkbox">
                            <label>
                                <input name="checkme" type="checkbox"> Запомнить меня
                            </label>
                        </div>
                        <button type="submit" class="btn btn-default">Отправить</button>
                    </form>
                </div>
                <div class="col-lg-4"></div>
            </div>
        </div>
    </body>
</html>
