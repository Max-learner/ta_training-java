package com.epam.rd.autotasks.figures;

public class Point {
    private double coordinateX;
    private double coordinateY;

    public Point(final double x, final double y) {
        this.coordinateX = x;
        this.coordinateY = y;
    }

    public double getX() {
        return coordinateX;
    }

    public double getY() {
        return coordinateY;
    }

    @Override
    public String toString() {
        return String.format("(%1.1f,%1.1f)", coordinateX, coordinateY);
    }
}
