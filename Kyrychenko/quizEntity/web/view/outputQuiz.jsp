<%--
  Created by IntelliJ IDEA.
  User: rpkyrych
  Date: 23.04.2018
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of the all entered quiz</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->

    <link rel="stylesheet" type="text/css" href="../assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../assets/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="../assets/fonts/iconic/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" type="text/css" href="../assets/vendor/animate/animate.css">
    <link rel="stylesheet" type="text/css" href="../assets/vendor/css-hamburgers/hamburgers.min.css">
    <link rel="stylesheet" type="text/css" href="../assets/vendor/animsition/css/animsition.min.css">
    <link rel="stylesheet" type="text/css" href="../assets/vendor/select2/select2.min.css">
    <link rel="stylesheet" type="text/css" href="../assets/vendor/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" type="text/css" href="../assets/vendor/noui/nouislider.min.css">
    <link rel="stylesheet" type="text/css" href="../assets/css/util.css">
    <link rel="stylesheet" type="text/css" href="../assets/css/main.css">
    <!--===============================================================================================-->
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark probootstrap-navabr-dark">
    <div class="container">
        <a class="navbar-brand" href="../index.html">Quiz adder</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#probootstrap-nav"
                aria-controls="probootstrap-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="probootstrap-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item probootstrap-cta probootstrap-seperator"><a href="quiz?action=add" class="nav-link">Add
                    Quiz</a></li>
                <li class="nav-item probootstrap-cta"><a href="quiz?action=view" class="nav-link">View All Quizzes</a>
                </li>
                <li class="nav-item probootstrap-cta"><a href="logout" class="nav-link">Logout</a></li>
            </ul>
        </div>
    </div>
</nav>


<div class="container-contact100">
    <div class="wrap-contact100">
        <div class="row">
            <div class="col-md-12">
                <h4>Quizzes list</h4>
                <br/>
                <div class="table-responsive">
                    <table id="mytable" class="table table-bordred table-striped">

                        <thead>

                        <th><input type="checkbox" id="checkall"/></th>
                        <th>Subjects</th>
                        <th>Topics</th>
                        <th>Author</th>

                        <th>Edit</th>
                        <th>Delete</th>
                        </thead>
                        <tbody>

                        <c:forEach var="quiz" items="${list}">
                            <tr>
                                <td><input type="checkbox" class="checkthis" name="id" value="${quiz.id}"/>
                                <td>${quiz.subject}</td>
                                <td>${quiz.topic}</td>
                                <td>${quiz.author}</td>

                                <td>
                                    <p data-placement="top" data-toggle="tooltip" title="Edit">
                                        <button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal"
                                                data-id="${quiz.id}" data-subject="${quiz.subject}"
                                                data-topic="${quiz.topic}"
                                                data-target="#edit"><i class="far fa-edit"></i></button>
                                    </p>
                                </td>
                                <td>
                                    <p data-placement="top" data-toggle="tooltip" title="Delete">
                                        <button class="btn btn-danger btn-xs" data-title="Delete"
                                                data-toggle="modal"
                                                data-id="${quiz.id}" data-target="#delete"><i
                                                class="far fa-trash"></i></button>
                                    </p>
                                </td>
                            </tr>
                        </c:forEach>

                        </tbody>

                    </table>

                    <%--<div class="clearfix"></div>--%>
                    <%--<ul class="pagination pull-right">--%>
                    <%--<li class="disabled"><a href="#"><span class="glyphicon glyphicon-chevron-left"></span></a></li>--%>
                    <%--<li class="active"><a href="#">1</a></li>--%>
                    <%--<li><a href="#">2</a></li>--%>
                    <%--<li><a href="#">3</a></li>--%>
                    <%--<li><a href="#">4</a></li>--%>
                    <%--<li><a href="#">5</a></li>--%>
                    <%--<li><a href="#"><span class="glyphicon glyphicon-chevron-right"></span></a></li>--%>
                    <%--</ul>--%>

                </div>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span
                        class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="Heading">Edit Your Detail</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <input class="form-control " type="hidden" name="dataID" value="">
                </div>
                <div class="form-group">
                    <p>Subject</p>
                    <input class="form-control " type="text" name="dataSubject" value="">
                </div>
                <div class="form-group">
                    <p>Topic</p>
                    <input class="form-control" type="text" name="dataTopic" value="">
                </div>

            </div>
            <div class="modal-footer ">
                <button type="button" id="update-confirm" class="btn btn-warning btn-lg" style="width: 100%;"><span
                        class="glyphicon glyphicon-ok-sign"></span> Update
                </button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>


<div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span
                        class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="Heading">Delete this entry</h4>
            </div>
            <div class="modal-body">

                <div class="alert alert-danger"><span class="glyphicon glyphicon-warning-sign"></span> Are you sure you
                    want to delete this Record?
                </div>

            </div>
            <div class="modal-footer ">
                <input type="hidden" name="dataID" value="">
                <button type="button" id="delete-confirm" class="btn btn-success">
                    <span class="glyphicon glyphicon-ok-sign"></span> Yes
                </button>
                <button type="button" class="btn btn-default" data-dismiss="modal"><span
                        class="glyphicon glyphicon-remove"></span> No
                </button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<!--===============================================================================================-->
<script src="../assets/vendor/jquery/jquery-3.2.1.min.js"></script>
<script src="../assets/vendor/animsition/js/animsition.min.js"></script>
<script src="../assets/vendor/bootstrap/js/popper.js"></script>
<script src="../assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="../assets/vendor/select2/select2.min.js"></script>
<script src="../assets/vendor/daterangepicker/moment.min.js"></script>
<script src="../assets/vendor/daterangepicker/daterangepicker.js"></script>
<script src="../assets/vendor/noui/nouislider.min.js"></script>
<script src="../assets/js/quiz-add-page-main.js"></script>
<script>
    $(document).ready(function () {
        $("#mytable #checkall").click(function () {
            if ($("#mytable #checkall").is(':checked')) {
                $("#mytable input[type=checkbox]").each(function () {
                    $(this).prop("checked", true);
                });

            } else {
                $("#mytable input[type=checkbox]").each(function () {
                    $(this).prop("checked", false);
                });
            }
        });

        $("[data-toggle=tooltip]").tooltip();
    });

    $('#edit').on('show.bs.modal', function (e) {
        var dataID = $(e.relatedTarget).data('id');
        $(e.currentTarget).find('input[name="dataID"]').val(dataID);
        var dataSubject = $(e.relatedTarget).data('subject');
        $(e.currentTarget).find('input[name="dataSubject"]').val(dataSubject);
        var dataTopic = $(e.relatedTarget).data('topic');
        $(e.currentTarget).find('input[name="dataTopic"]').val(dataTopic);
    });

    $('#update-confirm').click(function () {
        var quizID = $('.modal-body').find('input[name="dataID"]').val();
        var subject = $('.modal-body').find('input[name="dataSubject"]').val();
        var topic = $('.modal-body').find('input[name="dataTopic"]').val();
        $.ajax({
            url: '/quiz?quizID=' + quizID + '&subject=' + subject + '&topic=' + topic,
            type: 'PUT',
            success: (function () {
                location.reload();
            })
        })
    });

    $('#delete').on('show.bs.modal', function (e) {
        var dataID = $(e.relatedTarget).data('id');
        $(e.currentTarget).find('input[name="dataID"]').val(dataID);
    });

    $("#delete-confirm").click(function () {
        var quizID = $('#delete').find('input[name="dataID"]').val();
        $.ajax({
            url: '/quiz?quizID=' + quizID,
            type: 'DELETE',
            success: (function () {
                location.reload();
            })
        })
    });
</script>
</body>
</html>
