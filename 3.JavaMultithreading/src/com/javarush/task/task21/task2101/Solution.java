package com.javarush.task.task21.task2101;

import java.io.InputStream;

/*
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] result = new byte[4];
        result[0] = (byte) (ip[0] & mask[0]);
        result[1] = (byte) (ip[1] & mask[1]);
        result[2] = (byte) (ip[2] & mask[2]);
        result[3] = (byte) (ip[3] & mask[3]);
        return result;
    }

    public static void print(byte[] bytes) {
        int i1 = Byte.toUnsignedInt(bytes[0]);
        int i2 = Byte.toUnsignedInt(bytes[1]);
        int i3 = Byte.toUnsignedInt(bytes[2]);
        int i4 = Byte.toUnsignedInt(bytes[3]);
        String str1 = String.format("%8s", Integer.toBinaryString(i1)).replaceAll(" ","0");
        String str2 = String.format("%8s", Integer.toBinaryString(i2)).replaceAll(" ","0");
        String str3 = String.format("%8s", Integer.toBinaryString(i3)).replaceAll(" ","0");
        String str4 = String.format("%8s", Integer.toBinaryString(i4)).replaceAll(" ","0");
        System.out.println(str1 + " " + str2 + " " + str3 + " " + str4);
    }
}
