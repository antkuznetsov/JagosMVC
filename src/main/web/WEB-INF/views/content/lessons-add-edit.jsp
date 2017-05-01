<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="post" action="${action}">
    <div class="form-group">
        <label for="title">Название</label>
        <form:input path="title" cssClass="form-control" id="title"/>
    </div>
    <div class="form-group">
        <label for="content">Текст урока</label>
        <form:textarea path="content" cssClass="form-control" id="content" rows="20"/>
    </div>
    <form:hidden path="id"/>
    <form:hidden path="courseId"/>
    <button type="submit" class="btn btn-primary">Сохранить</button>
</form:form>