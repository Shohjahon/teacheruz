<%--
  Created by IntelliJ IDEA.
  User: Shoh Jahon
  Date: 14.04.2018
  Time: 11:49
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
                     <h4>New User  - Submission</h4>
                </div>

                <div class="panel-body">

                    <sf:form method="post" action="${contextRoot}/mydashboard/create/user" class="form-horizontal" id="userFrom" modelAttribute="admin_user"
                    enctype="multipart/form-data">

                        <div class="form-group">
                            <label class="control-label col-md-4">First Name</label>
                            <div class="col-md-8">
                                <sf:input type="text" path="firstName" class="form-control"
                                placeholder = "First Name"/>
                                <sf:errors path="firstName" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Last Name</label>
                            <div class="col-md-8">
                                <sf:input type="text" path="lastName" class="form-control"
                                          placeholder = "Last Name"/>
                                <sf:errors path="lastName" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Select Role</label>
                            <div class="col-md-8">
                                <label class="radio-inline">
                                    <sf:radiobutton path="role" value="USER" checked="checked"/> User
                                </label>
                                <label class="radio-inline">
                                    <sf:radiobutton path="role" value="ADMIN"/> Administrator
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Select Your Gender</label>
                            <div class="col-md-8">
                                <label class="radio-inline">
                                    <sf:radiobutton path="gender" value="MALE" checked="checked"/> Male
                                </label>
                                <label class="radio-inline">
                                    <sf:radiobutton path="gender" value="FEMALE"/> Female
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Email</label>
                            <div class="col-md-8">
                                <sf:input type="email" path="email" class="form-control"
                                          placeholder = "abc@xyz.com"/>
                                <sf:errors path="email" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4" for="thumbnail">Select an Thumbnail: </label>
                            <div class="col-md-8">
                                <sf:input type="file" path="thumbnail" id="thumbnail" class="form-control"/>
                                <sf:errors path="thumbnail" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Password</label>
                            <div class="col-md-8">
                                <sf:input type="password" path="password" class="form-control"
                                          placeholder = "Password"/>
                                <sf:errors path="password" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Confirm Password</label>
                            <div class="col-md-8">
                                <sf:input type="password" path="confirmPassword" class="form-control"
                                          placeholder = "Re - enter password"/>
                                <sf:errors path="password" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">

                                <button type="submit" class="btn btn-primary">
                                    Submit User <span class="glyphicon glyphicon-chevron-right"></span>
                                </button>

                                <sf:hidden path="code"/>
                                <sf:hidden path="id"/>
                                <sf:hidden path="active"/>
                            </div>
                        </div>
                    </sf:form>

                </div>
            </div>

        </div>

    </div>

</div>
