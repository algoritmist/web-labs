package org.algoritmist.weblabs.lab2.controller.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.algoritmist.weblabs.lab2.controller.shapes.Point;

@AllArgsConstructor
@Getter
public class Response {
    private Result result;
    private String currentTime;
    private String workingTime;
}
