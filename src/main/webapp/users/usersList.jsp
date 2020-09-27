<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users list</title>
</head>
<body>
<%@ include file="/header.jsp" %>

<div class="container">
    <div class="container shadow-lg p-4 mb-4 bg-white border rounded-lg">
        <table class="table table-hover">
            <h5 class="text-primary font-weight-bold">Lista użytkowników</h5>
            <thead class="bg-dark text-white">
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Nazwa użytkownika</th>
                <th scope="col">Email</th>
                <th scope="col">Akcja</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${allUsersList}">
                <tr>
                    <th scope="row">${user.id}</th>
                    <td>${user.userName}</td>
                    <td>${user.email}</td>
                    <td><a href="">Usuń</a> <a href="">Edytuj</a> <a href="">Pokaż</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%@ include file="/footer.jsp" %>
</body>
</html>
