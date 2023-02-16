package com.itYan.web;

import com.itYan.pojo.User;
import com.itYan.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get the verification code from user input
        String checkCode = request.getParameter("checkCode");

        // get the verification code answer from session
        HttpSession session = request.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");

        //compare verification code
        if(!checkCodeGen.equalsIgnoreCase(checkCode)) {
            request.setAttribute("registerMsg", "verification code error");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = "f";

        // packaging the user object
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setGender(gender);
        user.setEmail(email);



        boolean registerSuccessful = userService.register(user);

        // determine whether the user exists or not
        String registerMessage = "";
        String location = "";
        if(registerSuccessful) {
            registerMessage = "register successful, please login now";
            location = "/login.jsp";
            session.setAttribute("username", username);

        } else {
            registerMessage = "username already exists";
            location = "/register.jsp";
        }
        request.setAttribute("registerMsg", registerMessage);
        request.getRequestDispatcher(location).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
