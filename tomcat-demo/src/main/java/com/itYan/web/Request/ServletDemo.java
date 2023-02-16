package com.itYan.web.Request;


import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;


@WebServlet(urlPatterns="/demo2")
public class ServletDemo extends MyHttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, ServletResponse servletResponse) {
        System.out.println("Get。。");
    }

    @Override
    protected void doPost(HttpServletRequest request, ServletResponse servletResponse) {
        System.out.println("Post。。");
    }
}
