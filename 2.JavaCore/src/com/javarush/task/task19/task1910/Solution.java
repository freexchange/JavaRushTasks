package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader file2 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter file1 = new BufferedWriter(new FileWriter(reader.readLine()));
        //String str = "123Считать содержимое перв12ого файла, удалить все знаки пунктуации, включая символы новой строки.";
        //System.out.println(str.replaceAll("\\p{Punct}", ""));
        String str;
        while ((str = file2.readLine()) != null){
            file1.write(str.replaceAll("\\p{Punct}", ""));
        }
        reader.close();
        file2.close();
        file1.flush();
        file1.close();
    }
}
