package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        StringBuilder result = new StringBuilder();
        result.append(a);
        int temp = a;
        if (a == b) {
            return Integer.toString(a);
        } else {
            if (a > b) {
                while (temp > b) {
                    result.append(" ").append(--temp);
                }
            } else {

                while (temp < b) {
                    result.append(" ").append(++temp);
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}