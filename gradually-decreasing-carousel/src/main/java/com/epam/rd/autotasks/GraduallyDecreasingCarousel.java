package com.epam.rd.autotasks;

import java.util.Arrays;

public class GraduallyDecreasingCarousel extends DecrementingCarousel{

    static int[] valueToDecreaseCarouselElement;
    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
        DecrementingCarousel.isGraduallyDecreasingCarousel = true;
        this.valueToDecreaseCarouselElement = new int[capacity];
        Arrays.fill(valueToDecreaseCarouselElement, 1);
    }

    public static void decreaseElement() {
        if (elementsInCarousel[pointerIndex] >= 0) {
            elementsInCarousel[pointerIndex] -= valueToDecreaseCarouselElement[pointerIndex];
            valueToDecreaseCarouselElement[pointerIndex]++;
        }
    }
}
