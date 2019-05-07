/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Ngoc Huu
 */
public class Student implements Comparable<Student>{
    private String id;
    private String name;
    private int yob;

    public Student(String id, String name, int yob) {
        this.id = id;
        this.name = name;
        this.yob = yob;
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

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", yob=" + yob + '}';
    }
    
    public void showDetails() {
        System.out.printf("|Student|%8s|%-30s|%4d|\n", id, name, yob);
    }

    @Override
    public int compareTo(Student o) {
        return this.getId().compareToIgnoreCase(o.getId());
    }
}
