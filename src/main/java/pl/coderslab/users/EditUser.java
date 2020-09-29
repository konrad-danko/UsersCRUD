package pl.coderslab.users;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/edit")
public class EditUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long id = Long.parseLong(request.getParameter("id"));
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User(id, userName, email, password);

        boolean userUpdateResult = UserDao.updateUser(user);
        if (userUpdateResult) {
            response.sendRedirect(request.getContextPath() + "/user/list");
        } else {
            response.sendRedirect(request.getContextPath() + "/user/edit?id=" + id);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        User user = UserDao.readUser(id);
        request.setAttribute("user", user);
        request.setAttribute("displayParam", "editUser");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
