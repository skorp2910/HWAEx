package org.itstep.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/exit",name = "exit")
public class ExitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object auth = session.getAttribute("auth");
        Object authAdmin = session.getAttribute("authAdmin");
        if(auth != null){
            session.removeAttribute("auth");
        }
        if(authAdmin != null){
            session.removeAttribute("authAdmin");
        }

        resp.sendRedirect(req.getContextPath()+ "/authorization");
    }
}
