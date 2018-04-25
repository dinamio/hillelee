<%--
  Created by IntelliJ IDEA.
  User: rpkyrych
  Date: 20.04.2018
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quiz adding form</title>
</head>
<body>
    <form id="Quiz_adder" action="/" method="post">
        <p><b>Subject:</b></p>
        <p><input type="text" name="subject" value="add subject here"></p>
        <p><b>Topic:</b></p>
        <p><input type="text" name="topic" value="add quiz's topic here"></p>
        <p><input type="submit"></p>
    </form>

    <form id="Quiz_viewer" action="/print" >
        <p><input type="submit" value="Print list of books"></p>
    </form>

</body>
</html>
