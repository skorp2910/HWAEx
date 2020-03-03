<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<spring:url value="/static/css/style.css"/>" rel="stylesheet"/>
</head>
<body>
    <h1>Home page</h1>

<p>
    <a href="<spring:url value="/students"/>">Students</a>
</p>
<p>
    <a href="<spring:url value="/groups"/>">Groups</a>
</p>
    <p>
        <a href="<spring:url value="/h2console"/>">H2 Console</a>
    </p>
</body>
</html>
