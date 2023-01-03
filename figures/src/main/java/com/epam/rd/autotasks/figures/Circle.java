package com.epam.rd.autotasks.figures;

class Circle extends Figure{
    private Point circleCenterPoint;
    private double circleRadius;
    public Circle(Point c, double r) {
        this.circleCenterPoint = c;
        this.circleRadius = r;
    }
    @Override
    public double area() {
        return Math.PI * Math.pow(circleRadius, 2);
    }

    @Override
    public Point leftmostPoint() {
        return new Point (circleCenterPoint.getX() - circleRadius, circleCenterPoint.getY());
    }

    @Override
    public String pointsToString() {
        return circleCenterPoint.toString();
    }

    @Override
    public String toString() {
        return "Circle[" + circleCenterPoint.toString() + circleRadius + "]";
    }
}
