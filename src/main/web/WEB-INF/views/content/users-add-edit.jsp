<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="post" action="${action}">
    <div class="form-group">
        <label for="name">Ваше имя</label>
        <form:input path="name" cssClass="form-control" id="name"/>
    </div>
    <div class="form-group">
        <label for="lastName">Ваша фамилия</label>
        <form:input path="lastName" cssClass="form-control" id="lastName"/>
    </div>
    <div class="form-group">
        <label for="email">Электронная почта</label>
        <form:input path="email" cssClass="form-control" id="email"/>
    </div>
    <div class="form-group">
        <label for="password">Пароль</label>
        <form:password path="password" cssClass="form-control" id="password"/>
    </div>
    <div class="form-group">
        <label for="groupId">Группа</label>
        <form:select path="groupId" cssClass="form-control" id="groupId">
            <form:option value="0" disabled="true">Выберите группу</form:option>
            <form:options items="${groups}"/>
        </form:select>
    </div>
    <div class="form-check">
        <label class="form-check-label">
            <form:checkbox path="blocked" cssClass="form-check-input"/>
            Заблокировать
        </label>
    </div>
    <form:hidden path="id"/>
    <button type="submit" class="btn btn-primary">Сохранить</button>
</form:form>