package org.algoritmist.weblabs.lab2.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/check")
public class ControllerServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(ControllerServlet.class);

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
                logger.error(e.getMessage());
            }
        }
    }
}
