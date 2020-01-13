<html lang="en">
<head>
    <title>Registration or authorization</title>
    <link href="<%=request.getContextPath()%>/static/css/style.css" rel="stylesheet"/>
</head>
<body>
<form action="<%=request.getContextPath()%>/" method="post">
    <p>Registration</p>
    <div>
        <label for="login">Login</label>
        <input name="login" id="login"/>
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" name="password" id="password"/>
    </div>
    <input type="submit"/>
</form>
<form action="<%=request.getContextPath()%>/user" method="post">
    <p>Authorization</p>
    <div>
        <label for="loginA">Login</label>
        <input name="loginA" id="loginA"/>
    </div>
    <div>
        <label for="passwordA">Password</label>
        <input type="password" name="passwordA" id="passwordA"/>
    </div>
    <input type="submit"/>
</form>
</body>
</html>
