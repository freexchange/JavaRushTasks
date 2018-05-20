package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String file = reader.readLine();
        if (args.length != 0) {
            if (args[0].startsWith("-c")) {
                String quantity = args[args.length - 1];
                String productName = "";
                for (int i = 1; i < args.length - 2; i++) {
                    productName += args[i] + " ";
                }
                String price = args[args.length - 2];
                BufferedReader inputStream = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(file), Charset.forName("UTF-8")));
                String line;
                TreeSet<Integer> list = new TreeSet<>();
                ArrayList<String> Slist = new ArrayList<>();
                while ((line = inputStream.readLine()) != null) {
                    if (line.length() != 0) {
                        if ((byte) line.charAt(0) == -1) {
                            Slist.add(line.substring(1));
                            list.add(Integer.parseInt(line.substring(1, 9).trim()));
                        } else {
                            Slist.add(line);
                            list.add(Integer.parseInt(line.substring(0, 8).trim()));
                        }
                    }
                }
                inputStream.close();
                String strId = String.valueOf(list.last() + 1);
                for (int i = strId.length(); i < 9; i++) {
                    if (i != 8) {
                        strId += " ";
                    } else {

                    }
                }
                if (productName.length() < 31) {
                    for (int i = productName.length(); i < 31; i++) {
                        if (i != 30) {
                            productName += " ";
                        } else {

                        }
                    }
                } else {
                    productName = productName.substring(0, 30);
                }
                for (int i = price.length(); i < 9; i++) {
                    if (i != 8) {
                        price += " ";
                    } else {

                    }
                }
                for (int i = quantity.length(); i < 5; i++) {
                    if (i != 4) {
                        quantity += " ";
                    } else {

                    }
                }
                BufferedWriter outputStream = new BufferedWriter(new FileWriter(file, true));
                String etr = strId + productName + price + quantity;
                outputStream.newLine();
                outputStream.write(etr);
                outputStream.close();
            } else if (args[0].startsWith("-u")) {
                String quantity = args[args.length - 1];
                String productName = "";
                for (int i = 2; i < args.length - 2; i++) {
                    productName += args[i] + " ";
                }
                String price = args[args.length - 2];
                BufferedReader inputStream = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(file), Charset.forName("UTF-8")));
                String line;
                String idate = "";
                ArrayList<String> Slist = new ArrayList<>();
                if (productName.length() < 31) {
                    for (int i = productName.length(); i < 31; i++) {
                        if (i != 30) {
                            productName += " ";
                        } else {

                        }
                    }
                } else {
                    productName = productName.substring(0, 30);
                }
                if (price.length() < 9) {
                    for (int i = price.length(); i < 9; i++) {
                        if (i != 8) {
                            price += " ";
                        } else {

                        }
                    }
                } else {
                    price = price.substring(0, 9);
                }
                if (quantity.length() < 5) {
                    for (int i = quantity.length(); i < 5; i++) {
                        if (i != 4) {
                            quantity += " ";
                        } else {

                        }
                    }
                } else {
                    quantity = quantity.substring(0, 5);
                }
                while ((line = inputStream.readLine()) != null) {
                    if (line.length() != 0) {
                        if ((byte) line.charAt(0) == -1) {
                            if (line.substring(1, 9).trim().equals(args[1])){
                                idate += line.substring(1, 9) + productName + price + quantity;
                            }
                            Slist.add(line.substring(1));
                        } else {
                            if (line.substring(0, 8).trim().equals(args[1])){
                                idate += line.substring(0, 8) + productName + price + quantity;
                            }
                            Slist.add(line);
                        }
                    }
                }

                inputStream.close();
                BufferedWriter output = new BufferedWriter(new FileWriter(file));
                for (int i = 0; i < Slist.size(); i++) {
                    if(Slist.get(i).startsWith(idate.substring(0, 8).trim())) {
                        output.write(idate);
                        output.newLine();
                    } else {
                        output.write(Slist.get(i));
                        if(i < Slist.size() - 1) {
                            output.newLine();
                        }
                    }
                }
                output.flush();
                output.close();
            } else if (args[0].startsWith("-d")) {
                BufferedReader inputStream = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(file), Charset.forName("UTF-8")));
                String line;
                String idate = "";
                ArrayList<String> Slist = new ArrayList<>();
                while ((line = inputStream.readLine()) != null) {
                    if (line.length() != 0) {
                        if ((byte) line.charAt(0) == -1) {
                            if (line.substring(1, 9).trim().equals(args[1])){
                                idate += line.substring(1, 9);
                            }
                            Slist.add(line.substring(1));
                        } else {
                            if (line.substring(0, 8).trim().equals(args[1])){
                                idate += line.substring(0, 8);
                            }
                            Slist.add(line);
                        }
                    }
                }
                inputStream.close();
                BufferedWriter output = new BufferedWriter(new FileWriter(file));
                for (int i = 0; i < Slist.size(); i++) {
                    if(Slist.get(i).startsWith(idate.substring(0, 8).trim())) {
                    } else {
                        output.write(Slist.get(i));
                        if(i < Slist.size() - 1) {
                            output.newLine();
                        }
                    }
                }
                output.flush();
                output.close();
            }
        }
    }
}
