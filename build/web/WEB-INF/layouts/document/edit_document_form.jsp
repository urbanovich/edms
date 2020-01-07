<%-- 
    Document   : content
    Created on : Jun 2, 2019, 3:33:52 PM
    Author     : dzmitry
--%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="edms.entity.Document"%>
<form action="${pageContext.request.contextPath}/document?action=update&document_id=${document.getId()}" method="post">
    <div class="form-group">
        <label for="title">Название документа</label>
        <input type="text" class="form-control" id="title" name="title" value="${document.getTitle()}">
    </div>
    <div class="form-group">
        <label for="content">Содержание документа</label>
        <textarea cols="10" rows="10" id="content" class="form-control" name="content">${document.getContent()}</textarea>
    </div>
    <div class="form-group">
        <label for="user_id">Отправить пользователю</label>
        <t:user_list user_id="${user.id}" users="${users}"></t:user_list>
        <span class="help-block">
            Выберите пользователя кому отправить этот документ на рассмотрение.
        </span>
    </div>
    
    <button type="submit" class="btn btn-default">Отправить</button>
</form>