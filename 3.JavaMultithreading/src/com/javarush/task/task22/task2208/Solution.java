package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {


    }

    public static String getQuery(Map<String, String> params) {
        String and = "";
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> pair : params.entrySet()) {

            if (pair.getValue() != null) {
                sb.append(String.format(and + "%s = '%s'", pair.getKey(), pair.getValue()));
                and = " and ";
            }
        }
        return sb.toString();
        }

    }
