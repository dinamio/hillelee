<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Регистрация</title>
    <link href="styles.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <div class="mainblock">
        <h2>Зарегистрироваться</h2>
<form:form action="/reg" method="post" modelAttribute="userReg">
    <label><b>Введите логин:</b></label>
    <input name="login">
        <p>
    <label><b>Введите пароль:</b></label>
    <input name="password">
        <p>
    <input type="submit" value="Зарегистрироваться">
</form:form>
    </div>
</div>
</body>
</html>
