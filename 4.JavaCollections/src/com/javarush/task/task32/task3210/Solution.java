package com.javarush.task.task32.task3210;

/* 
Используем RandomAccessFile
*/

import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
        raf.seek(Integer.parseInt(args[1]));
        String text = args[2];
        byte[] buf = new byte[text.length()];
        raf.read(buf, 0, text.length());
        String text2 = new String(buf);
        raf.seek(raf.length());

        if (text.equals(text2)) {
            raf.write("true".getBytes());
        } else {
            raf.write("false".getBytes());
        }

    }
}
