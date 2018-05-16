<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin=“anonymous">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/quizViewTable.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<table class="table table-striped table-lg">
    <c:forEach items="${list}" var="t">
        <tr align="left">
            <td width="85"> ${t.subject}</td>
            <td width="300">${t.theme}</td>
            <td width="110">added by: ${t.login}</td>
            <td>
                <button class="btn btn-primary del${t.id}" name="submit" type="button">Remove</button>
                <script>
                    $(document).ready(function () {
                        $(".del${t.id}").click(function () {
                            $.ajax({
                                type: "delete",
                                url: "/quiz?id=${t.id}",
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