package com.epam.rd.autotasks;

public class CarouselRun {
    private static CarouselRun carouselRunInstance = new CarouselRun();
    private CarouselRun(){}
    public static CarouselRun getInstance(){
        return carouselRunInstance;
    }
    public int next() {
        if (DecrementingCarousel.isDecrementingCarouselOver == true) {
            return -1;
        }
        while (DecrementingCarousel.elementsInDecrementingCarousel[DecrementingCarousel.pointerIndex] == 0) {
            if (checkIfElementsAreOver()) {
                return -1;
            }
            changePointerIndex();
        }

        int currentElement = DecrementingCarousel.elementsInDecrementingCarousel[DecrementingCarousel.pointerIndex];
        if (DecrementingCarousel.elementsInDecrementingCarousel[DecrementingCarousel.pointerIndex] - 1 >= 0) {
            DecrementingCarousel.elementsInDecrementingCarousel[DecrementingCarousel.pointerIndex]--;
        }

        changePointerIndex();
        checkIfElementsAreOver();
        return currentElement;
    }

    private void changePointerIndex() {
        if(DecrementingCarousel.pointerIndex < DecrementingCarousel.elementsFilledInDecrementingCarousel - 1) {
            DecrementingCarousel.pointerIndex++;
        } else if (DecrementingCarousel.pointerIndex == DecrementingCarousel.elementsFilledInDecrementingCarousel - 1) {
            DecrementingCarousel.pointerIndex = 0;
        }
    }

    private boolean checkIfElementsAreOver() {
        DecrementingCarousel.zeroesCount = 0;
        for (int element : DecrementingCarousel.elementsInDecrementingCarousel) {
            if (element == 0) {
                DecrementingCarousel.zeroesCount++;
            }
        }
        if (DecrementingCarousel.zeroesCount == DecrementingCarousel.elementsInDecrementingCarousel.length) {
            DecrementingCarousel.isDecrementingCarouselOver = true;
            return true;
        }
        return false;
    }

    public boolean isFinished() {
        if (DecrementingCarousel.isDecrementingCarouselOver == true) {
            return true;
        }
        return false;
    }


}
