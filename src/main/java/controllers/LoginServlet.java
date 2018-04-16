package controllers;

import daos.DaoFactory;
import models.User;
import authentication.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/login.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        List<String> errors = new LinkedList<>();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = DaoFactory.getUsersDao().findByUsername(username);
        boolean error = false;

        if(username.isEmpty()){
            errors.add("Username can't be empty");
            error = true;
        }

        if(password.isEmpty()){
            errors.add("Password can't be empty");
            error = true;
        }

        if (user == null) {
            errors.add("User doesn't exist");
            error = true;
        }else{
            if(!Password.check(password, user.getPassword())){
                errors.add("Password doesn't match");
                error = true;
            }
        }

        if (!error) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/profile");
        }else{
            request.getSession().setAttribute("errors", errors);
            response.sendRedirect("/login");
        }
    }
}