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

<form:form action="/signin" method="post" modelAttribute="userDataFromLoginJSP" >
    <p class="text-center">It's the register page. Input your credentials. After that you can login.</p>
    <p></p>
    <div class="text-center mb-4">
        <%= request.getSession().getAttribute("wrongMessage") %>
    </div>
    <div class="form-label-group">
        <input type="text" id="login" name="login" class="form-control" placeholder="Login" required autofocus>
        <label for="login">Login</label>
    </div>
    <div class="form-label-group">
        <input type="text" id="pwd" name="pwd" class="form-control" placeholder="Password" required autofocus>
        <label for="pwd">Password</label>
    </div>
    <div class="text-center button-bar">
        <button class="btn btn-lg btn-outline-primary btn-block" name="submit" type="submit" value="Sign up">Sign up</button>
    </div>
</form:form>
</body>
</html>