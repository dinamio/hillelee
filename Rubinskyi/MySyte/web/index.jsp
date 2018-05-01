<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <title>Questionnaire</title>
</head>
<body style ="margin: 0;">
<div class = "global_wrapper" style="position: fixed; height: 100%; width: 100%; background: Beige;">
  <form class = "sending_form" method="post" action = "send">
    <p>Subject:<br>
      <input type="text" name="Subject" size="40">
    </p>
    <p>Theme:<br>
      <input type="text" name="Theme" size="40">
    </p>
    <input type="submit" value="Send" >

  </form>
  <form action="show_all" method="get">
    <p>   <input type="submit" value="Show all"> </p>
  </form>

  <form action="delete" method="post">
    <p>Subject:<br>
      <input type="text" name="Subject" size="40">
    </p>
    <p>Theme:<br>
      <input type="text" name="Theme" size="40">
    </p>
    <p> <input type="submit" value="Delete"> </p>
  </form>

  <table>
    <c:forEach items="${all_questions}" var="QuizTopicBean">
      <tr>
        <td> ${QuizTopicBean.quizSubject}</td>
        <td> ${QuizTopicBean.quizTopic}</td>
      </tr>
    </c:forEach>
  </table>
</div>

</body>
</html>
