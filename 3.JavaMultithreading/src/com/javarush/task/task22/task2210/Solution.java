package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        List<String> list = new ArrayList<String>();
        while (tokenizer.hasMoreTokens()) {
            list.add(tokenizer.nextToken());
        }
        String[] array = list.toArray(new String[list.size()]);

        return array;
    }
}
