package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream input = new FileInputStream(reader.readLine());
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String buffer;
        while ((buffer = br.readLine()) != null) {
                    if (buffer.contains("ï»¿")) {
                        String[] line = buffer.split("ï»¿");
                        String[] line2 = line[1].split(" ");
                        if (line2[0].equals(args[0])) {
                            System.out.print(Integer.parseInt(line2[0]) + " ");
                            for (int i = 1; i < line2.length-2; i++) {
                                System.out.print(line2[i] + " ");
                            }
                            System.out.print(Double.parseDouble(line2[line2.length-2]) + " ");
                            System.out.print(Integer.parseInt(line2[line2.length-1]));
                            break;
                        }
                    } else {
                        String[] line2 = buffer.split(" ");
                        if (line2[0].equals(args[0])) {
                            System.out.print(Integer.parseInt(line2[0]) + " ");
                            for (int i = 1; i < line2.length-2; i++) {
                                System.out.print(line2[i] + " ");
                            }
                            System.out.print(Double.parseDouble(line2[line2.length-2]) + " ");
                            System.out.print(Integer.parseInt(line2[line2.length-1]));
                            break;
                        }
                    }
        }
        input.close();
    }
}
