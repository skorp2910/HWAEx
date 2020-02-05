<%@ page import="java.util.concurrent.CopyOnWriteArrayList" %>
<%@ page import="org.itstep.db.Post" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@include file="include/header.jsp"%>
    <title>Index</title></head>

<body>

  <!-- Navigation -->
    <%@include file="include/navigation.jsp"%>

  <!-- Page Content -->
  <div class="container">

    <div class="row">

      <!-- Blog Entries Column -->
      <div class="col-md-8">

        <h1 class="my-4">Page Heading
          <small>Secondary Text</small>
        </h1>


        <!-- Blog Post -->
              <% CopyOnWriteArrayList<Post> posts = (CopyOnWriteArrayList<Post>) request.getAttribute("posts");%>
              <div class="card mb-4">
                  <% for(Post post:posts){%>
                  <img class="card-img-top" src="https://www.ixbt.com/img/n1/news/2019/8/3/Capture_3_large.JPG" alt="Card image cap">

                  <div class="card-body">
                      <h2 class="card-title">
                          <%--              Post Title--%>
                          <%=post.getTitle()%>
                      </h2>
                      <p class="card-text">
                          <%--              Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!--%>
                          <%=post.getContent()%>
                      </p>
                      <a href="#" class="btn btn-primary">Read More &rarr;</a>

<%--                          <a href="<%=request.getContextPath()%>/edit?id=<%=post.getId()%>&title=<%=post.getTitle()%>&content=<%=post.getContent()%>" class="btn btn-primary">Edit &rarr;</a>--%>
                      <a href="<%=request.getContextPath()%>/edit?id=<%=post.getId()%>" class="btn btn-primary">Edit &rarr;</a>
                      <a class="btn btn-primary" href="<%=request.getContextPath()%>/delete?id=<%=post.getId()%>">Delete</a>

                  </div>
                  <div class="card-footer text-muted">
                      <%--            Posted on January 1, 2017 by--%>
                      <%=post.getPublished()%>
                      <a href="#">Start Bootstrap</a>
                  </div>
                  <%}%>
              </div>


        <!-- Pagination -->
        <ul class="pagination justify-content-center mb-4">
          <li class="page-item">
            <a class="page-link" href="#">&larr; Older</a>
          </li>
          <li class="page-item disabled">
            <a class="page-link" href="#">Newer &rarr;</a>
          </li>
        </ul>

      </div>

      <!-- Sidebar Widgets Column -->
    <%@include file="include/sidebar.jsp"%>
  <!-- /.container -->

  <!-- Footer -->

    <%@include file="include/footer.jsp"%>

  <!-- Bootstrap core JavaScript -->
  <script src="static/vendor/jquery/jquery.min.js"></script>
  <script src="static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
