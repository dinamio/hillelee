<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

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
            <sec:authorize access="hasAuthority('ADMIN')">
                <button class="btn btn-primary  btn-lg del${t.id}" name="submit" type="button">Remove quiz</button>
            </sec:authorize>
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