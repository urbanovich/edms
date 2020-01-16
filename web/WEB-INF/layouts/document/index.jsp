<%-- 
    Document   : index
    Created on : Jun 2, 2019, 1:05:57 PM
    Author     : dzmitry
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:attribute name="message">
        <t:message message="${requestScope.message}"></t:message>
    </jsp:attribute>
    <jsp:attribute name="content">
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
                        <t:documents></t:documents>
                    </div>
                </div>
            </div>
        </div>
    </jsp:attribute>
</t:genericpage>