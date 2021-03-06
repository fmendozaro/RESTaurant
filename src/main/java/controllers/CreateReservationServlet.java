package controllers;

import authorization.Auth;
import daos.DaoFactory;
import models.Reservation;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/reservations/create")
public class CreateReservationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(!Auth.isLogged(request)){
            response.sendRedirect("/login");
            return;
        }

        request.getRequestDispatcher("/reservations/create.html")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        User user = Auth.getLoggedUser(request);
        Date date = null;Time time = null;

        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
            time = Time.valueOf(request.getParameter("time")+":00");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(date);
        System.out.println(time);

        Reservation rsv = new Reservation(
                user, // for now we'll hardcode the user id
                Integer.parseInt(request.getParameter("num_people")),
                date,
                time
        );

        DaoFactory.getReservationsDao().insert(rsv);
        response.sendRedirect("/profile");
    }
}