package org.itstep;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

public class CreateCookieServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");
        Cookie cookie;
        boolean create= false;
        if (!req.getParameter("key").equals("") && !req.getParameter("value").equals("")) {
            cookie = new Cookie(req.getParameter("key"), req.getParameter("value"));
            create=true;
            if (!req.getParameter("lifeTime").equals("")) {
                cookie.setMaxAge(Integer.parseInt(req.getParameter("lifeTime")));
            }
            if (!req.getParameter("domain").equals("")) {
                cookie.setDomain(req.getParameter("domain"));
            }
            if (req.getParameter("http...").equals("http")) {
                cookie.setSecure(false);
            } else {
                cookie.setSecure(true);
            }
            resp.addCookie(cookie);
        }

//        Enumeration<String> parameterNames = req.getParameterNames();
//        while (parameterNames.hasMoreElements()) {
//            String name = parameterNames.nextElement();
//            String[] parameterValues = req.getParameterValues(name);
//            System.out.println(name + " = " + String.join(",", parameterValues));
//            writer.println(Arrays.toString(req.getCookies()));
//        }
        if(create){
            String path= "/createCookie.html";
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
            requestDispatcher.forward(req,resp);
        }else {
            resp.sendRedirect(getServletContext().getContextPath() + "/");
        }


    }
}
