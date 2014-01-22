<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<h2>${greeting}</h2>
<ul>
    <c:forEach items="${phoneList}" var="phone">
        <s:url var="phoneDetailsUrl" value="/phone/details?id={phoneId}">
            <s:param name="phoneId" value="${phone.id}"/>
        </s:url>

        <li>
            <a href="${phoneDetailsUrl}">${phone.id}</a>, ${phone.name}
        </li>
    </c:forEach>
</ul>