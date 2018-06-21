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
          href="${pageContext.request.contextPath}/resources/css/question-page.css">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.min.css">
    <script src="${pageContext.request.contextPath}/resources/js/questions-page.js"></script>
</head>
<body>

<%@include file="parts/header.jsp"%>

<div class="container-fluid">

    <div class="row">

        <jsp:include page="parts/sidebar.jsp">
            <jsp:param name="currentPage" value="add"/>
        </jsp:include>

        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">


            <div class="signup-form">
                <form action="/question" method="post">
                    <h2>Add new Quize</h2>
                    <hr>
                    <h4>Enter question №${questionsCount+1}</h4>
                    <div class="container">
                        <input type="text" name='question'  placeholder='Example: What day is today?' class="form-control" required="required"/>
                    </div>
                    <hr>
                    <h4>Enter answers</h4>
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
                                            True/False
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr id='addr0'>
                                        <td>
                                            1
                                        </td>
                                        <td>
                                            <input type="text" name='answer0'  placeholder='Answer' class="form-control" required="required"/>
                                        </td>
                                        <td>
                                            <div class="custom-controls-stacked d-block my-3">
                                                <label class="custom-control material-switch">
                                                    <span class="material-switch-control-description">False</span>
                                                    <input type="checkbox" name="check0" id="checkbox0" class="material-switch-control-input"/>
                                                    <span class="material-switch-control-indicator"></span>
                                                    <span class="material-switch-control-description">True</span>
                                                </label>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr id='addr1'></tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <a id='delete_row' class="pull-left" href="#">Delete</a><a id="add_row" class="pull-right" href="#">Add</a>
                    </div>
                    <hr class="under-form">
                    <div class="container">

                        <input type="hidden" name="questionsCount" value="${questionsCount}">

                        <div class="col-xs-6 text-left save-btn-div">
                            <button type="submit" name="save" value="Save Button" class="btn btn-default btn-lg">
                                Save Quiz
                            </button>

                        </div>
                        <div class="col-xs-6 text-right add-btn-div">
                            <button type="submit" name ="add" value ="Add Button" class="btn btn-default btn-lg">
                                Add Question
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