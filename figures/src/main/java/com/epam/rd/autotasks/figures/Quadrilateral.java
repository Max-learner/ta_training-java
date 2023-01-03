package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure{
    Point cornerPointA, cornerPointB, cornerPointC, cornerPointD;
    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.cornerPointA = a;
        this.cornerPointB = b;
        this.cornerPointC = c;
        this.cornerPointD = d;
    }

    @Override
    public double area() {
        return Math.abs((cornerPointA.getX() * cornerPointB.getY()
                + cornerPointB.getX()* cornerPointC.getY()
                + cornerPointC.getX() * cornerPointD.getY()
                + cornerPointD.getX() * cornerPointA.getY())
                - (cornerPointB.getX() * cornerPointA.getY()
                + cornerPointC.getX() * cornerPointB.getY()
                + cornerPointD.getX() * cornerPointC.getY()
                + cornerPointA.getX() * cornerPointD.getY())) / 2.0;
    }

    @Override
    public Point leftmostPoint() {
        Point firstPoint = (cornerPointA.getX() < cornerPointB.getX() ? cornerPointA : cornerPointB);
        Point secondPoint = (cornerPointC.getX() < cornerPointD.getX() ? cornerPointC : cornerPointD);
        return ((firstPoint.getX() < secondPoint.getX()) ? firstPoint : secondPoint);
    }

    @Override
    public String pointsToString() {
        return (cornerPointA.toString() + cornerPointB.toString()
                + cornerPointC.toString() + cornerPointD.toString());
    }

    @Override
    public String toString() {
        return "Quadrilateral[" + cornerPointA.toString() + cornerPointB.toString()
                + cornerPointC.toString() + cornerPointD.toString() + "]";
    }
}
