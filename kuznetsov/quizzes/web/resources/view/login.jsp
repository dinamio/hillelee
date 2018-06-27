<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html >
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin=?anonymous">
    <link href="http://getbootstrap.com/docs/4.0/examples/floating-labels/floating-labels.css" rel="stylesheet">
    <title>Quizzes login</title>
</head>
<body>

<form action='<spring:url value="/signin"/>' method="post">

        <div class="form-label-group">
            <td><input type="text" name="userid" class="form-control" placeholder="Login" required autofocus></td>
        </div>

        <div class="form-label-group">
            <td><input type="password" name="passwd"class="form-control" placeholder="Password" required autofocus></td>
        </div>

        <div class="text-center button-bar">
            <button class="btn btn-lg btn-primary btn-block" name="submit" type="submit" value="Sign in">Sign in</button>

            <button class="btn btn-lg btn-outline-primary btn-block" name="submit" type="submit" value="Sign up">Sign up</button>

        </div>


</form>

<c:if test="${not empty sessionScope.message}">
    <span style="color:green"><c:out value="${sessionScope.message}"/></span>
    <c:remove var="message" scope="session" />
</c:if>
</body>
</html>