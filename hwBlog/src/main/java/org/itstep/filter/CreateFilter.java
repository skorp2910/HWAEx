package org.itstep.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(filterName = "createFilter",
           servletNames = {"create","delete","edit"})
public class CreateFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session= ((HttpServletRequest)servletRequest).getSession();
        Object authAdmin = session.getAttribute("authAdmin");
        if(authAdmin!=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            ((HttpServletResponse)servletResponse).sendRedirect("/authorization");
        }
    }

    @Override
    public void destroy() {

    }
}
