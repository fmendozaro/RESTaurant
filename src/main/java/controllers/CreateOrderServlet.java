package controllers;

import authorization.Auth;
import daos.DaoFactory;
import models.Item;
import models.Order;
import models.OrderItem;
import models.User;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;

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
import java.util.List;

@WebServlet(urlPatterns = "/orders/create")
public class CreateOrderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(!Auth.isLogged(request)){
            response.sendRedirect("/login");
            return;
        }

        List<Item> menuItems = DaoFactory.getItemsDao().all();
        request.getSession().setAttribute("menuItems", menuItems);
        request.getRequestDispatcher("/orders/create.html")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        User user = Auth.getLoggedUser(request);

        Date orderDate = new DateTime().toDate(), deliveryTime = null;
        Double subtotal = Double.parseDouble(request.getParameter("subtotal"));
        Double tip = Double.parseDouble(request.getParameter("tip"));
        Double tax = Double.parseDouble(request.getParameter("tax"));
        Double total = subtotal + tip + tax;
        String[] items = request.getParameterValues("items[]");

        try {
            deliveryTime = new SimpleDateFormat("hh:mm").parse(request.getParameter("deliveryTime"));
            System.out.println(deliveryTime);
            System.out.println(deliveryTime.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Order newOrder = new Order(orderDate, deliveryTime, subtotal, tax, tip, total, user);
        Long insertedId = DaoFactory.getOrdersDao().insert(newOrder);
        newOrder.setId(insertedId);
        // Save the items in the order
        for (String itemId : items) {
            System.out.println("itemId = " + itemId);
            Item item = DaoFactory.getItemsDao().findOne(Long.parseLong(itemId));
            DaoFactory.getorderItemsDao().insert(new OrderItem(newOrder, item, 1));
        }

        response.sendRedirect("/orders");
    }
}