package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData in) {
            this.data = in;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            int phoneNumberLength = 10 - String.valueOf(data.getPhoneNumber()).length();
            String phoneNumber = "";
            if (phoneNumberLength >= 1) {
                phoneNumber = "+" + String.valueOf(data.getCountryPhoneCode()) + "(0" +
                        String.valueOf(data.getPhoneNumber()).substring(0, 2) + ")" +
                        String.valueOf(data.getPhoneNumber()).substring(2, 5) + "-" +
                        String.valueOf(data.getPhoneNumber()).substring(5, 7) + "-" +
                        String.valueOf(data.getPhoneNumber()).substring(7, 9);
            }
            return phoneNumber;
        }
    }


    public static interface IncomeData {

        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}