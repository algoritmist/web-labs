package org.algoritmist.weblabs.lab2.controller.shapes;

import lombok.Getter;

@Getter
public class Point {
    private final double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double multiply(Point other) {
        return x * other.y - y * other.x;
    }

    public double squareDist(Point other) {
        return (x - other.getX()) * (x - other.getX()) +
                (y - other.getY()) * (y - other.getY());
    }
}
