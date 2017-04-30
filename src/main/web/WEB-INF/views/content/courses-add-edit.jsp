<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="post" action="${action}">
    <div class="form-group">
        <label for="title">Название</label>
        <form:input path="title" cssClass="form-control" id="title"/>
    </div>
    <div class="form-group">
        <label for="description">Описание</label>
        <form:input path="description" cssClass="form-control" id="description"/>
    </div>
    <div class="form-group">
        <label for="authorId">Автор</label>>
        <form:select path="authorId" cssClass="form-control" id="authorId">
            <form:options/>
        </form:select>
    </div>
    <form:hidden path="id"/>
    <button type="submit" class="btn btn-primary">Сохранить</button>
</form:form>
<br>
<h2>Список уроков</h2>
<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>Название</th>
            <th>Управление</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.lessons}" var="lesson">
            <tr>
                <td><c:out value="${lesson.id}"/></td>
                <td><c:out value="${lesson.title}"/></td>
                <td>
                    <a class="edit" href="/lessons/?action=edit&id=<c:out value="${lesson.id}"/>">Редактировать</a>
                    <a class="delete" href="/lessons/?action=delete&id=<c:out value="${lesson.id}"/>&course=<c:out value="${courseId}"/>">Удалить</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/lessons/?action=add&course=<c:out value="${courseId}" />" class="add btn btn-primary">Добавить</a><br>
</div>