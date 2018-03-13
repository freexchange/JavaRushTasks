package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static {

        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();//add your code here - добавьте код тут
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();//add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        InputStream inStream;
        public String str = "";
        @Override
        public void setFileName(String fullFileName) {
            try {
                inStream = new FileInputStream(fullFileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String getFileContent() {
            return str;
        }

        @Override
        public void run() {
            try {
                while (inStream.available() > 0) {
                    int data = inStream.read();
                    if ( data == 10) {
                        str += " ";
                    } else if ( data == 13) {
                       // str += " ";
                    } else {
                        str +=  (char)data;
                    }
                }
                inStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }//add your code here - добавьте код тут
}
