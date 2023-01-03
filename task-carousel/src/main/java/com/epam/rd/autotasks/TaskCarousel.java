package com.epam.rd.autotasks;

import java.util.Arrays;

public class TaskCarousel {
    private Task[] elementsInCarousel;
    private int taskPointer = 0;
    private int elementsFilledInCarousel = 0;
    private int carouselCapacity;
    private boolean isCarouselOver;
    private int zeroesCount;
    public TaskCarousel(int capacity) {
        this.carouselCapacity = capacity;
        this.elementsInCarousel = new Task[capacity];
        this.taskPointer = 0;
        this.elementsFilledInCarousel = 0;
        this.zeroesCount = 0;
        this.isCarouselOver = false;
    }

    public boolean addTask(Task task) {
        if (task == null || isFull() || task.isFinished()) {
             return false;
        }
        while (elementsInCarousel[taskPointer] != null) {
            changePointerIndex();
        }
        elementsInCarousel[taskPointer] = task;
        changePointerIndex();
        elementsFilledInCarousel++;
        return true;
    }

    public boolean execute() {
        if (isEmpty()) {
            return false;
        }
        while (elementsInCarousel[taskPointer] == null) {
            changePointerIndex();
        }
        if (elementsInCarousel[taskPointer] != null) {
            elementsInCarousel[taskPointer].execute();
            if (elementsInCarousel[taskPointer].isFinished()) {
                elementsInCarousel[taskPointer] = null;
                if (elementsFilledInCarousel - 1 >= 0) {
                    elementsFilledInCarousel--;
                }
            }
        }
        changePointerIndex();
        return true;
    }

    private void changePointerIndex() {
        if(taskPointer < elementsInCarousel.length - 1) {
            taskPointer++;
        } else if (taskPointer == elementsInCarousel.length - 1) {
            taskPointer = 0;
        }
    }
    public boolean isFull() {
        zeroesCount = 0;
        for (int i = 0; i < elementsInCarousel.length; i++) {
            if (elementsInCarousel[i] != null) {
                zeroesCount++;
            }
        }
        if (zeroesCount == elementsInCarousel.length) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        zeroesCount = 0;
        for (Task element : elementsInCarousel) {
            if (element == null) {
                zeroesCount++;
            }
        }
        if (zeroesCount == elementsInCarousel.length) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "TaskCarousel{" +
                "elements=" + Arrays.toString(elementsInCarousel) +
                ", index=" + taskPointer +
                ", elementsFilled=" + elementsFilledInCarousel +
                ", capacity=" + carouselCapacity +
                ", isOver=" + isCarouselOver +
                ", zeroCount=" + zeroesCount +
                '}';
    }
}
