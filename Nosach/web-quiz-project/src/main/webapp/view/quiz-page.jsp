<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=utf-8" %>

<head>
    <title>Add Quiz</title>
    <link href="https://v4-alpha.getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/quiz.css">
</head>
<body>

<%@include file="parts/header.jsp"%>

<div class="container-fluid">
    <div class="row">
        <nav class="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar">
            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a class="nav-link" href="#">Overview</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="#">Add quiz<span class="sr-only">(current)</span></a>
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


            <div class="signup-form">
                <form action="/add" method="post">
                    <h2>Add new Quize</h2>
                    <hr>
                    <h4>Input subject</h4>
                    <div class="container">
                        <h6>choose existing subject</h6>
                        <div class="form-group">
                            <select class="form-control" id="sel1" name = "subjectList">
                                <option></option>>
                                <c:forEach var="subject" items="${subjects}">
                                    <option>${subject.getSubjectName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="container">
                        <h6>Or enter new subject</h6>
                        <div class="form-group">
                            <input type="text" class="form-control" name="subjectInput" placeholder="Subject" >
                        </div>
                    </div>
                    <hr>
                    <h4>Input quiz theme</h4>
                    <div class="form-group">
                        <input type="text" class="form-control" name="theme" placeholder="Theme" required="required">
                    </div>

                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-block btn-lg">Add</button>
                    </div>
                </form>
            </div>


        </main>
    </div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://v4-alpha.getbootstrap.com/dist/js/bootstrap.min.js"></script>


</body>
</html>