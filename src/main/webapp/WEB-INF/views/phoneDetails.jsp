<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<div class="container">
    <div class="row">
        <div class="col-lg-9">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="page-header">
                        <h3>${phone.name}</h3>
                    </div>
                    <h4><em>"${phone.opinion}"</em></h4>

                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc eu adipiscing lectus, a placerat
                        elit. Vivamus feugiat congue libero, nec semper justo iaculis a. Praesent dignissim odio id urna
                        tincidunt porttitor. Etiam sit amet arcu sit amet urna malesuada aliquam. Donec auctor nisl eu
                        lacus interdum feugiat. Aliquam erat volutpat. Morbi vitae magna eget sem vulputate fermentum ac
                        ac lectus. Nullam vitae ipsum ac quam pharetra ultricies a nec ligula. Pellentesque consequat ut
                        dui non vulputate. Vestibulum commodo, purus eget molestie tempor, purus eros accumsan dui, id
                        imperdiet orci dolor in leo. Nunc laoreet tellus nec tellus viverra pulvinar. Nam consequat
                        pretium fringilla.</p>

                    <p>Mauris feugiat fringilla lectus. Sed vitae velit quis elit accumsan dictum. Fusce eget odio quis
                        odio ultricies luctus ut sed mauris. Phasellus eget turpis venenatis, tempor urna sit amet,
                        sollicitudin augue. Proin vitae quam interdum, dapibus justo ac, commodo magna. Ut congue
                        placerat quam, non iaculis erat porttitor vel. Nunc commodo justo quis sapien ornare dignissim.
                        Etiam vehicula ultrices nibh at ultrices. Fusce condimentum tincidunt nibh, et ultrices nunc
                        aliquam ac. Sed lobortis ac nunc eu fringilla. Morbi sollicitudin pellentesque sem, ac pulvinar
                        libero tempor eu. Nulla neque mi, sollicitudin nec adipiscing vel, bibendum sit amet mi.</p>

                    <p>Aenean laoreet neque turpis, nec dapibus magna fermentum a. Pellentesque tempor dapibus
                        sollicitudin. Nulla facilisi. Curabitur in odio luctus, mattis ipsum sit amet, cursus turpis.
                        Duis dapibus faucibus orci, eu ornare arcu elementum et. Cum sociis natoque penatibus et magnis
                        dis parturient montes, nascetur ridiculus mus. Curabitur in erat semper ante egestas condimentum
                        a vel sem. Proin malesuada dictum ipsum, ac tristique magna. Nulla sodales purus in vestibulum
                        volutpat.</p>

                    <p class="text-primary text-left"><s:message code="label.price"/>&nbsp;<fmt:formatNumber type="CURRENCY"
                                                                                                        currencySymbol="USD "
                                                                                                        value="${phone.price}"/></p>

                </div>

                <div class="panel-footer text-right">
                    <s:url var="editPhoneUrl" value="/phone/edit/{phoneId}">
                        <s:param name="phoneId" value="${phone.id}"/>
                    </s:url>

                    <a class="btn btn-default"><s:message code="button.watchNow"/></a>

                    <a class="btn btn-warning" href="${editPhoneUrl}"><s:message code="button.edit"/></a>
                </div>
            </div>
        </div>
    </div>
</div>