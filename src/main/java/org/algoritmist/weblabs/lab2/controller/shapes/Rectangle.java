package org.algoritmist.weblabs.lab2.controller.shapes;

import org.algoritmist.weblabs.lab2.controller.model.Dot;

public class Rectangle implements Shape {
    private Point lPoint;
    private Point rPoint;

    public Rectangle(Point p1, Point p2) {
        setPoints(p1, p2);
    }

    void setPoints(Point p1, Point p2) {
        lPoint = new Point(Math.min(p1.getX(), p2.getX()),
                Math.min(p1.getY(), p2.getY()));
        rPoint = new Point(Math.max(p1.getX(), p2.getX()),
                Math.max(p1.getY(), p2.getY()));
    }

    @Override
    public boolean isInside(Point point) {
        return lPoint.getX() <= point.getX() && point.getX() <= rPoint.getX() &&
                lPoint.getY() <= point.getY() && point.getY() <= rPoint.getY();
    }
}
