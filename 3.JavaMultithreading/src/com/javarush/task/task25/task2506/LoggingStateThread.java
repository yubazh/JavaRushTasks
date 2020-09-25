package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {

    Thread thread1;
    public LoggingStateThread(Thread thread) {
        thread1 = thread;
    }

    @Override
    public void run() {
        Thread.State currentState = thread1.getState();
        System.out.println(currentState);
        super.run();
        while (!currentState.equals(State.TERMINATED)) {
            Thread.State newState = thread1.getState();
            if (!newState.equals(currentState)) {
                currentState = newState;
                System.out.println(currentState);
            }
        }

    }
}
