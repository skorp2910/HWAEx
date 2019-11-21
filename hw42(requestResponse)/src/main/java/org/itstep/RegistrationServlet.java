package org.itstep;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.domain.Gender;
import org.itstep.domain.User;
import org.itstep.repository.UserRepository;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

public class RegistrationServlet extends HttpServlet {
    // private SaveDataRegistration dataRegistration= new SaveDataRegistration();

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String subscribe = req.getParameter("checkbox");

        userRepository
                .save(new User(login, password, Gender.parse(gender), phone, email, Boolean.parseBoolean(subscribe)));

        PrintWriter writer = resp.getWriter();
        writer.println("<p>" + "<head>" + "<style>" + " .butBack{" + "       color: white;"
                + "       background: yellow;" + "       border: 1px solid navy;" + "       border-radius: 10px;"
                + "       margin-left: 30px;" + "       margin-top: 10px;" + "       height: 30px;"
                + "       width: 56px;" + "       text-align: center;" + "       padding-top: 7px;" + "   }"
                + " .butBack:focus{" + "       outline: none;" + "   }" + "</style>" + "</head>"
                + "<div class='butBack'>" + "<a href='index.html'>Back</a>" + "</div>" + "</p>");
        writer.println("Add new user:  Login: " + login + " password: " + password + " gender: " + gender + " phone: "
                + phone + " email: " + email + " subscribe: " + subscribe);
    }
}
