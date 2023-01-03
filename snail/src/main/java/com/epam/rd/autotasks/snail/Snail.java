package com.epam.rd.autotasks.snail;

import java.util.Scanner;

public class Snail{
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int feetSnailClimbsUpEachDay = scan.nextInt();
        int feetSnailSlidesDownEachDay = scan.nextInt();
        int treeHeight = scan.nextInt();

        int daysToReachTreeTop = 0;
        int dailySnailTravel = 0;

        if (feetSnailClimbsUpEachDay > feetSnailSlidesDownEachDay) {

            while (dailySnailTravel < treeHeight) {
                dailySnailTravel = dailySnailTravel + feetSnailClimbsUpEachDay;
                if (dailySnailTravel < treeHeight) dailySnailTravel -= feetSnailSlidesDownEachDay;
                daysToReachTreeTop++;
            }
            System.out.println(daysToReachTreeTop);

        } else if (feetSnailClimbsUpEachDay >= treeHeight) {
            System.out.println(1);
        } else {
            System.out.println("Impossible");
        }
    }
}
