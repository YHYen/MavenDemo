package com.itYan.web;

import com.itYan.pojo.Brand;
import com.itYan.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 獲取id
        int id = Integer.parseInt(request.getParameter("id"));

        //2. 調用 BrandService 完成查詢
        Brand brand = brandService.selectById(id);

        //3. 存儲到 request 中
        request.setAttribute("brand", brand);

        //4. 轉發到 updateBrand.jsp
        request.getRequestDispatcher("/updateBrand.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
