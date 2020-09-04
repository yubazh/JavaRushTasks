package com.javarush.task.task19.task1921;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {

        String fileName = args[0];
        FileReader reader = new FileReader(fileName);
        Scanner scan = new Scanner(reader);
        String line;
        String strDate = null;
        String strName = null;

        while (scan.hasNextLine()) {
            line = scan.nextLine();
            for (int i = 1; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    strName = line.substring(0, i - 1);
                    strDate = line.substring(i, line.length());
                    break;
                }
            }
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("dd MM yyyy");
            Date docDate = format.parse(strDate);
            Person person = new Person(strName, docDate);
            PEOPLE.add(person);

        }
        scan.close();
        reader.close();

    }
}
