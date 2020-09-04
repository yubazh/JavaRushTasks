package com.javarush.task.task20.task2025;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.Vector;

/* 
Алгоритмы-числа
*/
public class Solution {

    public static long[][] stepen = new long[10][20];

    static {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 19; j++) {
                stepen[i][j] = stepenMeth(i, j);
            }
        }
    }

    public static long[] getNumbers(long N) {
        long[] result = new long[0];
        long m, m1, summ, summ1;
        byte[] chisla, proverkaChisla = new byte[0];
        for (int i = 1; i < N; i++) {
            summ = 0;
            m = getCountsOfDigits(i);
            chisla = razdelNaByte(i, (int) m);
            if (proverkaNaUvel(chisla)) {
                for (int j = 0; j < m; j++) {
                    summ += stepen[chisla[j]][(int) m];
                }

                m1 = getCountsOfDigits(summ);
                proverkaChisla = razdelNaByte(summ, (int) m1);
                summ1 = 0;
                for (int i1 = 0; i1 < m1; i1++) {
                    summ1 += stepen[proverkaChisla[i1]][(int) m1];

                }
                if ((summ == summ1) & (checkIfExist(result, summ))) {
                            result = Arrays.copyOf(result, result.length + 1);
                            result[result.length - 1] = summ;
                    //System.out.println(i);
                }
            }
        }
        long temp;
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                if (result[i] < result[j]) {
                    temp = result[i];
                    result[i] = result[j];
                    result[j] = temp;
                }
            }
        }
        return result;
    }

    public static boolean checkIfExist(long[] result, long summ) {
        for (int i = 0; i < result.length; i++) {
            if (result[i] == summ) {
                return false;
            }
        }
        return true;
    }

    public static boolean proverkaNaUvel(byte[] chisla) {
        byte check = 1;
        if (chisla.length == 1) {   return true; }
        for (int i = 1; i < chisla.length; i++) {
       // if (i > 0) {
            if ((chisla[i] <= chisla[i - 1]) | (chisla[i - 1]) == 0) {
                check++;

            }
      //  }
        }
        if (check == chisla.length) { return true; }
        else { return false; }
    }

    public static int getCountsOfDigits(long number) {
        return(number == 0) ? 1 : (int) Math.ceil(Math.log10(Math.abs(number) + 0.5));
    }

    public static int stepenMeth(int base, int step) {
        return (int) Math.pow(base, step);
    }

    public static byte[] razdelNaByte(long number, int size) {
        byte[] result = new byte[size];
        for (int i = 0; i < size; i++) {
            result[i] = (byte) (number % 10);

            number = number / 10;
        }

        return result;
    }


  /*  private static int N;
    private static int[] digitsMultiSet;
    private static int[] testMultiSet;

    private static TreeSet<Long> results;

    private static long maxPow;
    private static long minPow;
    private static long[][] pows;

    private static void genPows(int N) {
        pows = new long[10][N + 1];
        for (int i = 0; i < pows.length; i++) {
            long p = 1;
            for (int j = 0; j < pows[i].length; j++) {
                pows[i][j] = p;
                p *= i;
            }
        }
    }

    private static boolean check(long pow) {
        if (pow >= maxPow) return false;
        if (pow < minPow) return false;

        for (int i = 0; i < 10; i++) {
            testMultiSet[i] = 0;
        }

        while (pow > 0) {
            int i = (int) (pow % 10);
            testMultiSet[i]++;
            if (testMultiSet[i] > digitsMultiSet[i]) return false;
            pow = pow / 10;
        }

        for (int i = 0; i < 10; i++) {
            if (testMultiSet[i] != digitsMultiSet[i]) return false;
        }

        return true;
    }

    private static void search(int digit, int unused, long pow) {
        if (pow >= maxPow) return;

        if (digit == -1) {
            if (check(pow)) results.add(pow);
            return;
        }

        if (digit == 0) {
            digitsMultiSet[digit] = unused;
            search(digit - 1, 0, pow + unused * pows[digit][N]);
        } else {
            if (pow + unused * pows[digit][N] < minPow) return;

            long p = pow;
            for (int i = 0; i <= unused; i++) {
                digitsMultiSet[digit] = i;
                search(digit - 1, unused - i, p);
                if (i != unused) {
                    p += pows[digit][N];
                }
            }
        }
    }

    public static long[] getNumbers(long number) {
        N = 0;
        results = new TreeSet<>();
        digitsMultiSet = new int[10];
        testMultiSet = new int[10];

        int maxN = (number <= 1) ? 1 : (int) Math.ceil(Math.log10(number));
        genPows(maxN);

        for (N = 1; N <= maxN; N++) {
            minPow = (long) Math.pow(10, N - 1);
            maxPow = (long) Math.pow(10, N);
            search(9, N, 0);
        }

        return results.stream()
                .mapToLong(l -> l)
                .filter(l -> l < number)
                .toArray();
    } */

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
