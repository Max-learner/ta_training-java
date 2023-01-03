package com.epam.rd.autotasks.meetstrangers;

import java.io.IOException;
import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int namesNumber = scan.nextInt();

        if (namesNumber > 0) {
            int i = 1;
            String enteredName = scan.nextLine();
            while (i <= namesNumber) {
                enteredName = scan.nextLine();
                System.out.println("Hello, " + enteredName);
                i++;
            }
        } else if (namesNumber == 0) {
            System.out.println("Oh, it looks like there is no one here");
        } else {
            System.out.println("Seriously? Why so negative?");
        }

    }
}
