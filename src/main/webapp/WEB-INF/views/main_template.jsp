<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title>Phone Catalog</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%--style libs--%>
    <link href="<s:url value="/resources" />/css/bootstrap.css" rel="stylesheet"/>
</head>

<body>
<div class="container">
    <a href="<s:url value="/home" />">home</a>

    <div id="top">
        <t:insertAttribute name="top"/> <!--<co id="co_tile_top" />-->
    </div>
    <div id="side">
        <t:insertAttribute name="side"/> <!--<co id="co_tile_side" />-->
    </div>
    <div id="content">
        <t:insertAttribute name="content"/> <!--<co id="co_tile_content" />-->
    </div>
</div>
<%--vendor libs--%>
<script src="<s:url value="/resources" />/js/bootstrap.js"></script>
<script src="<s:url value="/resources"/>/js/jquery-1.10.1.js"></script>
</body>
</html>