<%--
  Created by IntelliJ IDEA.
  User: Shoh Jahon
  Date: 12.04.2018
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <div class="row container-kamn">
        <img src="${contextRoot}/resources/images/skills.jpg" class="blog-post" alt="Feature-img" align="right" width="100%">
    </div>

    <!-- End Header -->

    <!-- Main Container -->
    <div id="banners"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-9">

                <c:forEach var="article" items="${articles}">

                    <div class="blog-post">
                        <h1 class="blog-title">
                            <i class="fa fa-file-text"></i>
                            ${article.articleHeader} - by ${article.user.fullName}
                        </h1>
                        <br>
                        <video controls align="right" width="100%" class="blog-image">
                         <source src="${contextRoot}/resources/videos/${article.videoUrl}.mp4" type="video/mp4">
                        </video>
                        <br>
                        <p>
                            ${article.articleContent}
                        </p>
                        <div>
                            <span class="badge">Posted ${article.createdDate}</span>
                            <div class="pull-right">
                                <p><span class="label label-success"><a style="color: white" data-id="${article.id}" id="${article.id}" href="javascript:void(0)" class="btn btn-sucess like_button">${article.userPoint} Liked!</a></span></p>
                                <p class="w3-right"><a href="${contextRoot}/article/article/${article.id}/details" class="w3-button w3-green"><b>Detailed</b></a></p>
                            </div>
                        </div>
                    </div>
                    <hr>

                </c:forEach>

                <ul class="pagination">
                    <li class="disabled"><a href="#">&laquo;</a></li>
                    <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
                    <li><a href="#">2 <span class="sr-only"></span></a></li>
                    <li><a href="#">3 <span class="sr-only"></span></a></li>
                    <li><a href="#">4 <span class="sr-only"></span></a></li>
                    <li><a href="#">5 <span class="sr-only"></span></a></li>
                </ul>
            </div>

            <div class="col-md-3">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"><strong>Search by Criterion</strong></h3>
                    </div>
                    <div class="panel-body">
                        <div class="list-group">
                            <c:forEach var="subject" items="${subjects}">
                                <a href="${contextRoot}/show/subject/${subject.id}/articles" class="list-group-item active">${subject.subjectName}</a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

