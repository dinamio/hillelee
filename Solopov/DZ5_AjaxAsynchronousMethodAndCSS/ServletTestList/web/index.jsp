<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8"  language="java" %>
<html>
<head>
    <title>Main Page!</title>
    <%@include file="parts/stylesandscripts.jsp" %>
    <style>
        h3 {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <%@include file="parts/header.jsp" %>
    <div class="mainblock">
        <h3><%=session.getAttribute("login")%> <spring:message code="mainpage.notification"/></h3>
        <p> <spring:message code="mainpage.language"/>:  <a href="?locale=en">English language</a> <a href="?locale=ru">Русский язык</a>
    </div>
</div>
</body>
</html>
