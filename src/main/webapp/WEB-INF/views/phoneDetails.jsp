<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<div class="container">
    <div class="jumbotron text-center">
        <h1>${phone.name}</h1>

        <p class="text-primary">Price: <fmt:formatNumber type="CURRENCY" currencySymbol="USD"
                                                         value="${phone.price}"/></p>

        <p class="text-muted"><em>"${phone.opinion}"</em></p>

        <a class="btn btn-default">Watch Now!</a>

        <a class="btn btn-primary">Tweet It!</a>
    </div>
</div>