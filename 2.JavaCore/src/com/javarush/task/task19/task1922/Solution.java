package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileReader reader1 = new FileReader(fileName);
        Scanner scan = new Scanner(reader1);
        String line = null;
        while (scan.hasNext()) {
            line = scan.nextLine();
            String[] subStr;
            String delitel = " ";
            subStr = line.split(delitel);
            int sch = 0;
            for (int i = 0; i < subStr.length; i++) {
                for (int j = 0; j < words.size(); j++) {
                    if (subStr[i].equals(words.get(j))) {
                        sch++;
                    }
                }
            }
            if (sch == 2) System.out.println(line);

        }


        reader1.close();
    }
}
