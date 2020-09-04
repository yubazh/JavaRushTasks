package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileReader reader1 = new FileReader(fileName);
        Scanner scan = new Scanner(reader1);
        while (scan.hasNext()) {
            StringBuffer strBuffer = new StringBuffer(scan.nextLine());
            strBuffer.reverse();
            System.out.printf(String.valueOf(strBuffer) + "\n");
        }
        reader1.close();
    }
}
