package org.itstep.servlets;

import org.itstep.db.PostRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/edit", name = "edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/edit.jsp");
        requestDispatcher.forward(req, resp);
        System.out.println("Hello GetEdit");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello PostEdit");
        String id = (req.getParameter("id"));
        String title = req.getParameter("title");
        String context = req.getParameter("context");
        System.out.println(id);
        if (id != null) {
            PostRepository.getInstance().edit(Integer.parseInt(id), title, context);
        }
        resp.sendRedirect(getServletContext().getContextPath());
    }
}

