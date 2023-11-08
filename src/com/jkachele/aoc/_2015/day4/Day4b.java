package com.jkachele.aoc._2015.day4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day4b {
    public static void main(String[] args) {
        String key = "ckczppom";
        // String key = "pqrstuv";

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            boolean found = false;
            byte[] hash = null;
            int concat = 0;
            while (!found) {
                String keyNum = String.format("%s%d", key, concat);
                hash = md.digest(keyNum.getBytes());
                if (Byte.toUnsignedLong(hash[0]) == 0 && Byte.toUnsignedLong(hash[1]) == 0 && Byte.toUnsignedLong(hash[2]) == 0) {
                    found = true;
                    continue;
                }
                if (concat % 100000 == 0)
                    System.out.print(".");
                concat++;
            }
            
            System.out.println();
            System.out.println(concat);
            System.out.println(Byte.toUnsignedLong(hash[2]));
            System.out.println(bytesToHex(hash));

        } catch (NoSuchAlgorithmException e) {
            System.err.println("Invalid Hash Algorithm");
            throw new RuntimeException(e);
        }
    }


    public static String bytesToHex(byte[] bytes) {
        final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }
}
