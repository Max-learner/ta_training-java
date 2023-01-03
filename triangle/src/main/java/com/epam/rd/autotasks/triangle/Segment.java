package com.epam.rd.autotasks.triangle;

import static java.lang.Math.abs;

class Segment {
    Point segmentStartPoint;
    Point segmentEndPoint;

    public Segment(Point start, Point end) throws RuntimeException{
        if ((start.getX() == end.getX() && start.getY() == end.getY())
                || start.equals(null) || end.equals(null)) {
            throw new IllegalArgumentException();
        }
        this.segmentStartPoint = start;
        this.segmentEndPoint = end;
    }

    double length() {
        return Math.sqrt(Math.pow(segmentStartPoint.getX() - segmentEndPoint.getX(), 2)
                + Math.pow(segmentStartPoint.getY() - segmentEndPoint.getY(), 2));
    }

    Point middle() {
        return new Point((segmentStartPoint.getX() + segmentEndPoint.getX())/2,
                (segmentStartPoint.getY() + segmentEndPoint.getY())/2);
    }

    Point intersection(Segment another) {
        double intersectionCoordinateX, intersectionCoordinateY;
        Point proxyFirstSegmentStartPoint;
        Point proxyFirstSegmentEndPoint;
        if (this.segmentStartPoint.getX() > this.segmentEndPoint.getX()) {
            proxyFirstSegmentStartPoint = this.segmentEndPoint;
            proxyFirstSegmentEndPoint = this.segmentStartPoint;
        } else {
            proxyFirstSegmentEndPoint = this.segmentEndPoint;
            proxyFirstSegmentStartPoint = this.segmentStartPoint;
        }
        Point proxySecondSegmentStartPoint;
        Point proxySecondSegmentEndPoint;
        if (another.segmentStartPoint.getX() > another.segmentEndPoint.getX()) {
            proxySecondSegmentStartPoint = another.segmentEndPoint;
            proxySecondSegmentEndPoint = another.segmentStartPoint;
        } else {
            proxySecondSegmentEndPoint = another.segmentEndPoint;
            proxySecondSegmentStartPoint = another.segmentStartPoint;
        }
        double A1 = (proxyFirstSegmentStartPoint.getY() - proxyFirstSegmentEndPoint.getY()) / (proxyFirstSegmentStartPoint.getX() - proxyFirstSegmentEndPoint.getX());
        double A2 = (proxySecondSegmentStartPoint.getY() - proxySecondSegmentEndPoint.getY()) / (proxySecondSegmentStartPoint.getX() - proxySecondSegmentEndPoint.getX());
        double b1 = proxyFirstSegmentStartPoint.getY() - A1 * proxyFirstSegmentStartPoint.getX();
        double b2 = proxySecondSegmentStartPoint.getY() - A2 * proxySecondSegmentStartPoint.getX();

        if (A1 == A2) {
            return null;
        } else {
            intersectionCoordinateX = (b2 - b1) / (A1 - A2);
            if ( intersectionCoordinateX < Math.max(proxyFirstSegmentStartPoint.getX(),
                    proxySecondSegmentStartPoint.getX()) ||
                    intersectionCoordinateX > Math.min(proxyFirstSegmentEndPoint.getX(),
                            proxySecondSegmentEndPoint.getX())) {
                return null;
            }
        }
        intersectionCoordinateX = (b2 - b1) / (A1 - A2);
        intersectionCoordinateY = A1 * ((b2 - b1) / (A1 - A2)) + b1;
        return (new Point(intersectionCoordinateX, intersectionCoordinateY));

    }
}
