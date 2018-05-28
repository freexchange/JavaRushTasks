package com.javarush.task.task19.task1904;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
        //new PersonScannerAdapter(new Scanner(new File("c:/1/1.txt"))).read();

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String[] lines = new String[5];
            if (fileScanner.hasNextLine()) {
                lines = fileScanner.nextLine().split(" ");
            }
//            String birthDate = Integer.parseInt(lines[3]) + " " +
//                    Integer.parseInt(lines[4]) + " " +
//                    Integer.parseInt(lines[5]);
//            SimpleDateFormat format = new SimpleDateFormat();
//            format.applyPattern("dd MM yyyy");
//            Date PersonDate= null;
//            try {
//                PersonDate = format.parse(birthDate);
//            } catch (ParseException e) {
//                System.out.println("alarm");
//            }
            Date ddd = null;
            Person person = null;
            //SimpleDateFormat sdf  = new SimpleDateFormat("ddMMyyyy");
        //    try {
            GregorianCalendar calendar = new GregorianCalendar(Integer.parseInt(lines[5]), Integer.parseInt(lines[4])-1, Integer.parseInt(lines[3]));
            ddd = calendar.getTime();
                //ddd = new SimpleDateFormat("ddMMyyyy").parse(lines[3]+lines[4]+lines[5]);
                //dob = sdf.parse(String.format( "%s %s %s", lines[3], lines[4], lines[5]));
                person = new Person(lines[1], lines[2], lines[0], ddd);
         //   } catch (ParseException e) {
                //e.printStackTrace();
         //   }

            //System.out.println(person.toString());
            //System.out.println(lines[0] + " " + lines[1] + " " + lines[2] + " " + ddd +"    "+lines[3]+lines[4]+lines[5]);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
