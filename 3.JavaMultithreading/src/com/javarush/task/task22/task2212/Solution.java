package com.javarush.task.task22.task2212;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) {
            return false;
        }
        Pattern pattern1 = Pattern.compile("^\\+\\d*(\\(?\\d{3}\\)?)?\\d+\\-?\\d+\\-?\\d+");
        Matcher matcher1 = pattern1.matcher(telNumber);
        String string = null;
        if (matcher1.matches()) {
            string = telNumber.replaceAll("\\D", "");
            boolean result = string.length() == 12;
            return  result;
        }
        Pattern pattern2 = Pattern.compile("^[\\d,\\(]?\\d{3}\\)?\\d+\\-?\\d+\\-?\\d+");
        Matcher matcher2 = pattern2.matcher(telNumber);
        if (matcher2.matches()) {
            string = telNumber.replaceAll("\\D", "");
            boolean result = string.length() == 10;
            return result;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("050123-4567"));
        System.out.println(checkTelNumber("+38)050(1234567"));
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println(checkTelNumber("050ххх4567"));
        System.out.println(checkTelNumber("050123456"));
        System.out.println(checkTelNumber("(0)501234567"));

    }
}
