package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream input = new FileInputStream(reader.readLine());
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        while (input.available() > 0) {
            int data = input.read();
            if(hm.get(data) != null) {
                int temp = 0;
                temp = hm.get(data);
                hm.remove(data);
                hm.put(data, temp + 1);
            } else {
                hm.put(data, 1);
            }
        }
        input.close();
        reader.close();
        int temp = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();

        for(Map.Entry<Integer, Integer> pair : hm.entrySet())
        {
            Integer value = pair.getValue();
            Integer key = pair.getKey();
            if(value < temp){
                temp = value;
                list.clear();
                list.add(key);
            } else if (value == temp) {
                list.add(key);
            } else {

            }
        }
        for(Integer i: list) {
            System.out.print(i + " ");
        }
//        for (Map.Entry<Integer, Integer> i: hm.entrySet()) {
//            int value = i.getValue();
//            int key = i.getKey();
//            System.out.println(key + " " + value);
//        }
    }
}
