package edu.matc.controller;

import edu.matc.persistence.UsersDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(
        name = "searchUser",
        urlPatterns = {"/searchUser"}
)
public class SearchUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        UsersDao usersDao = new UsersDao();

        request.setAttribute("users", usersDao.getAllUsers());
        request.setAttribute("message", request.getSession().getAttribute("message"));
        request.getSession().removeAttribute("message");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/userResults.jsp");
        dispatcher.forward(request, response);
    }
}