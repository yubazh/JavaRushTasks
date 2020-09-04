package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("C:/test/test.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        if (is != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            StringWriter writer = new StringWriter();
            while ((line = reader.readLine()) != null) {
                writer.write(line);
            }
            return writer;
        } else {
            return new StringWriter();
        }

    }
}