<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>

<div class="container">
    <div class="row">
        <div class="col-lg-9">
            <div class="panel panel-default">
                <sf:form method="POST" modelAttribute="phone" class="form-horizontal" role="form">
                    <div class="panel-body">
                        <div class="page-header">
                            <h3><t:insertAttribute name="title"/></h3>
                        </div>

                        <div class="form-group <c:if test="${idHasValueErrors}">has-feedback has-error</c:if>">
                            <label class="col-lg-2 control-label" for="phone-id">Phone Id</label>

                            <div class="col-lg-10">
                                <div class="row">
                                    <div class="col-lg-3">
                                        <sf:input path="id" cssClass="form-control" id="phone-id" placeholder="Enter Id"
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
                            <label class="col-lg-2 control-label" for="phone-name">Phone Name</label>

                            <div class="col-lg-10">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <sf:input path="name" cssClass="form-control" type="text" id="phone-name"
                                                  placeholder="Enter Name"
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
                            <label class="col-lg-2 control-label" for="phone-price">Price</label>

                            <div class="col-lg-10">
                                <div class="row">
                                    <div class="col-lg-3">
                                        <sf:input path="price" cssClass="form-control" type="text" id="phone-price"
                                                  placeholder="Enter Price" maxlength="11"/>
                                        <c:if test="${priceHasValueErrors}">
                                            <span class="glyphicon glyphicon-remove form-control-feedback"></span>
                                        </c:if>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                    <span class="help-block">Price currency: <span
                                            class="glyphicon glyphicon-euro"></span></span>
                                        <sf:errors cssClass="help-block" path="price"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-group <c:if test="${opinionHasValueErrors}">has-feedback has-error</c:if>">
                            <label class="col-lg-2 control-label" for="phone-opinion">Opinion</label>

                            <div class="col-lg-10">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <sf:textarea path="opinion" cssClass="form-control" id="phone-opinion"
                                                     placeholder="Write your opinion here" rows="8"/>
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
                    </div>
                    <div class="panel-footer right text-right">
                        <button class="btn btn-primary" type="submit"><t:insertAttribute
                                name="submitButtonLabel"/></button>
                    </div>
                </sf:form>
            </div>
        </div>
    </div>
</div>