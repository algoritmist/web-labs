package org.algoritmist.weblabs.lab2.model;

import org.algoritmist.weblabs.lab2.shapes.*;

import java.util.Arrays;

public class Graph {
    private final Shape[] parts;

    public Graph(Shape[] shapes) {
        parts = shapes;
    }

    public static Graph graphFromRadius(Double r){
        return new Graph(
                new Shape[]{
                        new Rectangle(
                                new Point(0, 0),
                                new Point(r, -0.5 * r)
                        ),
                        new Triangle(
                                new Point(-r, 0),
                                new Point(0, 0),
                                new Point(0, r)
                        ),
                        new Sector(
                                new Point(0, 0),
                                new Point(0.5 * r, 0),
                                new Point(0, 0.5 * r)
                        )
                }
        );
    }

    public boolean isInside(Point point) {
        return Arrays.stream(parts).map(x -> x.isInside(point)).
                reduce(true, (x, y) -> x & y);
    }
}
