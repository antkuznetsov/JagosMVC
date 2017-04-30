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
        <label for="group">Группа</label>
        <form:select path="group" cssClass="form-control" id="group">
            <form:option value="1">Администратор</form:option>
            <form:option value="2">Пользователь</form:option>
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