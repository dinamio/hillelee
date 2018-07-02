<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <link href="https://v4-alpha.getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/available-subjects.css">
</head>
<body>

<%@include file="parts/header.jsp"%>

<div class="container-fluid">
    <jsp:include page="parts/sidebar.jsp">
        <jsp:param name="currentPage" value="list"/>
    </jsp:include>

        <section id="team" class="pb-5">
            <div class="container">
                <h5 class="section-title h1">Available subjects</h5>
                <div class="row">

                    <div class="col-xs-12 col-sm-6 col-md-4">
                        <div class="image-flip" ontouchstart="this.classList.toggle('hover');">
                            <div class="mainflip">
                                <div class="frontside">
                                    <div class="card">
                                        <div class="card-body text-center">
                                            <h4 class="card-title">All Subjects</h4>
                                            <a href="#" class="btn btn-primary btn-sm"><i class="fa fa-plus"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="backside">
                                    <div class="card">
                                        <div class="card-body text-center mt-4">
                                            <h4 class="card-title">All Subjects</h4>
                                            <p class="card-text">Number of Quizzies in all Subjects: ${totalQuizzies}</p>
                                            <a class="social-icon text-xs-center" href="/list?subj=all">
                                                See quizzies for this subject
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <c:forEach var="subject" items="${subjects}">

                    <div class="col-xs-12 col-sm-6 col-md-4">
                        <div class="image-flip" ontouchstart="this.classList.toggle('hover');">
                            <div class="mainflip">
                                <div class="frontside">
                                    <div class="card">
                                        <div class="card-body text-center">
                                            <h4 class="card-title">${subject.getSubjectName()}</h4>
                                            <a href="#" class="btn btn-primary btn-sm"><i class="fa fa-plus"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="backside">
                                    <div class="card">
                                        <div class="card-body text-center mt-4">
                                            <h4 class="card-title">${subject.getSubjectName()}</h4>
                                            <p class="card-text">Number of Quizzies in this Subject: ${subject.getQuizList().size()}</p>
                                            <a class="social-icon text-xs-center" href="/list?subj=${subject.getId()}">
                                                See quizzies for this subject
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    </c:forEach>

                </div>
            </div>
        </section>

</div>

</body>
</html>
