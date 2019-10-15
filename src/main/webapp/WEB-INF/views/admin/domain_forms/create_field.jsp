<%--
  Created by IntelliJ IDEA.
  User: Shoh Jahon
  Date: 17.04.2018
  Time: 11:27
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

                    <sf:form method="post" action="${contextRoot}/mydashboard/create/field" class="form-horizontal" id="userFrom" modelAttribute="field">

                        <div class="form-group">
                            <label class="control-label col-md-4">Field Code</label>
                            <div class="col-md-8">
                                <sf:input type="text" path="fieldCode" class="form-control"
                                          placeholder = "Field Code"/>
                                <sf:errors path="fieldCode" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Field Name</label>
                            <div class="col-md-8">
                                <sf:input type="text" path="fieldName" class="form-control"
                                          placeholder = "Field Name"/>
                                <sf:errors path="fieldName" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="description" class="control-label col-md-4">Field Description</label>
                            <div class="col-md-8">
                                <sf:textarea cols="" rows="5" path="description" id="description" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">

                                <button type="submit" class="btn btn-primary">
                                    Submit Field <span class="glyphicon glyphicon-chevron-right"></span>
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


