package org.itstep;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditCookiesServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Cookie cookie=null;
        boolean edit=false;
        if(cookies!=null){
            for(Cookie c: cookies){
                if(req.getParameter("key").equals(c.getName())){
                     cookie = c;
                     edit=true;
                    if(!req.getParameter("value").equals("")){
                        cookie.setValue(req.getParameter("value"));
                    }
                    if(!req.getParameter("lifeTime").equals("")){
                        cookie.setMaxAge(Integer.parseInt(req.getParameter("lifeTime")));
                    }else {
                        cookie.setMaxAge(c.getMaxAge());
                    }
                }
            }
            if(!req.getParameter("key").equals("") && cookie!=null){
                resp.addCookie(cookie);
            }
        }
        if(edit){
            String path= "/edit.html";
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
            requestDispatcher.forward(req,resp);
        }else {
            resp.sendRedirect(getServletContext().getContextPath()+"/");
        }

    }
}