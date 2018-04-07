package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream input = new FileInputStream(reader.readLine());
        byte[] buffer = new byte[1024];
        int count = 0;
        while (input.available() > 0) {
           input.read(buffer);
           for (byte i: buffer) {
               if (i == 44) {
                   count++;
               }
           }
        }
        input.close();
        reader.close();
        System.out.println(count);
    }
}
