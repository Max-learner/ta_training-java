package com.epam.rd.autotasks;

public class DecrementingCarousel {
    static int[] elementsInDecrementingCarousel;
    static int pointerIndex = 0;
    static int elementsFilledInDecrementingCarousel = 0;
    static int decrementingCarouselCapacity;
    static boolean isDecrementingCarouselOver = false;
    static int zeroesCount = 0;
    private boolean isCarouselStarted = false;
    private boolean isCarouselFilled = false;

    public DecrementingCarousel(int capacity) {
        this.decrementingCarouselCapacity = capacity;
        this.elementsInDecrementingCarousel = new int[capacity];
        this.pointerIndex = 0;
        this.elementsFilledInDecrementingCarousel = 0;
        this.zeroesCount = 0;
        this.isCarouselFilled = false;
        this.isCarouselStarted = false;
        this.isDecrementingCarouselOver = false;
    }
    public boolean addElement(int element){
        if (!isCarouselStarted) {
            if (!isCarouselFilled) {
                if (element > 0 && pointerIndex < decrementingCarouselCapacity) {
                    elementsInDecrementingCarousel[pointerIndex] = element;
                    elementsFilledInDecrementingCarousel++;
                    if(!(pointerIndex == decrementingCarouselCapacity - 1)) {
                        pointerIndex++;
                    } else if (pointerIndex == decrementingCarouselCapacity - 1) {
                        isCarouselFilled = true;
                    }
                    return true;
                }
            }
        }
        return false;//throw new UnsupportedOperationException();
    }
    public CarouselRun run(){
        if (isCarouselStarted == false) {
            isCarouselStarted = true;
            for (int el : elementsInDecrementingCarousel) {
                if (el == 0) {
                    zeroesCount++;
                }
            }
            if (zeroesCount == elementsInDecrementingCarousel.length) {
                isDecrementingCarouselOver = true;
            }
            pointerIndex = 0;
            return CarouselRun.getInstance();
        }
        return null;
    }
}
