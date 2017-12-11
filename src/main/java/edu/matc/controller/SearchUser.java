package edu.matc.controller;

import edu.matc.entity.Users;
import edu.matc.persistence.AbstractDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * Retrieves all of the users.
 */
@WebServlet(
        name = "searchUser",
        urlPatterns = {"/searchUser"}
)
public class SearchUser extends HttpServlet {
    /**
     * Retrieves all of the users.
     *
     * @param request the request
     * @param response the response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AbstractDao<Users> usersAbstractDao = new AbstractDao<>(Users.class);

        request.setAttribute("users", usersAbstractDao.getAll());
        request.setAttribute("message", request.getSession().getAttribute("message"));
        request.getSession().removeAttribute("message");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/userResults.jsp");
        dispatcher.forward(request, response);
    }
}