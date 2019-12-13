package org.itstep;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String connString = "jdbc:mysql://localhost/registration?serverTimezone=Europe/Kiev&characterEncoding=utf8";
        String user = "root";
        String password = "";

        String login = req.getParameter("login");
        String password1 = req.getParameter("password");
        String email = req.getParameter("email");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        Enumeration<String> parameterNames = req.getParameterNames();
//        while (parameterNames.hasMoreElements()) {
//            String name = parameterNames.nextElement();
//            String[] values = req.getParameterValues(name);

        try (Connection conn = DriverManager.getConnection(connString, user, password)) {

            try (Statement stmt = conn.createStatement()) {
                String sql = "insert into registration.users(`name`,`email`,`passwordd`) VALUES " + "('" + login + "','" + email + "','" + password1 + "');";
                stmt.execute(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //   System.out.println(name + " - " + String.join(", ", values));
        // }
        PrintWriter writer = resp.getWriter();
        if (validData(login, email, password)) {
            writer.println("<h1 style='color: blue'> Hello, " + login + " your email:" + email + " You add to database registration in table users</h1>"+
            "<script>"+
            "setTimeout(() => window.location='http://localhost:8080/demo',6000);"+
            "</script>");
        } else {
            System.out.println("введите данные!");
        }

    }

    private boolean validData(String login, String email, String password) {
        return login != null && email != null && password != null;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
