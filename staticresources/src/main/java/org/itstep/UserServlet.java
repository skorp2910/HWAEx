package org.itstep;

import org.itstep.dao.RegistrationCheck;
import org.itstep.dao.UserDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class UserServlet extends HttpServlet {

    private RegistrationCheck registrationCheck;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String user = getServletContext().getInitParameter("db.username");
        String pass = getServletContext().getInitParameter("db.password");
        String url = getServletContext().getInitParameter("db.url");
        try {
            registrationCheck = new RegistrationCheck(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("request");
        String loginA = req.getParameter("loginA");
        String passwordA = req.getParameter("passwordA");
        PrintWriter writer = resp.getWriter();
        writer.append("<head><link href=\"static/css/style.css\" rel=\"stylesheet\"/></head>");
        if (registrationCheck.checkAutorisation(loginA, passwordA)) {
            writer.append("Authorization was successful");
        } else {
            writer.append("authorization was NOT successful");
        }
    }
}
