<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <title>Quiz List</title>
    <link href="styles.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
<div class="container">

    <div class="mainblock">


        <!--New quiz -->
        <p>Create new quiz!</p>

<form:form action="/newquiz" method="post" modelAttribute="quizToAdd">
        <label><b>Введите название опроса:</b></label>
        <input name="name">
        <p>
            <label><b>Введите предметную область опроса:</b></label>
            <input name="objective">
        <p>
            <input type="submit" value="Создать опрос">
</form:form>

<!--quiz list -->


        <table class="table_quiz">
            <caption/>
            <tbody>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Objective</th>
                <th>Creator</th>
                <th/>
            </tr>
            <c:forEach items="${list}" var="test">
                <tr>
                    <input type="hidden" name="table_id" value="${test.getId()}"/>
                    <td> ${test.getId()}</td>
                    <td> <a href="questions/${test.getId()}">${test.getName()}</a></td>
                    <td> ${test.getObjective()} </td>
                    <td> ${test.getCreator().getLogin()} </td>
                    <td class="deleteRow">Delete</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $(".deleteRow").click(function (evt) {
            var selectId = $(this).closest("tr").find("[name='table_id']").val();

            $.ajax({
                type: 'DELETE',
                url: "quizlist/" + selectId,
                success: function () {
                    if (evt.target.closest('.deleteRow')) {
                        evt.target.closest('tr').remove()
                    }
                }
            })
        });
    });

</script>

</body>
</html>
