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

    private boolean between(Vector A, Vector B, Vector C) {
        return Math.min(A.angle(), B.angle()) <= C.angle() &&
                C.angle() <= Math.max(A.angle(), B.angle());
    }

    @Override
    public boolean isInside(Point point) {
        Vector OA = new Vector(centerPoint, Point1);
        Vector OB = new Vector(centerPoint, Point2);
        Vector OP = new Vector(centerPoint, point);
        return centerPoint.squareDist(point)
                <= centerPoint.squareDist(Point1) &&
                between(OA, OB, OP);
    }
}
