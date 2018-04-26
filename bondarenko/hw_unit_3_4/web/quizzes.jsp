<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>

</head>
    <body>

        <div>
            <form action="/quizzes" method="post">
                <input type="text" name="name">
                <input type="text" name="desc">
                <input type="submit" value="Add new">
            </form>
        </div>
        <div>
            <br/>
                <h3>QUIZZES</h3>
            <br/>
            <ul>
                <c:forEach var="num" items="${quizzes}">
                    <li>
                        <br/><a href="quiz?name=${num.getName()}">${num.getName()}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </body>
</html>
