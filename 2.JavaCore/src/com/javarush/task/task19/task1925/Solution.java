package com.javarush.task.task19.task1925;

/* 
Длинные слова
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
        String line = "";
        FileWriter writer = new FileWriter(args[1]);
        boolean pervoe = true;
        while (scan.hasNext()) {
            line = scan.nextLine();
            String[] subStr = line.split(" ");
            for (int i = 0; i < subStr.length; i++) {
                if (subStr[i].length() > 6) {
                        if (pervoe) {
                        writer.write(subStr[i]);
                        pervoe = false;
                    } else {
                        writer.write("," + subStr[i]);
                    }
                }
            }
        }
        reader.close();
        writer.close();


    }
}
