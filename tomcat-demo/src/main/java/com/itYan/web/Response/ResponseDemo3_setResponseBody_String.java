package com.itYan.web.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/resp3")
public class ResponseDemo3_setResponseBody_String extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //ps. Usually, the corresponding mode will be set at the beginning,
        // and the side code should be set to avoid garbled characters in Chinese
        response.setContentType("text/html;charset=UTF-8");

        //1. get string output stream
        PrintWriter writer = response.getWriter();

        //2. set output value
        writer.write("修");

        //2.1 set contentType
        //response.setHeader("content-type", "text/html");
        writer.write("<h1>aaa</h1>");

        // When the Response object is destroyed,
        // the writer will be automatically closed,
        // so there is no need to add close()

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
