package com.epam.rd.autotasks;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel{

    static int carouselRunsCount;
    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
        DecrementingCarousel.isDecrementingCarouselWithLimitedRun = true;
        this.carouselRunsCount = actionLimit;
    }
}
