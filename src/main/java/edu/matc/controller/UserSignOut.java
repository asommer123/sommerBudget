package edu.matc.controller;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Signs out the user.
 */
@WebServlet(
        name = "userSignOut",
        urlPatterns = {"/userSignOut"}
)
public class UserSignOut extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Signs out the user.
     *
     * @param request the request
     * @param response the response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getSession().invalidate();

        String url = "/logout.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
