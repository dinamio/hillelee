<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/quizViewTable.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin=“anonymous">

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
            integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
            crossorigin="anonymous"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
    <title>Forms</title>
</head>
<body>
<%@ include file="logOutButton.jsp" %>
<sec:authorize access="hasAuthority('ADMIN')">
<form:form method="POST" action="/quiz" modelattribute="dataFromForm">
    <table border="0">
        <thead>
        <tr>
            <th>
                Subject
            </th>
            <th>
                Theme
            </th>
            <th>
                Questions
            </th>
        </tr>
        </thead>


        <tbody>
        <tr>
            <td>
                <select class="custom-select d-block w-100 input-lg" name="Subject" required="">
                    <option value="">Subject...</option>
                    <option value="History">History</option>
                    <option value="Geography">Geography</option>
                    <option value="English">English</option>
                    <option value="Geometry">Geometry</option>
                </select>
            </td>
            <td>
                <input class="form-control input-lg" name="Theme" placeholder="Quiz theme is..." type="text">
            </td>
            <td>
                <table class="table" id="myTable">

                    <tbody>
                    <tr id="row0">
                        <td>
                            <div class="input-group">
                                <input type="checkbox" class="check-box-table-cell input-lg" name="Checkbox0">
                                <input type="text" class="form-control input-lg" name="Question0">
                                <span class="input-group-btn ">
                        <button id="btn0" type="button" class="btn btn-primary" onclick="addRow(this)">
                            <span id="icon0" class="glyphicon glyphicon-plus"></span>
                        </button>
                    </span>
                            </div>

                        </td>

                    </tr>
                    </tbody>
                </table>
            </td>

            <td>
                <button class="btn btn-primary btn-lg" name="submit" type="submit">Add test</button>
            </td>
        </tr>
        </tbody>

    </table>
</form:form>
</sec:authorize>
<%@ include file="quizViewTable.jsp" %>
<script src="${pageContext.request.contextPath}/resources/js/addQuestion.js"></script>
</body>
</html>