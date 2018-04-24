<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Denys
  Date: 15.04.2018
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Quiz</h1>
<table border="1">

    <tr>
        <th>№</th>
        <th>Subject</th>
        <th>Theme</th>
        <th></th>
    </tr>
    <c:forEach items="${listOfQuizzes}" var="quiz" varStatus="status">
        <tr>
            <td class="center"><c:out value="${status.count}" /></td>
            <td class="center">${quiz.nameOfSubject}</td>
            <td class="center">${quiz.theme}</td>
            <c:url var="deleteLink" value="/DeleteQuiz">
                <c:param name="id_for_delete_field" value="${status.count-1}" />
            </c:url>
            <td align="center"><a href="${deleteLink}"
                                  onclick="if (!(confirm('Are you sure?'))) return false">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<a href="index.jsp">Cancel</a>
</body>
</html>
