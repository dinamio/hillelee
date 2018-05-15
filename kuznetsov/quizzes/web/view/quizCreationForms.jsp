<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <link type="text/css" rel="stylesheet" href="resources/css/quizViewTable.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin=“anonymous">

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
            integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
            crossorigin="anonymous"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <%--<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>--%>
    <%--<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>--%>
    <title>Forms</title>
</head>
<body>
<form method="POST" action="/quiz">
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
                <select class="custom-select d-block w-100" name="Subject" required="">
                    <option value="">Subject...</option>
                    <option value="History">History</option>
                    <option value="Geography">Geography</option>
                    <option value="English">English</option>
                    <option value="Geometry">Geometry</option>
                </select>
            </td>
            <td>
                <input class="form-control" name="Theme" placeholder="Quiz theme is..." type="text">
            </td>
            <td>
                <table class="table" id="myTable">

                    <tbody>
                    <tr id="row0">

                        <td>
                            <div class="input-group">
                                <input type="checkbox" class="check-box-table-cell">
                                <input type="text" class="form-control"/>
                                <span class="input-group-btn">
                        <button id="btn0" type="button" class="btn btn-primary" onclick="addRow(this); sendQuestionData(this)">
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
                <button class="btn btn-primary" name="submit" type="submit">Add test</button>
            </td>
        </tr>
        </tbody>
    </table>
</form>
<script src="resources/js/addQuestion.js"></script>
</body>
</html>