package com.techelevator.view;

import com.techelevator.Utilities.Colors;
import com.techelevator.view.UserInput;
import com.techelevator.view.UserOutput;

import java.awt.*;

public class DisplayMenu extends MainMenu {

    public void run() {
        PurchaseMenu purchaseMenu = new PurchaseMenu();

        UserOutput.displayItems(super.currentInventory);
        String choice = UserInput.bottomOfDisplay();
        if (choice.equals("Purchase")) {
            purchaseMenu.run();
            super.run();
        }
        else if (choice.equals("Back")) {
            super.run();
        }else if (choice.equals("Invalid")){
            System.out.print(Colors.Red +  "Please select a valid response:" + Colors.Reset);
            run();
        }
    }
}

