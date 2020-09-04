package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Замена чисел
*/




public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileReader reader1 = new FileReader(fileName);
        Scanner scan = new Scanner(reader1);
        String line = "";
        while (scan.hasNext()) {
            line = scan.nextLine();
            String[] subStr = line.split(" ");
            line = "";
            for (int i = 0; i < subStr.length; i++) {
                if (isNumber(subStr[i])) {
                    int chislo = Integer.parseInt(subStr[i]);
                    if (map.containsKey(chislo)) {
                        subStr[i] = map.get(chislo);
                    }
                }
                if (i == 0) line = subStr[i]; else { line = line + " " + subStr[i]; };
            }
            System.out.println(line);
        }
        reader1.close();

    }

    public static boolean isNumber(String str) {
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }
}
