package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        try {
            reset();//add your code here - добавьте код тут
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Flyable result;

    public static void reset() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//add your code here - добавьте код тут
        String str = reader.readLine();
        if(str.equals("helicopter")) {
            result = new Helicopter();
        } else if(str.equals("plane")) {
            int num = Integer.parseInt(reader.readLine());
            result = new Plane(num);
        }
        reader.close();
    }
}
