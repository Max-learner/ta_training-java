package com.epam.rd.autotasks.max;

import java.util.OptionalInt;

public class MaxMethod {
    public static OptionalInt max(int[] values) {
        if (values == null || values.length == 0) return OptionalInt.empty();
        int maximumValue = values[0];
        for (int value : values) {
            if (value > maximumValue) maximumValue = value;
        }
        return OptionalInt.of(maximumValue);
    }
}
