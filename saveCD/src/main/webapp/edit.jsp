<%@ page import="org.itstep.CD" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="resources/css/style.css">
    <title>Edit</title>
</head>
<body>
<form method="post">
    <label> Old name CD
        <input type="text" name="name_edit" placeholder="enter old name CD" required>
    </label><br><br>
    <label> New name CD
        <input type="text" name="new_name" placeholder="new name CD" required>
    </label><br><br>
    <label> New price CD
        <input type="number" name="new_price" placeholder="new price CD" required>
    </label><br><br>
    <button>
        Edit
    </button>
</form>
<form method="post" action="index.jsp">
    <button>return to start page</button>
</form>
<%
    if ("POST".equals(request.getMethod())) {
        List<CD> listCD = (List<CD>) session.getAttribute("cd");
        double newPrice = 0;
        if (request.getParameter("name_edit") != null) {
            for (CD disk : listCD) {
                if (request.getParameter("name_edit").equals(disk.getName())) {
                    listCD.remove(disk);
                    CD newDisc = new CD(request.getParameter("new_name"), Double.parseDouble(request.getParameter("new_price")));
                    listCD.add(newDisc);
                    break;
                }
            }
        }
    }
%>
</body>
</html>
