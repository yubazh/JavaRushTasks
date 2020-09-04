package com.javarush.task.task20.task2024;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Знакомство с графами
*/
public class Solution implements Serializable {
    int node;
    List<Solution> edges = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        FileOutputStream fOS = new FileOutputStream("C:\\test.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fOS);
        objectOutputStream.writeObject(solution);


    }
}
