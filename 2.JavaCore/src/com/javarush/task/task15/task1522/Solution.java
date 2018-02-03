package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args){

    }

    public static Planet thePlanet;

    static{
        try {
            readKeyFromConsoleAndInitPlanet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String temp = reader.readLine();// implement step #5 here - реализуйте задание №5 тут
        if(temp.equals(Sun.SUN)) {
            thePlanet = Sun.getInstance();
        } else if(temp.equals(Moon.MOON)) {
            thePlanet = Moon.getInstance();
        } else if(temp.equals(Earth.EARTH)) {
            thePlanet = Earth.getInstance();
        } else {
            thePlanet = null;
        }
    }
}
