package org.algoritmist.weblabs.lab2.model;

import lombok.Getter;
import org.algoritmist.weblabs.lab2.shapes.Point;

public class Vector {
    @Getter
    private Point point;

    public Vector(Point a, Point b) {
        point = new Point(b.getX() - a.getX(), b.getY() - a.getY());
    }

    public double multiply(Vector other) {
        return point.multiply(other.getPoint());
    }
}
