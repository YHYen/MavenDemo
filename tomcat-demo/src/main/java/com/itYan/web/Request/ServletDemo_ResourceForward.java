package com.itYan.web.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(urlPatterns = "/demo11")
public class ServletDemo_ResourceForward extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo11");

        // save data
        // request.setAttribute, request.getAttribute, request.removeAttribute
        request.setAttribute("msg", "Hello");

        request.getRequestDispatcher("/demo3").forward(request, response);

        // Resource forwarding is automatically directed to the new address through the server,
        // so there is no need to write the full path
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
