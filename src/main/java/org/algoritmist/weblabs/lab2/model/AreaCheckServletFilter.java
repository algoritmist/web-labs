package org.algoritmist.weblabs.lab2.model;



import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebFilter(urlPatterns = {"/AreaCheck"})
public class AreaCheckServletFilter implements Filter {
    private ServletContext context;
    private final Logger logger = Logger.getLogger("org.algoritmist.weblabs.lab2.model");

    @Override
    public void init(FilterConfig config) {
        context = config.getServletContext();
        context.log("AreaCheckServletFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        String xVals = Arrays.toString(servletRequest.getParameterValues("x"));
        String yVals = Arrays.toString(servletRequest.getParameterValues("y"));
        String rVals = Arrays.toString(servletRequest.getParameterValues("r"));
        String message = String.format("received coordinates\n\tx: %s\n\ty: %s\n\tr: %s\n",
                xVals, yVals, rVals);
        logger.log(Level.INFO, message);
    }

    @Override
    public void destroy() {}
}
