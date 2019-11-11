package org.itstep;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;

public class AuthorizationServlet extends HttpServlet {
    private final String LOGIN = "admin";
    private final String PASSWORD = "qwerty";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password =  req.getParameter("password");
        PrintWriter writer = resp.getWriter();
        writer.println("<p>" +
                "<head>" +
                "<style>" +
                "   .butBack{" +
                "       color: white;" +
                "       background: yellow;" +
                "       border: 1px solid navy;" +
                "       border-radius: 10px;" +
                "       margin-left: 30px;" +
                "       margin-top: 10px;" +
                "       height: 30px;" +
                "       width: 56px;" +
                "       text-align: center;" +
                "       padding-top: 7px;" +
                "   }" +
                "   .butBack:focus{" +
                "       outline: none;" +
                "   }" +
                "</style>" +
                "</head>" +
                "<div class='butBack'>" +
                "<a href='index.html'>Back</a>" +
                "</div>" +
                "</p>");
        writer.println("<head>" +
                "<style>" +
                "table{" +
                "border:1px solid #ccc;" +
                " margin:20px;" +
                "border-collapse:collapse;}" +
                "th{" +
                "border:1px solid #ccc;" +
                " padding:20px;}" +
                "td{" +
                "border:1px solid #ccc;" +
                " padding:20px;}" +
                "</style>"+
                "</head>");
        if(login.equals(LOGIN)&&password.equals(PASSWORD)){
            FileInputStream fileInputStream= new FileInputStream("C:\\save.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            SaveDataRegistration dataRegistration= null;
            try {
                dataRegistration = (SaveDataRegistration) objectInputStream.readObject();
                writer.println("<table>" +
                        "<tr>" +
                        "<th>Id</th>" +
                        "<th>Login</th>" +
                        "<th>Password</th>" +
                        "<th>Gender</th>" +
                        "<th>Phone</th>" +
                        "<th>Email</th>" +
                        "<th>Subscribe</th>" +
                        "</tr>"+
                        "</table>");
                writer.println(dataRegistration);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
       else{
            writer.println("This is "+ login+" account!"+ login+" don't admin or invalid password...");
        }
    }
}
