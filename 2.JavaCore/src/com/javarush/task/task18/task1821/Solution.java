package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream  = new FileInputStream(args[0]);
        int[] buffer = new int[257];
        while (inputStream.available() > 0) {
            buffer[inputStream.read()] += 1;
        }
        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] != 0 && i < 123) {
                System.out.println((char) i + " " + buffer[i]);
            }
        }
        inputStream.close();
    }
}
