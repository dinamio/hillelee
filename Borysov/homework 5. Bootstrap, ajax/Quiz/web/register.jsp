<%--
  Created by IntelliJ IDEA.
  User: Denys
  Date: 23.04.2018
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<%@include file="/head.jsp"%>
<body>

<div id="main">
    <div id="header">
        <div id="logo">
            <div id="logo_text">
                <h1><a href="index.jsp"><span class="logo_colour">Quiz</span></a></h1>
            </div>
        </div>
    </div>



    <div id="site_content">
        <div class="sidebar">

        </div>
        <div id="content">

            <h2>Registration</h2>
            <form:form method="post" action="/register" modelAttribute="regModel">
                <h3>login</h3>
                <input required class="form-control" type="text" name="login"/>
                <h3>password</h3>
                <input required class="form-control" type="password" name="password"/>
                <h3>name</h3>
                <input required class="form-control" type="text" name="name"/>
                <br/>
                <button type="button" class="btn"><a href="index.jsp">Cancel</a></button>
                <input type="submit" class="btn btn-primary active" value="Register"/>

            </form:form>
        </div>
    </div>

    <div id="footer">
        Quizzes | <a href="#">1</a> | <a href="#">2</a> | <a href="#">3</a>
    </div>



</div>

</body>
</html>
