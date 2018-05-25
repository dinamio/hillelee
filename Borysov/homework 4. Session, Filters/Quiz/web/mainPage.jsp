<%--
  Created by IntelliJ IDEA.
  User: Denys
  Date: 14.04.2018
  Time: 16:22
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
          <h1><a href="mainPage.jsp"><span class="logo_colour">Quiz</span></a></h1>
        </div>
      </div>
    </div>

    <div id="site_content">
      <div class="sidebar">
        <h3><a href="LogOut">Log out</a></h3>
      </div>
      <div id="content">

        <ul class="menu">
          <li><a href="createQuiz.jsp">Create quiz</a></li>
          <li><a href="/ShowQuizzes">Show quizzes</a></li>
        </ul>

      </div>
    </div>

    <div id="footer">
      Quizzes | <a href="#">1</a> | <a href="#">2</a> | <a href="#">3</a>
    </div>

  </div>
  </body>
</html>
