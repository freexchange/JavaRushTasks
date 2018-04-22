package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream input = new FileInputStream(args[0]);
        int count = 0;
        while (input.available() > 0) {
            int data = input.read();
            if ((65 <= data && data <= 90) || (97 <= data && data <= 122)) {
                    count++;
            }
        }
        input.close();
        System.out.println(count);
    }
}
