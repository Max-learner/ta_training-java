package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        double overallBillToPay = scan.nextDouble();
        double friendsNumber = scan.nextDouble();

        if (overallBillToPay < 0) {
            System.out.println("Bill total amount cannot be negative");
            return;
        }
        if (friendsNumber <= 0) {
            System.out.println("Number of friends cannot be negative or zero");
            return;
        }

        double amountPerPerson = overallBillToPay / friendsNumber + overallBillToPay / friendsNumber / 10;
        System.out.println((int)amountPerPerson);

    }
}
