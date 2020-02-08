<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="posts" type="java/org.itstep/db/Post"--%>
<%@ page import="org.itstep.db.Post" %>
<%@ page import="java.util.concurrent.CopyOnWriteArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <%--    <%@include file="include/header.jsp" %>--%>
    <c:import url="include/header.jsp"/>

</head>

<body>

<!-- Navigation -->
<%--<%@include file="include/navigation.jsp" %>--%>
<c:import url="include/navigation.jsp"/>
<!-- Page Content -->
<div class="container">
    <div class="row">

        <!-- Post Content Column -->
        <div class="col-lg-8">
            <hr>

            <!-- Preview Image -->
            <img class="img-fluid rounded"
                 src="https://prodaga.com/wp-content/uploads/2018/03/024.telegram.prodaga.com_.jpg" alt="post edit">

            <hr>
            <br>
            <%--            <% CopyOnWriteArrayList<Post> posts = (CopyOnWriteArrayList<Post>) request.getAttribute("posts");%>--%>

            <form method="post">
                <label for="title">Title</label>
                <input name="title" id="title" type="text"><br>
                <%--                <label for="subtitle">Subtitle</label>--%>
                <%--                <input name="subtitle" id="subtitle"><br>--%>
                <%--                <label for="author">Author</label>--%>
                <%--                <input name="author" id="author"><br>--%>
                <label for="content">Content</label><br>
                <textarea id="content" name="content"></textarea><br>
                <input type="submit"/>
            </form>

        </div>

        <!-- Sidebar Widgets Column -->
        <%--        <%@include file="include/sidebar.jsp" %>--%>
        <c:import url="include/sidebar.jsp"/>
        <!-- /.container -->

        <!-- Footer -->
        <%--        <%@include file="include/footer.jsp" %>--%>
        <c:import url="include/footer.jsp"/>

        <!-- Bootstrap core JavaScript -->
        <script src="static/vendor/jquery/jquery.min.js"></script>
        <script src="static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>


