package org.algoritmist.weblabs.lab2.controller;



import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebFilter("/controllerFilter")
public class ControllerServletFilter implements Filter {
    private ServletContext context;
    private final Logger logger = Logger.getLogger("org.algoritmist.weblabs.lab2.controller");


    public void init(FilterConfig config) {
        context = config.getServletContext();
        context.log("AreaCheckFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        logger.log(Level.INFO, "Received request from IP " + servletRequest.getRemoteAddr() + " with parameters: " + servletRequest.getParameterNames());
    }

    public void destroy() {
        //Close resources
    }
}
