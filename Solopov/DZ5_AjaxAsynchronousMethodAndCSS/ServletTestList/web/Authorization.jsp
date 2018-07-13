<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизация</title>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link type="text/css" rel="stylesheet" href="styles.css"/>
    <link href="<c:url value="styles.css"/>" rel="stylesheet" type="text/css"/>

</head>
<body>
<div class="container">
    <div class="mainblock">

        <form action="/auth" method="post">
        <label><b>Введите логин:</b></label>
        <input name="login">
        <p>
            <label><b>Введите пароль:</b></label>
            <input name="password">
        <p>
            <input type="submit" value="Авторизироваться">
            </form>
        <p>Не создали аккаунт?
            <a href="/reg">Зарегистрироваться</a>
        </p>
    </div>
</div>
</body>
</html>
