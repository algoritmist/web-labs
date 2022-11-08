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


    @Override
    public boolean isInside(Point point) {
        double s1 = Math.signum(point.multiply(p1));
        double s2 = Math.signum(point.multiply(p2));
        double s3 = Math.signum(point.multiply(p3));
        return s1 == s2 && s2 == s3;
    }
}
