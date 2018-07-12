<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<form:form id="main-form"/>
<table align="center">
    <tbody>
    <tr>
        <td>
            <p class="text-center">
                <a href="?locale=en">en</a> | <a href="?locale=ru">ru</a> </p>
            <p class="text-center"> <spring:message code="login.message"/> </p>
        </td>
    </tr>
    <tr>
        <td>
            <p class="text-center">

            <c:if test="${not empty sessionScope.message}">
                <span style="color:red"><c:out value="${sessionScope.message}"/></span>
                <c:remove var="message" scope="session"/>
            </c:if>
            </p>
        </td>
    </tr>
    <tr>
        <td>
            <div class="form-label-group">
                <input type="text" name="userid" class="form-control" placeholder="Login" required autofocus form="main-form">
            </div>
        </td>
    </tr>

    <tr>
        <td>
            <div class="form-label-group">
                <input type="password" name="passwd" class="form-control" placeholder="Password" required autofocus form="main-form">
            </div>
        </td>
    </tr>

     <tr>
        <td>
            <button class="btn btn-lg btn-primary btn-block" type="submit" form="main-form"><spring:message code="login.button"/> </button>
        </td>


    </tr>
    <tr>
        <td>
            <div class="text-center button-bar">
                <a href="/signin">
                    <button class="btn btn-lg btn-outline-primary btn-block" type=button value="Sign up"><spring:message code="signup.button"/> </button>
                </a>
            </div>
        </td>
    </tr>
    </tbody>
</table>


</body>
</html>