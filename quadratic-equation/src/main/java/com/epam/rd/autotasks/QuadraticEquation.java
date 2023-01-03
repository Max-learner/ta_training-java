package com.epam.rd.autotasks;

import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double discriminant = b * b - 4.0 * a * c;
        double quadraticEquationRoot;

        if (discriminant > 0) {
            quadraticEquationRoot = -(b - Math.sqrt(discriminant)) / (2.0 * a);
            System.out.print(quadraticEquationRoot + " ");
            quadraticEquationRoot = -(b + Math.sqrt(discriminant)) / (2.0 * a);
            System.out.println(quadraticEquationRoot);
        } else if (discriminant == 0) {
            quadraticEquationRoot = -b / 2.0 * a;
            System.out.println(quadraticEquationRoot);
        } else {
            System.out.println("no roots");
        }

    }
}