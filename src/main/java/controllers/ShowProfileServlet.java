package controllers;

import daos.DaoFactory;
import models.User;
import models.Reservation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/profile")
public class ShowProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        User loggedUser = (User) request.getSession().getAttribute("user");

        List<Reservation> reservations = DaoFactory.getReservationsDao().findByUserId(loggedUser.getId());
        request.setAttribute("reservations", reservations);
        request.getRequestDispatcher("/profile.html").forward(request, response);
    }
}