package org.itstep;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String connString = "jdbc:mysql://localhost/films?serverTimezone=Europe/Kiev&characterEncoding=utf8";
        String user = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        PrintWriter writer = resp.getWriter();
        String textishe = req.getParameter("search");
        writer.println("Hello Database");
        writer.println(textishe);
    }
}
