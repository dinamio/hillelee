<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<link type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/sidebar.css">

<nav class="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar">
    <ul class="nav nav-pills flex-column">
        <li class="nav-item">
            <c:choose>
                <c:when test="${param.currentPage eq 'list'}">
                    <a class="nav-link active" href="/available"><spring:message code="sidebar.overview"/><span class="sr-only">(current)</span></a>
                </c:when>
                <c:otherwise>
                    <a class="nav-link" href="/available"><spring:message code="sidebar.overview"/></a>
                </c:otherwise>
            </c:choose>
        </li>
        <li class="nav-item">
            <c:choose>
                <c:when test="${param.currentPage eq 'add'}">
                    <a class="nav-link active" href="add"><spring:message code="sidebar.add"/><span class="sr-only">(current)</span></a>
                </c:when>
                <c:otherwise>
                    <a class="nav-link" href="/add"><spring:message code="sidebar.add"/></a>
                </c:otherwise>
            </c:choose>
        </li>
        <li class="nav-item">
            <c:choose>
                <c:when test="${param.currentPage eq 'stat'}">
                    <a class="nav-link active" href="#"><spring:message code="sidebar.statistic"/><span class="sr-only">(current)</span></a>
                </c:when>
                <c:otherwise>
                    <a class="nav-link" href="#"><spring:message code="sidebar.statistic"/></a>
                </c:otherwise>
            </c:choose>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#"><spring:message code="sidebar.account"/></a>
        </li>
    </ul>

</nav>