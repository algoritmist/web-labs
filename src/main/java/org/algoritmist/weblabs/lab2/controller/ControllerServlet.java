package org.algoritmist.weblabs.lab2.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(value = "/Check")
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
                request.getRequestDispatcher("/AreaCheck").forward(request, response);
            } catch (ServletException | IOException e) {
                logger.log(Level.WARNING, e.getMessage());
            }
        }
    }
}
