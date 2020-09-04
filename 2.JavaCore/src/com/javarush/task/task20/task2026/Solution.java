package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        byte[][] array = a;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] == 1) {
                    int x = i, y = j;

                    while (array[x][y] == 1) {
                        if (x >= (array.length - 1)) {
                            x++;
                            break;
                        }
                        x++;

                    }
                    x--;
                    while (array[x][y] == 1) {
                        if (y >= (array.length - 1)) {
                            y++;
                            break;
                        }
                        y++;
                    }
                    y--;
                    for (int i1 = i; i1 <= x; i1++) {
                        for (int j1 = j; j1 <= y; j1++) {
                            array[i1][j1] = 0;
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}
