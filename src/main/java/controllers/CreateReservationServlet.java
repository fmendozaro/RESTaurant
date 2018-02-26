package controllers;

import dao.DaoFactory;
import models.Reservation;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.CreateReservationServlet", urlPatterns = "/reservations/create")
public class CreateReservationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/reservations/create.html")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        Reservation rsv = new Reservation(
                user.getId(), // for now we'll hardcode the user id
                Integer.parseInt(request.getParameter("num_people")),
                request.getParameter("date"),
                request.getParameter("time")
        );
        DaoFactory.getReservationsDao().insert(rsv);
        response.sendRedirect("/profile");
    }
}