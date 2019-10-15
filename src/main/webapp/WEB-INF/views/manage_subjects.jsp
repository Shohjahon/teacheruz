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


        <!-- Form-->
        <div class="form">

            <div class="form-toggle"></div>
            <div class="form-panel one">
                <div class="form-header">
                    <c:if test="${not empty smessage}">

                    <div class="col-xs-12">

                        <div class="alert alert-success alert-dismissable">

                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            ${smessage}

                        </div>

                    </div>

                    </c:if>
                    <h1 style="text-align: center">Search and Decide for Coming Semenster! <span class="fa fa-arrow-circle-right"></span></h1>
                </div>
                <div class="form-content">

                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title" style="text-align: center">${title}</h3>
                        </div>
                        <div class="box-body">

                            <div class="table-responsive">

                                <table id="manageSubjectTable" class="table table-striped table-bordered">

                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Thumbnail</th>
                                        <th>Teacher</th>
                                        <th>Subject</th>
                                        <th>Group</th>
                                        <th>Remaining Seats</th>
                                    </tr>
                                    </thead>

                                    <tfoot>
                                    <tr>
                                        <th>#</th>
                                        <th>Thumbnail</th>
                                        <th>Teacher</th>
                                        <th>Subject</th>
                                        <th>Group</th>
                                        <th>Remaining Seats</th>
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
                    <h1>Register For Upcoming Semester</h1>
                </div>
                <div class="form-content">
                    <form method="post">
                        <div class="form-group">
                            <label for="spassword">Password</label>
                            <input type="password" id="spassword" name="password" required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="semail">Email Address</label>
                            <input type="email" id="semail" name="email" required="required"/>
                        </div>

                        <div class="form-group">
                            <label for="sschedule_id">Enter the id of the Schedule of Professor</label>
                            <input type="number" id="sschedule_id" name="schedule_id" required="required"/>
                        </div>
                        <div class="form-group" id="submitSemester">
                            <button type="submit">Register</button>
                        </div>
                        <div class="form-group" style="visibility: hidden">
                            <label for="semail">Email Address</label>
                            <input type="email" id="n" name="email" required="required"/>
                        </div>
                        <div class="form-group" style="visibility: hidden">
                            <label for="semail">Email Address</label>
                            <input type="email" id="n1" name="email" required="required"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>

</div>
