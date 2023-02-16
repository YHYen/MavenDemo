package com.itYan.web;

import com.itYan.mapper.UserMapper;
import com.itYan.pojo.User;
import com.itYan.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        User user = userService.login(username, password);

        // if user exists
        if(user != null) {
            // login success

            // determine whether the user ticked remember me
            if ("1".equals(remember)) {
                // create cookie
                Cookie usernameCookie = new Cookie("username", username);
                Cookie passwordCookie = new Cookie("password", password);

                // set the survival time of cookie
                usernameCookie.setMaxAge(60*60*24*7);
                passwordCookie.setMaxAge(60*60*24*7);

                // send cookie to browser
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
            }

            // save the successful login object to the session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // There is no information needs to be shared, so use redirect
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/brand.html");
        } else {
            // login fail

            // save error message to request
            request.setAttribute("loginMsg", "wrong username or password");

            // jump to login page
            request.getRequestDispatcher("/login.html").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
