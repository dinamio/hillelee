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
<%@include file="/head.jsp" %>
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
            <h3><a href="/logout">Log out</a></h3>
        </div>
        <div id="content">
            <form method="post" action="/addQuestionAndAnswers">
                <h3>Question Text</h3>
                <input required type="text" name="text_question_field"
                       value="What is Mathematics?"/>
                <h3>Aswers</h3>
                <input required type="text" name="answer_field1" value="Numbers "/>
                <input type="checkbox" name="answer_is_right_field1">
                <br>
                <input required type="text" name="answer_field2" value="Numbers "/>
                <input type="checkbox" name="answer_is_right_field2">
                <br>
                <input required type="text" name="answer_field3" value="Numbers "/>
                <input type="checkbox" name="answer_is_right_field3">
                <br>
                <input required type="text" name="answer_field4" value="Numbers "/>
                <input type="checkbox" name="answer_is_right_field4">
                <br>
                <input type="submit" class="btn" value="Add"/>

            </form>
            <a href="/showQuizzes">Cancel</a>

        </div>
    </div>

    <div id="footer">
        Quizzes | <a href="#">1</a> | <a href="#">2</a> | <a href="#">3</a>
    </div>


</div>
</body>
</html>
