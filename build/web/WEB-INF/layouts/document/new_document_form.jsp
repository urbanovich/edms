<%-- 
    Document   : content
    Created on : Jun 2, 2019, 3:33:52 PM
    Author     : dzmitry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form action="${pageContext.request.contextPath}/document?action=new" method="post">
    <div class="form-group">
        <label for="title">Название документа</label>
        <input type="text" class="form-control" id="title" name="title">
    </div>
    <div class="form-group">
        <label for="content">Содержание документа</label>
        <textarea cols="10" rows="10" id="content" class="form-control" name="content"></textarea>
    </div>
    <div class="form-group">
        <label for="user_id">Отправить пользователю</label>
        <select id="user_id" name="user_id" class="form-control">
            <option value="0">Выберите пользователя</option>
        </select>
        <span class="help-block">
            Выберите пользователя кому отправить этот документ на рассмотрение.
        </span>
    </div>
    
    <button type="submit" class="btn btn-default">Отправить</button>
</form>