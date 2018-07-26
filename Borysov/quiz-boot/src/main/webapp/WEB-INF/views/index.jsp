<%--
  Created by IntelliJ IDEA.
  User: Denys
  Date: 23.04.2018
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<%@include file="head.jsp"%>

<body>
<div id="main">
    <div id="header">
        <div id="logo">
            <div id="logo_text">
                <h1><a href="index.jsp"><span class="logo_colour"> <spring:message code="title"/></span></a></h1>
            </div>
            <a href="?locale=ru">RU</a>
            <a href="?locale=en">EN</a>
        </div>
    </div>



    <div id="site_content">
        <div class="sidebar">
            <c:if test="${requestScope.errorLogIn!=null}">
                <c:out value="Invalid params"/>
            </c:if>
            <h3><spring:message code="index.log_in"/></h3>
            <form method="post" action="/login" class="form-group">
                <h3><spring:message code="form.login"/></h3>
                <input class="form-control" required type="text" name="login_field"/>
                <h3><spring:message code="form.password"/></h3>
                <input class="form-control" required type="password" name="password_field"/>
                <br/>
                <input type="submit" class="btn btn-primary btn-lg active" value="<spring:message code="index.log_in"/>"/>

            </form>
            <spring:message code="form.or"/> <a href="/register"><spring:message code="form.register"/></a>

        </div>
        <div id="content">
            <h1><spring:message code="index.text"/></h1>

        </div>
    </div>

    <div id="footer">
        <spring:message code="footer"/> | <a href="#">1</a> | <a href="#">2</a> | <a href="#">3</a>
    </div>



</div>
</body>

</html>
