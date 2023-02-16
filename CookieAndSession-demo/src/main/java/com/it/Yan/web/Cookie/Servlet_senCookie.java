package com.it.Yan.web.Cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(urlPatterns = "/servlet_sendCookie")
public class Servlet_senCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // send cookie

        //1. create cookie
        Cookie cookie = new Cookie("username", "Xiu");

        //1.2 set survival time of cookie to 7 days
        cookie.setMaxAge(60*60*24*7);

        //2. response cookie
        response.addCookie(cookie);

        //p.s how to record chinese with cookie
        String value = "中文餅乾";

        // url encoding
        // value = URLEncoder.encode(value, "utf-8");
        // System.out.println("存儲數據: " + value);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
