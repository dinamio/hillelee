<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <title>Login</title>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap Simple Login Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/login-page.css">
</head>
<body>

<div class="login-form">
    <form action="/login" method="post">
        <h2 class="text-center">Log in</h2>
        <div class="form-group">
            <input type="text" class="form-control" name ="login" placeholder="Username" required="required">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" name="pass" placeholder="Password" required="required">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Log in</button>
        </div>

    </form>
    <p class="text-center"><a href="/register">Create an Account</a></p>
</div>


</body>
</html>
