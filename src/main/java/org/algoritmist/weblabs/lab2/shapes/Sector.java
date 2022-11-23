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
        Vector OA = new Vector(centerPoint, Point1);
        Vector OB = new Vector(centerPoint, Point2);
        Vector OC = new Vector(centerPoint, point);
        return centerPoint.squareDist(point)
                <= centerPoint.squareDist(Point1) &&
                OA.multiply(OC) * OB.length() + OC.multiply(OB) * OA.length() == OA.multiply(OB) * OC.length();
    }
}
