package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/
public class Solution extends Thread {

    UncaughtExceptionHandler exception = new MyUncaughtException();

    public Solution() {
        this.setUncaughtExceptionHandler(exception);
    }

    public static class MyUncaughtException implements UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread thread, Throwable throwable) {
            if (throwable instanceof Error) {
                System.out.println("Нельзя дальше работать");
            }
            if (throwable instanceof Exception) {
                System.out.println("Надо обработать");
            }
            if (throwable instanceof Throwable) {
                System.out.println("Поживем - увидим");
            }

        }
    }

    public static void main(String[] args) {

    }


}
