package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String[] strBuffer = outputStream.toString().split("\n");
        System.setOut(consoleStream);
        int j = 0;
        for (int i = 0; i < strBuffer.length; i++) {
            if (j >= 2) {
                System.out.println("JavaRush - курсы Java онлайн");
                System.out.println(strBuffer[i]);
                j = 1;
            } else {
                System.out.println(strBuffer[i]);
                j = j + 1;
            }

        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
