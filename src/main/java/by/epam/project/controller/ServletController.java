package by.epam.project.controller;

import by.epam.project.controller.command.Command;
import by.epam.project.model.connection.ConnectionPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.epam.project.util.RequestParameterName.*;

@WebServlet("/controller")
public class ServletController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Command command = CommandProvider.provideCommand(request.getParameter("command"));

        Router router = command.execute(request);
        String currentPage = router.getCurrentPage();
        HttpSession session = request.getSession();
        session.setAttribute(CURRENT_PAGE, currentPage);

        if (router.getCurrentType().equals(Router.Type.FORWARD)) {
            request.getRequestDispatcher(currentPage).forward(request, response);
        } else {
            response.sendRedirect(currentPage);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        ConnectionPool.INSTANCE.destroyPool();
    }
}
