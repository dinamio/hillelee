<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <head>
        <title>Quiz</title>
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }
            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }
            tr:nth-child(even) {
                background-color: #dddddd;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h2>${quiz.getName()}</h2>
            <p>${quiz.getDescription()}</p>
            <button class="submit" >Remove</button>
        </div>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script>
        $(document).ready(function () {
            $(".submit").click(function () {
                $.ajax({
                    url: '/quiz',
                    method: 'POST',
                    data: {name: '${quiz.getName()}'},
                    dataType: 'json',
                    success: function (result) {
                        location.href = "/quizzes";
                    }
                });
            });
        });
    </script>
    </body>
</html>
