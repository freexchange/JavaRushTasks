package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(reader.readLine()));
        String s;
        while ((s = file1.readLine()) != null) {
            //String string = "12 text var2 14 8ю 1";
            String pattern = "\\b[0-9]+\\b";
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(s);

            while (m.find()) {
                file2.write(s.substring(m.start(), m.end()) + " ");
            }
        }
        reader.close();
        file1.close();
        file2.flush();
        file2.close();
    }
}
