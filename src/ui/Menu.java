/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.Set;
import java.util.TreeSet;
import util.MyToys;

/**
 *
 * @author Ngoc Huu
 */
public class Menu {

    private String menuTitle;
    private Set<String> optionsList = new TreeSet<>();

    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public void addNewOption(String newOption) {
        optionsList.add(newOption);
    }

    public void printMenu() {
        if (optionsList.isEmpty()) {
            System.out.println("Menu has no options.");
            return;
        } else {
            System.out.println("\n================ " + menuTitle + " ================");
            for (String option : optionsList) {
                System.out.println(option);
            }
        }
    }

    public int getOptionToExit() {
        return optionsList.size();
    }

    public int getChoice() {
        if (optionsList.isEmpty()) {
            return 0;
        } else {
            return MyToys.getAnInteger("Choose [1.." + getOptionToExit() + "]: ", "You are required to "
                    + "choose the option 1.." + getOptionToExit(), 1, getOptionToExit());
        }
    }
}
