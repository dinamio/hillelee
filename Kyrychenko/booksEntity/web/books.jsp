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
    <title>Books adding form</title>
</head>
<body>
    <form id="Book_adder" action="/" method="post">
        <p><b>Author:</b></p>
        <p><input type="text" name="author" value="add author here"></p>
        <p><b>Book name:</b></p>
        <p><input type="text" name="name" value="add book's name here"></p>
        <p><input type="submit"></p>
        

    </form>
</body>
</html>
