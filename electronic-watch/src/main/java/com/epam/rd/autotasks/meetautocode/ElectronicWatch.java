package com.epam.rd.autotasks.meetautocode;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int enteredSeconds = scan.nextInt();

        int calculatedHours = enteredSeconds / 3600;
        int calculatedMinutes = (enteredSeconds - calculatedHours * 3600) / 60;
        int calculatedSeconds = enteredSeconds - calculatedHours * 3600 - calculatedMinutes * 60;

        System.out.printf("%01d" + ":%02d" + ":%02d",
                (calculatedHours == 24 ? 0 : calculatedHours), calculatedMinutes, calculatedSeconds);

    }
}
