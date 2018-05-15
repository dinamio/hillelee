<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin=“anonymous">
    <title>Forms</title>
</head>
<body>
<form method="POST" action="/quiz">
    <table border="0">
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
                <button class="btn btn-primary" name="submit" type="submit">Add test</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>