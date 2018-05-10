<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=utf-8" %>

<head>
    <title>Available Tests</title>
    <link href="https://v4-alpha.getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/list-of-quizies.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>

<%@include file="parts/header.jsp"%>

<div class="container-fluid">
    <div class="row">
        <nav class="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar">
            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a class="nav-link active" href="list">Overview <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="add">Add quiz</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Statistics</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Account</a>
                </li>
            </ul>

        </nav>

        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">

            <h2>Quiz List</h2>

            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Subject</th>
                        <th>Theme</th>
                        <th>Author</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="quiz" items="${quizzes}">
                            <tr>
                                 <td>${quiz.id}</td>
                                 <td>${quiz.subject}</td>
                                <td>${quiz.theme}</td>
                                 <td>${quiz.author}</td>
                                 <td>
                                     <a  class="delete${quiz.id}" href="list">Delete</a>
                                     <script>
                                         $(document).ready(function () {
                                             $(".delete${quiz.id}").click(function () {
                                                 $.ajax({
                                                     type: "delete",
                                                     url:"/delete?id=${quiz.id}"
                                             })
                                             })
                                         })
                                     </script>
                                 </td>
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