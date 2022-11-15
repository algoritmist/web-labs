package org.algoritmist.weblabs.lab2.controller;




import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet("/check")
public class ControllerServlet extends HttpServlet {
    private final Logger logger = Logger.getLogger("org.algoritmist.weblabs.lab2.controller");

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String requestType = request.getParameter("TYPE");
        if (requestType == null) {
            return;
        }

        if (requestType.equals("PAGEUPDATE")) {
            return;
        }

        if (requestType.equals("AREACHECK")) {
            try {
                request.getRequestDispatcher("/areaCheck").forward(request, response);
            } catch (ServletException | IOException e) {
                logger.log(Level.WARNING, e.getMessage());
            }
        }
    }
}
