<%--
  Created by IntelliJ IDEA.
  User: Shoh Jahon
  Date: 18.05.2018
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="container">

    <div class="row">

        <c:if test="${not empty message}">

            <div class="col-xs-12">

                <div class="alert alert-success alert-dismissable">

                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                        ${message}

                </div>

            </div>

        </c:if>
        <c:if test="${not empty messagefail}">

            <div class="col-xs-12">

                <div class="alert alert-danger alert-dismissable">

                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                        ${messagefail}

                </div>

            </div>

        </c:if>

    </div>

    <div class="row">

        <div class="col-md-6 col-md-offset-3">

            <div class="panel panel-info">

                <div class="panel-heading">
                    <h4>New Teacher Room Lesson  - Submission</h4>
                </div>

                <div class="panel-body">

                    <sf:form method="post" action="${contextRoot}/teacher_room_lesson/create/teacher_room_lesson" class="form-horizontal" id="roomFrom" modelAttribute="tRoomLesson">

                        <div class="form-group">
                            <label class="control-label col-md-4">Day of Week</label>
                            <div class="col-md-8">
                                <sf:input type="text" path="dayOfWeek" class="form-control"
                                          placeholder = "Day of Week"/>
                                <sf:errors path="dayOfWeek" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Pair</label>
                            <div class="col-md-8">
                                <sf:input type="number" path="pair" class="form-control"
                                          placeholder = "Select pairs"/>
                                <sf:errors path="pair" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                        <label class="control-label col-md-4" for="user_id">Select Teacher: </label>
                        <div class="col-md-8">
                            <sf:select class="form-control" id="user_id" path="user.id"
                                       items="${users}"
                                       itemLabel="fullName"
                                       itemValue="id"/>
                        </div>
                    </div>

                        <div class="form-group">
                            <label class="control-label col-md-4" for="room_id">Select Room: </label>
                            <div class="col-md-8">
                                <sf:select class="form-control" id="room_id" path="room.id"
                                           items="${rooms}"
                                           itemLabel="roomNumber"
                                           itemValue="id"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4" for="lesson_id">Select Subject: </label>
                            <div class="col-md-8">
                                <sf:select class="form-control" id="lesson_id" path="lesson.id"
                                           items="${lessons}"
                                           itemLabel="lessonName"
                                           itemValue="id"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4" for="group_id">Select Group: </label>
                            <div class="col-md-8">
                                <sf:select class="form-control" id="group_id" path="group.id"
                                           items="${groups}"
                                           itemLabel="groupNumber"
                                           itemValue="id"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">

                                <button type="submit" class="btn btn-primary">
                                    Submit Teacher Room Lesson <span class="glyphicon glyphicon-chevron-right"></span>
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
