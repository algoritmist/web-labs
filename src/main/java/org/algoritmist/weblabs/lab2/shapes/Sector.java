package org.algoritmist.weblabs.lab2.shapes;

public class Sector implements Shape {
    private final Point centerPoint;
    private final Point Point1;
    private final Point Point2;

    public Sector(Point O, Point A, Point B) {
        centerPoint = O;
        Point1 = A;
        Point2 = B;
    }

    @Override
    public boolean isInside(Point point) {
        return centerPoint.squareDist(point)
                <= centerPoint.squareDist(Point1) &&
                Double.compare(Point1.multiply(point), 0)
                        * Double.compare(Point2.multiply(point), 0) <= 0;
    }
}
