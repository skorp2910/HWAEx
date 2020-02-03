<%@ page import="org.itstep.db.Post" %>
<%@ page import="java.util.concurrent.CopyOnWriteArrayList" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <%@include file="include/header.jsp" %>

</head>

<body>

<!-- Navigation -->
<%@include file="include/navigation.jsp" %>
<!-- Page Content -->
<div class="container">

    <div class="row">

        <!-- Post Content Column -->
        <div class="col-lg-8">
            <hr>

            <!-- Preview Image -->
            <img class="img-fluid rounded" src="https://i.ytimg.com/vi/fE4T63Fh27E/maxresdefault.jpg" alt="">

            <hr><br>

            <form method="post">
                <label for="title">Title</label>
                <input name="title" id="title"><br>
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
        <%@include file="include/sidebar.jsp" %>
        <!-- /.container -->

        <!-- Footer -->
        <%@include file="include/footer.jsp" %>

        <!-- Bootstrap core JavaScript -->
        <script src="static/vendor/jquery/jquery.min.js"></script>
        <script src="static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>

