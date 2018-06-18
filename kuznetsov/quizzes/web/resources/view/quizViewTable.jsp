<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin=“anonymous">

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
            integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/quizViewTable.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">


</head>
<body>

<table class="table table-striped table-lg">
    <thead>
    <tr>
        <th>
            Added by:
        </th>
        <th>
            Subject
        </th>
        <th>
            Theme
        </th>
        <th>
            Correct/Questions
        </th>
        <th>
            Control
        </th>
    </tr>
    </thead>

    <c:forEach items="${list}" var="t">
        <tr align="left">
            <td>${t.login}</td>
            <td> ${t.subject}</td>
            <td>${t.theme}</td>
            <td>
              <table>
                <c:forEach var="entry" items="${t.questions}">
                <tr>
                    ${entry.value} | ${entry.key}<br/>
                </tr>
                </c:forEach>
              </table>
            <td>
                <button class="btn btn-primary  btn-lg del${t.id}" name="submit" type="button">Remove quiz</button>
                <script>
                    $(document).ready(function () {
                        $(".del${t.id}").click(function () {
                            var csrf='${_csrf.token}';
                            $.ajax({
                                type: "POST",
                                url: "/quiz/" + ${t.id},
                                data:{_csrf: csrf},
                                success:  $(this).parent().parent().remove()
                            })
                        })
                    })
                </script>
            </td>
        </tr>
    </c:forEach>
</table>

</body>

</html>