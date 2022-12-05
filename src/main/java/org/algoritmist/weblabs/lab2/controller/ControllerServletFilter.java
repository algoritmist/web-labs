package org.algoritmist.weblabs.lab2.controller;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebFilter(urlPatterns = {"/Check"})
public class ControllerServletFilter implements Filter {
    private ServletContext context;
    private final Logger logger = Logger.getLogger("org.algoritmist.weblabs.lab2.controller");


    public void init(FilterConfig config) {
        context = config.getServletContext();
        context.log("AreaCheckFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        logger.log(Level.INFO, "Received request from IP " + servletRequest.getRemoteAddr() + " with parameters: " + servletRequest.getParameterNames());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
    }
}
