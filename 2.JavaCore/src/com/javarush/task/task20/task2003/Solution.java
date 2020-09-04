package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        //напишите тут ваш код
        PrintWriter writer = new PrintWriter(outputStream);
        Properties properties = new Properties();
        for (Map.Entry<String, String> entry : runtimeStorage.entrySet()) {
            properties.put(entry.getKey(), entry.getValue());
        }
        properties.store(writer, null);
        writer.close();
    }

    public static void load(InputStream inputStream) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        Properties properties = new Properties();
        properties.load(reader);
        for (String key : properties.stringPropertyNames()) {
            runtimeStorage.put(key, properties.get(key).toString());
        }
        reader.close();
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}
