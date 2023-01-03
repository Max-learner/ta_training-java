package com.epam.rd.autotasks.arrays;

public class SumOfEvenNumbers {

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 8, 15, 199};
        System.out.println(sum(array));
    }

    public static int sum(int[] array){

        if (array == null || array.length == 0) {
            return 0;
        }
        int sumOfEvenNumbers = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                sumOfEvenNumbers += array[i];
            }
        }
        return sumOfEvenNumbers;
    }
}
