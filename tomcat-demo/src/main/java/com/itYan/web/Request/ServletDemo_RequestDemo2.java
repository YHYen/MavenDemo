package com.itYan.web.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/demo9")
public class ServletDemo_RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("get...");

        Map<String, String[]> parameterMap = req.getParameterMap();
        for (String key: parameterMap.keySet()) {
            System.out.print(key+": ");

            String[] values = parameterMap.get(key);
            for (String value: values) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        System.out.println("--------------");

        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(username);
        System.out.println(password);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("post...");
        this.doGet(req, resp);
//        Map<String, String[]> parameterMap = req.getParameterMap();
//        for (String key: parameterMap.keySet()) {
//            System.out.print(key);
//
//            String[] values = parameterMap.get(key);
//            for (String value: values) {
//                System.out.print(value + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println("--------------");
//
//        String[] hobbies = req.getParameterValues("hobby");
//        for (String hobby : hobbies) {
//            System.out.println(hobby);
//        }
//
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//
//        System.out.println(username);
//        System.out.println(password);
    }
}
