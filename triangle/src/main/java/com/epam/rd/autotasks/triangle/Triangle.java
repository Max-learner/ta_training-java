package com.epam.rd.autotasks.triangle;

class Triangle {

    Point cornerPointA, cornerPointB, cornerPointC;
    double triangleArea;
    public Triangle(Point a, Point b, Point c) throws IllegalArgumentException {

        Segment sideAB = new Segment(a, b);
        Segment sideBC = new Segment(b, c);
        Segment sideCA = new Segment(c, a);

        double area = Math.sqrt( (sideAB.length() + sideBC.length() + sideCA.length())
                *(sideBC.length() + sideCA.length() - sideAB.length())
                *(sideAB.length() + sideCA.length() - sideBC.length())
                *(sideAB.length() + sideBC.length() - sideCA.length())
                )/4;

        if (area <= 0.0) {
            throw new IllegalArgumentException();
        }
        this.cornerPointA = a;
        this.cornerPointB = b;
        this.cornerPointC = c;
        this.triangleArea = area;
    }

    public double area() {
        return this.triangleArea;
    }

    public Point centroid(){
        return new Point((cornerPointA.getX() + cornerPointB.getX() + cornerPointC.getX())/3,
                (cornerPointA.getY() + cornerPointB.getY() + cornerPointC.getY())/3);
    }

}
