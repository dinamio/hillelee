<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
      integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin=“anonymous">
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand"> Hello, <%= request.getSession().getAttribute("login") %>
    </a>
    <ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">

    </ul>
    <form method="POST" action="/logout">

        <button class="btn btn-sm btn-outline-info d-lg-inline-block mb-3 mb-md-0 ml-md-3" name="submit" type="submit"
                value="Log out">Log out
        </button>

    </form>

</nav>
</body>
</html>
