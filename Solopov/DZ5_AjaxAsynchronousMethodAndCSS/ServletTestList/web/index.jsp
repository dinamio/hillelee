<%--
Created by IntelliJ IDEA.
User: Username
Date: 23.04.2018
Time: 15:55
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="styles.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="mainblock">

<h2>Привет <%=session.getAttribute("login")%>,Рад видеть тебя на веб-сайте.</h2>
        <p>Выбери понравившуюся тебе ссылку
           <p><a href="/auth">Авторизация</a>
           <p><a href="/quizlist">Главная страница с опросами</a>
    </div>
</div>
</body>
</html>
