<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="org.itstep.CD" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>

<html>
<head>
    <link rel="stylesheet" href="resources/css/style.css">
    <title>Index</title>
</head>

<body>
<div>
    <label> Add CD
        <form method="post" action="add.jsp">
            <button>add</button>
        </form>
    </label><br>
    <label> Edit CD
        <form method="post" action="edit.jsp">
            <button>edit</button>
        </form>
    </label><br>
    <label> Delete CD
        <form method="post" action="delete.jsp">
            <button>delete</button>
        </form>
    </label><br>
</div>
<div>
    <%
        if (session.isNew()) {
            session.setAttribute("cd", new ArrayList());
        }
    %>

    <table>
        <caption>List CD</caption>
        <thead>
        <tr>
            <th>Название</th>
            <th>Стоимость</th>
        </tr>
        </thead>
        <tbody>
        <%
            List listCD = (List) session.getAttribute("cd");
            if (listCD != null) {
                for (Object o : listCD) {
                    CD cd = (CD) o;
        %>
        <tr>
            <td><%= cd.getName()%>
            </td>
            <td><%= cd.getPrice()%>
            </td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>



