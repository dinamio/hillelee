<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=utf-8" %>

<head>
    <title>Add Quiz</title>
    <link href="https://v4-alpha.getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/result.css">
</head>
<body>

<%@include file="parts/header.jsp"%>

<div class="container-fluid">

    <div class="row">

        <jsp:include page="parts/sidebar.jsp">
            <jsp:param name="currentPage" value="stat"/>
        </jsp:include>

        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">

            <div class="signup-form">
                <c:set var="userAnswersId" value="0"/>
                <c:forEach var="question" items="${quiz.getQuestionsList()}">
                    <h4>${question.getIssue()}</h4>
                    <table class="table table-bordered table-hover" id="tab_logic">
                        <thead>
                        <tr >
                            <th class="text-center answer-num">
                                #
                            </th>
                            <th class="text-center answer-opt">
                                Options
                            </th>
                            <th class="text-center answer-corr">
                                Your answer was:
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:set var="id" value="0"/>
                        <c:set var="userAnswers" value="${question.getListOfAnswers()}"/>
                            <c:forEach var="answer" items="${userAnswers}">
                                <tr>
                                    <c:set var="id" value="${id+1}"/>
                                    <td class="answer-num">${id}</td>
                                    <td class="answer-opt">${answer.getAnswer()}</td>
                                    <td class="answer-corr ${answers.get(userAnswersId) eq answer.isCorrect() ? 'green-line':'red-line'}">
                                        ${answers.get(userAnswersId) eq answer.isCorrect() ? 'right!':'wrong!'}
                                    </td>
                                </tr>
                                <c:set var="userAnswersId" value="${userAnswersId+1}"/>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:forEach>
            </div>


        </main>
    </div>
</div>


</body>
</html>