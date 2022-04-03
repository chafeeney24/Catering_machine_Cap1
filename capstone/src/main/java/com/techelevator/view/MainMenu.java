package com.techelevator.view;

import com.techelevator.Utilities.Colors;
import com.techelevator.Utilities.Logger;
import com.techelevator.Utilities.SalesReporter;
import com.techelevator.Utilities.Stocker;
import com.techelevator.item.Item;
import java.util.Map;


public class MainMenu {


    Logger auditLogger = new Logger("audit.txt");
    double totalMoneyProvided=0.00;


       Map<String , Item> currentInventory = Stocker.stockItems();


    public void run() {

        DisplayMenu displayMenu = new DisplayMenu();
        PurchaseMenu purchaseMenu=new PurchaseMenu();
        boolean keepRunning = true;

        while (keepRunning) {
            String choice = UserInput.showMainMenu();         //Did this to make sure correct responses are passed in.

            if(choice.equals("Invalid")){
                System.out.println(Colors.Red + "I'm sorry I didn't understand that. Please enter a valid response from list above" + Colors.Reset);
            }
            else if(choice.equals("Display")){
                displayMenu.run();
                break;
            }
            else if(choice.equals("Purchase")){
                purchaseMenu.run();
            }
            else if(choice.equals("Sales Report")){
                SalesReporter salesReporter=new SalesReporter();
                salesReporter.logSales(currentInventory);
            }
            else if(choice.equals("Exit")){
                UserOutput.goodByeMessage();
                keepRunning = false;
            }


        }
    }



}


//        Stocker stocker;
//    {
//        try {
//            stocker = new Stocker();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//    Map<String , Item> currentInventory = Stocker.stockItems();
//boolean keepRunning
//            PurchaseMenu purchaseMenu =new PurchaseMenu();
//            DisplayMenu displayMenu = new DisplayMenu();
