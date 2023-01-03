package com.epam.rd.autotasks.figures;

class Triangle extends Figure{
    private Point cornerPointA, cornerPointB, cornerPointC;
    public Triangle(Point a, Point b, Point c) {
        this.cornerPointA = a;
        this.cornerPointB = b;
        this.cornerPointC = c;
    }

    @Override
    public double area() {
        return Math.abs((cornerPointA.getX() * (cornerPointB.getY() - cornerPointC.getY())
                        + cornerPointB.getX() * (cornerPointC.getY() - cornerPointA.getY())
                        + cornerPointC.getX() * (cornerPointA.getY() - cornerPointB.getY())) / 2.0);
    }

    @Override
    public Point leftmostPoint() {
        Point leftMostPoint;
        if (cornerPointA.getX() < cornerPointB.getX()) {
            leftMostPoint = cornerPointA;
        } else {
            leftMostPoint = cornerPointB;
        }
        if (leftMostPoint.getX() > cornerPointC.getX()) leftMostPoint = cornerPointC;
        return leftMostPoint;
    }

    @Override
    public String pointsToString() {
        return (cornerPointA.toString() + cornerPointB.toString() + cornerPointC.toString());
    }

    @Override
    public String toString() {
        return "Triangle[" + cornerPointA.toString() + cornerPointB.toString() + cornerPointC.toString() + "]";
    }
}
