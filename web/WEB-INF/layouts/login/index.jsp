<%-- 
    Document   : index
    Created on : Jun 1, 2019, 2:34:39 PM
    Author     : dzmitry
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:attribute name="content">
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
    </jsp:attribute>
</t:genericpage>