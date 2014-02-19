<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<div class="container">
    <div class="jumbotron text-center">
        <h1>${greeting}</h1>

        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur suscipit erat id enim dignissim, tristique
            aliquet diam sodales. Nulla placerat suscipit ultrices. Proin tortor quam, egestas fringilla dapibus ac,
            tincidunt non sapien. Praesent dignissim, odio semper tristique consectetur, neque arcu dictum elit, ut
            mollis nisl eros at urna. Vivamus at ligula blandit, tristique augue sit amet, elementum velit. Fusce
            lobortis, risus ac egestas dapibus, nisi urna facilisis risus, aliquam ultrices ligula purus et sem. Nulla
            in risus in risus placerat gravida. Vestibulum tristique lacus at tellus consequat blandit. Suspendisse quis
            lacus sapien. Nullam nec justo sit amet leo semper suscipit. Donec egestas pharetra elit. Curabitur diam
            lacus, semper interdum eros eget, iaculis porta purus. Etiam eu varius magna. Morbi vel diam a odio
            facilisis lobortis at ac turpis.</p>

        <a class="btn btn-default"><s:message code="button.watchNow"/></a>

        <a class="btn btn-primary"><s:message code="button.tweetIt"/></a>
    </div>
</div>

<div class="container">
    <div class="row">
        <c:forEach items="${phoneList}" var="phone">
            <s:url var="phoneDetailsUrl" value="/phone/details/{phoneId}">
                <s:param name="phoneId" value="${phone.id}"/>
            </s:url>
            <s:url var="editPhoneUrl" value="/phone/edit/{phoneId}">
                <s:param name="phoneId" value="${phone.id}"/>
            </s:url>
            <div class="col-sm-3">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h3>${phone.id}</h3>

                        <p>${phone.name}</p>
                        <a class="btn btn-default" href="${phoneDetailsUrl}"><s:message code="button.details"/></a>
                        <a class="btn btn-warning" href="${editPhoneUrl}"><s:message code="button.edit"/></a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>