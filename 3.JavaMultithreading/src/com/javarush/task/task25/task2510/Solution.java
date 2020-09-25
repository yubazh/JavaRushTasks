package com.javarush.task.task25.task2510;

/*
Поживем - увидим
*/
public class Solution extends Thread {

    Thread.UncaughtExceptionHandler handlerException = new MyUncaughtException ( );

    public Solution() {
        this.setUncaughtExceptionHandler (handlerException);
    }

    public static class MyUncaughtException implements Thread.UncaughtExceptionHandler
    {
        @Override
        public void uncaughtException(Thread t, Throwable e)
        {
            if (e instanceof Error)
            {
                System.out.println ("Нельзя дальше работать");
            }
            else if (e instanceof Exception)
            {
                System.out.println ("Надо обработать");
            }
            else if (e instanceof Throwable)
            {
                System.out.println ("Поживем - увидим");
            }
        }
    }

    public static void main(String[] args) {
    }
}