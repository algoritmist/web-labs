package org.algoritmist.weblabs.lab2.shapes;

import org.algoritmist.weblabs.lab2.model.Vector;

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
        Vector OA = new Vector(centerPoint, Point1);
        Vector OB = new Vector(centerPoint, Point2);
        Vector OP = new Vector(centerPoint, point);
        return centerPoint.squareDist(point)
                <= centerPoint.squareDist(Point1) &&
                OA.multiply(OP) * OB.multiply(OP) <= 0 && OP.multiply(OA) * OP.multiply(OB) <= 0;
    }
}
