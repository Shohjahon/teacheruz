<%--
  Created by IntelliJ IDEA.
  User: Shoh Jahon
  Date: 10.04.2018
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

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
                <li id="courses">
                    <a href="${contextRoot}/courses">Courses</a>
                </li>
                <li id="managegroups">
                    <a href="${contextRoot}/manage_groups">Groups</a>
                </li>
                <li id="managesubjects">
                    <a href="${contextRoot}/manage_subjects">Subjects</a>
                </li>
                <li id="aboutus">
                    <a href="${contextRoot}/about_us"><span>About us</span></a>
                </li>
                <security:authorize access="hasAuthority('ADMIN')">
                    <li id="dashboard">
                        <a href="${contextRoot}/dashboard">Administration</a>
                    </li>
                </security:authorize>
                <security:authorize access="isAnonymous()">
                    <li id="signin">
                        <a href="${contextRoot}/login"><span>Sign in</span></a>
                    </li>
                    <li id="signup">
                        <a href="${contextRoot}/register"><span>Sign up</span></a>
                    </li>
                </security:authorize>
                <security:authorize access="isAuthenticated()">
                    <li>
                        <a href="${contextRoot}/personal/${userModel.id}/profile">${userModel.full_name}</a>
                    </li>
                    <li>
                        <a href="${contextRoot}/perform-logout">Logout</a>
                    </li>
                </security:authorize>
            </ul>
        </div>
    </div>
</nav>
