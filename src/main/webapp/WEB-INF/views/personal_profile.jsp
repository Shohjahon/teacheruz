<%--
  Created by IntelliJ IDEA.
  User: Shoh Jahon
  Date: 14.05.2018
  Time: 3:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="w3-light-grey">

<!-- Page Container -->
<div class="w3-content w3-margin-top" style="max-width:1400px;">

    <!-- The Grid -->
    <div class="w3-row-padding">

        <!-- Left Column -->
        <div class="w3-third">

            <div class="w3-white w3-text-grey w3-card-4">
                <div class="w3-display-container">
                    <img src="${contextRoot}/resources/images/thumbnails/${userModel.code}.jpg" style="width:100%" alt="Avatar">
                    <div class="w3-display-bottomleft w3-container w3-text-black">
                    </div>
                </div>
                <div class="w3-container" style="margin-top: 20px">
                    <p><i class="fa fa-user fa-fw w3-margin-right w3-large w3-text-teal"></i>${userModel.full_name}</p>
                    <p><i class="fa fa-briefcase fa-fw w3-margin-right w3-large w3-text-teal"></i>${userModel.role}</p>
                    <p><i class="fa fa-envelope fa-fw w3-margin-right w3-large w3-text-teal"></i>${userModel.email}</p>
                    <p><i class="fa fa-phone fa-fw w3-margin-right w3-large w3-text-teal"></i>+998 97 772 01 17</p>
                    <hr>

                    <p class="w3-large"><b><i class="fa fa-asterisk fa-fw w3-margin-right w3-text-teal"></i>Skills</b></p>

                    <c:forEach var="skill" items="${skills}">

                        <p>${skill.skillName}</p>
                        <div class="w3-light-grey w3-round-xlarge w3-small">
                            <div class="w3-container w3-center w3-round-xlarge w3-teal" style="width:${skill.skillTrend}%">${skill.skillTrend}%</div>
                        </div>
                        <br>

                    </c:forEach>

                </div>
            </div><br>

            <!-- End Left Column -->
        </div>

        <!-- Right Column -->
        <div class="w3-twothird" >

            <div class="w3-container w3-card-2 w3-white w3-margin-bottom" style="height: 1060px">
                <div class="w3-row">
                    <a href="javascript:void(0)" onclick="openCity(event, 'London');" style="height: 1000px">
                        <div class="w3-third tablink w3-bottombar w3-hover-light-grey w3-padding w3-border-red">Lessons</div>
                    </a>
                    <a href="javascript:void(0)" onclick="openCity(event, 'Paris');">
                        <div class="w3-third tablink w3-bottombar w3-hover-light-grey w3-padding">Edit Profile</div>
                    </a>
                    <a href="javascript:void(0)" onclick="openCity(event, 'Tokyo');">
                        <div class="w3-third tablink w3-bottombar w3-hover-light-grey w3-padding">Create Article</div>
                    </a>
                </div>

                <div id="London" class="w3-container city">
                    <h2 style="text-align: center">Lessons Schedule</h2>


                    <table class="table table-hover">
                        <thead>
                        <th>#</th>
                        <th>Day of Week</th>
                        <th>Subject Name</th>
                        <th>Room Number</th>
                        <th>Group Number</th>
                        </thead>
                        <tbody>

                        <c:forEach var="item" items="${schedule}">

                            <tr>
                                <td>${item.pair}</td>
                                <td>${item.dayOfWeek}</td>
                                <td>${item.lesson.lessonName}</td>
                                <td>${item.room.roomNumber}</td>
                                <td>${item.group.groupNumber}</td>
                            </tr>

                        </c:forEach>

                        </tbody>
                        <tfoot>
                        <th>#</th>
                        <th>Day of Week</th>
                        <th>Subject Name</th>
                        <th>Room Number</th>
                        <th>Group Number</th>
                        </tfoot>
                    </table>
                </div>

                <div id="Paris" class="w3-container city" style="display:none; ">
                    <hr>
                    <h3 style="text-align: center">Edit your profile information</h3>
                    <hr>

                                        <sf:form method="post" action="${contextRoot}/personal/edit/user" class="form-horizontal" id="editUserFrom" modelAttribute="user"
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
                                                        <sf:radiobutton path="role" value="USER" checked="checked"/>User
                                                    </label>
                                                    <label class="radio-inline">
                                                        <sf:radiobutton path="role" value="ADMIN"/>Administrator
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

                <div id="Tokyo" class="w3-container city" style="display:none">

                    <hr>
                    <h3 style="text-align: center">Upload your article or video course to the system</h3>
                    <hr>
                        <sf:form method="post" action="${contextRoot}/personal/create/article" class="form-horizontal" id="personalArticleFrom" modelAttribute="article"
                                 enctype="multipart/form-data">

                            <div class="form-group">
                                <label class="control-label col-md-4">Article Header</label>
                                <div class="col-md-8">
                                    <sf:input type="text" path="articleHeader" class="form-control"
                                              placeholder = "Article Header"/>
                                    <sf:errors path="articleHeader" cssClass="help-block" element="em"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="articleContent" class="control-label col-md-4">Article Content</label>
                                <div class="col-md-8">
                                    <sf:textarea cols="" rows="5" path="articleContent" id="articleContent" class="form-control" placeholder="Enter here your article text source!"/>
                                </div>
                            </div>

                            <sf:hidden path="userPoint"/>

                            <div class="form-group">
                                <label class="control-label col-md-4" for="videoContent">Select an your video rolik: </label>
                                <div class="col-md-8">
                                    <sf:input type="file" path="videoContent" id="videoContent" class="form-control"/>
                                    <sf:errors path="videoContent" cssClass="help-block" element="em"/>
                                </div>
                            </div>

                            <sf:hidden path="user.id"/>

                            <div class="form-group">
                                <label class="control-label col-md-4" for="subject_id">Select Video Subject: </label>
                                <div class="col-md-8">
                                    <sf:select class="form-control" id="subject_id" path="subject.id"
                                               items="${subjects}"
                                               itemLabel="subjectName"
                                               itemValue="id"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-offset-4 col-md-8">

                                    <button type="submit" class="btn btn-primary">
                                        Submit Category <span class="glyphicon glyphicon-chevron-right"></span>
                                    </button>
                                    <sf:hidden path="id"/>
                                    <sf:hidden path="videoUrl"/>
                                </div>
                            </div>
                        </sf:form>
                </div>

            </div>

            <div class="w3-container w3-card-2 w3-white">
                <h2 class="w3-text-grey w3-padding-16"><i class="fa fa-certificate fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i>Education</h2>


                   <div class="w3-container">
                       <h5 class="w3-opacity"><b>${universityFieldUser.university.universityName}</b></h5>
                       <h6 class="w3-text-teal"><i class="fa fa-sitemap  fa-fw w3-margin-right"></i><a href="${universityFieldUser.university.webSite}">${universityFieldUser.university.webSite}</a></h6>
                       <p>${universityFieldUser.university.description}</p>
                       <hr>
                   </div>

                <div class="w3-container">
                    <h5 class="w3-opacity"><b>${universityFieldUser.field.fieldName}</b></h5>
                    <h6 class="w3-text-teal"><i class="fa fa-sitemap  fa-fw w3-margin-right"></i>Field Code: ${universityFieldUser.field.fieldCode}</h6>
                    <p>${universityFieldUser.field.description}</p>
                    <hr>
                </div>

                <div class="w3-container">
                    <h5 class="w3-opacity"><b>Education History of ${userModel.full_name}</b></h5>
                    <p>${educationHistory.universityDetails}</p>
                    <hr>
                    <hr>
                    <p>${educationHistory.collegeDetails}</p>
                    <hr>
                    <p>${educationHistory.schoolDetails}</p>
                </div>


            </div>

            <!-- End Right Column -->
        </div>

        <!-- End Grid -->
    </div>

    <!-- End Page Container -->
</div>


</div>
