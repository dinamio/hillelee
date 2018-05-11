<%--
  Created by IntelliJ IDEA.
  User: eugen
  Date: 4/13/18
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Books</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<table class="table">
    <thead>
    <tr>
        <th>Id</th>
        <th>Book</th>
        <th>Author</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.author}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form action="/book" method="post">
    <input name="title">
    <input name="author">
    <input type="submit" value="Создать">
</form>
<input type="button" class="my-button" value="Добавить случайную книгу">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
    $(document).ready(function () {
        $(".my-button").click(function () {
            $.ajax({
                type: "POST",
                url: "/book",
                success: function () {
                    location.reload();
                }

            })
        });
    });
</script>
</body>
</html>
