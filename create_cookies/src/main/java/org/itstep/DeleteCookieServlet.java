package org.itstep;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCookieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        boolean del=false;
        String key = req.getParameter("key");
        if(!key.equals("")){
            Cookie[] cookies = req.getCookies();
            if(cookies!=null){
                for(Cookie c: cookies){
                    if(key.equals(c.getName())){
                        c.setMaxAge(0);
                        resp.addCookie(c);
                        del=true;
                        break;
                    }
                }
            }
        }
        if(del){
            String path= "/delete.html";
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
            requestDispatcher.forward(req,resp);
        }else
            resp.sendRedirect(getServletContext().getContextPath() + "/");
    }
}
