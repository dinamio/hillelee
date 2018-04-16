<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/test-style.css">
</head>

<body>

    <header ><h1>Quiz</h1></header>

    <div class="list">
        <form name = "add" method="post" action="add">
        <table>
            <tr>
                <td>Subject</td>
                <td><input type="text" name="subject"></td>
            </tr>
            <tr>
                <td>Theme</td>
                <td><input type="text" name="theme"></td>
            </tr>
        </table>
            <input hidden name="formChecked" value="true">
            <input type="submit" name="add" value="Send">
        </form>
    </div>

</body>
</html>