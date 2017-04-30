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