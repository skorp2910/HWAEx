package org.itstep.servlets;

import org.itstep.db.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = "/authorization", name = "authorization")
public class AuthorizationServlet extends HttpServlet {

    private List<Person> people = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/authorization.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void generatingPerson() {
        people.add(new Person("admin", "admin", "all"));
        people.add(new Person("Vasyliy","123","onlyRead"));
        people.add(new Person("Masha","333","onlyRead"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        for(Person p :people){
            if(name.equals(p.getName())&& password.equals(p.getPassword())){
                HttpSession session = req.getSession();
                session.setAttribute("auth",true);
                System.out.println("Hello "+ p.getName());
                resp.sendRedirect(req.getContextPath()+ "/");
                break;
            }else {
                resp.sendRedirect(req.getContextPath()+ "/authorization");
            }
        }
    }
}
