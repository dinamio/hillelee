<%--
  Created by IntelliJ IDEA.
  User: Denys
  Date: 15.04.2018
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <h3><a href="/logout">Log out</a></h3>
        </div>
        <div id="content">
<%--            <form:form method="post" action="/addQuiz" modelAttribute="quiz">
                <h3>Subject</h3>
                <input required type="text" name="nameOfSubject"
                       value="Math"/>

               <p><form:errors path="nameOfSubject"/></p>

                <h3>Theme</h3>
                <input required type="text" name="theme"
                       value="Numbers "/>
                <input type="submit" class="btn" value="Create"/>

            </form:form>--%>


            <form:form method="post" action="addQuiz" modelAttribute="quiz">
                <table>
                    <tr>
                        <td><form:label path="nameOfSubject">Name</form:label></td>
                        <td><form:input path="nameOfSubject"/></td>
                        <td><form:errors path="nameOfSubject"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="theme">Description</form:label></td>
                        <td><form:input path="theme"/></td>
                        <td><form:errors path="theme"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit"/></td>
                    </tr>
                </table>

            </form:form>

            <a href="/mainPage">Cancel</a>

        </div>
    </div>

    <div id="footer">
        Quizzes | <a href="#">1</a> | <a href="#">2</a> | <a href="#">3</a>
    </div>



</div>
</body>
</html>
