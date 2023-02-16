package com.itYan.web.Request;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebServlet(urlPatterns="/demo1")
public class MyHttpServlet implements Servlet {
    private ServletConfig servletConfig;
    /**
    *  service method
    * 1. Call timing: The service method will be called every time the Servlet is accessed
    * 2. Number of calls: many times
    * */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet Hello World");
        //0. Depending on the request method, it must be processed separately

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        //1. Get request method
        String method = request.getMethod();
        //2. judge
        if ("GET".equals(method)) {
            //get method to handle
            doGet(request, servletResponse);
        } else if ("POST".equals(method)){
            //post method to handle
            doPost(request, servletResponse);
        }
    }

    protected void doPost(HttpServletRequest request, ServletResponse servletResponse) {

    }

    protected void doGet(HttpServletRequest request, ServletResponse servletResponse) {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
    * destroy method
    *1. Call timing: When the memory is released or the server is closed,
    *   the Servlet will be destroyed,
    *   and the destroy method will be called at this time.
    *2. Number of calls: once
    * */
    @Override
    public void destroy() {
        System.out.println("destroy...");
    }

    /**
    * initialization method
    * 1. Call timing: By default, the Servlet will call the initialization method when it is accessed for the first time
    *       * Call loadOnStartup: Use this to call the initialization method when creating the Servlet
    * 2. number of calls: only called once
    *
    * */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        System.out.println("init...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }
}
