<%@ page import="java.util.List" %>
<%@ page import="org.itstep.CD" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html>
<head>
    <link rel="stylesheet" href="resources/css/style.css">
    <title>Add</title>
</head>
<body>
<div>
    <form method="post">
        <h2>Add CD</h2>
        <label> Name CD:
            <input type="text" name="nameCD" placeholder="enter name CD" required><br>
        </label><br><br>
        <label>Price CD:
            <input type="number" name="priceCD" placeholder="enter price CD" required><br>
        </label><br><br>
        <button>ADD</button>
    </form>
    <form method="post" action="index.jsp">
        <button>return to start page</button>
    </form>
</div>
<%
    if (request.getParameter("nameCD") != null && request.getParameter("priceCD") != null) {
        if ("POST".equals(request.getMethod())) {
            List<CD> listCD = (List<CD>) session.getAttribute("cd");
            listCD.add(new CD(request.getParameter("nameCD"), Integer.parseInt(request.getParameter("priceCD"))));
        }
    }
%>
</body>
</html>
