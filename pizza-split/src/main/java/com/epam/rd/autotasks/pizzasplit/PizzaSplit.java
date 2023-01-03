package com.epam.rd.autotasks.pizzasplit;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int peopleToEatPizza = scanner.nextInt();
        int slicesPerPizza = scanner.nextInt();
        int equallySplittedPizzasAmount = 1;

        while (equallySplittedPizzasAmount * slicesPerPizza % peopleToEatPizza != 0) {
            equallySplittedPizzasAmount++;
        }
        System.out.println(equallySplittedPizzasAmount);
    }
}
