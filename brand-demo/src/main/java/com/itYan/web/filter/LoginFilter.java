package com.itYan.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        // The path that should be released
        String[] urls = {"/selectUserServlet", "/login.jsp", "/login.html", "/loginServlet", "/register.jsp", "/register.html", "/registerServlet", "/header_user_unlogin.html", "/footer_unlogin.html", "/checkCodeServlet", "/css/", "/js/"};

        // get the currently visited path
        String url = httpServletRequest.getRequestURL().toString();

        for (String u : urls) {
            if (url.contains(u)) {
                chain.doFilter(request, response);
                return;
            }
        }


        //1. determine whether there is user object in session
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");

        if (user == null) {
            httpServletRequest.setAttribute("loginMsg", "you are not logged in");
            httpServletRequest.getRequestDispatcher("/login.jsp").forward(httpServletRequest, response);
        } else {
            // let go
            chain.doFilter(request, response);
        }


    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }


}
