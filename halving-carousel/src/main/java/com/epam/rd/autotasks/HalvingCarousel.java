package com.epam.rd.autotasks;

public class HalvingCarousel extends DecrementingCarousel {

    public HalvingCarousel(final int capacity) {
        super(capacity);
        DecrementingCarousel.isHalvingCarousel = true;
    }

    public static void decreaseElement() {
        if (elementsInCarousel[pointerIndex] - 1 >= 0) {
            elementsInCarousel[pointerIndex] /= 2;
        }
    }

}
