package com.javarush.task.task17.task1711;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    public static String[] data;

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args)throws ParseException {

        data = args.clone();

        switch(args[0]) {
            case "-c": synchronized (allPeople){create(); break;}
            case "-u": synchronized (allPeople){update(); break;}
            case "-d": synchronized (allPeople){delete(); break;}
            case "-i": synchronized (allPeople){info(); break;}
            default:
                synchronized (allPeople) {
                    throw new IllegalArgumentException();
                }
        }

    }
    public static void create() throws ParseException {
        for(int i = 1; i < data.length; i += 3) {
            if (data[i+1].equals("м")) {
                SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date date1 = date.parse(data[i+2]);
                allPeople.add(Person.createMale(data[i], date1));
                System.out.println(allPeople.size() - 1);
//            } else if (data[3].equals("m")) {
//                SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
//                Date date1 = date.parse(data[4]);
//                allPeople.add(Person.createFemale(data[1] + " " + data[2], date1));
//                System.out.println(allPeople.size() - 1);
            } else if (data[i+1].equals("ж")) {
                SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date date1 = date.parse(data[i+2]);
                allPeople.add(Person.createFemale(data[i], date1));
                System.out.println(allPeople.size() - 1);
//            } else if (data[3].equals("w")) {
//                SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
//                Date date1 = date.parse(data[4]);
//                allPeople.add(Person.createFemale(data[1] + " " + data[2], date1));
//                System.out.println(allPeople.size() - 1);
            }
        }
    }

    public static void update() throws ParseException {
        for(int i = 1; i < data.length; i += 4) {
            allPeople.get(Integer.parseInt(data[i])).setName(data[i+1]);
            System.out.println(data[i+2]);
            if (data[i+2].equals("м")) {
                allPeople.get(Integer.parseInt(data[i])).setSex(Sex.MALE);
            } else if (data[i+2].equals("ж")) {
                allPeople.get(Integer.parseInt(data[i])).setSex(Sex.FEMALE);
            } else {
                return;
            }
            if (data[i+3].contains("/")) {
                SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date newdate = date.parse(data[i+3]);
                allPeople.get(Integer.parseInt(data[i])).setBirthDay(newdate);
            }
        }
    }

    public static void delete() {
        for(int i = 1; i < data.length; i++) {
            allPeople.get(Integer.parseInt(data[i])).setBirthDay(null);
            allPeople.get(Integer.parseInt(data[i])).setSex(null);
            allPeople.get(Integer.parseInt(data[i])).setName(null);
        }
    }

    public static void info() {
        for(int i = 1; i < data.length; i++) {
            String sex = "";
            String name = allPeople.get(Integer.parseInt(data[i])).getName();
            if (allPeople.get(Integer.parseInt(data[i])).getSex() == Sex.MALE) {
                sex = "м";
            } else if (allPeople.get(Integer.parseInt(data[i])).getSex() == Sex.FEMALE) {
                sex = "ж";
            }
            Date infodate = allPeople.get(Integer.parseInt(data[i])).getBirthDay();
            SimpleDateFormat newDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String idate = newDateFormat.format(infodate);
            System.out.println(name + " " + sex + " " + idate);
        }
    }
}
