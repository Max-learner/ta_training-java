package com.epam.rd.autotasks.max;

public class MaxMethod {
    public static int max(int[] values) {

        int maximumValue = values[0];
        for (int element : values) {
            if (element > maximumValue) maximumValue = element;
        }
        return maximumValue;

    }
}
