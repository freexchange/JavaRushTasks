package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<Integer, byte[]> list = new TreeMap<>();
        String filepath = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = "";
        while (true) {
            file = reader.readLine();
            if (filepath.equals("")) {
                filepath = file;
            }
            if (file.equals("end")) {
                break;
            } else {
                FileInputStream inputStream = new FileInputStream(file);
                byte[] buffer = new byte[inputStream.available()];
                while (inputStream.available() > 0) {
                    inputStream.read(buffer);
                }
                list.put(Integer.parseInt(file.substring(file.lastIndexOf('.')+5, file.length())), buffer);
                inputStream.close();
            }
        }

        String out = filepath.substring(0, filepath.lastIndexOf(46));

        FileOutputStream outputStream = new FileOutputStream(out, true);
        Iterator<Map.Entry<Integer, byte[]>> iterator = list.entrySet().iterator();

        while (iterator.hasNext())
        {
            //получение «пары» элементов
            Map.Entry<Integer, byte[]> pair = iterator.next();
            Integer key = pair.getKey();            //ключ
            byte[] value = pair.getValue();        //значение
            outputStream.write(value, 0, value.length);
        }
        outputStream.close();
    }
}
