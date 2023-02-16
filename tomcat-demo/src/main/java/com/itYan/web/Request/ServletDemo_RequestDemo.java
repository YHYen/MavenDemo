package com.itYan.web.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo8")
public class ServletDemo_RequestDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // String getMethod(): Get the request method: GET POST .... 7 types in total
        String method = req.getMethod();
        System.out.println(method); //GET
        // String getContextPath(): Get the virtual directory (project access path): tomcat-demo, because of the setting of xml <configuration>,
        // it is currently empty
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        // StringBuffer getRequestURL(): Get URL (Uniform Resource Locator): http://localhost:8080/demo8
        StringBuffer url = req.getRequestURL();
        System.out.println(url.toString());
        // String getRequestURI(): Get URI (Uniform Resource Identifier): /demo8
        String uri = req.getRequestURI();
        System.out.println(uri);
        // String getQueryString(): Get request parameters (GET method): username=Xiu
        String queryString = req.getQueryString();
        System.out.println(queryString);

        // String getHeader(String name): According to the request header name, get the value
        String header = req.getHeader("user-agent");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ServletInputStream getInputStream(): get byte input stream
        //ServletInputStream inputStream = req.getInputStream();
        // BufferedReader getReader(): Get character input stream
        BufferedReader bufferedReader = req.getReader();
        String line = bufferedReader.readLine();
        System.out.println(line);
    }
}
