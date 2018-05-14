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
<form class="form-signin" method="POST">

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
        <button class="btn btn-lg btn-primary btn-block" name="submit" type="submit" value="Sign in">Sign in</button>
        <button class="btn btn-lg btn-outline-primary btn-block" name="submit" type="submit" value="Sign up">Sign up
        </button>
    </div>
</form>
</body>
<%--
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>

--%>

</html>