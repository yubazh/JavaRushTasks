package com.javarush.task.task19.task1918;


/* 
Знакомство с тегами
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileReader reader1 = new FileReader(fileName);
        Scanner scan = new Scanner(reader1);
        String tag = "<" + args[0];
        String zakrTag = "</" + args[0] + ">";
        StringBuffer stringBuffer = new StringBuffer();
        while (scan.hasNext()) {
            stringBuffer.append(scan.nextLine());
            //stringBuffer.append(" ");
        }
        scan.close();
        boolean vivod = false;
        int j = 0;
        int zakr = 0;
        for (int i = 0; i < (stringBuffer.length() - zakrTag.length()); i++) {
            if (stringBuffer.substring(i, i + tag.length()).equals(tag)) {
                j++;
                for (int ij = i + tag.length(); ij < stringBuffer.length(); ij++) {
                    if (stringBuffer.substring(ij, ij + tag.length()).equals(tag)) {
                        j++;
                        ij = ij + tag.length();
                    }
                    if (stringBuffer.substring(ij, ij + zakrTag.length()).equals(zakrTag)) {
                        if (j == 1) {
                            zakr = ij + zakrTag.length();
                            vivod = true;
                            break;
                        }
                        else {
                            j--;
                        }
                    }
                }
            }
            if (vivod) {
                j = 0;
                System.out.println(stringBuffer.substring(i, zakr));
                //i = zakr - 1;
                vivod = false;
            }
        }
    }
}

