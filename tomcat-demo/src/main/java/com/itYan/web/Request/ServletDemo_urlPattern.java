package com.itYan.web.Request;


import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;


/*
* 訪問路徑:
*       * 精確匹配: 在urlPattern後面寫上精確路徑，瀏覽器可以通過精確路徑導向相應頁面
*       * 目錄匹配: 在urlPattern後面寫上目錄路徑，如: /user/* ，瀏覽器可以通過目錄路徑導向相應頁面，如: /user/aaa 或 /user/bbb
*       * 擴展名匹配: 在urlPattern後面寫上擴展名，如: *.aaa，瀏覽器可以通過任意名稱配上擴展名導向相應頁面，如: /aaa.aaa
*       * 任意匹配: 在urlPattern後面寫上 / 或 /* ， 瀏覽器可以通過任意後綴導向相應頁面，/* 優先級高於 /
*       * /* 和 / 會覆蓋掉 tomcat 中的 DefaultServlet，因此會覆蓋掉所有的靜態頁面 (html)
**/
@WebServlet(urlPatterns= {"/demo4", "/demo5"})
public class ServletDemo_urlPattern extends MyHttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, ServletResponse servletResponse) {
        System.out.println("Get。。");
    }

    @Override
    protected void doPost(HttpServletRequest request, ServletResponse servletResponse) {
        System.out.println("Post。。");
    }
}
