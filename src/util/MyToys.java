/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Ngoc Huu
 */
public class MyToys {

    private static Scanner sc = new Scanner(System.in);

    public static int getAge(String inputMsg, String errorMsg) {
        int num, age;
        while (true) {
            try {
                System.out.print(inputMsg);
                num = Integer.parseInt(sc.nextLine());
                age = Calendar.getInstance().get(Calendar.YEAR) - num;
                if (age < 18 || age > 40) {
                    throw new Exception();
                }
                return num;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        int temp, num;
        if (lowerBound > upperBound) {
            temp = lowerBound;
            upperBound = lowerBound;
            lowerBound = temp;
        }

        while (true) {
            try {
                System.out.print(inputMsg);
                num = Integer.parseInt(sc.nextLine());
                if (num < lowerBound || num > upperBound) {
                    throw new Exception();
                }
                return num;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String getAString(String inputMsg, String errorMsg) {
        String string;
        while (true) {
            System.out.print(inputMsg);
            string = sc.nextLine().trim();
            if (string.isEmpty() || string.length() == 0) {
                System.out.println(errorMsg);
            } else {
                return string;
            }
        }
    }

    public static String getID(String inputMsg, String errorMsg, String format) {
        String id;
        boolean match;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);
            if (id.length() == 0 || id.isEmpty() || match == false) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }
}
