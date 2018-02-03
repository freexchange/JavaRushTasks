package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(2.5, "543");
        labels.put(43.324, "534");
        labels.put(543.534, "434");
        labels.put(43.534, "5345");
        labels.put(543.54, "3422");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
