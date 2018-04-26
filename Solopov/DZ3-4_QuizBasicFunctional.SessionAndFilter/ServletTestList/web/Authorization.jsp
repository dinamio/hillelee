<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Autorisation</title>
</head>
<body>
<form action="/auth">


    <div class="container">
        <label><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="uname" required>

        <label><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" required>

        <button type="submit">Login</button>
    </div>
</form>
<p>Don't have an account?
<a href="/reg">Sign up</a>
</p>
</body>
</html>
