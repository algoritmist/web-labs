package org.algoritmist.weblabs.lab2.controller;


import org.jboss.logging.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

@WebFilter("/controllerFilter")
public class ControllerServletFilter implements Filter {
    private ServletContext context;
    private final Logger logger = Logger.getLogger(ControllerServlet.class);


    public void init(FilterConfig config) {
        context = config.getServletContext();
        context.log("AreaCheckFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        logger.info("Received request from IP " + servletRequest.getRemoteAddr() + " with parameters: " + servletRequest.getParameterNames());
    }

    public void destroy() {
        //Close resources
    }
}
