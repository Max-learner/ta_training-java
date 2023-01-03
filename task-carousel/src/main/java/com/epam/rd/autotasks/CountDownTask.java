package com.epam.rd.autotasks;

public class CountDownTask implements Task{

    private int taskExecutionCount;
    private boolean isTaskFinished = false;
    public CountDownTask(int value) {
        if (value <= 0) {
            this.taskExecutionCount = 0;
            isTaskFinished = true;
        } else {
            this.taskExecutionCount = value;
            isTaskFinished = false;
        }
    }

    public int getValue() {
        return taskExecutionCount;
    }


    @Override
    public void execute() {
        if (!isTaskFinished){
            taskExecutionCount--;
            if (taskExecutionCount == 0){
                isTaskFinished = true;
            }
        }
    }

    @Override
    public boolean isFinished() {
        if (isTaskFinished == true) {
            return true;
        }
        return false;
    }
}
