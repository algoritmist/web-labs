package org.algoritmist.weblabs.lab2.model;



import org.jboss.logging.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;


@WebFilter("/areaFilter")
public class AreaCheckServletFilter implements Filter {
    private ServletContext context;
    private final Logger logger = Logger.getLogger(AreaCheckServletFilter.class);

    @Override
    public void init(FilterConfig config) {
        context = config.getServletContext();
        context.log("AreaCheckServletFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain){
        String xVals = Arrays.toString(servletRequest.getParameterValues("x"));
        String yVals = Arrays.toString(servletRequest.getParameterValues("y"));
        String rVals = Arrays.toString(servletRequest.getParameterValues("r"));
        String message = String.format("received coordinates\n\tx: %s\n\ty: %s\n\tr: %s\n",
                xVals, yVals, rVals);
        logger.info(message);
    }

    @Override
    public void destroy() {

    }
}
