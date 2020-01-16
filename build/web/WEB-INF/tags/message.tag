<%-- 
    Document   : message
    Created on : Jan 7, 2020, 5:51:04 PM
    Author     : dzmitry
--%>

<%@tag description="The tag for messaging" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- any content can be specified here e.g.: --%>
<div class="row">
    <div class="col-lg-12">
        <c:if test="${not empty message}">
            <div class="alert alert-danger" role="alert">
                ${message}
            </div>
        </c:if>
    </div>
</div>