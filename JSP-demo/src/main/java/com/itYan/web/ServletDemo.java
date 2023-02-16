package com.itYan.web;

import com.itYan.pojo.Brand;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/ServletDemo")
public class ServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. prepare data
        List<Brand> brands = new ArrayList<Brand>();
        brands.add(new Brand(1, "三隻松鼠", "三隻松鼠", 100, "三隻松鼠，好吃不上火", 1));
        brands.add(new Brand(2, "優衣褲", "優衣褲", 10, "優衣褲，服適人生", 0));
        brands.add(new Brand(3, "小米", "小米科技有限公司", 1000, "為發燒而生", 1));

        //2. store the data in the request
        request.setAttribute("brands", brands);
        request.setAttribute("status", 1);

        //3. forward to el-demo.jsp
        //request.getRequestDispatcher("/el-demo.jsp").forward(request, response);
        //request.getRequestDispatcher("/JSTL-if.jsp").forward(request, response);
        request.getRequestDispatcher("/JSTL-forEach.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
