<%--
  Created by IntelliJ IDEA.
  User: eugen
  Date: 4/13/18
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td><input type="button" class="my-button btn-danger" book-id="${book.id}" value="Удалить">
                <a href="/book/${book.id}/edit" class="my-button btn-danger" >Редактировать</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
Hello, <sec:authentication property="principal.username"/>
<sec:authorize access="hasAuthority('ADMIn')">
<form:form action="/book" method="post" modelAttribute="bookToAdd">
    <input name="name">
    <input name="author">
    <input type="submit" value="Создать">
</form:form>
</sec:authorize>
<input type="button" class='logout' value="Logout">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
    $(document).ready(function () {
        $(".my-button").click(function () {
            var bookId = $(this).attr("book-id");
            $.ajax({
                type: "DELETE",
                url: "/book/"+bookId,
                success: function () {
                    location.reload();
               }

            })
        });
        $(".logout").click(function () {
            var csrf='${_csrf.token}';
            $.ajax({
                type: "POST",
                url: "/logout?_csrf="+csrf,
                success: function () {
                    location.reload();
                }

            })
        });
    });
</script>
</body>
</html>
