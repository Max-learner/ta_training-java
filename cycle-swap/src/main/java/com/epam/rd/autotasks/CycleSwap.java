package com.epam.rd.autotasks;

import java.util.Arrays;

class CycleSwap {
    static void cycleSwap(int[] array) {
        if (array.length > 0) {

            int[] swappedArrayBySinglePosition = Arrays.copyOf(array, array.length);
            System.arraycopy(swappedArrayBySinglePosition, 0, array, 1, array.length - 1);
            System.arraycopy(swappedArrayBySinglePosition, array.length - 1, array, 0, 1);

        }
    }

    static void cycleSwap(int[] array, int shift) {
        int[] swappedArrayVariableShift = Arrays.copyOf(array, array.length);

        if (array.length > 0) {
            System.arraycopy(swappedArrayVariableShift, 0, array, shift, array.length - shift);
            System.arraycopy(swappedArrayVariableShift, array.length - shift, array, 0, shift);
        }
    }
}
