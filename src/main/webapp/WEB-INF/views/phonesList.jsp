<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<div class="container">
    <c:forEach items="${phoneList}" var="phone">
        <div class="row">
            <s:url var="phoneDetailsUrl" value="/phone/details/{phoneId}">
                <s:param name="phoneId" value="${phone.id}"/>
            </s:url>
            <div class="panel panel-default">
                <div class="panel-body">
                    <h3>${phone.id}</h3>

                    <p>${phone.name}</p>
                    <a class="btn btn-default" href="${phoneDetailsUrl}"><s:message code="button.details"/></a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>