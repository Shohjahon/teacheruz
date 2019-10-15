<%--
  Created by IntelliJ IDEA.
  User: Shoh Jahon
  Date: 13.05.2018
  Time: 19:17
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
                    <h4>New Thumbnail  - Submission</h4>
                </div>

                <div class="panel-body">

                    <sf:form method="post" action="${contextRoot}/thumbnail/create/thumbnail" class="form-horizontal" id="thumbnailFrom" modelAttribute="thumbnail"
                             enctype="multipart/form-data">

                        <div class="form-group">
                            <label class="control-label col-md-4" for="thumbnail">Select an thumbnail for your article: </label>
                            <div class="col-md-8">
                                <sf:input type="file" path="thumbnail" id="thumbnail" class="form-control"/>
                                <sf:errors path="thumbnail" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4" for="article_id">Select Article: </label>
                            <div class="col-md-8">
                                <sf:select class="form-control" id="article_id" path="article.id"
                                           items="${articles}"
                                           itemLabel="articleHeader"
                                           itemValue="id"/>
                            </div>
                        </div>


                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">

                                <button type="submit" class="btn btn-primary">
                                    Submit Thumbnail <span class="glyphicon glyphicon-chevron-right"></span>
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
