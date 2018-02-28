package controllers;

import com.sun.tools.javac.jvm.Items;
import dao.DaoFactory;
import models.Item;
import models.Order;
import models.Reservation;
import models.User;
import org.joda.time.DateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "controllers.CreateReservationServlet", urlPatterns = "/orders/create")
public class CreateOrderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if (request.getSession().getAttribute("user") == null) {
//            response.sendRedirect("/login");
//            return;
//        }
        List<Item> menuItems = DaoFactory.getItemsDao().all();
        request.getSession().setAttribute("menuItems", menuItems);
        request.getRequestDispatcher("/orders/create.html")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");

        Date orderDate = new DateTime().toDate(), deliveryTime = null;
        Double subtotal = Double.parseDouble(request.getParameter("subtotal"));
        Double tip = Double.parseDouble(request.getParameter("tip"));
        Double tax = Double.parseDouble(request.getParameter("tax"));
        Double total = subtotal + tip + tax;

        try {
            deliveryTime = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("deliveryTime"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Order newOrder = new Order(orderDate, deliveryTime, subtotal, tax, tip, total, user);

        DaoFactory.getOrdersDao().insert(newOrder);
        response.sendRedirect("/orders");
    }
}