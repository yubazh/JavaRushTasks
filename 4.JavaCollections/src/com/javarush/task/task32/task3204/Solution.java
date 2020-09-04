package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String password = "";
        int numberOfDigits = (int) (1 + Math.random() * 2);
        int numberOfUpperCase = (int) (1 + Math.random() * 2);
        int numberlowerCase = 8 - numberOfDigits - numberOfUpperCase;
        for (int i = 0; i < numberlowerCase; i++) {
            password += randomCharacter("abcdefghijklmnopqrstuvwxyz");
        }
        String upperCaseChar = "";
        for (int i = 0; i < numberOfUpperCase; i++) {
            upperCaseChar = randomCharacter("abcdefghijklmnopqrstuvwxyz").toUpperCase();
            password = insertAtRandom(password, upperCaseChar);
        }
        String digit = "";
        for (int i = 0; i < numberOfDigits; i++) {
            digit = randomCharacter("0123456789");
            password = insertAtRandom(password, digit);
        }
        outputStream.write(password.getBytes());
        return outputStream;
    }

    public static String randomCharacter(String characters) {
        int n = characters.length();
        int r = (int) (Math.random() * n);
        return characters.substring(r, r + 1);
    }

    public static String insertAtRandom(String line, String toInsert) {
        int n = line.length();
        int r = (int) (Math.random() * (n + 1));
        return line.substring(0, r) + toInsert + line.substring(r);
    }



}