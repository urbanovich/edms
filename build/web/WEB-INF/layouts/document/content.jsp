<%-- 
    Document   : content
    Created on : Jun 2, 2019, 3:33:52 PM
    Author     : dzmitry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="edms.entity.Document"%>
<table class="table table-striped">
    <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Название документа</th>
            <th scope="col">Дата добавления</th>
            <th scope="col">Пользователь</th>
        </tr>
    </thead>
    <tbody>
        <% List<Document> documents = (ArrayList<Document>) request.getAttribute("documents");
            for (Document document : documents) {%>
                <tr>
                    <th scope="row"><% out.print(document.getId()); %></th>
                    <td><% out.print(document.getTitle()); %></td>
                    <td><% out.print(document.getDateAdd()); %></td>
                    <td><% out.print(document.getUser().getName()); %></td>
                </tr>
        <% }%>
    </tbody>
</table>