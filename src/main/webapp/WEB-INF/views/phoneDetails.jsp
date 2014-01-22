<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h2>${phone.name}</h2>
<p>${phone.opinion}</p>
<p><fmt:formatNumber type="CURRENCY" currencySymbol="USD" value="${phone.price}"/></p>