<%-- 
    Document   : menu
    Created on : Jun 2, 2019, 3:28:57 PM
    Author     : dzmitry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<ul class="list-group">
    <a class="list-group-item list-group-item-action active" 
       href="${pageContext.request.contextPath}/dashboard">
        Панель
    </a>
    <a class="list-group-item list-group-item-action" 
       href="${pageContext.request.contextPath}/document">
        Документы
    </a>
</ul>