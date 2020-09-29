<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>

<div class="container">
    <div class="container shadow-lg p-4 mb-4 bg-white border rounded-lg">
        <form method="post" action="/user/add">
            <h5 class="text-primary font-weight-bold">Dodaj użytkownika</h5>
            <div class="form-group">
                <label for="userNameInput">Nazwa</label>
                <input type="text" name="userName" required class="form-control" id="userNameInput" placeholder="Nazwa użytkownika">
            </div>
            <div class="form-group">
                <label for="emailInput">Email</label>
                <input type="email" name="email" required class="form-control" id="emailInput" placeholder="Email użytkownika" aria-describedby="emailHelp">
                <small id="emailHelp" class="form-text text-muted">Nigdy nikomu nie udostępnimy Twojego adresu email.</small>
            </div>
            <div class="form-group">
                <label for="passwordInput">Hasło</label>
                <input type="password" name="password" required class="form-control" id="passwordInput" placeholder="Hasło użytkownika">
            </div>
            <button type="submit" class="btn btn-success">Zapisz</button>
        </form>
    </div>
</div>

</body>
</html>
