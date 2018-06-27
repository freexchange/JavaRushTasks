package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        BufferedReader buffileReader = new BufferedReader(fileReader);
        Scanner scan = new Scanner(fileReader);
        reader.close();
        int count = 0;
//        String pattern = "\\b[Ww][Oo][Rr][Ll][Dd]\\b+";
//        String text = "1world world world wworld world, world: \"world\" - world";
//        Pattern p2 = Pattern.compile(pattern);
//        Matcher m2 = p2.matcher(text);
//        System.out.println(text);
//        while(m2.find()) {
//            System.out.print(text.substring(m2.start(), m2.end()) + "*");
//        }
        String line;
        while ((line = buffileReader.readLine()) != null) {
            String pattern2 = "\\b[Ww][Oo][Rr][Ll][Dd]\\b+";
            Pattern p = Pattern.compile(pattern2);
            Matcher m = p.matcher(line);

            while(m.find()) {
                count++;
                //System.out.print(line.substring(m.start(), m.end()) + "*");
            }
        }
        reader.close();
        fileReader.close();
        buffileReader.close();
        System.out.println(count);
    }
}
