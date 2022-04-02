package com.techelevator.view;

import com.techelevator.Utilities.Logger;
import com.techelevator.Utilities.SalesReporter;
import com.techelevator.Utilities.Stocker;
import com.techelevator.item.Item;

import java.io.FileNotFoundException;
import java.util.Map;

public class MainMenu {
    //private Scanner userInput = new Scanner(System.in);

    Logger auditLogger = new Logger("audit.txt");
    double totalMoneyProvided=0.00;

//    Stocker stocker;
//    {
//        try {
//            stocker = new Stocker();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
       Map<String , Item> currentInventory = Stocker.stockItems();
            //boolean keepRunning
//            PurchaseMenu purchaseMenu =new PurchaseMenu();
//            DisplayMenu displayMenu = new DisplayMenu();

    public void run() {
//        UserInput userInput = new UserInput();
        DisplayMenu displayMenu = new DisplayMenu();
        PurchaseMenu purchaseMenu=new PurchaseMenu();
        boolean keepRunning = true;

        while (keepRunning) {
            String choice = UserInput.showMainMenu();
            //Added this to make sure user entered correct responses.
            if(choice.equals("Invalid")){
                System.out.println("\u001B[31m" + "I'm sorry I didn't understand that. Please enter a valid response from list above" + "\u001B[0m");
            }
            else if(choice.equals("Display")){
                displayMenu.run();
            }
            else if(choice.equals("Purchase")){
                purchaseMenu.run();
            }
            else if(choice.equals("Sales Report")){
                SalesReporter salesReporter=new SalesReporter();
                salesReporter.logSales(currentInventory);
            }
            else if(choice.equals("Exit")){
                System.out.println("\u001B[33m" + "Thank You! Please Come Again." + "\u001B[0m");
                keepRunning = false;
            }


        }
    }



}
