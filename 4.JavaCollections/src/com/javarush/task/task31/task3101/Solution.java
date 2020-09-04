package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*
Проход по дереву файлов

мое решение
*/

 public class Solution {
    public static void main(String[] args) throws IOException {
        String path = args[0];
        String resultFileAbsolutePath = args[1];
        File file = new File(resultFileAbsolutePath);
        File file2 = new File(file.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(file, file2);
        TreeMap<String, String> fileList = new TreeMap<String, String>();
        fileList.putAll(sortFiles(path));
        fileList.remove("allFilesContent.txt");
        FileWriter writer = new FileWriter(file2);
        for (String iFile : fileList.values()) {
            BufferedReader reader = new BufferedReader(new FileReader(iFile));
            String line = "";
            while (reader.ready()) {
                writer.write(reader.readLine());
            }
            writer.write("\n");
            reader.close();
        }
        writer.close();

    }

    public static TreeMap<String, String> sortFiles(String stroka) {
        File file = new File(stroka);
        TreeMap<String, String> iList = new TreeMap<String, String>();
        for (File iFile : file.listFiles()) {
            if (iFile.isDirectory()) {
                iList.putAll(sortFiles(iFile.getAbsolutePath()));
            } else
            {
                if (iFile.length() <= 50) iList.put(iFile.getName(), iFile.getAbsolutePath());
            }

        }
        return iList;
    }
}
