package org.algoritmist.weblabs.lab2.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/controllerFilter")
public class ControllerServletFilter implements Filter {
    private ServletContext context;
    private final Logger logger = LogManager.getLogger(ControllerServlet.class);

    public void init(FilterConfig config) {
        context = config.getServletContext();
        context.log("AreaCheckFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("Received request from IP " + servletRequest.getRemoteAddr() + " with parameters: " + servletRequest.getParameterNames());
    }

    public void destroy() {
        //Close resources
    }
}
