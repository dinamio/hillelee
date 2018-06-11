<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=utf-8" %>

<head>
    <title>Available Tests</title>
    <link href="https://v4-alpha.getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/list-of-quizies.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://npmcdn.com/tether@1.2.4/dist/js/tether.min.js"></script>
</head>
<body>

<%@include file="parts/header.jsp"%>

<div class="container-fluid">

    <div class="row">

        <jsp:include page="parts/sidebar.jsp">
            <jsp:param name="currentPage" value="list"/>
        </jsp:include>

        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">

            <h2>Quiz List</h2>

            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Subject</th>
                        <th>Theme</th>
                        <th>Author</th>
                        <th>Action</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:set var = "id" scope = "page" value = "${1}"/>
                        <c:forEach var="quiz" items="${quizzies}">
                            <tr>
                                <td>${id} </td>
                                <td>${quiz.getSubject().getSubjectName()}</td>
                                <td>${quiz.getTheme()}</td>
                                <td>${quiz.getAuthor()}</td>
                                <td>
                                    <a  class="delete${id}" href="/delete/${quiz.getId()}">Delete</a>
                                </td>
                                <c:set var="id" scope="page" value="${id+1}"/>
                             </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <div class = "add">
                <input type="submit" name="add" value="Add" onclick="location.href='add'">
            </div>
        </main>
    </div>
</div>


<script src="https://v4-alpha.getbootstrap.com/dist/js/bootstrap.min.js"></script>


</body>
</html>