<%--
  Created by IntelliJ IDEA.
  User: Shoh Jahon
  Date: 16.05.2018
  Time: 0:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <title>Teacher.uz - ${title}</title>
    <script>
        window.menu = '${title}';
        window.contextRoot = '${contextRoot}';
        window.articleId = ${article.id};
    </script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Clean Blog - Start Bootstrap Theme</title>
    <link rel="shortcut icon" href="${contextRoot}/resources/assets/ico/favicon.ico">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="${contextRoot}/resources/css/w3.css">
    <link rel="stylesheet" href="${contextRoot}/resources/comments/bootstrap.min.css">

    <!-- Custom fonts for this template -->
    <link rel="stylesheet" href="${contextRoot}/resources/assets/css/font-awesome.min.css">


    <!-- Custom styles for this template -->
    <link href="${contextRoot}/resources/css/clean-blog.min.css" rel="stylesheet">

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand" href="${contextRoot}/courses">Courses</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
            </ul>
        </div>
    </div>
</nav>

<!-- Page Header -->
<c:choose>
     <c:when test="${not empty thumbnails}">
   <header class="masthead" style="background-image: url('/resources/thumbs/${thumbnails.get(0).fileName}.jpg')">
       <div class="overlay"></div>
       <div class="container">
           <div class="row">
               <div class="col-lg-8 col-md-10 mx-auto">
                   <div class="post-heading">
                       <h1>${article.articleHeader}</h1>
                       <span class="meta">Posted by ${article.user.fullName}
                on ${article.createdDate}</span>
                   </div>
               </div>
           </div>
       </div>
   </header>
    </c:when>
    <c:otherwise>
    <header class="masthead" style="background-image: url('/resources/images/glasses.jpg')">
        <div class="overlay"></div>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-10 mx-auto">
                    <div class="post-heading">
                        <h1>${article.articleHeader}</h1>
                        <span class="meta">Posted by ${article.user.fullName}
                on ${article.createdDate}</span>
                    </div>
                </div>
            </div>
        </div>
    </header>
        </c:otherwise>
</c:choose>


<!-- Post Content -->
<article>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <h2 class="section-heading">${article.articleHeader}</h2>

                <p>${article.articleContent}</p>


                <br>
                <video controls align="right" width="100%" class="blog-image">
                    <source src="${contextRoot}/resources/videos/${article.videoUrl}.mp4" type="video/mp4">
                </video>
                <br>

                <blockquote class="blockquote">The dreams of yesterday are the hopes of today and the reality of tomorrow. Science has not yet mastered prophecy. We predict too much for the next year and yet far too little for the next ten.</blockquote>


                <c:forEach var="img" items="${thumbnails}">
                    <a href="#">
                        <img style="width: 100%;height: 500px;" src="/resources/thumbs/${img.fileName}.jpg" alt="">
                        <hr>
                    </a>
                </c:forEach>

            </div>
        </div>
    </div>
</article>

<hr>
<div class="w3-container" style="height: auto">
    <div class="w3-col m12">
        <div class="w3-card-2 w3-round w3-white">
            <div class="w3-container w3-padding">
                <h6 class="w3-opacity">Comments</h6>
                <p contenteditable="true" class="w3-border w3-padding" data-id="${article.id}" id="commenter"></p>
                <button type="button" class="w3-button w3-blue" data-id="${userModel.id}" id="comment"><i class="fa fa-pencil"  ></i>  Post</button>


               <div class="w3-row" id="comment_box">

                   <div class="w3-row w3-padding-bottom">
                       <hr>
                       <div class="w3-col l2 m3">
                           <img src="/resources/images/and.JPG" style="width:90px;">
                       </div>
                       <div class="w3-col l10 m9">
                           <h4>George <span class="w3-opacity w3-medium">May 3, 2015, 6:32 PM</span></h4>
                           <p>Great blog post! Following</p>
                       </div>
                   </div>


               </div>
        </div>

    </div>
</div>
</div>
<!-- Footer -->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <ul class="list-inline text-center">
                    <li class="list-inline-item">
                        <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fa fa-circle fa-stack-2x"></i>
                    <i class="fa fa-twitter fa-stack-1x fa-inverse"></i>
                  </span>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fa fa-circle fa-stack-2x"></i>
                    <i class="fa fa-facebook fa-stack-1x fa-inverse"></i>
                  </span>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fa fa-circle fa-stack-2x"></i>
                    <i class="fa fa-github fa-stack-1x fa-inverse"></i>
                  </span>
                        </a>
                    </li>
                </ul>
                <p class="copyright text-muted">Copyright &copy; FutureDevs 2018</p>
            </div>
        </div>
    </div>
</footer>

<!-- Bootstrap core JavaScript -->
<script src="${contextRoot}/resources/assets/js/jquery-1.10.2.min.js"></script>
<script src="${contextRoot}/resources/comments/jquery-comments.js"></script>
<script src="${contextRoot}/resources/assets/bootstrap/js/bootstrap.min.js"></script>

<!-- Custom scripts for this template -->
<script src="${contextRoot}/resources/js/clean-blog.min.js"></script>
<script src="${contextRoot}/resources/js/bootbox.min.js"></script>
<script src="${contextRoot}/resources/assets/js/wow.min.js"></script>
<script src="${contextRoot}/resources/js/myapp.js"></script>

</body>

</html>

