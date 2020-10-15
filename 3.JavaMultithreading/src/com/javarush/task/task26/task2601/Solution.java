package com.javarush.task.task26.task2601;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        Integer[] array = new Integer[] {13, 8, 15, 5, 17};
        sort(array);
    }

    public static Integer[] sort(Integer[] array) {
        double mediana;
        Arrays.sort(array);
        if ((array.length % 2) != 0) {
             mediana = array[(int) Math.floor(array.length / 2)];
        } else {
            mediana = (array[array.length / 2] + array[array.length / 2 - 1]) / 2;
        }
        System.out.println(mediana);
        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                double i1 = (integer - mediana);
                double i2 = (t1 - mediana);
                return (int) (i1 * i1 - i2 * i2) * 100;
            }
        };

        Arrays.sort(array, comp);

        for (Integer i : array) {
            System.out.println(i);
        }


        //implement logic here
        return array;
    }
}
