<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <title>Available Tests</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/test-list-style.css">
</head>
<body>

<header ><h1>Available Quizzes</h1></header>

<div class="table">

    <table>
        <tr>
            <th>ID</th>
            <th>Subject</th>
            <th>Theme</th>
            <th></th>
            <th></th>
        </tr>

            <c:forEach var="quizzes" items="${tests}">
                <tr>
                    <td>${quizzes.id}</td>
                    <td>${quizzes.subject}</td>
                    <td>${quizzes.theme}</td>
                    <td>
                        <a href="delete?id=${quizzes.id}" content="">Delete</a>
                    </td>
                    <td></td>
                </tr>
            </c:forEach>

    </table>
</div>
<div name = "add">

    <form name="add" action="add" method="post" >
        <input type="submit" name="add" value="add" >
    </form>

</div>

</body>
</html>