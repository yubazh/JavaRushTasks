package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        InputStream input = new FileInputStream(args[0]);
        OutputStream output = new FileOutputStream(args[1]);

        Charset utf8 = Charset.forName("UTF-8");
        Charset windows1251 = Charset.forName("windows-1251");
        byte[] buffer = new byte[input.available()];
        while (input.available() > 0) {
            input.read(buffer);
            String s = new String(buffer, "Cp1251");
            buffer = s.getBytes("UTF-8");
            output.write(buffer);
        }

        input.close();
        output.close();
    }
}
