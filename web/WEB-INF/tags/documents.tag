<%@tag description="Documents" pageEncoding="UTF-8"%>
<%@tag import="java.util.ArrayList"%>
<%@tag import="java.util.List"%>
<%@tag import="edms.entity.Document"%>
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
                    <td><a href="${pageContext.request.contextPath}/document?action=edit&document_id=<% out.print(document.getId()); %>">
                        <% out.print(document.getTitle()); %>
                        </a>
                    </td>
                    <td><% out.print(document.getDateAdd()); %></td>
                    <td><% out.print(document.getUser().getName()); %></td>
                </tr>
        <% }%>
    </tbody>
</table>