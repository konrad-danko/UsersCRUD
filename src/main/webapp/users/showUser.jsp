<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show a user</title>
</head>
<body>

<div class="container">
    <div class="container shadow-lg p-4 mb-4 bg-white border rounded-lg">
        <table class="table table-hover">
            <h5 class="text-primary font-weight-bold">Szczegóły użytkownika</h5>
            <tbody>
            <tr>
                <th scope="row">Id</th>
                <td>${user.id}</td>
            </tr>
            <tr>
                <th scope="row">Nazwa użytkownika</th>
                <td>${user.userName}</td>
            </tr>
            <tr>
                <th scope="row">Email</th>
                <td>${user.email}</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
