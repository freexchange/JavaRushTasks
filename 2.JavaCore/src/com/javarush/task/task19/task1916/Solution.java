package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader file2 = new BufferedReader(new FileReader(reader.readLine()));
        List<String> list1 = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        String str1 = "";
        String str2 = "";
        while ((str1 = file1.readLine()) != null) {
            if (!str1.equals("")) {
                list1.add(str1);
            }
        }
        while ((str2 = file2.readLine()) != null) {
            if (!str2.equals("")) {
                list2.add(str2);
            }
        }
        int i = 0;
        try {
            if(list1.size() > list2.size()) {
            for (; i < list1.size(); i++) {
                if (list2.get(i).equals(list1.get(i))) {
                    LineItem item = new LineItem(Type.SAME, list1.get(i));
                    lines.add(item);
                } else if (list2.get(i + 1).equals(list1.get(i))) {
                    list1.add(i, "");
                    LineItem item = new LineItem(Type.ADDED, list2.get(i));
                    lines.add(item);
                } else if (list2.get(i).equals(list1.get(i + 1))) {
                    list2.add(i, "");
                    LineItem item = new LineItem(Type.REMOVED, list1.get(i));
                    lines.add(item);
                }
            }
            }
            if(list1.size() < list2.size()) {
                for (; i < list2.size(); i++) {
                    if (list2.get(i).equals(list1.get(i))) {
                        LineItem item = new LineItem(Type.SAME, list1.get(i));
                        lines.add(item);
                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            if(list1.size() < list2.size()) {
                list1.add(i,"");
                LineItem item = new LineItem(Type.ADDED, list2.get(i));
                lines.add(item);
            } else {
                LineItem item = new LineItem(Type.REMOVED, list1.get(i));
                lines.add(item);
            }
        }
        reader.close();
        file1.close();
        file2.close();
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
