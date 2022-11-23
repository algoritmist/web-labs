package org.algoritmist.weblabs.lab2.shapes;

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

    public double crossProduct(Point p2, Point p3) {
        return (this.getX() - p3.getX()) * (p2.getY() - p3.getY())
                - (p2.getX() - p3.getX()) * (this.getY() - p3.getY());
    }

}
