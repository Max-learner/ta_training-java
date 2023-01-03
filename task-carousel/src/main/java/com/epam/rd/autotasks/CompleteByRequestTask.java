package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {

    private boolean isTaskCompleted = false;
    private boolean isTaskFinished = false;
    public CompleteByRequestTask() {
        this.isTaskCompleted = false;
        this.isTaskFinished = false;
    }

    @Override
    public void execute() {
        if (isTaskCompleted) {
            isTaskFinished = true;
        }
    }

    @Override
    public boolean isFinished() {
        if (isTaskFinished == true) {
            return true;
        }
        return false;
    }

    public void complete() {
        isTaskCompleted = true;
    }
}
