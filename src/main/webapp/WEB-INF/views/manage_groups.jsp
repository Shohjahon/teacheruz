<%--
  Created by IntelliJ IDEA.
  User: Shoh Jahon
  Date: 12.04.2018
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container" style="margin-top: 70px">

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


        <script>
            window.userId = ${userModel.id};
        </script>
        <!-- Form-->
        <div class="form">

            <div class="form-toggle"></div>
            <div class="form-panel one">
                <div class="form-header">
                    <h1 style="text-align: center">Add New Group of You to Start This Semester! <span class="fa fa-arrow-circle-right"></span></h1>
                </div>
                <div class="form-content">

                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">${title}</h3>
                        </div>
                        <div class="box-body">

                            <div class="table-responsive">

                                <table id="teacherRoomLessonListTable" class="table table-striped table-bordered">

                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Pair</th>
                                        <th>Lesson</th>
                                        <th>Group</th>
                                        <th>Room</th>
                                        <th>Day of Week</th>
                                        <th>Edit/Delete</th>
                                    </tr>
                                    </thead>

                                    <tfoot>
                                    <tr>
                                        <th>#</th>
                                        <th>Pair</th>
                                        <th>Lesson</th>
                                        <th>Group</th>
                                        <th>Room</th>
                                        <th>Day of Week</th>
                                        <th>Edit/Delete</th>
                                    </tr>
                                    </tfoot>

                                </table>

                            </div>

                        </div>
                    </div>

                </div>
            </div>
            <div class="form-panel two">
                <div class="form-header">
                    <h1>Create New Group <span class="fa fa-plus-circle"></span></h1>
                </div>
                <div class="form-content">

                    <sf:form method="post"  class="form-horizontal" id="teacherrFrom" modelAttribute="tRoomLesson">

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
                                <button type="submit" class="btn btn-primary" id="submitSchedule">
                                    Submit Teacher Room Lesson <span class="glyphicon glyphicon-chevron-right"></span>
                                </button>
                                <sf:hidden path="id"/>
                                <sf:hidden path="user" id="user" data-id="${userModel.id}"/>
                        </div>
                    </sf:form>


                </div>
            </div>
        </div>

    </div>

</div>
