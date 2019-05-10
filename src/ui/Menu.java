/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import java.util.List;
import util.MyToys;

/**
 *
 * @author Ngoc Huu
 */
public class Menu {

    private String menuTitle;
    private List<String> optionsList = new ArrayList<>();

    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public void addNewOption(String newOption) {
        for (String string : optionsList) {
            if(string.contains(newOption))
                return;
        }
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
