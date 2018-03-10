package com.javarush.task.task16.task1626;

import java.util.Date;

public class Solution {
    public static int number = 5;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new CountDownRunnable(), "Уменьшаем").start();

        new Thread(new CountUpRunnable(), "Увеличиваем").start();


    }

    public static class CountUpRunnable implements Runnable {
        private int countIndexUp = 1;

        public void run() {Date currentTime = new Date();
            try {
                while (true) {Thread.sleep(500);
                    System.out.println(toString());
                    countIndexUp += 1;
                    if (countIndexUp == Solution.number+1) return;

                }
            } catch (InterruptedException e) {
            }
            Date newTime = new Date();
            System.out.println(newTime.getTime() - currentTime.getTime());
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexUp;
        }//Add your code here - добавь код тут
    }


    public static class CountDownRunnable implements Runnable {
        private int countIndexDown = Solution.number;

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexDown -= 1;
                    if (countIndexDown == 0) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexDown;
        }
    }
}
