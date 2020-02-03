package org.itstep.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "authorizeFilter",
        servletNames = {"create"},
        initParams = {
                @WebInitParam(name = "encoding",value = "UTF8")
        })


public class AuthorizeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session= ((HttpServletRequest)servletRequest).getSession();
        Object auth = session.getAttribute("auth");
        if(auth!=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            ((HttpServletResponse)servletResponse).sendRedirect("/authorization");
        }
    }

    @Override
    public void destroy() {

    }
}
