package org.itstep;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class RegistrationServlet extends HttpServlet {
    private SaveDataRegistration dataRegistration= new SaveDataRegistration();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String subscribe = req.getParameter("checkbox");
        PrintWriter writer = resp.getWriter();
        dataRegistration.addData(login, password, gender, phone, email, subscribe);
        FileOutputStream outputStream = new FileOutputStream("C:\\save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(dataRegistration);
        objectOutputStream.close();

        writer.println("<p>" +
                "<head>" +
                "<style>" +
                " .butBack{" +
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
                " .butBack:focus{" +
                "       outline: none;" +
                "   }" +
                "</style>" +
                "</head>" +
                "<div class='butBack'>" +
                "<a href='index.html'>Back</a>" +
                "</div>" +
                "</p>");
        writer.println("Add new user:  Login: " + login + " password: " + password + " gender: " + gender + " phone: " + phone
                + " email: " + email + " subscribe: " + subscribe);
    }
}
