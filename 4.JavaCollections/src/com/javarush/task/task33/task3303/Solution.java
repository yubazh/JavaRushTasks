package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

/* 
Десериализация JSON объекта
*/
public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        FileReader reader = new FileReader(new File(fileName));
        return mapper.readValue(reader, clazz);
    }

    public static void main(String[] args) {

    }
}
