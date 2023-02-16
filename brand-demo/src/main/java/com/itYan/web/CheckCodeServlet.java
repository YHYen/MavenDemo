package com.itYan.web;

import com.itYan.util.CheckCodeUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileOutputStream;
import java.io.IOException;

@WebServlet(urlPatterns = "/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CheckCodeUtil checkCodeUtil = new CheckCodeUtil();
        ServletOutputStream responseOutputStream = response.getOutputStream();
        String checkCode = checkCodeUtil.drawImage(responseOutputStream);

        //save the check code answer to session
        HttpSession session = request.getSession();
        session.setAttribute("checkCodeGen", checkCode);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
