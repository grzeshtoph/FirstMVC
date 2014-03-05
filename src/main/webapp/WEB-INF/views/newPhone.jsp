<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<div class="container">
    <div class="row">
        <div class="col-lg-9">
            <div class="panel panel-default">
                <sf:form method="POST" modelAttribute="phone" class="form-horizontal" role="form"
                         enctype="multipart/form-data">
                <div class="panel-body">
                    <div class="page-header">
                        <h3><s:message code="newPhone.form.title"/></h3>
                    </div>

                    <div class="form-group <c:if test="${idHasValueErrors}">has-feedback has-error</c:if>">
                        <label class="col-lg-2 control-label" for="phone-id"><s:message
                                code="phone.form.phoneId.label"/></label>

                        <div class="col-lg-10">
                            <div class="row">
                                <div class="col-lg-3">
                                    <s:message code="phone.form.phoneId.placeholder" var="phoneIdPlaceholder"/>
                                    <sf:input path="id" cssClass="form-control" id="phone-id"
                                              placeholder="${phoneIdPlaceholder}"
                                              maxlength="10"/>
                                    <c:if test="${idHasValueErrors}">
                                        <span class="glyphicon glyphicon-remove form-control-feedback"></span>
                                    </c:if>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12">
                                    <sf:errors cssClass="help-block" path="id"/>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="form-group <c:if test="${nameHasValueErrors}">has-feedback has-error</c:if>">
                        <label class="col-lg-2 control-label" for="phone-name">
                            <s:message code="phone.form.phoneName.label"/>
                        </label>

                        <div class="col-lg-10">
                            <div class="row">
                                <div class="col-lg-12">
                                    <s:message code="phone.form.phoneName.placeholder" var="phoneNamePlaceholder"/>
                                    <sf:input path="name" cssClass="form-control" type="text" id="phone-name"
                                              placeholder="${phoneNamePlaceholder}"
                                              maxlength="50"/>
                                    <c:if test="${nameHasValueErrors}">
                                        <span class="glyphicon glyphicon-remove form-control-feedback"></span>
                                    </c:if>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12">
                                    <sf:errors cssClass="help-block" path="name"/>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="form-group <c:if test="${priceHasValueErrors}">has-feedback has-error</c:if>">
                        <label class="col-lg-2 control-label" for="phone-price">
                            <s:message code="phone.form.price.label"/>
                        </label>

                        <div class="col-lg-10">
                            <div class="row">
                                <div class="col-lg-3">
                                    <s:message code="phone.form.price.placeholder" var="pricePlaceholder"/>
                                    <sf:input path="price" cssClass="form-control" type="text" id="phone-price"
                                              placeholder="${pricePlaceholder}" maxlength="11"/>
                                    <c:if test="${priceHasValueErrors}">
                                        <span class="glyphicon glyphicon-remove form-control-feedback"></span>
                                    </c:if>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12">
                                    <span class="help-block">
                                        <s:message code="phone.form.priceCurrency.label"/>: <span
                                            class="glyphicon glyphicon-euro"></span></span>
                                    <sf:errors cssClass="help-block" path="price"/>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="form-group <c:if test="${opinionHasValueErrors}">has-feedback has-error</c:if>">
                        <label class="col-lg-2 control-label" for="phone-opinion">
                            <s:message code="phone.form.opinion.label"/>
                        </label>

                        <div class="col-lg-10">
                            <div class="row">
                                <div class="col-lg-12">
                                    <s:message code="phone.form.opinion.placeholder" var="opinionPlaceholder"/>
                                    <sf:textarea path="opinion" cssClass="form-control" id="phone-opinion"
                                                 placeholder="${opinionPlaceholder}" rows="8"/>
                                    <c:if test="${opinionHasValueErrors}">
                                        <span class="glyphicon glyphicon-remove form-control-feedback"></span>
                                    </c:if>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-12">
                                    <sf:errors cssClass="help-block" path="opinion"/>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-lg-2 control-label" for="phone-picture">
                            <s:message code="phone.form.picture.label"/>
                        </label>

                        <div class="col-lg-10">
                            <input name="image" id="phone-picture" type="file"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel-footer right text-right">
                <button class="btn btn-primary" type="submit"><s:message code="button.save"/></button>
            </div>
            </sf:form>
        </div>
    </div>
</div>
</div>