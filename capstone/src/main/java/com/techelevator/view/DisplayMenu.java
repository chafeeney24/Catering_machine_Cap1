package com.techelevator.view;

import com.techelevator.view.UserInput;
import com.techelevator.view.UserOutput;

public class DisplayMenu extends Menu {

    public void run(){
        UserOutput.displayItems(super.currentInventory);
    }
}
