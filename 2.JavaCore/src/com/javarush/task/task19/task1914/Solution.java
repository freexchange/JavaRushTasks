package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();
        String str = outputStream.toString();
        //str = str.substring(0,str.length()- 3);
        String[] result = str.split(" ");
        int a = Integer.parseInt(result[0]);
        int b = Integer.parseInt(result[2]);
        int c = 0;
        if(result[1].equals("-")) {
            c = a - b;
        } else if (result[1].equals("+")) {
            c = a + b;
        } else if (result[1].equals("*")) {
            c = a * b;
        }

        System.setOut(consoleStream);
        System.out.println(str + c);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

