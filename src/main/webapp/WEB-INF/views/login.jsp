<%--
  Created by IntelliJ IDEA.
  User: Shoh Jahon
  Date: 13.05.2018
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en" >
<head>
    <title>Teacher.uz - ${title}</title>

    <script>
        window.menu = '${title}';
        window.contextRoot = '${contextRoot}';
    </script>
    <meta charset="UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up Form</title>
    <link rel="stylesheet" href="${contextRoot}/resources/css/style.css">

</head>
<body>



<c:if test="${not empty message}">

    <div class="row">

        <div class="col-md-offset-3 col-md-6">
            <div class="alert alert-danger">
                    ${message}
            </div>
        </div>

    </div>

</c:if>
<c:if test="${not empty logout}">

    <div class="row">

        <div class="col-md-offset-3 col-md-6">
            <div class="alert alert-success">
                    ${logout}
            </div>
        </div>

    </div>

</c:if>


<form action="/login" method="post">

    <h1>Sign In</h1>

    <fieldset>
        <legend><span class="number">1</span>Enter you email and password!</legend>

        <label for="email">Email:</label>
        <input type="text" id="email" name="username"/>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password"/>
    </fieldset>


    <button type="submit">Sign Up</button>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
New User - <a href="${contextRoot}/register">Register Here</a>
</body>
</html>
