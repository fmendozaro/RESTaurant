package authorization;

import models.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Auth {

    public static boolean isLogged(HttpServletRequest request) {
        return request.getSession().getAttribute("user") != null;
    }

    public static User getLoggedUser(HttpServletRequest request){
        return (User) request.getSession().getAttribute("user");
    }
}
