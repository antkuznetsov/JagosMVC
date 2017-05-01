<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="ru">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <title>${title}</title>

        <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
        <link href="/resources/css/dashboard.css" rel="stylesheet">
    </head>

    <body>
        <nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse">
            <button class="navbar-toggler navbar-toggler-right hidden-lg-up" type="button" data-toggle="collapse"
                    data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand" href="/dashboard/">Jagos</a>

            <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Главная</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Настройки</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Профиль</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Помощь</a>
                    </li>
                </ul>
                <div class="form-inline mt-2 mt-md-0">
                    <button onclick="window.location = '/auth/?logout'" class="btn btn-outline-success my-2 my-sm-0"
                            type="submit">Выход
                    </button>
                </div>
            </div>
        </nav>

        <div class="container-fluid">
            <div class="row">
                <nav class="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar">
                    <ul class="nav nav-pills flex-column">
                        <li class="nav-item">
                            <a class="nav-link" href="/dashboard/">Обзор</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/courses/">Курсы</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Комментарии</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/users/">Пользователи</a>
                        </li>
                    </ul>
                </nav>

                <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">
                    <h1>${title}</h1>
                    <tiles:insertAttribute name="body"/>
                </main>
            </div>
        </div>
    </body>
</html>