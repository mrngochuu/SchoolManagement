/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import data.ClassRoom;
import data.School;
import ui.Menu;

/**
 *
 * @author Ngoc Huu
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu menu = new Menu("FPT University.");
        menu.addNewOption("1. Add new Class profile.");
        menu.addNewOption("2. Update Class profile.");
        menu.addNewOption("3. Remove Class profile.");
        menu.addNewOption("4. Show all Classes profile.");
        menu.addNewOption("5. Show all Students profile.");
        menu.addNewOption("6. Select a Class.");
        menu.addNewOption("7. Show School profile.");
        menu.addNewOption("8. Export All students profile to file.");
        menu.addNewOption((menu.getOptionToExit() + 1) + ". Exit program.");

        School fpt = new School("FPT", "Quang Trung Software Park");
        ClassRoom classRoom;
        int choiceSchool;
        do {
            menu.printMenu();
            choiceSchool = menu.getChoice();
            switch (choiceSchool) {
                case 1:
                    System.out.println("You are preparing to Add new Class profile.");
                    fpt.addNewClass();
                    break;
                case 2:
                    System.out.println("You are preparing to Update the Class profile.");
                    fpt.updateClassById();
                    break;
                case 3:
                    System.out.println("You are preparing to Remove the Class profile.");
                    fpt.removeClassById();
                    break;
                case 4:
                    fpt.showClassList();
                    break;
                case 5:
                    fpt.showAllStudents();
                    break;
                case 6:
                    classRoom = fpt.searchClassObjectById();
                    if (classRoom != null) {
                        Menu menuClass = new Menu(classRoom.getId());
                        menuClass.addNewOption("1. Add new Student profile.");
                        menuClass.addNewOption("2. Update Student profile.");
                        menuClass.addNewOption("3. Remove Student profile.");
                        menuClass.addNewOption("4. Show all Students profile.");
                        menuClass.addNewOption((menuClass.getOptionToExit() + 1) + ". Exit class profile.");
                        int choiceClass;
                        do {
                            menuClass.printMenu();
                            choiceClass = menuClass.getChoice();
                            switch (choiceClass) {
                                case 1:
                                    System.out.println("You are preparing to Add new Student profile.");
                                    classRoom.addNewStudent();
                                    break;
                                case 2:
                                    System.out.println("You are preparing to Update the Student profile.");
                                    classRoom.updateStudentById();
                                    break;
                                case 3:
                                    System.out.println("You are preparing to Remove the Student profile.");
                                    classRoom.deleteStudentById();
                                    break;
                                case 4:
                                    classRoom.showStudentList();
                                    break;
                            }
                        } while (choiceClass != menuClass.getOptionToExit());
                    }
                    break;
                case 7:
                    fpt.showDetails();
                    break;
                case 8:
                    fpt.exportFile();
                    break;
            }
        } while (choiceSchool != menu.getOptionToExit());
    }

}
