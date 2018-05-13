<%--
  Created by IntelliJ IDEA.
  User: rpkyrych
  Date: 23.04.2018
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of the all entered quiz</title>
</head>
<body>
    <form id="Quiz_remover" action="quiz?action=delete" method="post">
        <table border="1">
            <col width="10%">
            <col width="30%" align="center">
            <col width="30$" align="center">
            <col width="15$" align="center">
            <caption><h3>List of quizzes</h3></caption>
            <th>Action</th>
            <th>Subjects</th>
            <th>Topics</th>
            <th>Author</th>
            <c:forEach var="quiz" items="${list}">
                <tr>
                    <td><input type="checkbox" name="id" value="${quiz.id}"/>
                    <td>${quiz.subject}</td>
                    <td>${quiz.topic}</td>
                    <td>${quiz.author}</td>
                </tr>
            </c:forEach>
        </table>
        <p><input type="submit" value="Delete"></p>
    </form>

    <input type="button" onclick="location.href='quiz?action=add';" value="Add new quiz" />

</body>
</html>
