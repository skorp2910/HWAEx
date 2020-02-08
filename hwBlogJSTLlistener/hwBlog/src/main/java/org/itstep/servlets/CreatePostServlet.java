package org.itstep.servlets;

import org.itstep.db.Post;
import org.itstep.db.PostRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet(urlPatterns = "/create", name = "create")
public class CreatePostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/create.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        CopyOnWriteArrayList<Post> posts = PostRepository.getInstance().getPosts();
        int id = posts.size();
        for(Post p: posts){
            if((id+1)==p.getId()){
                id++;
            }
        }
//        String subtitle = req.getParameter("subtitle");
//        String author = req.getParameter("author");
        String content = req.getParameter("content");
        PostRepository.getInstance().save(Post.builder()

                .title(title)
                .id(++id)
//        .subTitle(subtitle)
//        .author(author)
                .content(content)
                .published(new Date()).build());
        System.out.println(id);
        resp.sendRedirect(getServletContext().getContextPath());
    }
}
