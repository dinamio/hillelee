<%--
  Created by IntelliJ IDEA.
  User: eugen
  Date: 4/13/18
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
</head>
We are at the library <%= request.getAttribute("book")%>

<input type="button" class="my-button" value="Добавить случайную книгу">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
    $(document).ready(function () {
        $(".my-button").click(function () {
            $.ajax({
                type: "POST",
                url: "/book",
                success: function() {
                    location.reload();
                }

            })
        });
    });
</script>
</body>
</html>
