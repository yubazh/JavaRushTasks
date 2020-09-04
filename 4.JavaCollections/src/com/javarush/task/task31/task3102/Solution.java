package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        Stack<File> stack = new Stack<File>();
        File rootdir = new File(root);
        Collections.addAll(stack, rootdir.listFiles());
        while (!stack.empty()) {
            File iFile = stack.pop();
            if (iFile.isDirectory()) {
                Collections.addAll(stack, iFile.listFiles());
            } else if (iFile.isFile()) {
                list.add(iFile.getAbsolutePath());
            }
        }
        return list;

    }

    public static void main(String[] args) throws IOException {
        String line = "C:\\test";
        ArrayList<String> list = (ArrayList<String>) getFileTree(line);
        for (String iLine : list) {
            System.out.println(iLine);
        }
    }
}
