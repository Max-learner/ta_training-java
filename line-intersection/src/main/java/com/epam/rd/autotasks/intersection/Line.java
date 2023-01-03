package com.epam.rd.autotasks.intersection;

public class Line {
    int lineCoefficientK;
    int lineCoefficientB;
    public Line(int k, int b) {
        this.lineCoefficientK = k;
        this.lineCoefficientB = b;
    }

    public Point intersection(Line other) {
        int coordinateX,coordinateY;

        if (this.lineCoefficientK == other.lineCoefficientK) {
            return null;
        } else {
            coordinateX = (other.lineCoefficientB -this.lineCoefficientB) /
                    (this.lineCoefficientK -other.lineCoefficientK);
            coordinateY = this.lineCoefficientK * ((other.lineCoefficientB -this.lineCoefficientB) /
                    (this.lineCoefficientK -other.lineCoefficientK)) + this.lineCoefficientB;
            return (new Point(coordinateX, coordinateY));
        }
    }
}
