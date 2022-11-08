package org.algoritmist.weblabs.lab2.controller.model;

import org.algoritmist.weblabs.lab2.controller.shapes.Point;
import org.algoritmist.weblabs.lab2.controller.shapes.Shape;

import java.util.Arrays;

public class Graph {
    private final Shape[] parts;

    public Graph(Shape[] shapes) {
        parts = shapes;
    }

    public boolean isInside(Point point) {
        return Arrays.stream(parts).map(x -> x.isInside(point)).
                reduce(true, (x, y) -> x & y);
    }
}
