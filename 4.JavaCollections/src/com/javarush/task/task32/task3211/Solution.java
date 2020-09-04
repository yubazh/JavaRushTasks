package com.javarush.task.task32.task3211;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.StringReader;
import java.security.MessageDigest;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        byte[] bytesStroka = byteArrayOutputStream.toByteArray();
        MessageDigest md5Digest = MessageDigest.getInstance("MD5");
        byte[] bytes = md5Digest.digest(bytesStroka);
        String md5result = "";
        for (int i = 0; i < bytes.length; i++) {
            md5result += Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1);
        }
        return md5result.equals(md5);
    }
}
