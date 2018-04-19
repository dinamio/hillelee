<%--
  Created by IntelliJ IDEA.
  User: Denys
  Date: 15.04.2018
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Quiz</h1>
<form method="post" action="AddQuiz">
    <h3>Subject</h3>
    <input required type="text" name="subject_field"
           value="Math"/>
    <h3>Theme</h3>
    <input required type="text" name="theme_field"
           value="Numbers "/>
    <input type="submit" class="btn" value="Create"/>

</form>
 <a href="index.jsp">Cancel</a>
</body>
</html>
