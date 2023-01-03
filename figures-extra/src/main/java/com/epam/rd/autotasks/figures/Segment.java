package com.epam.rd.autotasks.figures;


import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

public class Segment {
        Point start;
        Point end;

        public Segment(Point start, Point end) throws RuntimeException{
            if ((start.getX() == end.getX() && start.getY() == end.getY())
                    || start.equals(null) || end.equals(null)) {
                throw new IllegalArgumentException();
            }
            this.start = start;
            this.end = end;
        }

        double length() {
            double length;
            length = Math.sqrt(Math.pow(start.getX() - end.getX(), 2) + Math.pow(start.getY() - end.getY(), 2));
            return length;
        }

        Point middle() {
            double x, y;
            x = (start.getX() + end.getX())/2;
            y = (start.getY() + end.getY())/2;
            return new Point(x, y);
        }

        Point intersection(Segment another) {
            double x, y;
            Point p1;
            Point p2;
            if (this.start.getX() > this.end.getX()) {
                p1 = this.end;
                p2 = this.start;
            } else {
                p2 = this.end;
                p1 = this.start;
            }
            Point p3;
            Point p4;
            if (another.start.getX() > another.end.getX()) {
                p3 = another.end;
                p4 = another.start;
            } else {
                p4 = another.end;
                p3 = another.start;
            }
            double A1 = (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());
            double A2 = (p3.getY() - p4.getY()) / (p3.getX() - p4.getX());
            double b1 = p1.getY() - A1 * p1.getX();
            double b2 = p3.getY() - A2 * p3.getX();

            if (A1 == A2) {
                return null;

            } else {
                double swap;
                x = (b2 - b1) / (A1 - A2);
                if (p2.getX()> p1.getX()) {

                }
                if ( x < Math.max(p1.getX(), p3.getX()) || x > Math.min(p2.getX(), p4.getX())) {
                    return null;
                }
            }
            x = (b2 - b1) / (A1 - A2);
            y = A1 * ((b2 - b1) / (A1 - A2)) + b1;
            return (new Point(x, y));

        }
    }

