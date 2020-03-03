<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Update student</title>
    <link href="<c:url value="/static/css/style.css"/>" rel="stylesheet"/>
</head>
<body>
<h1>Update group</h1>
<form method="post">
    <div>
        <label for="Name">Name: </label>
        <input name="Name" id="Name" value="${group.name}"/>
    </div>
    <div>
        <input type="submit"/>
    </div>
</form>
</body>
</html>
