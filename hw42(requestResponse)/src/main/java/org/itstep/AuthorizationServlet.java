package org.itstep;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.repository.UserRepository;

import java.io.FileNotFoundException;
//import java.io.FileInputStream;
import java.io.IOException;
//import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

public class AuthorizationServlet extends HttpServlet {
    private final String LOGIN = "admin";
    private final String PASSWORD = "qwerty";

    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            userRepository = new UserRepository(
                    Paths.get(getServletContext().getResource("/WEB-INF/").toURI()).toString());
        } catch (FileNotFoundException | MalformedURLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        PrintWriter writer = resp.getWriter();
        writer.println("<!doctype html><html>" + "<head>" + "<style>" + "   .butBack{" + "       color: white;"
                + "       background: yellow;" + "       border: 1px solid navy;" + "       border-radius: 10px;"
                + "       margin-left: 30px;" + "       margin-top: 10px;" + "       height: 30px;"
                + "       width: 56px;" + "       text-align: center;" + "       padding-top: 7px;" + "   }"
                + "   .butBack:focus{" + "       outline: none;" + "   }");
        writer.println("table{" + "with:100%" + "border:1px solid #ccc;" + " margin:20px 0 0 20px;"
                + "border-collapse:collapse;}" + "th{" + "with:180;" + "border:1px solid #ccc;" + " padding:20px;}"
                + "td{" + "border:1px solid #ccc;" + " padding:20px;}" + "</style></head>");
        writer.println("<body><div class='butBack'>" + "<a href='index.html'>Back</a>" + "</div>");
        if (login.equals(LOGIN) && password.equals(PASSWORD)) {

            writer.println("<table>" + "<tr>" + "<th>Id</th>" + "<th>Login</th>" + "<th>Password</th>"
                    + "<th>Gender</th>" + "<th>Phone</th>" + "<th>Email</th>" + "<th>Subscribe</th>" + "</tr>");
            userRepository.findAll()
                    .forEach(u -> writer.println(
                            "<tr>" + "<td>" + "</td>" + "<td>" + u.getLogin() + "</td>" + "<td>" + u.getPassword()
                                    + "</td>" + "<td>" + u.getGender() + "</td>" + "<td>" + u.getPhone() + "</td>"
                                    + "<td>" + u.getEmail() + "</td>" + "<td>" + u.isSubscribe() + "</td>" + "</tr>"));
            writer.println("</table>");
        } else {
            writer.println("This is " + login + " account!" + login + " don't admin or invalid password...");
        }
        writer.println("</body></html>");
    }
}
