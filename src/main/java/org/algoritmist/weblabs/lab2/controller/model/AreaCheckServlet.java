package org.algoritmist.weblabs.lab2.controller.model;

import com.google.gson.Gson;
import org.algoritmist.weblabs.lab2.controller.shapes.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/areaCheck")
public class AreaCheckServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        double startTime = System.currentTimeMillis();
        //TODO: add IOException catch!
        List<Double> xValues = Arrays.stream(request.getParameterValues("x")).
                map(Double::parseDouble).collect(Collectors.toList());
        List<Double> yValues = Arrays.stream(request.getParameterValues("y")).
                map(Double::parseDouble).collect(Collectors.toList());
        List<Double> rValues = Arrays.stream(request.getParameterValues("r")).
                map(Double::parseDouble).collect(Collectors.toList());

        for (Double x : xValues) {
            for (Double y : yValues) {
                for (Double r : rValues) {
                    Graph graph = Graph.graphFromRadius(r);
                    Point point = new Point(x, y);
                    Result result = new Result(point, r, graph.isInside(point));
                    double runTime = System.currentTimeMillis() - startTime;
                    String currentTime = getCurrentTime();
                    Response answer = new Response(result,
                            String.valueOf(runTime), currentTime);
                    writeJSON(answer, response);
                }
            }
        }
    }

    private String getCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);
        String curTime = hours + ":" + minutes + ":" + seconds;
        return curTime;
    }
    private void writeJSON(Response answer, HttpServletResponse response) throws IOException {
        Gson gson = new Gson();
        String JSONResponse = gson.toJson(answer);
        response.getWriter().write(JSONResponse);
    }
}
