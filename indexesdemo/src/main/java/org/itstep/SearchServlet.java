package org.itstep;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class SearchServlet extends HttpServlet {
    String url;
    String user;
    String password;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        url = getServletContext().getInitParameter("db:url");
        user = getServletContext().getInitParameter("db:user");
        password = getServletContext().getInitParameter("db:pass");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int count =0;
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        PrintWriter writer = resp.getWriter();

        String SELECT = "Select count(*) from people.person where first_name = '"+first_name+"' AND last_name='"+last_name+"';";
        String INDEX = "create index if not exists person_first_name_idx on person(first_name)";
        //http://localhost:8080/indexes/search?last_name=Anderson&first_name=Roma
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try( Connection connection= DriverManager.getConnection(url,user,password)) {
            Statement statement = connection.createStatement();
            long startTime= System.currentTimeMillis();
            boolean resultSet2 = statement.execute(INDEX);
            ResultSet resultSet = statement.executeQuery(SELECT);

            long time = System.currentTimeMillis()-startTime;
            while (resultSet.next()){
                count=resultSet.getInt(1);
            }
            writer.println("Number of persons with selected data: "+count);
            writer.println("Counting time is: "+time+" milliseconds");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
