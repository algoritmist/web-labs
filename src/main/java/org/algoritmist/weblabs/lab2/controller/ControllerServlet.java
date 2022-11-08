package org.algoritmist.weblabs.lab2.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/check")
public class ControllerServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String requestType = request.getParameter("TYPE");
        if (requestType == null) {
            ///TODO: SEND MESSAGE "NO REQUEST TYPE"
            return;
        }

        if (requestType.equals("PAGEUPDATE")) {
            return;
        }

        if (requestType.equals("AREACHECK")) {
            String[] xValues = request.getParameterValues("x");
            String[] yValues = request.getParameterValues("y");
            String[] rValues = request.getParameterValues("r");
            request.getRequestDispatcher("/areaCheck").forward(request, response);
        }
        ///TODO: SEND MESSAGE "INVALID REQUEST"
    }
}
