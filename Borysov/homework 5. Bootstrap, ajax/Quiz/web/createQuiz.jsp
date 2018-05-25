<%--
  Created by IntelliJ IDEA.
  User: Denys
  Date: 15.04.2018
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@include file="head.jsp"%>
<body>
<div id="main">
    <div id="header">
        <div id="logo">
            <div id="logo_text">
                <h1><a href="mainPage.jsp"><span class="logo_colour">Quiz</span></a></h1>
            </div>
        </div>
    </div>

    <div id="site_content">
        <div class="sidebar">
            <h3><a href="LogOut">Log out</a></h3>
        </div>
        <div id="content">
            <form method="post" action="AddQuiz">
                <h3>Subject</h3>
                <input required type="text" name="subject_field"
                       value="Math"/>
                <h3>Theme</h3>
                <input required type="text" name="theme_field"
                       value="Numbers "/>
                <input type="submit" class="btn" value="Create"/>

            </form>
            <a href="mainPage.jsp">Cancel</a>

        </div>
    </div>

    <div id="footer">
        Quizzes | <a href="#">1</a> | <a href="#">2</a> | <a href="#">3</a>
    </div>



</div>
</body>
</html>
