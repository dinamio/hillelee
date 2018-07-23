<%--
  Created by IntelliJ IDEA.
  User: Denys
  Date: 14.04.2018
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<%@include file="/head.jsp"%>
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
        <input type="button" class='logout' value="Logout">
      </div>
      <div id="content">

        <ul class="menu">
          <li><h1><a href="/createQuiz">Create quiz</a></h1></li>
          <li><h1><a href="/showQuizzes">Show quizzes</a></h1></li>
        </ul>
          <sec:authorize access="hasAuthority('admin')">
              <li><h1><a href="/showQuizzes">Show quizzes</a></h1></li>
          </sec:authorize>
          Hello, <sec:authentication property="principal.username"/>
      </div>
    </div>

    <div id="footer">
      Quizzes | <a href="#">1</a> | <a href="#">2</a> | <a href="#">3</a>
    </div>

  </div>
  </body>
<script>
    $(document).ready(function () {
    $(".logout").click(function () {
        var csrf='${_csrf.token}';
        $.ajax({
            type: "POST",
            url: "/logout?_csrf="+csrf,
            success: function () {
                location.reload();
            }
        })
    });
    });
</script>
</html>
