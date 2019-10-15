<%--
  Created by IntelliJ IDEA.
  User: Shoh Jahon
  Date: 05.05.2018
  Time: 23:31
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
                    <h4>New Skill  - Submission</h4>
                </div>

                <div class="panel-body">

                    <sf:form method="post" action="${contextRoot}/skill/create/skill" class="form-horizontal" id="skillFrom" modelAttribute="skill">

                        <div class="form-group">
                            <label class="control-label col-md-4">Skill Name</label>
                            <div class="col-md-8">
                                <sf:input type="text" path="skillName" class="form-control"
                                          placeholder = "Skill Name"/>
                                <sf:errors path="skillName" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Skill Trend</label>
                            <div class="col-md-8">
                                <sf:input type="number" path="skillTrend" class="form-control"
                                          placeholder = "Skill Trend"/>
                                <sf:errors path="skillTrend" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4" for="category_id">Select Category: </label>
                            <div class="col-md-8">
                                <sf:select class="form-control" id="category_id" path="category.id"
                                           items="${categories}"
                                           itemLabel="categoryName"
                                           itemValue="id"/>
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
                            <div class="col-md-offset-4 col-md-8">

                                <button type="submit" class="btn btn-primary">
                                    Submit Skill <span class="glyphicon glyphicon-chevron-right"></span>
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
