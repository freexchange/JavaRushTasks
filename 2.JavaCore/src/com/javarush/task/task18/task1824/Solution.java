package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String file = null;
        boolean f = true;
        while (f) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                file = reader.readLine();

                FileInputStream inputStream = new FileInputStream(file);
                inputStream.close();
                //reader.close();
            } catch (FileNotFoundException e) {
                System.out.println(file);

                f = false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
