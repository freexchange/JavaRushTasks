package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(reader.readLine()));
        String str;
        while ((str = file1.readLine()) != null) {
            String separator=System.getProperty("line.separator");
            //System.out.print(str.replace(".", "!")+ "\\n");
            file2.write(str.replace(".", "!") + separator);

        }
        reader.close();
        file1.close();
        file2.flush();
        file2.close();
    }
}
