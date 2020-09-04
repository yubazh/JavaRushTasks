package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.regex.Pattern;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dir = reader.readLine();
        if (!Files.isDirectory(Paths.get(dir))) {
            System.out.println(dir + " - не папка");
        } else {
            MySimpleFileVisitor mySimpleFileVisitor = new MySimpleFileVisitor();
            Files.walkFileTree(Paths.get(dir), mySimpleFileVisitor);
            System.out.println("Всего папок - " + (mySimpleFileVisitor.getCountDir() - 1));
            System.out.println("Всего файлов - " + mySimpleFileVisitor.getCountFiles());
            System.out.println("Общий размер - " + mySimpleFileVisitor.getSizeFiles());
        }
    }

    public static class MySimpleFileVisitor extends SimpleFileVisitor {
        private int countDir = 0;
        private int countFiles = 0;
        private long sizeFiles = 0;

        public int getCountDir() {
            return countDir;
        }

        public int getCountFiles() {
            return countFiles;
        }

        public long getSizeFiles() {
            return sizeFiles;
        }

        @Override
        public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
            countFiles++;
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
            countDir++;
            sizeFiles += attrs.size();
            return FileVisitResult.CONTINUE;
        }
    }
}
