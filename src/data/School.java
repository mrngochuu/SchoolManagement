/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import util.File;
import util.MyToys;

/**
 *
 * @author Ngoc Huu
 */
public class School {

    private String name;
    private String address;
    private List<ClassRoom> classList = new ArrayList<>();

    public School(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ClassRoom> getClassList() {
        return classList;
    }

    public void setClassList(List<ClassRoom> classList) {
        this.classList = classList;
    }

    @Override
    public String toString() {
        return "School{" + "name=" + name + ", address=" + address + ", classList=" + classList + '}';
    }

    public void showDetails() {
        System.out.println(this.name + " UNIVERSITY.");
        System.out.println("Address: " + this.address);
    }

    public void searchClassById() {
        if (classList.isEmpty()) {
            System.out.println("Class List is empty.");
            return;
        }

        String id;
        ClassRoom x;
        id = MyToys.getAString("Input Class ID: ", "Class ID is required.");
        x = searchClassObjectById(id);
        if (x == null) {
            System.out.println("Not found.");
        } else {
            System.out.println("Here is profile of class: ");
            x.showDetails();
        }
    }

    public ClassRoom searchClassObjectById() {
        if (classList.isEmpty()) {
            System.out.println("Class List is empty.");
            return null;
        }
        String id = MyToys.getAString("Input Class ID to select: ", "Class ID is required.");;
        ClassRoom x = searchClassObjectById(id);
        if (x == null) {
            System.out.println("Not found.");
            return null;
        } else {
            return x;
        }
    }

    public ClassRoom searchClassObjectById(String id) {
        if (classList.isEmpty()) {
            return null;
        }
        for (ClassRoom classRoom : classList) {
            if (classRoom.getId().equalsIgnoreCase(id)) {
                return classRoom;
            }
        }
        return null;
    }

    public int searchClassById(String id) {
        if (classList.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < classList.size(); i++) {
            if (classList.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public void addNewClass() {
        String id, name;
        int pos;
        do {
            id = MyToys.getID("Input Class ID(AAXXXX): ",
                    "The format of ID is AAXXXX (A stands for a character. X stands for a digit.)", "^[A-Z]{2}\\d{4}$");
            pos = searchClassById(id);
            if (pos != -1) {
                System.out.println("The Student ID already exists. Input another one.");
            }
        } while (pos != -1);

        name = MyToys.getAString("Input Class Major: ", "Class Major is required.");

        classList.add(new ClassRoom(id, name));
        System.out.println("New class profile is added successfully.");
    }

    public void addNewClass(String id, String name) {
        classList.add(new ClassRoom(id, name));
    }

    public void removeClassById() {
        if (classList.isEmpty()) {
            System.out.println("Class List is empty.");
            return;
        }

        String id;
        int x;
        id = MyToys.getAString("Input Class ID to remove: ", "Class ID is required.");
        x = searchClassById(id);
        if (x == -1) {
            System.out.println("Not found.");
        } else {
            classList.remove(x);
            System.out.println("Class profile is removed successfully.");
        }
    }

    public void updateClassById() {
        if (classList.isEmpty()) {
            System.out.println("Class List is empty.");
            return;
        }

        String id;
        ClassRoom x;
        id = MyToys.getAString("Input Class ID to remove: ", "Class ID is required.");
        x = searchClassObjectById(id);
        if (x == null) {
            System.out.println("Not found.");
        } else {
            System.out.println("Class profile before updating: ");
            x.showDetails();
            x.setName(MyToys.getAString("Input new Class Major: ", "Class Major is required."));
            System.out.println("Class profile is updated successfully.");
            System.out.println("Class profile after updating: ");
            x.showDetails();
        }
    }

    public void showClassList() {
        if (classList.isEmpty()) {
            System.out.println("Class List is empty.");
            return;
        }

        Collections.sort(classList);
        System.out.println("Print class list: ");
        for (ClassRoom classRoom : classList) {
            classRoom.showDetails();
        }
    }

    public void showAllStudents() {
        if (classList.isEmpty()) {
            System.out.println("Class List is empty.");
            return;
        }
        System.out.println("===========" + this.getName() + " University ===========");
        for (ClassRoom classRoom : classList) {
            classRoom.showStudentList();
        }
    }

    public void exportFile() {
        String fileName;
        fileName = MyToys.getAString("Input file name to export: ", "File name is required.");
        File.exportFile(fileName, "===========" + this.getName() + " University ===========");
        for (ClassRoom classRoom : classList) {
            File.exportFile(fileName, classRoom);
        }
        System.out.println("File is exported successfully.");
    }
    
    public School importFile() {
        String fileName;
        fileName = MyToys.getAString("Input file name to import: ", "File name is required.");
        return File.importFile(fileName);
    }
}
