<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Title</title>
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
    <table>
        <tr>
            <th>${quiz.getName()}</th>
        </tr>
        <tr>
            <td>${quiz.getDescription()}</td>
        </tr>
    </table>

    <form action="/quiz" method="post">
        <input type="hidden" name="name" value="${quiz.getName()}">
        <input type="submit" value="Remove">
    </form>

</body>
</html>
