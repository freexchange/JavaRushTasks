package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream input = new FileInputStream(reader.readLine());
        Set<Integer> hm = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        while (input.available() > 0) {
            int data = input.read();
            hm.add(data);
        }
        input.close();
        reader.close();
        for(Integer q: hm) {
            list.add(q);
        }
        Collections.sort(list);
        for(Integer i: list) {
            System.out.print(i + " ");
        }
    }
}
