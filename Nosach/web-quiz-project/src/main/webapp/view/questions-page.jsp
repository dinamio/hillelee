<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=utf-8" %>

<head>
    <title>Add Quiz</title>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <link href="https://v4-alpha.getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/question-page.css">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.min.css">
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/questions-page.js"></script>
</head>
<body>

<%@include file="parts/header.jsp"%>

<div class="container-fluid">
    <div class="row">
        <nav class="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar">
            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a class="nav-link" href="#">Overview</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="#">Add quiz<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Statistics</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Account</a>
                </li>
            </ul>

        </nav>

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
                                            <div class="col-md-4">
                                                    <div class="checkbox checkbox-primary">
                                                        <input name="check0" id="checkbox0" type="checkbox" >
                                                        <label for="checkbox0">
                                                            check if true
                                                        </label>
                                                    </div>
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
                    <hr>
                    <div class="container">

                        <input type="hidden" name="questionsCount" value="${questionsCount}">

                        <div class="col-xs-6 text-left">
                            <button type="submit" name="save" value="Save Button" class="btn btn-default btn-lg">
                                Save Quiz
                            </button>

                        </div>
                        <div class="col-xs-6 text-right">
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