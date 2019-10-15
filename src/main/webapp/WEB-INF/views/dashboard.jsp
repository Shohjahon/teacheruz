<%--
  Created by IntelliJ IDEA.
  User: Shoh Jahon
  Date: 10.04.2018
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Teacher.Uz - ${title}</title>
    <script>
        window.menu = '${title}';
        window.contextRoot = '${contextRoot}'
    </script>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="${contextRoot}/resources/admin-panel/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${contextRoot}/resources/admin-panel/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="${contextRoot}/resources/admin-panel/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${contextRoot}/resources/admin-panel/css/AdminLTE.min.css">
    <link rel="stylesheet" href="${contextRoot}/resources/admin-panel/css/skin-blue.min.css">
    <link href="${contextRoot}/resources/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="${contextRoot}/resources/css/mydashboard.css" rel="stylesheet">
</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <!-- Main Header -->
    <header class="main-header">

        <!-- Logo -->
        <a href="index2.html" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>A</b>D</span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>My</b>DASHBOARD</span>
        </a>

        <!-- Header Navbar -->
        <nav class="navbar navbar-static-top" role="navigation">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>
            <!-- Navbar Right Menu -->
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- Messages: style can be found in dropdown.less-->
                    <li class="dropdown messages-menu">
                        <!-- Menu toggle button -->
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-envelope-o"></i>
                            <span class="label label-success">4</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">You have 4 messages</li>
                            <li>
                                <!-- inner menu: contains the messages -->
                                <ul class="menu">
                                    <li><!-- start message -->
                                        <a href="#">
                                            <div class="pull-left">
                                                <!-- User Image -->
                                                <img src="${contextRoot}/resources/images/and.JPG" class="img-circle" alt="User Image">
                                            </div>
                                            <!-- Message title and timestamp -->
                                            <h4>
                                                Support Team
                                                <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                            </h4>
                                            <!-- The message -->
                                            <p>Why not buy a new awesome theme?</p>
                                        </a>
                                    </li>
                                    <!-- end message -->
                                </ul>
                                <!-- /.menu -->
                            </li>
                            <li class="footer"><a href="#">See All Messages</a></li>
                        </ul>
                    </li>
                    <!-- /.messages-menu -->

                    <!-- Notifications Menu -->
                    <li class="dropdown notifications-menu">
                        <!-- Menu toggle button -->
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-bell-o"></i>
                            <span class="label label-warning">10</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">You have 10 notifications</li>
                            <li>
                                <!-- Inner Menu: contains the notifications -->
                                <ul class="menu">
                                    <li><!-- start notification -->
                                        <a href="#">
                                            <i class="fa fa-users text-aqua"></i> 5 new members joined today
                                        </a>
                                    </li>
                                    <!-- end notification -->
                                </ul>
                            </li>
                            <li class="footer"><a href="#">View all</a></li>
                        </ul>
                    </li>
                    <!-- Tasks Menu -->
                    <li class="dropdown tasks-menu">
                        <!-- Menu Toggle Button -->
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-flag-o"></i>
                            <span class="label label-danger">9</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">You have 9 tasks</li>
                            <li>
                                <!-- Inner menu: contains the tasks -->
                                <ul class="menu">
                                    <li><!-- Task item -->
                                        <a href="#">
                                            <!-- Task title and progress text -->
                                            <h3>
                                                Design some buttons
                                                <small class="pull-right">20%</small>
                                            </h3>
                                            <!-- The progress bar -->
                                            <div class="progress xs">
                                                <!-- Change the css width attribute to simulate progress -->
                                                <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar"
                                                     aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                    <span class="sr-only">20% Complete</span>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                    <!-- end task item -->
                                </ul>
                            </li>
                            <li class="footer">
                                <a href="#">View all tasks</a>
                            </li>
                        </ul>
                    </li>
                    <!-- User Account Menu -->
                    <li class="dropdown user user-menu">
                        <!-- Menu Toggle Button -->
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <!-- The user image in the navbar-->
                            <img src="${contextRoot}/resources/images/and.JPG" class="user-image" alt="User Image">
                            <!-- hidden-xs hides the username on small devices so only the image appears. -->
                            <span class="hidden-xs">Shoh Jahon</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- The user image in the menu -->
                            <li class="user-header">
                                <img src="${contextRoot}/resources/images/and.JPG" class="img-circle" alt="User Image">

                                <p>
                                    Shoh Jahon - Web Developer
                                    <small>Member since Nov. 2018</small>
                                </p>
                            </li>
                            <!-- Menu Body -->
                            <li class="user-body">
                                <div class="row">
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Followers</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Sales</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Friends</a>
                                    </div>
                                </div>
                                <!-- /.row -->
                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-right">
                                    <a href="${contextRoot}/home" class="btn btn-default btn-flat">Sign out</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <!-- Control Sidebar Toggle Button -->
                </ul>
            </div>
        </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">

        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">

            <!-- Sidebar user panel (optional) -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="${contextRoot}/resources/images/and.JPG" class="img-circle"
                         style="height: 50px; width: 50px" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>Shoh Jahon</p>
                    <!-- Status -->
                    <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                </div>
            </div>

            <!-- search form (Optional) -->
            <form action="#" method="get" class="sidebar-form">
                <div class="input-group">
                    <input type="text" name="q" class="form-control" placeholder="Search...">
                    <span class="input-group-btn">
              <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
              </button>
            </span>
                </div>
            </form>
            <!-- /.search form -->
            <!-- Sidebar Menu -->
            <ul class="sidebar-menu" data-widget="tree">
                <li class="header">Admin Panel</li>
                <li>
                    <a href="/mydashboard/users">
                        <i class="fa fa-users"></i> <span>Users</span>
                    </a>
                </li>
                <li>
                    <a href="/mydashboard/universities">
                        <i class="fa fa-university"></i> <span>Universities</span>
                    </a>
                </li>
                <li>
                    <a href="/mydashboard/fields">
                        <i class="fa fa-building"></i> <span>Fields</span>
                    </a>
                </li>
                <li>
                    <a href="/mydashboard/university_field">
                        <i class="fa fa-institution"></i> <span>University Field</span>
                    </a>
                </li>
                <li>
                    <a href="/university_field_user/university_field_users">
                        <i class="fa fa-group"></i> <span>University Field Users</span>
                    </a>
                </li>
                <li>
                    <a href="/skill/skills">
                        <i class="fa fa-archive"></i> <span>Skills</span>
                    </a>
                </li>
                <li>
                    <a href="/category/categories">
                        <i class="fa fa-book"></i> <span>Categories</span>
                    </a>
                </li>
                <li>
                    <a href="/education_history/education_histories">
                        <i class="fa fa-history"></i> <span>Education Histories</span>
                    </a>
                </li>
                <li>
                    <a href="/subject/subjects">
                        <i class="fa fa-file-code-o"></i> <span>Subjects</span>
                    </a>
                </li>
                <li>
                    <a href="/comment/comments">
                        <i class="fa fa-comments-o"></i> <span>Comments</span>
                    </a>
                </li>
                <li>
                    <a href="/article/articles">
                        <i class="fa fa-newspaper-o"></i> <span>Articles</span>
                    </a>
                </li>
                <li>
                    <a href="/thumbnail/thumbnails">
                        <i class="fa fa-thumb-tack"></i> <span>Thumbnails</span>
                    </a>
                </li>
                <li>
                    <a href="/teacher_room_lesson/teacher_room_lessons">
                        <i class="fa fa-building-o"></i> <span>Teacher & Room & Lesson</span>
                    </a>
                </li>
            </ul>
            <!-- /.sidebar-menu -->
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">

        </section>

        <!-- Main content -->
        <section class="content container-fluid">

            <c:if test="${userClickUserList == true}">
                <%@include file="admin/user.jsp"%>
            </c:if>
            <c:if test="${userClickCreateUser == true}">
                <%@include file="admin/domain_forms/create_user.jsp"%>
            </c:if>
            <c:if test="${userClickUniversityList == true}">
                <%@include file="admin/university.jsp"%>
            </c:if>
            <c:if test="${userClickCreateUniversity == true}">
                <%@include file="admin/domain_forms/create_university.jsp"%>
            </c:if>
            <c:if test="${userClickFieldList == true}">
                <%@include file="admin/field.jsp"%>
            </c:if>
            <c:if test="${userClickCreateField == true}">
                <%@include file="admin/domain_forms/create_field.jsp"%>
            </c:if>
            <c:if test="${userClickUniversityFieldList == true}">
                <%@include file="admin/university_field.jsp"%>
            </c:if>
            <c:if test="${userClickCreateUniversityField == true}">
                <%@include file="admin/domain_forms/create_university_field.jsp"%>
            </c:if>
            <c:if test="${userClickUniversityFieldUserList == true}">
                <%@include file="admin/university_field_user.jsp"%>
            </c:if>
            <c:if test="${userClickCreateUniversityFieldUser == true}">
                <%@include file="admin/domain_forms/create_university_field_user.jsp"%>
            </c:if>
            <c:if test="${userClickSkillList == true}">
                <%@include file="admin/skill.jsp"%>
            </c:if>
            <c:if test="${userClickCreateSkill == true}">
                <%@include file="admin/domain_forms/create_skill.jsp"%>
            </c:if>
            <c:if test="${userClickCategoryList == true}">
                <%@include file="admin/category.jsp"%>
            </c:if>
            <c:if test="${userClickCreateCategory == true}">
                <%@include file="admin/domain_forms/create_category.jsp"%>
            </c:if>
            <c:if test="${userClickEducationHistoryList == true}">
                <%@include file="admin/education_history.jsp"%>
            </c:if>
            <c:if test="${userClickCreateEducationHistory == true}">
                <%@include file="admin/domain_forms/create_educationhistory.jsp"%>
            </c:if>
            <c:if test="${userClickSubjectList == true}">
                <%@include file="admin/subject.jsp"%>
            </c:if>
            <c:if test="${userClickCreateSubject == true}">
                <%@include file="admin/domain_forms/create_subject.jsp"%>
            </c:if>
            <c:if test="${userClickCommentList == true}">
                <%@include file="admin/comment.jsp"%>
            </c:if>
            <c:if test="${userClickCreateComment == true}">
                <%@include file="admin/domain_forms/create_comment.jsp"%>
            </c:if>
            <c:if test="${userClickArticleList == true}">
                <%@include file="admin/article.jsp"%>
            </c:if>
            <c:if test="${userClickCreateArticle == true}">
            <%@include file="admin/domain_forms/create_article.jsp"%>
            </c:if>
            <c:if test="${userClickThumbnailList == true}">
                <%@include file="admin/thumbnail.jsp"%>
            </c:if>
            <c:if test="${userClickCreateThumbnail == true}">
                <%@include file="admin/domain_forms/create_thumbnail.jsp"%>
            </c:if>
            <c:if test="${userClickTeacherRoomLesson == true}">
                <%@include file="admin/teacher_room_lesson.jsp"%>
            </c:if>
            <c:if test="${userClickCreateTeacherRoomLesson == true}">
                <%@include file="admin/domain_forms/create_teacher_room_lesson.jsp"%>
            </c:if>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <footer class="main-footer">
        <div class="row">
            <div class="col-lg-12">
                <p style="text-align: center">Copyright &copy; Future Devs 2018</p>
            </div>
        </div>
    </footer>

</div>
<!-- ./wrapper -->

<script src="${contextRoot}/resources/admin-panel/js/jquery.min.js"></script>
<script src="${contextRoot}/resources/admin-panel/js/bootstrap.min.js"></script>
<script src="${contextRoot}/resources/admin-panel/js/adminlte.min.js"></script>
<script src="${contextRoot}/resources/js/jquery.dataTables.js"></script>
<script src="${contextRoot}/resources/js/dataTables.bootstrap.js"></script>
<script src="${contextRoot}/resources/js/bootbox.min.js"></script>
<script src="${contextRoot}/resources/js/myapp.js"></script>
</body>
</html>