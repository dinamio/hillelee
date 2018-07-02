<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Sign up</title>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin=“anonymous">
    <!-- Custom styles for this template -->
    <link href="http://getbootstrap.com/docs/4.0/examples/floating-labels/floating-labels.css" rel="stylesheet">
</head>
<body>


<form:form method="post" action="/signin" modelAttribute="user">
<table>
    <tr>
        <td><form:label path="login">Name</form:label></td>
        <td><form:input path="login"/></td>
        <td><form:errors path="login"/></td>
    </tr>
    <tr>
        <td><form:label path="pwd">Password</form:label></td>
        <td><form:input path="pwd"/></td>
        <td><form:errors path="pwd"/></td>
    </tr>
    <tr>
        <td><input type="submit" value="Submit"/></td>
    </tr>
</table>
</form:form>
</body>
</html>