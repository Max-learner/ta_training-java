package com.epam.rd.autotasks;

public class DecrementingCarousel {
    static int[] elementsInCarousel;
    static int pointerIndex = 0;
    static int elementsFilledInCarousel = 0;
    static int carouselCapacity;
    static boolean isCarouselOver = false;
    static int zeroesCount = 0;
    static boolean isGraduallyDecreasingCarousel = false;
    static boolean isHalvingCarousel = false;
    static boolean isDecrementingCarouselWithLimitedRun = false;
    private boolean isCarouselStarted = false;
    private boolean isCarouselFilled = false;

    public DecrementingCarousel(int capacity) {
        this.carouselCapacity = capacity;
        this.elementsInCarousel = new int[capacity];
        this.pointerIndex = 0;
        this.elementsFilledInCarousel = 0;
        this.zeroesCount = 0;
        this.isHalvingCarousel = false;
        this.isGraduallyDecreasingCarousel = false;
        this.isDecrementingCarouselWithLimitedRun = false;
        this.isCarouselFilled = false;
        this.isCarouselStarted = false;
        this.isCarouselOver = false;
    }
    public boolean addElement(int element){
        if (!isCarouselStarted) {
            if (!isCarouselFilled) {
                if (element > 0 && pointerIndex < carouselCapacity) {
                    elementsInCarousel[pointerIndex] = element;
                    elementsFilledInCarousel++;
                    if(!(pointerIndex == carouselCapacity - 1)) {
                        pointerIndex++;
                    } else if (pointerIndex == carouselCapacity - 1) {
                        isCarouselFilled = true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static void decreaseElement() {
        if (elementsInCarousel[pointerIndex] - 1 >= 0) {
            elementsInCarousel[pointerIndex]--;
        }
    }

    public CarouselRun run(){
        if (isCarouselStarted == false) {
            isCarouselStarted = true;
            for (int element : elementsInCarousel) {
                if (element == 0) {
                    zeroesCount++;
                }
            }
            if (zeroesCount == elementsInCarousel.length) {
                isCarouselOver = true;
            }
            pointerIndex = 0;
            return CarouselRun.getInstance();
        }
        return null;
    }
}
