<%-- 
    Document   : index
    Created on : Jun 2, 2019, 1:05:57 PM
    Author     : dzmitry
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:attribute name="content">
        <div class="row">
                <div class="col-md-2 col">
                    <%@ include file="../blocks/menu.jsp" %>
                </div>
                <div class="col-md-10">
                    <%@ include file="new_document_form.jsp" %>
                </div>
            </div>
    </jsp:attribute>
</t:genericpage>