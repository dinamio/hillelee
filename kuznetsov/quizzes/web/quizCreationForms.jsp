
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head><!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin=“anonymous">
    <title>Forms</title>
</head>
<body>
<form method="POST" action="/quiz">
    <table border="0">
        <tr>
            <td><b>Subject</b></td>
            <td><b>Theme</b></td>
        </tr>
        <tr>
            <td>
                <select name="Subject">
                    <option value="History">History</option>
                    <option value="Geography">Geography</option>
                    <option value="English">English</option>
                    <option value="Geometry">Geometry</option>
                </select>
            </td>

            <td>
                <input type="text" name="Theme" size="65"/>
            </td>
            <td><input type = "submit" name="submit" value = "Add test"/>
            </td>

        </tr>
    </table>
</form>
</body>
</html>