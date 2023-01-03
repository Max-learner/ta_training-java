package com.epam.rd.autotasks.figures;

class Circle extends Figure{
    private Point c;
    private double r;
    public Circle(Point c, double r) throws IllegalArgumentException{
        if (r <= 0.0 || c == null) {
            throw new IllegalArgumentException();
        }
        this.c = c;
        this.r = r;
    }
    public double area() {
        return Math.PI * Math.pow(r, 2);
    }
    public Point leftmostPoint() {
        return new Point (c.getX() - r, c.getY());
    }
    public String pointsToString() {
        return c.toString();
    }
    public Point getC(){
        return c;
    }
    public double getR(){
        return r;
    }
    @Override
    public String toString() {
        return "Circle[" + c.toString() + r + "]";
    }

    @Override
    public Point centroid() {
        return c;
    }

    @Override
    public boolean isTheSame(Figure figure) {
//        System.out.println(( ((Circle)figure).getC().getX() - c.getX() < 0.00001 )
//                + " " + ( ( ((Circle)figure).getC().getY() - c.getY() ) < 0.00001 )
//                + " " + (Math.abs(((Circle)figure).getR()) - r < 0.00001));
        if (figure.getClass() == Circle.class){
            if ( Math.abs(((Circle)figure).getC().getX() - c.getX()) <= 0.01
                    && Math.abs( ((Circle)figure).getC().getY() - c.getY() ) <= 0.01
                    &&   Math.abs(((Circle)figure).getR() - r) <= 0.01 ){
                return  true;
            }
        }
        return false;
    }
}
