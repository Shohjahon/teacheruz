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
    <link rel="stylesheet" href="${contextRoot}/resources/css/w3.css">
    <link rel="shortcut icon" href="${contextRoot}/resources/assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${contextRoot}/resources/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${contextRoot}/resources/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${contextRoot}/resources/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${contextRoot}/resources/assets/ico/apple-touch-icon-57-precomposed.png">

    <!-- CSS -->
    <link rel="stylesheet" href="${contextRoot}/resources/comments/jquery-comments.css">
    <link rel="stylesheet" href="${contextRoot}/resources/assets/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="${contextRoot}/resources/assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="${contextRoot}/resources/assets/css/animate.min.css">
    <link rel="stylesheet" href="${contextRoot}/resources/assets/css/style.css">
    <link rel="stylesheet" href="${contextRoot}/resources/css/myapp.css">



</head>
<body>

    <%--Navigation--%>
    <%@include file="shared/navbar.jsp"%>

    <div class="content">

        <c:if test="${userClickHome == true}">
            <%@include file="home.jsp"%>
        </c:if>

        <c:if test="${userClickCourses == true}">
            <%@include file="courses.jsp"%>
        </c:if>

        <c:if test="${userClickAboutUs == true}">
            <%@include file="about_us.jsp"%>
        </c:if>

        <c:if test="${userClickManageGroups == true}">
            <%@include file="manage_groups.jsp"%>
        </c:if>

        <c:if test="${userClickManageSubjects == true}">
            <%@include file="manage_subjects.jsp"%>
        </c:if>

        <c:if test="${userClickPersonal == true}">
            <%@include file="personal_profile.jsp"%>
        </c:if>

    <%@include file="shared/footer.jsp"%>


        <script type="text/javascript" src="${contextRoot}/resources/assets/js/jquery-1.10.2.min.js"></script>
        <script src="${contextRoot}/resources/comments/jquery-comments.js"></script>
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

