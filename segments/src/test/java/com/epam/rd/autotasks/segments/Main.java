package com.epam.rd.autotasks.segments;

import org.junit.jupiter.params.provider.Arguments;

public class Main {
    public static void main(String[] args) {

        {
            double length = new Segment(new Point(0, 0), new Point(3, 4)).length();
            System.out.println(length);
        }

        {
            Segment first = new Segment(new Point(0, 0), new Point(4, 4));
            Segment second = new Segment(new Point(2, 0), new Point(0, 2));
            Point intersection = first.intersection(second);

            System.out.println(intersection.getX());
            System.out.println(intersection.getY());
        }

        {
            Segment first = new Segment(new Point(0, 0), new Point(4, 0));
            Segment second = new Segment(new Point(2, 1), new Point(1, 2));
            Point intersection = first.intersection(second);

            System.out.println(intersection == null);
        }

        {
            Segment first = new Segment(new Point(0, 3), new Point(9, 0));
            Segment second = new Segment(new Point(0, 2), new Point(10, 0));
            Point intersection = first.intersection(second);
            System.out.println("1."+ (intersection == new Point(7.5, 0.5)));
        }
        {
            Segment first = new Segment(new Point(0, 0), new Point(3, 4));
            Segment second = new Segment(new Point(0, 0), new Point(5, 100));
            Point intersection = first.intersection(second);
            System.out.println("2." + (intersection == new Point(0, 0)));
        }
        {
            Segment first =new Segment(new Point(2, 5), new Point(5, 1));
            Segment second =        new Segment(new Point(0, 2), new Point(5, 5));
            Point intersection = first.intersection(second);
            System.out.println("3." + (intersection == new Point(2.9310344827586206, 3.7586206896551726)));
        }
        {
            Segment first =new Segment(new Point(2, 5), new Point(0.5, 1.5));
            Segment second =  new Segment(new Point(0, 2), new Point(5, 5));
            Point intersection = first.intersection(second);
            System.out.println("4." + (intersection == new Point(0.9615384615384616, 2.576923076923077)));
        }
        {
            Segment first =   new Segment(new Point(2, 5), new Point(0.5, 1.5));
            Segment second =     new Segment(new Point(0, 2), new Point(2, 5));
            Point intersection = first.intersection(second);
            System.out.println("5." + intersection.equals( new Point(2, 5)));
        }
            Segment first =  new Segment(new Point(-3, 0.5), new Point(0.5, 1.5));
            Segment second =   new Segment(new Point(0, 2), new Point(-3, -1.5));
            Point intersection = first.intersection(second);
            System.out.println("6." + (intersection == new Point(-0.7297297297297297, 1.1486486486486487)));
        }

        {
            Segment first = new Segment(new Point(0, 0), new Point(1, 1));
            Segment second =  new Segment(new Point(1, 1), new Point(2, 2));
            Point intersection = first.intersection(second);
            System.out.println("7." + (intersection ==null));
        }

        {
            Segment first = new Segment(new Point(0, 0), new Point(1, 1));
            Segment second =        new Segment(new Point(2, 2), new Point(3, 3));
            Point intersection = first.intersection(second);
            System.out.println("8." + (intersection ==null));
        }

        {
            Segment first = new Segment(new Point(0, 0), new Point(2, 2));
            Segment second =         new Segment(new Point(2, 2), new Point(1, 1));
            Point intersection = first.intersection(second);
            System.out.println("9." + (intersection ==null));

        }

        {
            Segment first = new Segment(new Point(0, 0), new Point(1, 1));
            Segment second =         new Segment(new Point(-1, -1), new Point(-2, 2));
            Point intersection = first.intersection(second);
            System.out.println("10." + (intersection ==null));
        }

        {
            Segment first =new Segment(new Point(0, 3), new Point(9, 0));
            Segment second =          new Segment(new Point(0, 2), new Point(2, 0));
            Point intersection = first.intersection(second);
            System.out.println("11." + (intersection ==null));
        }
        {
            Segment first =       new Segment(new Point(0, 3), new Point(4, 0));
            Segment second =  new Segment(new Point(-1, -3), new Point(1, 1));
            Point intersection = first.intersection(second);
            System.out.println("12." + (intersection ==null));
        }

}
