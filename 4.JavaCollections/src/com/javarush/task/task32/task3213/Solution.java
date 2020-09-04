package com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        if (reader == null) {
            return "ридер пустой";
        } else {
            BufferedReader reader1 = new BufferedReader(reader);
            String line = reader1.readLine();
            reader1.close();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                c = (char) (c + key);
                stringBuilder.append(c);
            }
            return stringBuilder.toString();
        }

    }
}
