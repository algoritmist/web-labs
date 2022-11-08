package org.algoritmist.weblabs.lab2.controller.shapes;

import lombok.Getter;

@Getter
public class Point {
    private final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int multiply(Point other) {
        return x * other.y - y * other.x;
    }
}
