<%-- 
    Document   : index
    Created on : Jun 2, 2019, 1:05:57 PM
    Author     : dzmitry
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>

        <link href="${pageContext.request.contextPath}/pub/css/bootstrap-3.3.7/bootstrap.min.css" rel="stylesheet"/>
        <script src="${pageContext.request.contextPath}/pub/js/jquery/jquery-1.12.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/pub/js/bootstrap-3.3.7/bootstrap.min.js"></script>
    </head>
    <body>
        <!--<h1>Cистемы учета документооборота предприятия.</h1>-->
        <div class="container">
            <div class="row">
                <div class="col-md-12">

                </div>
            </div>
            <div class="row">
                <div class="col-md-2 col">
                    <ul class="list-group">
                        <a class="list-group-item list-group-item-action active" 
                           href="${pageContext.request.contextPath}/document">
                            Документы
                        </a>
                        <a class="list-group-item list-group-item-action" 
                           href="${pageContext.request.contextPath}/document">
                            Документы
                        </a>
                    </ul>
                </div>
                <div class="col-md-10">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-md-2">
                                            <a class="btn btn-primary">Зарегистрировать новый документ</a>
                                        </div>
                                        <div class="col-md-2">
                                            <a class="btn btn-primary">Удалить выбранные</a>
                                        </div>
                                    </div>
                                </div>
                                
                            </div>
                            <div class="col-md-12">
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
                                        <!--<tr>
                                            <th scope="row">1</th>
                                            <td>Mark</td>
                                            <td>Otto</td>
                                            <td>@mdo</td>
                                        </tr>-->

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
