<%--
  Created by IntelliJ IDEA.
  User: Shoh Jahon
  Date: 13.04.2018
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

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

    <div class="col-xs-12">

        <div class="alert alert-success alert-dismissable">

            <button type="button" class="close" data-dismiss="alert">${message}  <span><a href="/" style="color: white">Welcome!, Home!</a></span></button>
        </div>

    </div>

</c:if>

<c:if test="${not empty messagefail}">

    <div class="col-xs-12">

        <div class="alert alert-danger alert-dismissable">

            <button style="background-color: red" type="button" class="close" data-dismiss="alert"> ${messagefail}</button>

        </div>

    </div>

</c:if>

<sf:form action="${contextRoot}/register" method="post"
         modelAttribute="user" enctype="multipart/form-data">

    <h1>Sign Up</h1>

    <fieldset>
        <legend><span class="number">1</span>Your basic info</legend>
        <label for="firstName">First Name:</label>
        <sf:input type="text" id="firstName" path="firstName"/>
        <sf:errors path="firstName" cssClass="help-block" element="em"/>

        <label for="lastName">Last Name:</label>
        <sf:input type="text" id="lastName" path="lastName"/>
        <sf:errors path="lastName" cssClass="help-block" element="em"/>

        <label for="email">Email:</label>
        <sf:input type="email" id="email" path="email"/>
        <sf:errors path="email" cssClass="help-block" element="em"/>

        <label for="password">Password:</label>
        <sf:input type="password" id="password" path="password"/>
        <sf:errors path="password" cssClass="help-block" element="em"/>

        <label for="confirmPassword">Confirm Password:</label>
        <sf:input type="password" id="confirmPassword" path="confirmPassword"/>
        <sf:errors path="confirmPassword" cssClass="help-block" element="em"/>

        <label>Gender: </label>
        <sf:radiobutton id="under_13" value="MALE" path="gender"/><label  class="light">Male</label><br>
        <sf:radiobutton id="over_13" value="FEMALER" path="gender"/><label  class="light">Female</label>

        <label>Role: </label>
        <sf:radiobutton id="under_13" value="Student" path="role"/><label  class="light">Student</label><br>
        <sf:radiobutton id="over_13" value="Teacher" path="role"/><label  class="light">Teacher</label>
    </fieldset>

        <label>Upload your profile picture</label>
       <sf:input type="file" path="thumbnail"/>
    <sf:errors path="thumbnail" cssClass="help-block" element="em"/>

    <button type="submit">Sign Up</button>
    <sf:hidden path="id"/>
</sf:form>
</body>
</html>


