<%--
  Created by IntelliJ IDEA.
  User: eugen
  Date: 11/21/17
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
  <link rel="stylesheet" href="resources/styles.css">
</head>
<html>
  <head>
    <title><spring:message code="servers.title"/></title>
  </head>
  <body>
  <h1>Hello ${name}</h1>
  <c:if test="${not empty servers}">

    <ul>
      <c:forEach var="server" items="${servers}">
        <li>${server.name}, ${server.description}</li>
      </c:forEach>
    </ul>

  </c:if>
  <a href="/server/add"><spring:message code="servers.add"/></a>
  <hr/>
  <a href="?locale=en">en</a>
  <a href="?locale=ru">ru</a>
  </body>
</html>
