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
          href="${pageContext.request.contextPath}/resources/css/pass-the-quiz.css">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.min.css">
</head>
<body>

<%@include file="parts/header.jsp"%>

<div class="container-fluid">

    <div class="row">

        <jsp:include page="parts/sidebar.jsp">
            <jsp:param name="currentPage" value="list"/>
        </jsp:include>

        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">

            <div class="signup-form">
                <form action="/pass" method="post">
                    <h2>${question.getIssue()}</h2>
                    <hr>
                    <div class="container">
                        <div class="row clearfix">
                            <div class="col-md-12 column">
                                <table class="table table-bordered table-hover" id="tab_logic">
                                    <thead>
                                    <tr >
                                        <th class="text-center">
                                            #
                                        </th>
                                        <th class="text-center">
                                            Answer
                                        </th>
                                        <th class="text-center">
                                            Check if true
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody class="quiz-pass">
                                    <c:set var="id" value='0'/>
                                     <c:forEach var="answer" items="${question.getListOfAnswers()}">
                                         <c:set var="id" value="${id+1}"/>
                                         <tr>
                                             <td class="answer-num">${id}</td>
                                             <td>${answer.getAnswer()}</td>
                                             <td class="answer-chk">
                                                 <div class="custom-controls-stacked d-block my-3">
                                                     <label class="custom-control material-switch">
                                                         <span class="material-switch-control-description">No</span>
                                                         <input type="hidden" name="checkbox${id}" value="present"/>
                                                         <input type="checkbox" name="check${id}" class="material-switch-control-input" value="true"/>
                                                         <span class="material-switch-control-indicator"></span>
                                                         <span class="material-switch-control-description">Yes</span>
                                                     </label>
                                                 </div>
                                             </td>
                                         </tr>
                                     </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <hr class="under-form">
                    <input type="hidden" name="currentQuestion" value="${currentQuestion+1}"/>
                    <div class="container">
                        <div class="col-xs-6 text-left next-btn-div">
                            <button type="submit" name="save" value="Save Button" class="btn btn-default btn-lg">
                                Next >>
                            </button>
                        </div>
                    </div>
                </form>
            </div>


        </main>
    </div>
</div>


</body>
</html>