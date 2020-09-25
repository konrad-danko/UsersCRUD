package pl.coderslab.servlets;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/testServlet")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.getWriter().println("Witaj Konrad w servlecie projektu UsersCRUD");
        response.getWriter().println("Nowa linijka kodu");
        //User user = new User("Userek11", "emailik11", "paqq1");
        //UserDao.createUser(user);
        //response.getWriter().println("Zapisano pod id= " + user.getId());


        User user = UserDao.readUser(8);
        response.getWriter().println("id " + user.getId());
        response.getWriter().println("name " + user.getUserName());
        response.getWriter().println("email " + user.getEmail());
        response.getWriter().println("hash pass " + user.getPassword());

    }
}
