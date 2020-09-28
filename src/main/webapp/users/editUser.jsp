<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<%@ include file="/header.jsp" %>

<div class="container">
    <div class="container shadow-lg p-4 mb-4 bg-white border rounded-lg">
        <form method="post" action="/user/edit">
            <h5 class="text-primary font-weight-bold">Edytuj dane użytkownika</h5>
            <input type="number" hidden name="id" value="${user.id}">
            <div class="form-group">
                <label for="userNameInput">Nazwa</label>
                <input type="text" name="userName" required class="form-control" id="userNameInput" value="${user.userName}">
            </div>
            <div class="form-group">
                <label for="emailInput">Email</label>
                <input type="email" name="email" required class="form-control" id="emailInput" value="${user.email}" aria-describedby="emailHelp">
                <small id="emailHelp" class="form-text text-muted">Nigdy nikomu nie udostępnimy Twojego adresu email.</small>
            </div>
            <div class="form-group">
                <label for="passwordInput">Hasło</label>
                <input type="password" name="password" required class="form-control" id="passwordInput" placeholder="Hasło użytkownika">
            </div>
            <button type="submit" class="btn btn-primary">Zapisz</button>
        </form>
    </div>
</div>

<%@ include file="/footer.jsp" %>
</body>
</html>
