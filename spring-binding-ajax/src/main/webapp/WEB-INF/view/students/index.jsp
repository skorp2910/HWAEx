<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link href="<spring:url value="/static/css/style.css"/>" rel="stylesheet"/>
</head>
<body>
<h1>Students</h1>
<div>${message}</div>
<div>${error2}</div>
<%--<p><a href="<spring:url value="/students/new"/>">Create student</a></p>--%>
<p><a href="<spring:url value="/groups"/>">Group List</a></p>
<h1>Create new student</h1>
<form method="post" action="<spring:url value="/students/new"/>">
    <div>
        <label for="firstName">First name: </label>
        <input name="firstName" id="firstName" required/>
    </div>
    <div>
        <label for="lastName">Last name: </label>
        <input name="lastName" id="lastName" required/>
    </div>
    <div>
        <label for="age">Age: </label>
        <input name="age" id="age" type="number" min="8" max="60" required/>
    </div>

    <div>
        <label for="groupId">Group: </label>
        <input name="groupId" id="groupId" required/>
    </div>

    <div>
        <input type="submit"/>
    </div>
</form>

<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Age</th>
        <th>Group</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody id="tbody">
<%--    <c:forEach var="student" items="${students}">--%>
<%--        <tr>--%>
<%--            <td>${student.id}</td>--%>
<%--            <td>${student.firstName}</td>--%>
<%--            <td>${student.lastName}</td>--%>
<%--            <td>${student.age}</td>--%>
<%--            <td>${student.groupId}</td>--%>
<%--            <td><a href="<spring:url value="/students/delete/${student.id}"/>">Delete</a>--%>
<%--                <br/>--%>
<%--                <a href="<spring:url value="/students/update/${student.id}"/>">Update</a></td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
    </tbody>
</table>
<script src="<spring:url value="/static/js/script.js"/>"></script>
</body>
</html>
