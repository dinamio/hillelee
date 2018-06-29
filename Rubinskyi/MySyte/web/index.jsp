<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="shortcut icon" href="resources/img/Question.png" type="image/png">

    <title>Questionnaire</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" href="resources/css/index.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<div class = "global_wrapper">

    <div class="header">
        <div class="hello_user">
            <form:form action="logout" method="get">
                <div class="user_name">
                    Hello, <%=session.getAttribute("login")%>
                </div>
                <button class="btn btn-primary" type="submit">log out</button>
            </form:form>
        </div>
    </div>

    <div class="main_content">
        <form:form class = "sending_form" method="post" action = "send">
            <p>Subject:<br>
                <input type="text" name="Subject" size="40">
            </p>
            <p>Theme:<br>
                <input type="text" name="Theme" size="40">
            </p>
            <button class="btn btn-primary" type="submit">Create a quiz</button>

        </form:form>

        <table>
            <tr>
                <td>Id</td>
                <td>Theme</td>
                <td>Subject</td>
                <td>Creator</td>
                <td>Actions</td>
            </tr>
            <c:forEach items="${all_questions}" var="QuizTopicBean">
                <tr class="table">
                    <td class="table"> ${QuizTopicBean.id}</td>
                    <td class="table"> ${QuizTopicBean.quizSubject}</td>
                    <td class="table"> ${QuizTopicBean.quizTopic}</td>
                    <td class="table"> ${QuizTopicBean.idCreator}</td>
                    <td><input type="button" class="delete-button btn-danger" delete-id = ${QuizTopicBean.id} value="Delete"></td>
                </tr>
            </c:forEach>
        </table>

        <script>
            $(document).ready(function () {
                $(".delete-button").click(function () {
                    var deleteId = $(this).attr("delete-id");
                    $.ajax({
                        type: "DELETE",
                        url: "/delete/" + deleteId,
                        success: function () {
                            location.reload();
                        }
                    })
                })
            })


        </script>

    </div>

    <footer class="footer">
        <div class="container">
            <span class="text-muted">FOOTER</span>
        </div>
    </footer>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</body>
</html>