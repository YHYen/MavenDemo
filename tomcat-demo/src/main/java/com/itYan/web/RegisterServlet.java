package com.itYan.web;

import com.itYan.mapper.UserMapper;
import com.itYan.pojo.User;
import com.itYan.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. receive username and password
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //String confirmPassword = request.getParameter("confirm_password");
        String email = request.getParameter("email");
        String gender = "f";

        //1.2 package object
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(gender);


        //2. call Mybatis to complete the query
        //2.1 Loading MyBatis config file, and get SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        //2.2 get the SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.3 execute sql query
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);





        //3 check if username exists
        User findUser = userMapper.selectByUsername(username);
        if(findUser != null) {
            //3.1 get the string output stream and set the corresponding content type
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("用戶已存在");

        } else {
            //3.2 add data
            userMapper.insertUser(user);
            //4. commit transaction
            sqlSession.commit();

            //5. release source
            sqlSession.close();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
