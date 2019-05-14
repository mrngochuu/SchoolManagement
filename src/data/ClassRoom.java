/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import util.MyToys;

/**
 *
 * @author Ngoc Huu
 */
public class ClassRoom implements Comparable<ClassRoom> {

    private String id;
    private String name;
    private List<Student> studentList = new ArrayList<>();

    public ClassRoom(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public int compareTo(ClassRoom o) {
        return this.id.compareToIgnoreCase(o.id);
    }

    @Override
    public String toString() {
        return "Class{" + "id=" + id + ", name=" + name + ", studentList=" + studentList + '}';
    }

    public void showDetails() {
        System.out.printf("|Class|%6s|%2s|\n", id, name);
    }

    public void addNewStudent(List<ClassRoom> classList) {
        String id, name, className;
        int yob;
        do {
            id = MyToys.getID("Input Student ID(AAXXXXXX): ",
                    "The format of id is AAXXXXXX (A stands for a character. X stands for a digit.)", "^[A-Z]{2}\\d{6}$");
            className = searchStudentAllClassById(classList,id);
            if (className != null) {
                System.out.println("The Student ID already exists in " + className + ". Input another one.");
            }
        } while (className != null);

        name = MyToys.getAString("Input Student name: ", "Student name is required.");
        yob = MyToys.getAge("Input Student yob: ", "Student age must be from 18 to 40.");

        studentList.add(new Student(id, name, yob));
        System.out.println("New student profile is added successfully.");
    }

    public void addNewStudent(String id, String name, int yob) {
        studentList.add(new Student(id, name, yob));
    }

    public String searchStudentAllClassById(List<ClassRoom> classList, String id) {
        if (classList.isEmpty()) {
            return null;
        }

        for (ClassRoom x : classList) {
            List<Student> list = x.getStudentList();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equalsIgnoreCase(id)) {
                    return x.getId();
                }
            }
        }
        return null;
    }

    public void searchStudentById() {
        if (studentList.isEmpty()) {
            System.out.println("Student List of the Class " + this.id + " is empty.");
            return;
        }

        String id;
        Student x;
        id = MyToys.getAString("Input Student ID: ", "Student ID is required.");
        x = searchStudentObjectById(id);
        if (x == null) {
            System.out.println("Not found.");
        } else {
            System.out.println("Here is student's profile: ");
            x.showDetails();
        }
    }

    public Student searchStudentObjectById(String id) {
        if (studentList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equalsIgnoreCase(id)) {
                return studentList.get(i);
            }
        }
        return null;
    }

    public int searchStudentById(String id) {
        if (studentList.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public void updateStudentById() {
        if (studentList.isEmpty()) {
            System.out.println("Student List of the Class " + this.id + " is empty.");
            return;
        }

        String id;
        Student x;
        id = MyToys.getAString("Input Student ID to update: ", "Student ID is required.");
        x = searchStudentObjectById(id);
        if (x == null) {
            System.out.println("Not found.");
        } else {
            System.out.println("Student profile before updating: ");
            x.showDetails();
            x.setName(MyToys.getAString("Input new Student name: ", "Student name is required."));
            x.setYob(MyToys.getAge("Input Student yob: ", "Student age must be from 18 to 40."));
            System.out.println("Student profile is updated successfully.");
            System.out.println("Student profile after updating: ");
            x.showDetails();
        }
    }

    public void deleteStudentById() {
        if (studentList.isEmpty()) {
            System.out.println("Student List of the Class " + this.id + " is empty.");
            return;
        }

        String id;
        int x;
        id = MyToys.getAString("Input Student ID to remove: ", "Student ID is required.");
        x = searchStudentById(id);
        if (x == -1) {
            System.out.println("Not found.");
        } else {
            studentList.remove(x);
            System.out.println("Student profile is removed successfully.");
        }
    }

    public void showStudentList() {
        if (studentList.isEmpty()) {
            System.out.println("Student List of the Class " + this.id + " is empty.");
            return;
        }

        Collections.sort(studentList);
        System.out.println("Students list of class " + this.id + ": ");
        for (Student student : studentList) {
            student.showDetails();
        }
    }
}
