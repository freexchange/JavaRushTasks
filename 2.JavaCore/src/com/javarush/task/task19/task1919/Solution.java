package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> map = new TreeMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        //Scanner scanner = new Scanner(reader);
        int i;
        try {
            while (reader.ready()) {
                String[] s = reader.readLine().split(" ");
                if (s.length < 2) continue;
                if (map.containsKey(s[0])) {
                    map.put(s[0], map.get(s[0]) + Double.parseDouble(s[1]));
                } else map.put(s[0], Double.parseDouble(s[1]));
            }
        } catch (ArrayIndexOutOfBoundsException w) {

        }
        for (Map.Entry<String, Double> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        reader.close();

        //System.out.println(map.get("строка1"));
    }
}
