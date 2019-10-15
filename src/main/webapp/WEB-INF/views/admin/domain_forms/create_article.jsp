<%--
  Created by IntelliJ IDEA.
  User: Shoh Jahon
  Date: 12.05.2018
  Time: 16:44
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
                    <h4>New Article  - Submission</h4>
                </div>

                <div class="panel-body">

                    <sf:form method="post" action="${c
                    }/article/create/article" class="form-horizontal" id="articleFrom" modelAttribute="article"
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
                                <sf:textarea cols="" rows="5" path="articleContent" id="articleContent" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Points</label>
                            <div class="col-md-8">
                                <sf:input type="number" path="userPoint" class="form-control"
                                          placeholder = "Article Header"/>
                                <sf:errors path="userPoint" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4" for="videoContent">Select an your video rolik: </label>
                            <div class="col-md-8">
                                <sf:input type="file" path="videoContent" id="videoContent" class="form-control"/>
                                <sf:errors path="videoContent" cssClass="help-block" element="em"/>
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

        </div>

    </div>

</div>
