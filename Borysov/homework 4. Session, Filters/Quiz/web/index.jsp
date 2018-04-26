<%--
  Created by IntelliJ IDEA.
  User: Denys
  Date: 23.04.2018
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css" title="style"/>
    <title>Quiz</title>
</head>
<body>
<div id="main">
    <div id="header">
        <div id="logo">
            <div id="logo_text">
                <h1><a href="index.jsp"><span class="logo_colour">Quiz</span></a></h1>
            </div>
        </div>
    </div>



    <div id="site_content">
        <div class="sidebar">
            <c:if test="${requestScope.errorLogIn!=null}">
                <c:out value="Invalid params"/>
            </c:if>
            <h3>Log in</h3>
            <form method="post" action="LoginController">
                <h3>login</h3>
                <input required type="text" name="login_field"/>
                <h3>password</h3>
                <input required type="password" name="password_field"/>
                <input type="submit" class="btn" value="Log in"/>

            </form>
            or <a href="register.jsp">Register</a>

        </div>
        <div id="content">
            <h1>Our quizzes are the best</h1>

        </div>
    </div>

    <div id="footer">
        Quizzes | <a href="#">1</a> | <a href="#">2</a> | <a href="#">3</a>
    </div>



</div>
</body>

</html>
