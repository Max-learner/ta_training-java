package com.epam.rd.autotasks.figures;

public class Triangle extends Figure {

    private Point cornerPointA, cornerPointB, cornerPointC;
    double area;
    public Triangle(Point a, Point b, Point c) throws IllegalArgumentException {
        if (a == null || b == null || c == null) {
            throw new IllegalArgumentException();
        }
        double area = Math.abs((a.getX() * (b.getY() - c.getY())
                + b.getX() * (c.getY() - a.getY())
                + c.getX() * (a.getY() - b.getY())) / 2.0);
        if (Math.abs(area) <= 0.0) {
            throw new IllegalArgumentException();
        }
        this.cornerPointA = a;
        this.cornerPointB = b;
        this.cornerPointC = c;
        this.area = area;
    }

    public double area() {
        return this.area;
    }

    public Point centroid(){
        return new Point((cornerPointA.getX() + cornerPointB.getX() + cornerPointC.getX())/3,
                (cornerPointA.getY() + cornerPointB.getY() + cornerPointC.getY())/3);
    }
    @Override
    public boolean isTheSame(Figure figure){
        return false;
    };
}
