package com.epam.rd.autotasks.figures;

public class Quadrilateral extends Figure{
    Point cornerPointA, cornerPointB, cornerPointC, cornerPointD;
    Point[] points = new Point[4];
    double area;
    public Quadrilateral(Point a, Point b, Point c, Point d) {
        if (a == null || b == null || c == null || d == null) {
            throw new IllegalArgumentException();
        }
        double area = Math.abs((a.getX() * b.getY() + b.getX()* c.getY()
                + c.getX() * d.getY() + d.getX() * a.getY())
                - (b.getX() * a.getY() + c.getX() * b.getY()
                + d.getX() * c.getY() + a.getX() * d.getY())) / 2.0 ;

        if (Math.abs(area) <= 0.0) {
            throw new IllegalArgumentException();
        }
        if ((b.getX() - a.getX()) * (c.getY() - a.getY()) == (c.getX() - a.getX()) * (b.getY() - a.getY())
            && (b.getX() - a.getX()) * (d.getY() - a.getY()) == (d.getX() - a.getX()) * (b.getY() - a.getY())) {
            throw new IllegalArgumentException();
        }

        Triangle ABC = new Triangle(a, b, c);
        Triangle BCD = new Triangle(b, c, d);
        Triangle ACD = new Triangle(a, c, d);
        Triangle ABD = new Triangle(a, b, d);
        if (ABD.area() + BCD.area() != ACD.area() + ABC.area()) {
            throw new IllegalArgumentException();
        }

        this.cornerPointA = a; points[0] = a;
        this.cornerPointB = b; points[1] = b;
        this.cornerPointC = c; points[2] = c;
        this.cornerPointD = d; points[3] = d;
        this.area = area;

    }

    public double area() {
        return area;
    }

    public Point leftmostPoint() {
        Point firstPoint = (cornerPointA.getX() < cornerPointB.getX() ? cornerPointA : cornerPointB);
        Point secondPoint = (cornerPointC.getX() < cornerPointD.getX() ? cornerPointC : cornerPointD);
        return ((firstPoint.getX() < secondPoint.getX()) ? firstPoint : secondPoint);
    }


    public String pointsToString() {
        return (cornerPointA.toString() + cornerPointB.toString() + cornerPointC.toString() + cornerPointD.toString());
    }

    @Override
    public String toString() {
        return "Quadrilateral[" + cornerPointA.toString() + cornerPointB.toString() + cornerPointC.toString() + cornerPointD.toString() + "]";
    }

    @Override
    public Point centroid() {
        Triangle ABC = new Triangle(cornerPointA, cornerPointB, cornerPointC);
        Triangle BCD = new Triangle(cornerPointB, cornerPointC, cornerPointD);
        Triangle ACD = new Triangle(cornerPointA, cornerPointC, cornerPointD);
        Triangle ABD = new Triangle(cornerPointA, cornerPointB, cornerPointD);

        Point centroidPointA = BCD.centroid();
        Point centroidPointB = ACD.centroid();
        Point centroidPointC = ABD.centroid();
        Point centroidPointD = ABC.centroid();

        return new Segment(centroidPointA,centroidPointC).intersection(new Segment(centroidPointB,centroidPointD));
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure.getClass() == Quadrilateral.class
                && ( ((Quadrilateral) figure).cornerPointA.equals(this.cornerPointA) || ((Quadrilateral) figure).cornerPointB.equals(this.cornerPointA) || ((Quadrilateral) figure).cornerPointC.equals(this.cornerPointA) || ((Quadrilateral) figure).cornerPointD.equals(this.cornerPointA) )
                && ( ((Quadrilateral) figure).cornerPointA.equals(this.cornerPointB) || ((Quadrilateral) figure).cornerPointB.equals(this.cornerPointB) || ((Quadrilateral) figure).cornerPointC.equals(this.cornerPointB)|| ((Quadrilateral) figure).cornerPointD.equals(this.cornerPointB) )
                && ( ((Quadrilateral) figure).cornerPointA.equals(this.cornerPointC) || ((Quadrilateral) figure).cornerPointB.equals(this.cornerPointC) || ((Quadrilateral) figure).cornerPointC.equals(this.cornerPointC)|| ((Quadrilateral) figure).cornerPointD.equals(this.cornerPointC) )
                && ( ((Quadrilateral) figure).cornerPointA.equals(this.cornerPointD) || ((Quadrilateral) figure).cornerPointB.equals(this.cornerPointD) || ((Quadrilateral) figure).cornerPointC.equals(this.cornerPointD)|| ((Quadrilateral) figure).cornerPointD.equals(this.cornerPointD) )
            ) {
            return true;
        }
        return true;
    }
}
