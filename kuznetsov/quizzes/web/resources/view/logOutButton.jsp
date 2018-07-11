<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand"> <spring:message code="header.hello"/>, <sec:authentication property="principal.username"/>
    </a>
    <ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">

    </ul>
    <form method="POST" action="/logout">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>

        <button class="btn btn-sm btn-outline-info d-lg-inline-block mb-3 mb-md-0 ml-md-3" name="submit" type="submit"
                value="Log out">Log out
        </button>

    </form>

</nav>
</body>
</html>
