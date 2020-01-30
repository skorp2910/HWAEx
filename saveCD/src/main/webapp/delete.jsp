<%@ page import="java.util.List" %>
<%@ page import="org.itstep.CD" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="resources/css/style.css">
    <title>Delete</title>
</head>
<body>
<form method="post">
    <h3>Delete CD</h3>
    <label>
        <input type="text" name="del_name" placeholder="enter name for del CD">
    </label>
    <button>DELETE</button>
</form>
<form method="post" action="index.jsp">
    <button>return to start page</button>
</form>
<%
    if (request.getParameter("del_name") != null) {
        if ("POST".equals(request.getMethod())) {
            List<CD> listCD = (List<CD>) session.getAttribute("cd");
            for (CD disk : listCD) {
                if (request.getParameter("del_name").equals(disk.getName())) {
                    listCD.remove(disk);
                    break;
                }
            }
        }
    }
%>

</body>
</html>
