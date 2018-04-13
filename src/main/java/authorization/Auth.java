package authorization;

import daos.DaoFactory;
import models.User;
import javax.servlet.http.HttpServletRequest;

public class Auth {

    public static boolean isLogged(HttpServletRequest request) {
        return request.getSession().getAttribute("user") != null;
    }

    // Get the most recent info from the DB from the logged in user
    public static User getLoggedUser(HttpServletRequest request){
        if(isLogged(request)){
            User sessionUser = (User) request.getSession().getAttribute("user");
            return DaoFactory.getUsersDao().findById(sessionUser.getId());
        }
        return null;
    }
}
