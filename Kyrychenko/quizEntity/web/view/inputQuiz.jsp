<%--
  Created by IntelliJ IDEA.
  User: rpkyrych
  Date: 20.04.2018
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quiz adding form</title>
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
        <form class="contact100-form validate-form" action="quiz" method="post">
                    <span class="contact100-form-title">
                        Add quiz
                    </span>

            <div class="wrap-input100 validate-input bg1" data-validate="Please Add Subject Here">
                <span class="label-input100">SUBJECT *</span>
                <input class="input100" type="text" name="subject" placeholder="Enter Subject">
            </div>

            <div class="wrap-input100 validate-input bg1" data-validate="Please Add Topic Here">
                <span class="label-input100">TOPIC *</span>
                <input class="input100" type="text" name="topic" placeholder="Enter Topic">
            </div>

            <div class="wrap-input100 validate-input bg0 rs1-alert-validate" data-validate="Please Type Your Quiz">
                <span class="label-input100">Quiz</span>
                <textarea class="input100" name="message" placeholder="Type your quiz here..."></textarea>
            </div>

            <div class="wrap-input100 input100-select bg1">
                <span class="label-input100">Quiz Type *</span>
                <div>
                    <select class="js-select2" name="service">
                        <option>Please chooses</option>
                        <option>Single Choice</option>
                        <option>Multi-Select</option>
                        <option>Text Answer</option>
                    </select>
                    <div class="dropDownSelect2"></div>
                </div>
            </div>


            <div class="w-full dis-none js-show-service">
                <div class="wrap-contact100-form-radio">
                    <span class="label-input100">How much answers must be?</span>

                    <div class="contact100-form-radio m-t-15">
                        <input class="input-radio100" id="radio1" type="radio" name="type-product" value="physical"
                               checked="checked">
                        <label class="label-radio100" for="radio1">
                            3 answer options
                        </label>
                    </div>

                    <div class="contact100-form-radio">
                        <input class="input-radio100" id="radio2" type="radio" name="type-product" value="digital">
                        <label class="label-radio100" for="radio2">
                            4 answer options
                        </label>
                    </div>

                    <div class="contact100-form-radio">
                        <input class="input-radio100" id="radio3" type="radio" name="type-product" value="service">
                        <label class="label-radio100" for="radio3">
                            5 answer options
                        </label>
                    </div>
                </div>
            </div>


            <div class="container-contact100-form-btn">
                <button class="contact100-form-btn">
                            <span>
                                Add Quiz
                                <i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i>
                            </span>
                </button>
            </div>
        </form>
    </div>
</div>


<!--===============================================================================================-->
<script src="../assets/vendor/jquery/jquery-3.2.1.min.js"></script>
<script src="../assets/vendor/animsition/js/animsition.min.js"></script>
<script src="../assets/vendor/bootstrap/js/popper.js"></script>
<script src="../assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="../assets/vendor/select2/select2.min.js"></script>
<script>
    $(".js-select2").each(function () {
        $(this).select2({
            minimumResultsForSearch: 20,
            dropdownParent: $(this).next('.dropDownSelect2')
        });


        $(".js-select2").each(function () {
            $(this).on('select2:close', function (e) {
                if ($(this).val() == "Please chooses") {
                    $('.js-show-service').slideUp();
                }
                else {
                    $('.js-show-service').slideUp();
                    $('.js-show-service').slideDown();
                }
            });
        });
    })
</script>
<script src="../assets/vendor/daterangepicker/moment.min.js"></script>
<script src="../assets/vendor/daterangepicker/daterangepicker.js"></script>
<script src="../assets/vendor/noui/nouislider.min.js"></script>
<script src="../assets/js/quiz-add-page-main.js"></script>

</body>
</html>
