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
    <table >
        <caption><h3>List of quizzes</h3></caption>
        <th>Subjects</th>
        <th>Topics</th>
        <c:forEach var="quiz" items="${list}">
            <tr>
                <td>${quiz.subject}</td>
                <td>${quiz.topic}</td>
            </tr>
        </c:forEach>
    </table>

    <h3>Delete quiz</h3>
    <form id="Quiz_remover" action="/print" method="post">
        <p><b>Subject:</b></p>
        <p><input type="text" name="subject" ></p>
        <p><b>Topic:</b></p>
        <p><input type="text" name="topic"></p>
        <p><input type="submit" name="delete"></p>
    </form>

</body>
</html>
