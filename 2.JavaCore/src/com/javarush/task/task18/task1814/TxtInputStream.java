package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws UnsupportedFileNameException, IOException {
        super(fileName);
        String[] s;
        s = fileName.split(".");
        if (!s[0].equals("txt")) {
            super.close();
            throw new UnsupportedFileNameException();
        } else {
            System.out.println("0");
        }
    }

    public static void main(String[] args) throws IOException, UnsupportedFileNameException {
        new TxtInputStream("C:/1/1.txt");
    }
}

