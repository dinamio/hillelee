<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Autorisation</title>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link type="text/css" rel="stylesheet" href="styles.css"/>
    <link href="<c:url value="styles.css"/>" rel="stylesheet" type="text/css"/>

</head>
<body>
<div class="container">
    <div class="mainblock">

        <form action="/auth">

            <label><b>Username</b></label>
            <input type="text" placeholder="Enter Username" name="uname" required>

            <label><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="psw" required>

            <button type="submit">Login</button>
        </form>
        <p>Don't have an account?
            <a href="/reg">Sign up</a>
        </p>
    </div>
</div>
</body>
</html>
