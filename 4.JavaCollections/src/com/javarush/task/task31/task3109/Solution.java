package com.javarush.task.task31.task3109;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties properties = new Properties();
        try {
            File file = new File(fileName);
            FileInputStream fileInputStream = new FileInputStream(fileName);
            String expansion = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (expansion.equals("xml")) {
                properties.loadFromXML(fileInputStream);
            } else
                properties.load(fileInputStream);
            return properties;
        } catch (Exception e) {
            return properties;
        }
    }

}
