package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream input1 = new FileInputStream(reader.readLine());
        FileOutputStream output2 = new FileOutputStream(reader.readLine());
        reader.close();
        byte[] buffer = new byte[1024];
        ArrayList<Byte> list = new ArrayList<>();
        while (input1.available() > 0) {
            input1.read(buffer);
            for (byte i: buffer) {
                if (i > 0) {
                    list.add(i);
                }
            }
        }
        input1.close();
        Collections.reverse(list);
        for (byte b: list) {
            output2.write(b);
        }
        output2.close();
    }
}
