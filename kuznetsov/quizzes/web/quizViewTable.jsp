<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin=“anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<table border="1">
    <c:forEach items="${list}" var="t">
        <tr align="left">
            <td width="85"> ${t.subject}</td>
            <td width="300">${t.theme}</td>
            <td width="110">added by: ${t.login}</td>
            <td height="40">
                <input type="button" class="remove-button" value="Remove">
                   <script>
                    $(document).ready(function() {
                        $(".remove-button").click(function () {
                            $.ajax({
                                type: "delete",
                                url:  "/quiz?id=${t.id}"

                            })
                        });
                    });

                </script>

            </td>
        </tr>
    </c:forEach>
</table>



</body>
</html>