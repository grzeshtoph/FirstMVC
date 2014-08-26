<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    </div>
</div>
<br/>
<br/>
<br/>
<br/>

<div class="container">
    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <c:if test="${loginError}">
                <div class="alert alert-danger"><s:message code="login.error" /></div>
            </c:if>
            <div class="panel panel-warning">
                <div class="panel-heading"><s:message code="label.login"/></div>
                <div class="panel-body">
                    <s:url value="/j_spring_security_check" var="submitUrl" />
                    <form method="post" role="form" action="${submitUrl}">
                        <div class="form-group <c:if test="${loginError}">has-feedback has-error</c:if>">
                            <label for="username"><s:message code="login.form.username"/></label>
                            <input type="text" class="form-control" id="username" name="j_username"/>
                        </div>
                        <div class="form-group <c:if test="${loginError}">has-feedback has-error</c:if>">
                            <label for="password"><s:message code="login.form.password"/></label>
                            <input type="password" class="form-control" id="password" name="j_password"/>
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" id="remember-me" name="_spring_security_remember_me">
                                <label for="remember-me">Remember me</label>
                            </label>
                        </div>
                        <input name="commit" type="submit" value="SignIn"/>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-sm-4"></div>
    </div>
</div>

<script type="text/javascript">
    document.getElementById('username').focus();
</script>

<%--vendor libs--%>
<script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="<s:url value="/resources" />/js/bootstrap.min.js"></script>
</body>
</html>