package com.itYan.web;

import com.alibaba.fastjson2.JSON;
import com.itYan.pojo.Brand;
import com.itYan.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(urlPatterns = "/addServlet")
public class AddServlet extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.0 解決亂碼: POST, getReader()
        request.setCharacterEncoding("UTF-8"); // 設置輸入流的編碼

        ////1. 獲取數據，並封裝成Brand對象，request.Parameter 接收不了 Json數據
        //String brandName = request.getParameter("brandName");
        //String companyName = request.getParameter("companyName");
        //String ordered = request.getParameter("ordered");
        //String description = request.getParameter("description");
        //String status = request.getParameter("status");
        //
        //Brand brand = new Brand();
        //brand.setBrandName(brandName);
        //brand.setCompanyName(companyName);
        //brand.setOrdered(Integer.parseInt(ordered));
        //brand.setDescription(description);
        //brand.setStatus(Integer.parseInt(status));

        //1. get JSON Data
        BufferedReader reader = request.getReader();
        String parameters = reader.readLine();

        // convert json to java object
        Brand brand = JSON.parseObject(parameters, Brand.class);
        System.out.println(brand);

        //2. 調用service 完成添加
        brandService.add(brand);

        ////3. 轉發到查詢所有Servlet
        //request.getRequestDispatcher("/selectAllServlet").forward(request, response);

        //response add successful
        response.getWriter().write("successful");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
