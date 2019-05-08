/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import data.ClassRoom;
import java.io.FileWriter;
import java.io.PrintWriter;

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
}
