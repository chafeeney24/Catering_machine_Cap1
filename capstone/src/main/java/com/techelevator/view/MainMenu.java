package com.techelevator.view;

import com.techelevator.Utilities.Stocker;
import com.techelevator.item.Item;

import java.io.FileNotFoundException;
import java.util.Map;

public class MainMenu {
    //private Scanner userInput = new Scanner(System.in);
    Stocker stocker;
    double totalMoneyProvided=0.00;
    {
        try {
            stocker = new Stocker();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    Map<String , Item> currentInventory = stocker.stockItems();
    //boolean keepRunning;

    public void run() {
        UserInput userInput = new UserInput();
        DisplayMenu displayMenu = new DisplayMenu();
        PurchaseMenu purchaseMenu=new PurchaseMenu();
        boolean keepRunning = true;

        while (keepRunning) {
            String choice = UserInput.showMainMenu();
            if(choice.equals("Display")){
                displayMenu.run();
            }
            else if(choice.equals("Purchase")){
                purchaseMenu.run();
            }

            keepRunning = false;
        }
    }



}
