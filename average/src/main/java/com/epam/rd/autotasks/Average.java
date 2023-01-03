package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int enteredNumber;
        int numbersCount = 1;
        int numbersSum = scanner.nextInt();

        while (scanner.hasNext()) {
            enteredNumber = scanner.nextInt();
            if (enteredNumber != 0) {
               numbersSum += enteredNumber;
               numbersCount++;
            } else {break;}
        }
        System.out.println(numbersSum / numbersCount);
    }

}