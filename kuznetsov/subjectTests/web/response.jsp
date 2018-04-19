<%--
  Created by IntelliJ IDEA.
  User: Prog3
  Date: 17.04.2018
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Response</title>
</head>
<body>

<form method="POST">
    <table  border="1">
        <c:forEach items="${list}" var="t">
            <tr align="left">
                <td width="85" > ${t.subject}</td>
                <td width="410">${t.theme}</td>
                <td HEIGHT="40">
                    <form method="POST">
                        <input type="hidden" name="Id" value="${t.id}"/>
                        <input type="submit" value="Remove" name="remove">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
