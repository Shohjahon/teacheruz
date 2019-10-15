<%--
  Created by IntelliJ IDEA.
  User: Shoh Jahon
  Date: 13.05.2018
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<!doctype html>
<html lang="en">
<head>

    <!-- meta data & title -->
    <meta charset="utf-8">
    <title>Teacher.uz - ${title}</title>
    <script>
        window.menu = '${title}';
        window.contextRoot = '${contextRoot}';
    </script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="${contextRoot}/resources/assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${contextRoot}/resources/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${contextRoot}/resources/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${contextRoot}/resources/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${contextRoot}/resources/assets/ico/apple-touch-icon-57-precomposed.png">

    <!-- CSS -->
    <link rel="stylesheet" href="${contextRoot}/resources/assets/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="${contextRoot}/resources/assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="${contextRoot}/resources/assets/css/animate.min.css">
    <link rel="stylesheet" href="${contextRoot}/resources/assets/css/style.css">


</head>
<body>

<div class="wrapper">

    <nav id="navbar-section" class="navbar navbar-default navbar-static-top navbar-sticky" role="navigation">
        <div class="container">

            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

                <a class="navbar-brand wow fadeInDownBig" href="${contextRoot}/home"><img class="office-logo" src="${contextRoot}/resources/assets/img/slider/Teacher.png" alt="Office"></a>
            </div>

            <div id="navbar-spy" class="collapse navbar-collapse navbar-responsive-collapse">
                <ul class="nav navbar-nav pull-right">
                    <li id="home">
                        <a href="${contextRoot}/home">Home</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="content">
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="jumbotron">

                        <h1>${errorTitle}</h1>
                        <hr/>

                        <blockquote style="word-wrap: break-word">

                            ${errorDescription}

                        </blockquote>

                    </div>

                </div>
            </div>
        </div>

        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <h3><i class="fa fa-map-marker"></i> Contact:</h3>
                        <p class="footer-contact">
                            Street: Amir Temur,Tashkent , 54267, Uzbekistan<br>
                            Phone: +998 97 772-01-17 Fax: 1.800.245.357<br>
                            Email: r.shohjahon@gmail.com<br>
                        </p>
                    </div>
                    <div class="col-md-4">
                        <h3><i class="fa fa-external-link"></i> Links</h3>
                        <p> <a href="#"> About ( Who we are )</a></p>
                        <p> <a href="#"> Services ( What we do )</a></p>
                        <p> <a href="#"> Contact ( Feel free to contact )</a></p>
                        <p> <a href="#"> Blog ( Write to us )</a></p>
                        <p> <a href="#"> Team ( Meet the Team )</a></p>
                    </div>
                    <div class="col-md-4">
                        <h3><i class="fa fa-heart"></i> Socialize</h3>
                        <div id="social-icons">
                            <a href="#" class="btn-group google-plus">
                                <i class="fa fa-google-plus"></i>
                            </a>
                            <a href="#" class="btn-group linkedin">
                                <i class="fa fa-linkedin-square"></i>
                            </a>
                            <a href="#" class="btn-group twitter">
                                <i class="fa fa-twitter"></i>
                            </a>
                            <a href="#" class="btn-group facebook">
                                <i class="fa fa-facebook"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </footer>


        <div class="copyright text center">
            <p>&copy; Copyright 2018, <a href="#">www.teacher.uz</a>. Designed by FutureDevs</p>
        </div>
    </div>


    <script type="text/javascript" src="${contextRoot}/resources/assets/js/jquery-1.10.2.min.js"></script>
    <script src="${contextRoot}/resources/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="${contextRoot}/resources/assets/js/wow.min.js"></script>
    <script src="${contextRoot}/resources/js/jquery.dataTables.js"></script>
    <script src="${contextRoot}/resources/js/dataTables.bootstrap.js"></script>
    <script src="${contextRoot}/resources/js/bootbox.min.js"></script>
    <script src="${contextRoot}/resources/assets/js/wow.min.js"></script>
    <script src="${contextRoot}/resources/js/myapp.js"></script>

</div>
<script>
    new WOW().init();
</script>
</body>
</html>
