package com.it.Yan.web.Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet(urlPatterns = "/servlet_getCookie")
public class Servlet_getCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get cookie

        //1. get cookie array
        Cookie[] cookies = request.getCookies();

        //2. traversal cookie
        for (Cookie cookie : cookies) {
            // get data
            String name = cookie.getName();
            if("username".equals(name)) {
                String value = cookie.getValue();

                // if cookie is chinese
                //value = URLDecoder.decode(value, "utf-8");

                System.out.println(name + ": " + value);

                break;
            }
        }




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
