package org.algoritmist.weblabs.lab2.controller.shapes;

public class Triangle implements Shape {
    private final Point p1;
    private final Point p2;
    private final Point p3;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    private int sign(int x) {
        return Integer.compare(x, 0);
    }

    @Override
    public boolean isInside(Point point) {
        int s1 = sign(point.multiply(p1));
        int s2 = sign(point.multiply(p2));
        int s3 = sign(point.multiply(p3));
        return s1 == s2 && s2 == s3;
    }
}
