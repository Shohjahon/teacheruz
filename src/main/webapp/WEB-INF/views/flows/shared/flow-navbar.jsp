<%--
  Created by IntelliJ IDEA.
  User: Shoh Jahon
  Date: 13.05.2018
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<nav id="navbar-section" class="navbar navbar-default navbar-static-top navbar-sticky" role="navigation">
    <div class="container">

        <div class="navbar-header">
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
