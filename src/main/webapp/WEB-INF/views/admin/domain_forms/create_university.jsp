<%--
  Created by IntelliJ IDEA.
  User: Shoh Jahon
  Date: 16.04.2018
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">

    <div class="row">

        <div class="col-md-6 col-md-offset-3">

            <div class="panel panel-info">

                <div class="panel-heading">
                    <h4>New University  - Submission</h4>
                </div>

                <div class="panel-body">

                    <sf:form method="post" action="${contextRoot}/mydashboard/create/university" class="form-horizontal" id="userFrom" modelAttribute="university">

                        <div class="form-group">
                            <label class="control-label col-md-4">University Name</label>
                            <div class="col-md-8">
                                <sf:input type="text" path="universityName" class="form-control"
                                          placeholder = "University Name"/>
                                <sf:errors path="universityName" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Address</label>
                            <div class="col-md-8">
                                <sf:input type="text" path="address" class="form-control"
                                          placeholder = "Address"/>
                                <sf:errors path="address" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Phone</label>
                            <div class="col-md-8">
                                <sf:input type="text" path="phone" class="form-control"
                                          placeholder = "+998 XX XXX - XX - XX"/>
                                <sf:errors path="phone" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Web site</label>
                            <div class="col-md-8">
                                <sf:input type="text" path="webSite" class="form-control"
                                          placeholder = "Web Site"/>
                                <sf:errors path="webSite" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Rector</label>
                            <div class="col-md-8">
                                <sf:input type="text" path="rector" class="form-control"
                                          placeholder = "Rector"/>
                                <sf:errors path="rector" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="description" class="control-label col-md-4">University Description</label>
                            <div class="col-md-8">
                                <sf:textarea cols="" rows="5" path="description" id="description" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">

                                <button type="submit" class="btn btn-primary">
                                    Submit University <span class="glyphicon glyphicon-chevron-right"></span>
                                </button>
                                <sf:hidden path="id"/>
                            </div>
                        </div>
                    </sf:form>

                </div>
            </div>

        </div>

    </div>

</div>

