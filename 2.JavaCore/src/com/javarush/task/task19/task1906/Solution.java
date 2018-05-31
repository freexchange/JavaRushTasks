package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader file1 = new FileReader(reader.readLine());
        FileWriter file2 = new FileWriter(reader.readLine());
        reader.close();
        int count = 0;
        while (file1.ready()) {
            int data = file1.read();
            count++;
            //System.out.print(count%2 + " ");
            if ((count%2) == 0) {
                file2.write(data);
            }
        }
        file1.close();
        file2.close();
    }
}
