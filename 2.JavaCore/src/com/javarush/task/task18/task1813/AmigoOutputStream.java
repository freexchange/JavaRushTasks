package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    public static String fileName = /*"C:/1/1.txt";//*/"C:/tmp/result.txt";
    private FileOutputStream out;
    public AmigoOutputStream(FileOutputStream fos) throws FileNotFoundException {
        super(fileName, true);
        this.out = fos;
    }

    @Override
    public void write(byte[] b) throws IOException {
        out.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        out.write(b, off, len);
    }

    @Override
    public void write(int b) throws IOException {
        out.write(b);
    }

    @Override
    public void flush() throws IOException {
        out.flush();
    }

    @Override
    public void close() throws IOException {
        out.flush();
        out.write("JavaRush © All rights reserved.".getBytes());
        out.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
            new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
