<%--
  Created by IntelliJ IDEA.
  User: rpkyrych
  Date: 03.05.2018
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registration page</title>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css" id="bootstrap-css">

    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/fonts/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/form-elements.css">
    <link rel="stylesheet" href="assets/css/enter_page_style.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark probootstrap-navabr-dark">
    <div class="container">
        <a class="navbar-brand" href="index.html">Quiz adder</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#probootstrap-nav"
                aria-controls="probootstrap-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="probootstrap-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a href="index.html" class="nav-link">Home</a></li>
                <li class="nav-item"><a href="about.html" class="nav-link">About</a></li>
                <li class="nav-item"><a href="contact.html" class="nav-link">Contact</a></li>
                <li class="nav-item probootstrap-cta probootstrap-seperator"><a href="registration" class="nav-link">Sign
                    up</a></li>
                <li class="nav-item probootstrap-cta"><a href="authentication" class="nav-link">Log In</a></li>
            </ul>
        </div>
    </div>
</nav>

<!-- Top content -->
<div class="top-content">
    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-offset-2 col-md-8">

                    <h3>${loginExist}</h3>

                    <div class="form-box">
                        <div class="form-top">
                            <div class="form-top-left">
                                <h3>Sign up now</h3>
                                <p>Fill in the form below to get instant access:</p>
                            </div>
                            <div class="form-top-right">
                                <i class="fa fa-pencil"></i>
                            </div>
                        </div>
                        <div class="form-bottom">
                            <form role="form" action="registration" method="post" class="registration-form">
                                <div class="form-group">
                                    <label class="sr-only" for="form-fullName">Full Name</label>
                                    <input type="text" name="fullName" placeholder="Full name..."
                                           class="form-fullName form-control" id="form-fullName">
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="form-login">Login</label>
                                    <input type="text" name="login" placeholder="Login..."
                                           class="form-login form-control" id="form-login">
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="form-password">Password</label>
                                    <input type="password" name="password" placeholder="Password..."
                                           class="form-password form-control" id="form-password">
                                </div>

                                <button type="submit" class="btn">Sign me up!</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Footer -->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-sm-8 col-sm-offset-2">
                <div class="footer-border"></div>
                <p>Made by Anli Zaimi at <a href="http://azmind.com" target="_blank"><strong>AZMIND</strong></a>
                    having a lot of fun. <i class="fa fa-smile-o"></i></p>
            </div>
        </div>
    </div>
</footer>

<!-- Javascript -->
<script src="assets/js/jquery-1.11.1.min.js"></script>
<script src="assets/js/main_pages/bootstrap.min.js"></script>
<script src="assets/js/jquery.backstretch.min.js"></script>
<script src="assets/js/scripts.js"></script>

<!--[if lt IE 10]>
<script src="assets/js/placeholder.js"></script>
<![endif]-->
</body>
</html>
