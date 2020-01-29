<%@ page import="java.util.List" %>
<%@ page import="org.itstep.CD" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<div>
    <form method="post">
        <h2>Add CD</h2>
        <label> Name CD:
            <input type="text" name="nameCD" placeholder="enter name CD"><br>
        </label>
        <label>Price CD:
            <input type="number" name="priceCD" placeholder="enter price CD"><br>
        </label>
        <button>ADD</button>
    </form>
    <form method="post" action="index.jsp">
        <button>return to start page</button>
    </form>
</div>
<%
    if(request.getParameter("nameCD")!=null && request.getParameter("priceCD")!=null){
        if("POST".equals(request.getMethod())){
            List listCD = (List) session.getAttribute("cd");

            System.out.println("listCD: "+ listCD);
            System.out.println("name: "+ request.getParameter("nameCD")+" price: "+ request.getParameter("priceCD"));
            listCD.add(new CD(request.getParameter("nameCD"),Integer.parseInt(request.getParameter("priceCD"))));
        }
    }
%>
</body>
</html>
