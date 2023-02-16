package com.itYan.web;

import com.itYan.mapper.UserMapper;
import com.itYan.pojo.User;
import com.itYan.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. receive username and password
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //2. call Mybatis to complete the query
        //2.1 Loading MyBatis config file, and get SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        //2.2 get the SqlSession object
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.3 execute sql query
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.select(username, password);

        //3. release source
        sqlSession.close();

        //4.0 get the string output stream and set the corresponding content type
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        //4. determine whether user is null
        if (user != null) {
            writer.write("sign in successfully");
        } else {
            writer.write("Login failed");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
