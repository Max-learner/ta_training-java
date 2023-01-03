package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns) {
        int[][] spiralFilledArrayElementsIncreaseByOne = new int[rows][columns];
        int currentUpperRow = 0;
        int currentBottomRow = rows - 1;
        int currentLeftmostColumn = 0;
        int currentRightmostColumn = columns - 1;
        int numberToPutInArrayElement = 1;
        int maximumNumberToPut = rows * columns;
        while (numberToPutInArrayElement <= maximumNumberToPut) {

            // filling the array from left to right
            for (int j = currentLeftmostColumn; j <= currentRightmostColumn; j++) {
                spiralFilledArrayElementsIncreaseByOne[currentUpperRow][j] = numberToPutInArrayElement;
                numberToPutInArrayElement++;
            }
            currentUpperRow++;

            // filling the array from top to bottom
            if (numberToPutInArrayElement <= maximumNumberToPut && currentUpperRow >= 0) {
                for (int i = currentUpperRow; i <= currentBottomRow; i++) {
                    spiralFilledArrayElementsIncreaseByOne[i][currentRightmostColumn] = numberToPutInArrayElement;
                    numberToPutInArrayElement++;
                }
                currentRightmostColumn--;
            }

            // filling the array from right to left
            if (numberToPutInArrayElement <= maximumNumberToPut) {
                for (int j = currentRightmostColumn; j >= currentLeftmostColumn; j--) {
                    spiralFilledArrayElementsIncreaseByOne[currentBottomRow][j] = numberToPutInArrayElement;
                    numberToPutInArrayElement++;
                }
                currentBottomRow--;
            }

            // filling the array from bottom to top
            if (numberToPutInArrayElement <= maximumNumberToPut) {
                for (int i = currentBottomRow; i >= currentUpperRow; i--) {
                    spiralFilledArrayElementsIncreaseByOne[i][currentLeftmostColumn] = numberToPutInArrayElement;
                    numberToPutInArrayElement++;
                }
                currentLeftmostColumn++;
            }
        }
        return spiralFilledArrayElementsIncreaseByOne;
    }
}
