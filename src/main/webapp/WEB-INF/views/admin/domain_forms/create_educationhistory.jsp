<%--
  Created by IntelliJ IDEA.
  User: Shoh Jahon
  Date: 10.05.2018
  Time: 15:10
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
                    <h4>New Education History  - Submission</h4>
                </div>

                <div class="panel-body">

                    <sf:form method="post" action="${contextRoot}/education_history/create/education_history" class="form-horizontal" id="eduhistoryFrom" modelAttribute="educationHistory">

                        <div class="form-group">
                            <label for="universityDetails" class="control-label col-md-4">University Details</label>
                            <div class="col-md-8">
                                <sf:textarea cols="" rows="5" path="universityDetails" id="universityDetails" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="collegeDetails" class="control-label col-md-4">College Details</label>
                            <div class="col-md-8">
                                <sf:textarea cols="" rows="5" path="collegeDetails" id="collegeDetails" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="schoolDetails" class="control-label col-md-4">School Details</label>
                            <div class="col-md-8">
                                <sf:textarea cols="" rows="5" path="schoolDetails" id="schoolDetails" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4" for="user_id">Select User: </label>
                            <div class="col-md-8">
                                <sf:select class="form-control" id="user_id" path="user.id"
                                           items="${users}"
                                           itemLabel="fullName"
                                           itemValue="id"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="createdDate" class="control-label col-md-4">Last Modified Date</label>
                            <div class="col-md-8">
                                <sf:input type="date" path="createdDate" id="createdDate" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">

                                <button type="submit" class="btn btn-primary">
                                    Submit Education History <span class="glyphicon glyphicon-chevron-right"></span>
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
