package com.javarush.task.task33.task3304;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Конвертация из одного класса в другой используя JSON Ӏ 3304
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Second s = (Second) convertOneToAnother(new First(), Second.class);
        First f = (First) convertOneToAnother(new Second(), First.class);
    }

    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, one);
        String string = writer.toString();
        /*String targetClass = resultClassObject.getSimpleName().toLowerCase();
        if (string.contains("first") || (targetClass.equals("second"))) {
            string = string.replaceFirst("first", "second");
        } else { if (string.contains("second") || (targetClass.equals("first")))
            string = string.replace("second", "first");
        } */
        String oneClass = one.getClass().getSimpleName().toLowerCase();
        String resultClass = resultClassObject.getSimpleName().toLowerCase();
        String result = string.replaceFirst(oneClass, resultClass);
        StringReader reader = new StringReader(result);
        return mapper.readValue(reader, resultClassObject);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = First.class, name = "first"))
    public static class First {
        public int i;
        public String name;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = Second.class, name = "second"))
    public static class Second {
        public int i;
        public String name;
    }
}
