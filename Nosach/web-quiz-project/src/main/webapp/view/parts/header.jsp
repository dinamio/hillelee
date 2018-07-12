<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/header.css">

<div class="header">

    <nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse">

        <div class="collapse navbar-collapse" id="navbarsExampleDefault">

            <ul class="navbar-nav mr-auto">
                <li class="account-name">
                    <spring:message code="header.account"/>: <sec:authentication property="principal.username"/>
                </li>
                <li class="account-name logout-href" >
                    <a href="/logout"><spring:message code="header.logout"/></a>
                </li>
                <spring:url value="${requestScope['javax.servlet.forward.request_uri']}" var="url" htmlEscape="true"/>
                <c:choose>
                    <c:when test="${empty param['subj']}">
                        <li><a href="${url}?locale=en"
                               class="language" rel="en-Us"><img src="${pageContext.request.contextPath}/resources/images/en_US.png" alt="English" />
                        </a></li>
                        <li><a href="${url}?locale=ru"
                               class="language" rel="uk-Ua"><img src="${pageContext.request.contextPath}/resources/images/uk_UA.png" alt="Ukrainian" />
                        </a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${url}?subj=${param['subj']}&locale=en"
                               class="language" rel="en-Us"><img src="${pageContext.request.contextPath}/resources/images/en_US.png" alt="English" />
                        </a></li>
                        <li><a href="${url}?subj=${param['subj']}&locale=ru"
                               class="language" rel="uk-Ua"><img src="${pageContext.request.contextPath}/resources/images/uk_UA.png" alt="Ukrainian" />
                        </a></li>
                    </c:otherwise>
                </c:choose>
            </ul>


            <form class="form-inline mt-2 mt-md-0">
                <input class="form-control mr-sm-2" type="text" placeholder="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit"><spring:message code="header.search"/></button>
            </form>
        </div>
    </nav>

</div>

