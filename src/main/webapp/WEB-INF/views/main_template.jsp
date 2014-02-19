<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title><s:message code="app.title"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%--style libs--%>
    <link href="<s:url value="/resources" />/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="<s:url value="/resources" />/css/style.css" rel="stylesheet"/>
</head>
<body>
<div class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <a href="<s:url value="/home"/>" class="navbar-brand"><s:message code="app.title"/></a>

        <button class="navbar-toggle" data-toggle="collapse" data-target=".navHeaderCollapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>

        <div class="collapse navbar-collapse navHeaderCollapse">
            <ul class="nav navbar-nav">
                <li <c:if test="${pageActive eq 'home'}">class="active"</c:if>>
                    <a href="<s:url value="/home"/>"><s:message code="button.home"/></a>
                </li>
                <li <c:if test="${pageActive eq 'new'}">class="active"</c:if>>
                    <a href="<s:url value="/phone/new"/>"><s:message code="button.new"/></a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <s:message code="button.language"/> <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="<s:url value="?lang=en"/>"><s:message code="button.language.en"/></a></li>
                        <li><a href="<s:url value="?lang=pl"/>"><s:message code="button.language.pl"/></a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <s:message code="button.other"/> <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#"><s:message code="button.about"/></a></li>
                        <li><a href="#"><s:message code="button.contact"/></a></li>
                    </ul>
                </li>
            </ul>

            <sf:form method="GET" servletRelativeAction="/phones/list">
                <div class="nav navbar-right navbar-btn input-group col-sm-3">
                    <input type="text" class="form-control" placeholder="<s:message code="placeholder.name"/>"
                           name="name"/>
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="submit"><s:message code="button.search"/></button>
                    </span>
                </div>
            </sf:form>
        </div>
    </div>
</div>

<t:insertAttribute name="content"/>

<div class="navbar navbar-default navbar-fixed-bottom">
    <div class="container">
        <p class="navbar-text pull-left"><s:message code="footer.info"/></p>
        <a class="navbar-btn btn btn-danger pull-right" href="https://twitter.com/grzeshtoph" target="_blank">
            <s:message code="footer.button.twitter"/></a>
    </div>
</div>

<%--vendor libs--%>
<script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="<s:url value="/resources" />/js/bootstrap.min.js"></script>
</body>
</html>