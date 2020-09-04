package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader(args[0]);
        Scanner scan = new Scanner(reader);
        FileWriter writer = new FileWriter(args[1]);
        String line = null;
        while (scan.hasNext()) {
            line = scan.nextLine();
            String[] subStr;
            subStr = line.split(" ");
            for (int i = 0; i < subStr.length; i++) {
                for (int j = 0; j < subStr[i].length(); j++) {
                    if (Character.isDigit(subStr[i].charAt(j))) {
                        writer.write(subStr[i] + " ");
                        break;
                    }
                }
            }
        }
        reader.close();
        writer.close();
    }
}
