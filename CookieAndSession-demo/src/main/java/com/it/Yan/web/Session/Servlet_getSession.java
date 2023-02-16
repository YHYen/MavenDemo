package com.it.Yan.web.Session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/servlet_getSession")
public class Servlet_getSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get data from Session
        //1. get Session
        HttpSession session = request.getSession();

        // p.s. self destroy
        //session.invalidate();

        //2. get data
        Object username = session.getAttribute("username");
        System.out.println(username);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
