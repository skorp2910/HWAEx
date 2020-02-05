package org.itstep.servlets;


import org.itstep.db.PostRepository;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/delete", name = "delete")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = (req.getParameter("id"));
//        req.setCharacterEncoding("UTF-8");
        System.out.println(id);
        if (id != null) {
            PostRepository.getInstance().delete(Integer.parseInt(id));
        }
        resp.sendRedirect(getServletContext().getContextPath());
    }
}
