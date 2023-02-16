package com.itYan.web.Request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(urlPatterns = "/demo10")
public class ServletDemo_gibberish extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. Solve garbled characters: POST, getReader()
        request.setCharacterEncoding("UTF-8"); // 設置輸入流的編碼

        //2. get username
        String username = request.getParameter("username");
        System.out.println("Before solving the garbled characters: " + username);

        //3. Solve garbled characters: GET, the way to get parameters is getQueryString()
        // When tomcat decodes, it uses ISO-8859-1
        //3.1 First encode the garbled data and convert it into a byte array
        //byte[] bytes = username.getBytes(StandardCharsets.ISO_8859_1);

        //3.2 Then convert the byte array to a string
        //username = new String(bytes, StandardCharsets.UTF_8);

        //3.1 + 3.2, this method can also be used in the POST scheme
        //After tomcat 8, the default decoding method has been converted to UTF-8, and this solution is no longer needed
        username = new String(username.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

        System.out.println("After solving the garbled characters: " + username);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
