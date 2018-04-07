package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        FileInputStream input = new FileInputStream(file1);
        List<Byte> list = new ArrayList<>();
        byte[] buffer = new byte[1024];
        while (input.available() > 0) {
            int count = input.read(buffer);
            for(int i = 0; i < count; i++) {
                list.add(buffer[i]);
            }
        }
        FileOutputStream output1 = new FileOutputStream(file2);
        FileOutputStream output2 = new FileOutputStream(file3);
        if ((list.size() % 2) == 0) {
            for (int i = 0; i < (list.size()/2); i++) {
                output1.write(list.get(i));
            }
            for (int i = (list.size()/2); i < (list.size()); i++) {
                output2.write(list.get(i));
            }
        } else {
            for (int i = 0; i <= (list.size()/2); i++) {
                output1.write(list.get(i));
            }
            for (int i = ((list.size()/2)+1); i < (list.size()); i++) {
                output2.write(list.get(i));
            }
        }
        reader.close();
        input.close();
        output1.close();
        output2.close();
    }
}
