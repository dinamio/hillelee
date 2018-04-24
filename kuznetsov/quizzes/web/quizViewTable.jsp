<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<table border="1">
    <c:forEach items="${list}" var="t">
        <tr align="left">
            <td width="85"> ${t.subject}</td>
            <td width="300">${t.theme}</td>
            <td width="110">added by: ${t.login}</td>
            <td height="40">
                <form method="POST">
                    <input type="hidden" name="Id" value="${t.id}"/>
                    <input type="submit" value="Remove" name="remove">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>