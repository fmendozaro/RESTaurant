package controllers;

import authorization.Auth;
import daos.DaoFactory;
import models.Item;
import models.Order;
import models.OrderItem;
import models.User;
import org.joda.time.DateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/profile/update")
public class UpdateProfileServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        User user = Auth.getLoggedUser(request);

        user.setFirstName(request.getParameter("fname"));
        user.setLastName(request.getParameter("lname"));
        user.setEmail(request.getParameter("email"));
        user.setPhone(request.getParameter("phone"));

        DaoFactory.getUsersDao().save(user);

        String message = URLEncoder.encode("Profile Updated", "UTF-8");

        response.sendRedirect("/profile?msg="+message);
    }


}