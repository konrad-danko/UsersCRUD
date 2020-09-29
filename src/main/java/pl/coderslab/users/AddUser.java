package pl.coderslab.users;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/add")
public class AddUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User(userName, email, password);
        
        user = UserDao.createUser(user);
        if (user == null || user.getId()==0) {
            response.sendRedirect(request.getContextPath() + "/user/add");
        } else {
            response.sendRedirect(request.getContextPath() + "/user/list");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("displayParam", "addUser");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
