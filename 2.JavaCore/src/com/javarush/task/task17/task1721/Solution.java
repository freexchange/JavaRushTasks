package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            InputStream inStream = new BufferedInputStream(new FileInputStream(reader.readLine()));
            String buf = "";
            int data = 0;
            int i =0;
            while (inStream.available() > 0) {
                data = inStream.read();
                if(data != 10) {
                    buf += (char)data;
                } else {
                    allLines.add(buf);
                    buf = "";
                }
            }
            allLines.add(buf);
            if(allLines.get(allLines.size()-1).isEmpty()) {
                allLines.remove(allLines.size()-1);
            }
            inStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            InputStream inStream = new BufferedInputStream(new FileInputStream(reader.readLine()));
            String buf = "";
            int data = 0;
            int i =0;
            while (inStream.available() > 0) {
                data = inStream.read();
                if(data != 10) {
                    buf += (char)data;
                } else {
                    forRemoveLines.add(buf);
                    buf = "";
                }
            }
            forRemoveLines.add(buf);
            if(forRemoveLines.get(forRemoveLines.size()-1).isEmpty()) {
                forRemoveLines.remove(forRemoveLines.size()-1);
            }
            inStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            System.out.println("fuck");
        }

    }

    public void joinData() throws CorruptedDataException {
        if(!allLines.containsAll(forRemoveLines)) {
            allLines.clear();
            throw new CorruptedDataException();
        } else {
            allLines.removeAll(forRemoveLines);
        }
    }

//    public static void readfile(BufferedReader reader, List<String> list) {
//        try {
//            InputStream inStream = new BufferedInputStream(new FileInputStream(reader.readLine()));
//            String buf = "";
//            int data = 0;
//            int i =0;
//            while (inStream.available() > 0) {
//                data = inStream.read();
//                if(data != 10) {
//                    buf += (char)data;
//                } else {
//                    list.add(buf);
//                    buf = "";
//                }
//            }
//            list.add(buf);
//            if(list.get(list.size()-1).isEmpty()) {
//                list.remove(list.size()-1);
//            }
//            inStream.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
