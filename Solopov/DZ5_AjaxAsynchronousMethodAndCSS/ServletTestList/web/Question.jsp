<%--
  Created by IntelliJ IDEA.
  User: Username
  Date: 18.04.2018
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Test</title>
</head>
<body>
<H1>Ask a few questions</H1>

<form name="formQuestion" method="post">
    <table>
        <tr>
            <th>ID</th>
            <th>Question</th>
        </tr>
        <tr>
            <td>Question</td>
            <td><input type="text" name="question"></td>
        </tr>
        <tr>
            <td>Answer</td>
            <td><input type="text" name="answerLine"></td>
        </tr>
    </table>
    <input hidden name="formAddQuestion" value="true">
    <input type="submit" name="addQuestion" value="Add question">
</form>
<form name="formTest" method="post">
</form>
<form name="formViewQuestions" action="questions">
    <input type="submit" name="viewTest" value="View Questions">
</form>

<p>To create multiple answers, use the separator --</p>

</body>
</html>
