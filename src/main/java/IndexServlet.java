import config.TemplateEngineUtil;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<String> names = Arrays.asList("Fer", "Justin", "Luis", "Ryan", "Zach");

        // Add the following properties to the request object
        request.setAttribute("name", "Codeup");
        request.setAttribute("names", names);

        request.getRequestDispatcher("/home.html").forward(request, response);
    }
}