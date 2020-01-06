<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="User list" pageEncoding="UTF-8"%>
<%@tag import="java.util.ArrayList"%>
<%@tag import="java.util.List"%>
<%@tag import="edms.entity.User"%>
<%@attribute name="user_id"%>
<%@attribute name="users" type="ArrayList<User>"%>
<select id="user_id" name="user_id" class="form-control">
    <c:forEach items="${users}" var="user">
        <option <c:if test="${user_id == user.id}">selected</c:if> value="${user.id}">
            ${user.lastname} ${user.firstname}
        </option>
    </c:forEach>
</select>
