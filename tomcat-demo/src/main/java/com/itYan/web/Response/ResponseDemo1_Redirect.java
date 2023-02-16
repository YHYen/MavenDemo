package com.itYan.web.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/resp1")
public class ResponseDemo1_Redirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp1....");

//        //status code
//        //1. set response status code
//        response.setStatus(302);
//
//        //2. Set the response header Location
//        response.setHeader("Location", "/resp2");

        //3. simplified way to complete redirection
        //response.sendRedirect("/resp2");

        //4. get virtual directory dynamically
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "/resp2");

        // redirection is to let the browser send a request to the new location through the status code, so the full path needs to be written

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
