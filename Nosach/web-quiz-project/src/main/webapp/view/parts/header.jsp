<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>

<div class="header">

    <nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse">

        <div class="collapse navbar-collapse" id="navbarsExampleDefault">

            <ul class="navbar-nav mr-auto">
                <li class="account-name">
                    Account: ${login}
                </li>
                <li class="account-name">
                    <a href="/logout">Log out</a>
                </li>
            </ul>


            <form class="form-inline mt-2 mt-md-0">
                <input class="form-control mr-sm-2" type="text" placeholder="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>

</div>

