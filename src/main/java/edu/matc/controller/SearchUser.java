package edu.matc.controller;

import edu.matc.entity.Users;
import edu.matc.persistence.UsersDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/searchUser"}
)

public class SearchUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UsersDao usersDao = new UsersDao();

        String searchTerm = req.getParameter("searchTerm");

        if (req.getParameter("submit").equals("search")) {
            List<Users> usersList = new ArrayList<Users>();
            usersList.add(usersDao.getUser(Integer.valueOf(searchTerm)));
            req.setAttribute("users", usersList);
        } else {
            req.setAttribute("users", usersDao.getAllUsers());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/userResults.jsp");
        dispatcher.forward(req, resp);
    }
}