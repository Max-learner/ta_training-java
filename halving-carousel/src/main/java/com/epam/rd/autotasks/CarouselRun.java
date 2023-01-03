package com.epam.rd.autotasks;

public class CarouselRun {
    private static CarouselRun carouselRun = new CarouselRun();
    private CarouselRun(){}
    public static CarouselRun getInstance(){
        return carouselRun;
    }
    public int next() {
        if (DecrementingCarousel.isCarouselOver == true) {
            return -1;
        }
        while (DecrementingCarousel.elementsInCarousel[DecrementingCarousel.pointerIndex] == 0) {
            if (checkIsCarouselOver()) {
                return -1;
            }
            changePointerIndex();
        }

        int currentElement = DecrementingCarousel.elementsInCarousel[DecrementingCarousel.pointerIndex];

        if (DecrementingCarousel.isHalvingCarousel) {
            HalvingCarousel.decreaseElement();
        } else {
            DecrementingCarousel.decreaseElement();
        }
        changePointerIndex();
        checkIsCarouselOver();
        return currentElement;
    }

    private void changePointerIndex() {
        if(DecrementingCarousel.pointerIndex < DecrementingCarousel.elementsFilledInCarousel - 1) {
            DecrementingCarousel.pointerIndex++;
        } else if (DecrementingCarousel.pointerIndex == DecrementingCarousel.elementsFilledInCarousel - 1) {
            DecrementingCarousel.pointerIndex = 0;
        }
    }

    private boolean checkIsCarouselOver() {
        DecrementingCarousel.zeroesCount = 0;
        for (int element : DecrementingCarousel.elementsInCarousel) {
            if (element == 0) {
                DecrementingCarousel.zeroesCount++;
            }
        }
        if (DecrementingCarousel.zeroesCount == DecrementingCarousel.elementsInCarousel.length) {
            DecrementingCarousel.isCarouselOver = true;
            return true;
        }
        return false;
    }

    public boolean isFinished() {
        if (DecrementingCarousel.isCarouselOver == true) {
            return true;
        }
        return false;
    }


}
