<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Username
  Date: 21.04.2018
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

        <form class="form-style-4" name="formQuiz" method="post" action="newquiz">
            <table>
                <tr>
                    <td>Test title</td>
                    <td><input type="text" name="testTitle"></td>
                </tr>
                <tr>
                    <td>Objective</td>
                    <td><input type="text" name="objective"></td>
                </tr>
            </table>


            <input hidden name="formCreateQuiz" value="true">
            <input type="submit" name="addTest" value="Add quiz">

        </form>
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
                    <td> <a href="\questions?id=${test.getId()}">${test.getName()}</a></td>
                    <td> ${test.getObjective()} </td>
                    <td> ${test.getCreator().getLogin()} </td>
                    <td class="deleteRow">Delete</td>

                    <!--<td><a href="delQuiz?id=${test.getId()}" content=" ">Delete</a></td>-->
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
                url: "/delQuiz?id=" + selectId,
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
