package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String string = reader.readLine();
        //List<String> temp = new ArrayList<>();
        String sex = "";
//        for(String str: string.split(" ")) {
//            temp.add(str);
//           // System.out.println(str);
//        }
        if (args[0].equals("-c") && args[2].equals("м")) {
            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date date1 = date.parse(args[3]);
            allPeople.add(Person.createMale(args[1], date1));
            System.out.println(allPeople.size()-1);
            //System.out.println(allPeople.get(allPeople.size()-1).getName());
            //System.out.println("id ("+(allPeople.size()-1)+")");
        } else if (args[0].equals("-c") && args[3].equals("м")) {
            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date date1 = date.parse(args[4]);
            allPeople.add(Person.createFemale(args[1]+" "+args[2], date1));
            System.out.println(allPeople.size()-1);
            //System.out.println("id ("+(allPeople.size()-1)+")");
        } else if (args[0].equals("-c") && args[2].equals("ж")) {
            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date date1 = date.parse(args[3]);
            allPeople.add(Person.createFemale(args[1], date1));
            System.out.println(allPeople.size()-1);
            //System.out.println("id ("+(allPeople.size()-1)+")");
        }else if (args[0].equals("-c") && args[3].equals("ж")) {
            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date date1 = date.parse(args[4]);
            allPeople.add(Person.createFemale(args[1]+" "+args[2], date1));
            System.out.println(allPeople.size()-1);
            //System.out.println("id ("+(allPeople.size()-1)+")");
        } else if (args[0].equals("-u")) {
            allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
            if (args[3].equals("м")) {
                allPeople.get(Integer.parseInt(args[1])).setSex(Sex.MALE);
            } else if (args[3].equals("ж")) {
                allPeople.get(Integer.parseInt(args[1])).setSex(Sex.FEMALE);
            } else {
                return;
            }
            if (args[4].contains("/")) {
                SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);;
                Date newdate = date.parse(args[4]);
                allPeople.get(Integer.parseInt(args[1])).setBirthDay(newdate);
            }
        } else if (args[0].equals("-d")) {
            allPeople.get(Integer.parseInt(args[1])).setBirthDay(null);
            allPeople.get(Integer.parseInt(args[1])).setSex(null);
            allPeople.get(Integer.parseInt(args[1])).setName(null);
        } else if (args[0].equals("-i")) {
            String name = allPeople.get(Integer.parseInt(args[1])).getName();
            if (allPeople.get(Integer.parseInt(args[1])).getSex() == Sex.MALE) {
                sex = "м";
            } else if (allPeople.get(Integer.parseInt(args[1])).getSex() == Sex.MALE) {
                sex = "ж";
            }
            Date infodate = allPeople.get(Integer.parseInt(args[1])).getBirthDay();
            SimpleDateFormat newDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String idate = newDateFormat.format(infodate);
            System.out.println(name + " " + sex + " " + idate);
        }
//        for (int i = 0; i < allPeople.size(); i++) {
//            String name = allPeople.get(i).getName();
//            if (allPeople.get(i).getSex() == Sex.MALE) {
//                sex = "м";
//            } else if (allPeople.get(i).getSex() == Sex.MALE) {
//                sex = "ж";
//            }
//            Date infodate = allPeople.get(i).getBirthDay();
//            SimpleDateFormat newDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
//            String idate = newDateFormat.format(infodate);
//            System.out.println(name + " " + sex + " " + idate);
//        }
        }
    }


