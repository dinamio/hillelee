<%--
  Created by IntelliJ IDEA.
  User: Denys
  Date: 23.04.2018
  Time: 16:07
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

        </div>
        <div id="content">

            <h3>Registration</h3>
            <form method="post" action="RegisterController">
                <h3>login</h3>
                <input required type="text" name="login_field"/>
                <h3>password</h3>
                <input required type="password" name="password_field"/>
                <h3>email</h3>
                <input required type="email" name="email_field"/>
                <input type="submit" class="btn" value="Register"/>

            </form>
            or <a href="index.jsp">Cancel</a>

        </div>
    </div>

    <div id="footer">
        Quizzes | <a href="#">1</a> | <a href="#">2</a> | <a href="#">3</a>
    </div>



</div>

</body>
</html>
