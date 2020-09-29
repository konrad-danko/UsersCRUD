<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users list</title>
</head>
<body>

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
                    <td class="d-sm-flex justify-content-between">
                        <a href="${pageContext.request.contextPath}/user/delete?id=${user.id}" class="btn btn-danger btn-sm shadow-sm">Usuń</a>
                        <a href="${pageContext.request.contextPath}/user/edit?id=${user.id}" class="btn btn-warning btn-sm shadow-sm">Edytuj</a>
                        <a href="${pageContext.request.contextPath}/user/show?id=${user.id}" class="btn btn-primary btn-sm shadow-sm">Pokaż</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
