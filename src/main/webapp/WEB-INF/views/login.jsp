<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
        <span class="navbar-brand"><s:message code="app.title"/></span>
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
            <div class="panel panel-warning">
                <div class="panel-heading"><s:message code="label.login"/></div>
                <div class="panel-body">

                </div>
            </div>
        </div>
        <div class="col-sm-4"></div>
    </div>
</div>

<%--vendor libs--%>
<script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="<s:url value="/resources" />/js/bootstrap.min.js"></script>
</body>
</html>

<%--<div>--%>
<%--<s:url var="authUrl" value="/j_spring_security_check"/>--%>

<%--<form method="post" action="${authUrl}">--%>
<%--<fieldset>--%>
<%--<table cellspacing="0">--%>
<%--<tr>--%>
<%--<th>--%>
<%--<label for="username_or_email">UsernameorEmail</label></th>--%>
<%--<td>--%>
<%--<input id="username_or_email"--%>
<%--name="j_username"--%>
<%--type="text"/>--%>
<%--</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<th>--%>
<%--<label for="password">Password</label></th>--%>
<%--<td>--%>
<%--<input id="password"--%>
<%--name="j_password"--%>
<%--type="password"/>--%>
<%--<small><a href="/account/resend_password">Forgot?</a></small>--%>
<%--</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<th></th>--%>
<%--<td>--%>
<%--<input id="remember_me"--%>
<%--name="_spring_security_remember_me"--%>
<%--type="checkbox"/>--%>
<%--<label for="remember_me"--%>
<%--class="inline">Rememberme</label></td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<th></th>--%>
<%--<td>--%>
<%--<input name="commit" type="submit" value="SignIn"/></td>--%>
<%--</tr>--%>
<%--</table>--%>
<%--</fieldset>--%>
<%--</form>--%>

<%--<script type="text/javascript">--%>
<%--document.getElementById('username_or_email').focus();--%>
<%--</script>--%>
<%--</div>--%>