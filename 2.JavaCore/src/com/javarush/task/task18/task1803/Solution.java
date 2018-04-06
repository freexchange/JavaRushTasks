package com.javarush.task.task18.task1803;

import javax.management.ObjectName;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;


/* 
Самые частые байты
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
        int temp = 0;
        List<Integer> list = new ArrayList<>();

        for(Map.Entry<Integer, Integer> pair : hm.entrySet())
        {
            Integer value = pair.getValue();
            Integer key = pair.getKey();
            if(value > temp){
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

//        Map<Integer, Integer> sortedMap = sortByValue(hm);
//        int temp = 0;
//        for(Map.Entry<Integer, Integer> pair : sortedMap.entrySet())
//        {
//            Integer value = pair.getValue();
//            Integer key = pair.getKey();
//            if(value > temp){
//                temp = value;
//                System.out.print(key + " ");
//            } else {
//                System.out.print(key);
//                break;
//            }
//            //System.out.println(value);
//        }

    }
//    private static Map<Integer, Integer> sortByValue(Map<Integer, Integer> unsortMap) {
//
//        // 1. Convert Map to List of Map
//        List<Map.Entry<Integer, Integer>> list =
//                new LinkedList<Map.Entry<Integer, Integer>>(unsortMap.entrySet());
//
//        // 2. Sort list with Collections.sort(), provide a custom Comparator
//        //    Try switch the o1 o2 position for a different order
//        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
//            public int compare(Map.Entry<Integer, Integer> o1,
//                               Map.Entry<Integer, Integer> o2) {
//                return (o2.getValue()).compareTo(o1.getValue());
//            }
//        });
//
//        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
//        Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
//        for (Map.Entry<Integer, Integer> entry : list) {
//            sortedMap.put(entry.getKey(), entry.getValue());
//        }
//
//        return sortedMap;
//    }
}
