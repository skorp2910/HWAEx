package org.itstep;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class HomeServlet extends HttpServlet {

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
        try (Connection conn = DriverManager.getConnection(connString, user, password)) {
            System.out.println("Connected");
            Statement stmt = conn.createStatement();
            String sql = "create table if not exists  demoMovies " +
                    "(id int auto_increment primary key," +
                    "name varchar(30) not null," +
                    "title varchar(50) not null" +
                    ")";
            stmt.executeUpdate(sql);
            sql = "insert into demoMovies(name,title) VALUES ('demka','this is demka for one film')";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String password0 = req.getParameter("password");
        String login1 = req.getParameter("login1");
        String email1 = req.getParameter("email1");
        String password1 = req.getParameter("password1");

        PrintWriter writer = resp.getWriter();
        writer.println("Hello Database");
        writer.println("login = " + login + " email =" + email + " password0: " + password0);
        writer.println("login1 = " + login1 + " email1 =" + email1 + " password1: " + password1);
    }
}