package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, -5};
        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array){
        int localMaximaCount = 0;
        int[] proxyArray = Arrays.copyOf(array, array.length);
        boolean[] isArrayElementLocalMaxima = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                if (array[i] > array [i + 1]) {
                    isArrayElementLocalMaxima[i] = true;
                    localMaximaCount++;
                }
            } else if (i == array.length - 1) {
                if (array[i] > array [i - 1]) {
                    isArrayElementLocalMaxima[i] = true;
                    localMaximaCount++;
                }
            } else {
                if (array[i] > array [i + 1] &&  array[i] > array [i - 1]) {
                    isArrayElementLocalMaxima[i] = true;
                    localMaximaCount++;
                }
            }
        }
        if (localMaximaCount<=0) return array;
        
        int[] arrayWithLocalMaximasRemoved = new int[proxyArray.length - localMaximaCount];
        int j = 0;
        for (int i = 0; i < proxyArray.length; i++ ) {
              if (isArrayElementLocalMaxima[i] != true) {
                  arrayWithLocalMaximasRemoved[j++] = proxyArray[i];
              }
        }
        return arrayWithLocalMaximasRemoved;
    }
}
