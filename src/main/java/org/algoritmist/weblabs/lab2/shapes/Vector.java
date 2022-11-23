package org.algoritmist.weblabs.lab2.shapes;

import lombok.Getter;

public class Vector {
    @Getter
    private Point point;

    public Vector(Point a, Point b) {
        point = new Point(b.getX() - a.getX(), b.getY() - a.getY());
    }

    public double multiply(Vector other) {
        return point.multiply(other.getPoint());
    }

    public double length() {
        return Math.sqrt(point.getX() * point.getX() +
                point.getY() * point.getY());
    }
}
