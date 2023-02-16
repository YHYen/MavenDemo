package com.itYan.web.Response;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(urlPatterns = "/resp4")
public class ResponseDemo4_setResponseBody_Byte extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. read file
        FileInputStream fileInputStream = new FileInputStream("d://Xiu.JPG");

        //2. Get the response byte output stream
        ServletOutputStream outputStream = response.getOutputStream();

        //3. complete the copy of the stream
        /*byte[] bytes = new byte[1024];
        int len = 0;
        while((len = fileInputStream.read(bytes)) != 1) {
            outputStream.write(bytes, 0, len);
        }*/

        IOUtils.copy(fileInputStream, outputStream);

        fileInputStream.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
