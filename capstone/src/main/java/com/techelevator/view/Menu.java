package com.techelevator.view;

import com.techelevator.Utilities.Stocker;
import com.techelevator.item.Item;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Scanner userInput = new Scanner(System.in);

    public void run() {
        Stocker stocker= null;
        try {
            stocker = new Stocker();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Map<String , Item> currentInventory=stocker.stockItems();
        boolean keepRunning=true;
        while (keepRunning) {
            //  to do -- build out main menu

        }
    }

}
