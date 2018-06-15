<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="shortcut icon" href="img/Question.png" type="image/png">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" href="resources/css/Registration.css"/>
    <title>Register here</title>
</head>
<%--<body>--%>


<body class="text-center">

<form:form method="post" action = "registration" class="form-signin form-group" modelAttribute="userToAdd">
    <img class="mb-4" src="img/Question.png" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal">Create new account</h1>
    <label for="inputEmail" class="sr-only">login</label>
    <input type="text" name="login" id="inputEmail" class="form-control" placeholder="Enter login" required autofocus>
    <label for="inputPassword" class="sr-only">password</label>
    <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Enter password" required>
    <small id="passwordHelpBlock" class="form-text text-muted">
        Password must not contain spaces or emoji.
    </small>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Registration</button>
    <p><a href="redirect_authorization">Have an account</a></p>
    <p class="mt-5 mb-3 text-muted">&copy; 2018-2019</p>
</form:form>


<%--TODO delete auto centration for forms--%>

<%--<form method="get" action = "redirect_authorization" class="form-signin form-group">
    <button class="btn btn-lg btn-primary btn-block" type="submit">Have an account</button>
</form>--%>

</body>

<%--<h2>Create new account</h2>
<form method="post" action = "registration">
    <p>login:<br>
        <input name="login" type="text" placeholder="Enter login" size="40">
    </p>
    <p>password:<br>
        <input name="password" type="password" placeholder="Enter password" size="40">
    </p>
    <button type="submit">Registration</button>

    <form method="get" action = "login">
        <button type="submit">Have an account</button>
    </form>

</form>
</body>--%>
</html>
