<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Register here</title>
</head>
<body>
<h2>Create new account</h2>
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
</body>
</html>
