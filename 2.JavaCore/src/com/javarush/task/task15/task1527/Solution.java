package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import static java.lang.Double.isNaN;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattren = Pattern.compile("\\?|\\&");
        String[] url = pattren.split(reader.readLine());
         String[][] buf = new String[url.length][2];
        String line = "";
        for(int i = 1; i < url.length; i++) {
            buf[i-1] = url[i].split("=");
            System.out.print(buf[i-1][0] + " ");
            if(buf[i-1][0].equals("obj")){
                line = buf[i-1][1];
            }
        }
        try{
            if(!line.isEmpty()){
                System.out.println();
                alert(Double.parseDouble(line));
                }
        } catch (NumberFormatException e){
            System.out.println();
            alert(line);
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
