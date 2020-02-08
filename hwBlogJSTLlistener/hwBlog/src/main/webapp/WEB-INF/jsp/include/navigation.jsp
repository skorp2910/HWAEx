<%--@elvariable id="count" type="java/org.itstep/listener/UserListener"--%>
<%@ page import="org.itstep.listener.UserListener" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="${requestScope.ContextPath}/">Start Bootstrap</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="${requestScope.ContextPath}/">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${requestScope.ContextPath}/authorization">Sign in</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${requestScope.ContextPath}/exit">Sign out</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${requestScope.ContextPath}/create">Create post</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${requestScope.ContextPath}/about">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${requestScope.ContextPath}/services">Services</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${requestScope.ContextPath}/contact">Contact</a>
                </li>
                <li class="nav-item">
                    <h6 class="nav-link">Hello,
                        <%--                        <%= session.getAttribute("name")%>--%>
                        ${sessionScope.name}
                    </h6>
                </li>
                <li class="nav-item">
                    <h3>online ${sessionScope.count} people</h3>
                </li>
            </ul>
        </div>
    </div>
</nav>
