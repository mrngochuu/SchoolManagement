/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import data.ClassRoom;
import data.School;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ngoc Huu
 */
public class File {

    public static void exportFile(String fileName, ClassRoom obj) {

        try {
            FileWriter fw = new FileWriter(fileName, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(obj + "\n");
            pw.close();
            fw.close();
        } catch (Exception ex) {
            System.out.println("Create file failed");
        }
    }

    public static void exportFile(String fileName, String str) {
        try {
            FileWriter fw = new FileWriter(fileName, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(str + "\n");
            pw.close();
            fw.close();
        } catch (Exception ex) {
            System.out.println("Create file failed");
        }
    }

    public static School importFile(String fileName) {
        String str;
        School fpt = new School("FPT", "Quang Trung Software Park");
        ClassRoom x;
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            while ((str = br.readLine()) != null) {
                if (str.contains("Class")) {
                    String id, name;
                    int posStart, posEnd, yob;
                    posStart = str.indexOf("=") + 1;
                    posEnd = str.indexOf(",");
                    id = str.substring(posStart, posEnd);
                    str = str.substring(posEnd + 1);
                    posStart = str.indexOf("=") + 1;
                    posEnd = str.indexOf(",");
                    name = str.substring(posStart, posEnd);
                    str = str.substring(posEnd + 1);
                    x = new ClassRoom(id, name);
                    while (str.contains("Student")) {
                        posStart = str.indexOf("id=") + 3;
                        posEnd = str.indexOf(",");
                        id = str.substring(posStart, posEnd);
                        str = str.substring(posEnd + 1);
                        posStart = str.indexOf("=") + 1;
                        posEnd = str.indexOf(",");
                        name = str.substring(posStart, posEnd);
                        str = str.substring(posEnd + 1);
                        posStart = str.indexOf("=") + 1;
                        posEnd = str.indexOf("}");
                        yob = Integer.parseInt(str.substring(posStart, posEnd));
                        str = str.substring(posEnd + 2);
                        x.addNewStudent(id, name, yob);
                    }
                    fpt.getClassList().add(x);
                }
            }
            System.out.println("File is imported successfully.");
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("File is wrong.");
        }
        return fpt;
    }
}
