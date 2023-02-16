package com.itYan.web;

import com.alibaba.fastjson2.JSON;
import com.itYan.pojo.Brand;
import com.itYan.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 調用BrandService 完成查詢
        List<Brand> brands = brandService.selectAll();

        //1.1 convert object to json
        String jsonString = JSON.toJSONString(brands);

        //1.2 Processing Chinese data
        response.setContentType("text/json;charset=utf-8");

        //1.3 response json String
        response.getWriter().write(jsonString);

        ////2. 存入request域中
        //request.setAttribute("brands", brands);
        //
        ////3. 轉發到brand.jsp
        //request.getRequestDispatcher("/brand.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
