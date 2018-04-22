package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream input = new FileInputStream(args[0]);
        int count1 = 0;
        int count2 = 0;
        while (input.available() > 0) {
            count1++;
            int data = input.read();
            if (data == 32) {
                count2++;
            }
        }
        input.close();
        double result = (double)count2/count1*100;
        System.out.printf("%.2f", result);
        //System.out.println(BigDecimal.valueOf(result).setScale(2,BigDecimal.ROUND_HALF_DOWN).doubleValue());

    }
}
