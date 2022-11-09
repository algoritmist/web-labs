package org.algoritmist.weblabs.lab2.shapes;


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
        boolean s1 = point.crossProduct(p1, p2) > 0;
        boolean s2 = point.crossProduct(p2, p3) > 0;
        boolean s3 = point.crossProduct(p3, p1) > 0;
        return s1 == s2 && s2 == s3;
    }
}