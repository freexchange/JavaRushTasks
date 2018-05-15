package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args[0].startsWith("-e")) {
            String[] param = args[0].split(" ");
            FileInputStream inputStream = new FileInputStream(args[1]);
            FileOutputStream outputStream = new FileOutputStream(args[2]);
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                outputStream.write(data+1);
            }
            inputStream.close();
            outputStream.close();
        } else if (args[0].startsWith("-d")) {
            String[] param = args[0].split(" ");
            FileInputStream inputStream = new FileInputStream(args[1]);
            FileOutputStream outputStream = new FileOutputStream(args[2]);
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                outputStream.write(data - 1);
            }
            inputStream.close();
            outputStream.close();
        }
    }
}
