<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<link type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/header.css">

<div class="header">

    <div class="account"> Account: ${login}</div>
   <div class="logout"><a href="/logout">Log out</a></div>

</div>
