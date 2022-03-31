package com.techelevator.view;

import com.techelevator.Utilities.Stocker;
import com.techelevator.item.Item;

import java.io.FileNotFoundException;
import java.util.Map;

public class Menu {
    //private Scanner userInput = new Scanner(System.in);
    Stocker stocker;
    {
        try {
            stocker = new Stocker();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    Map<String , Item> currentInventory = stocker.stockItems();
    boolean keepRunning;

    public void run() {
        UserInput userInput = new UserInput();

        while (keepRunning) {
            userInput.showMainMenu();
            keepRunning = false;
        }
    }



}
