<%--
  Created by IntelliJ IDEA.
  User: Shoh Jahon
  Date: 19.04.2018
  Time: 11:35
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
                    <h4>New University Field - Submission</h4>
                </div>

                <div class="panel-body">

                    <sf:form method="post" action="${contextRoot}/mydashboard/create/university_field" class="form-horizontal" id="universityFieldFrom" modelAttribute="universityField">


                        <div class="form-group">
                            <label class="control-label col-md-4" for="university_id">Select University: </label>
                            <div class="col-md-8">
                                <sf:select class="form-control" id="university_id" path="university.id"
                                           items="${universities}"
                                           itemLabel="universityName"
                                           itemValue="id"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4" for="field_id">Select Field: </label>
                            <div class="col-md-8">
                                <sf:select class="form-control" id="field_id" path="field.id"
                                           items="${fields}"
                                           itemLabel="fieldName"
                                           itemValue="id"/>
                            </div>
                        </div>


                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">

                                <button type="submit" class="btn btn-primary">
                                    Submit University Field <span class="glyphicon glyphicon-chevron-right"></span>
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


