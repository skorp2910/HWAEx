<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>authorization</title>
</head>
<body>
<h1>Вы не авторизованы!</h1>
<h2>Для просмотра постов необходима авторизация(создавать и редактировать посты имеет право только администратор!)</h2>
<form action="authorization" method="post">
    <label> Name
        <input type="text" name="name"/>
    </label><br><br>
    <label>Password
        <input type="password" name="password"/>
    </label><br><br>
    <button type="submit">Enter
    </button>
</form>
</body>
</html>
