<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Username
  Date: 21.04.2018
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quiz List</title>
</head>
<body>
    <table>
        <tr>
        <th>ID</th><th>Title</th><th>Objective</th><th>Creator</th>
        </tr>
        <c:forEach items="${list}" var="test">
    <tr>
        <td> ${test.getId()}</td>
        <td> ${test.getName()}</td>
        <td> ${test.getObjective()} </td>
        <td> ${test.getCreator()} </td>

        <td><a href="delQuiz?id=${test.getId()}" content=" ">Delete</a></td>
    </tr>
</c:forEach>
    </table>

    <!--New quiz -->
    <p>Create new quiz!</p>

    <form name = "formQuiz" method="post" action="newquiz">
        <table>
            <tr>
                <td>Test title</td>
                <td><input type="text" name="testTitle"></td>
            </tr>
            <tr>
                <td>Objective</td>
                <td><input type="text" name="objective"></td>
            </tr>
        </table>


        <input hidden name="formCreateQuiz" value="true">
        <input  type="submit" name="addTest" value="Save and Ask questions">

    </form>

</body>
</html>
