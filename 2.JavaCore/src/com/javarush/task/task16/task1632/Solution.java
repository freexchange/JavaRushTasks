package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        Thread thread1 = new Thread1();
        threads.add(thread1);
        Thread2 thread2 = new Thread2();
        threads.add(thread2);
        Thread3 thread3 = new Thread3();
        threads.add(thread3);
        Thread4 thread4 = new Thread4();
        threads.add(thread4);
        Thread5 thread5 = new Thread5();
        threads.add(thread5);
    }

    public static void main(String[] args) {
        for (Thread thread: threads) {
            thread.start();
        }
    }
    public static class Thread1 extends Thread implements Runnable {
        public void run() {
            while (true) {
            }
        }
    }

    public static class Thread2 extends Thread implements Runnable {
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Thread3 extends Thread implements Runnable {
        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Thread4 extends Thread implements Message {
        public void run() {
            while (!isInterrupted()){

            }
        }

        @Override
        public void showWarning() {
                interrupt();
        }
    }

    public static class Thread5 extends Thread implements Runnable {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        public void run() {
            String temp = "";
            int temp2 = 0;
            while (!temp.equals("N")) {
                try {
                    temp = reader.readLine();
                    temp2 = Integer.parseInt(temp);
                    list.add(temp2);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (NumberFormatException e) {
                    //temp = "N";
                }
            }
            temp2 = 0;
            for (Integer i: list) {
                temp2 += i;
            }
            System.out.println(temp2);
        }
    }
}