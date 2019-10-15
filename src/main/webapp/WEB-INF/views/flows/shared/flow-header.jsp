<%--
  Created by IntelliJ IDEA.
  User: Shoh Jahon
  Date: 13.05.2018
  Time: 23:40
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

    <%--Navigation--%>
    <%@include file="flow-navbar.jsp"%>

    <div class="content">
