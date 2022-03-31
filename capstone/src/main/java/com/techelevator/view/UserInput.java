package com.techelevator.view;

import java.util.Scanner;

public class UserInput {

    private static Scanner userInput = new Scanner(System.in);
    static DisplayMenu displayMenu = new DisplayMenu();
    static PurchaseMenu purchaseMenu = new PurchaseMenu();
    static Menu menu = new Menu();

    public static void showMainMenu(){


        System.out.println("********************************");
        System.out.println("********************************");
        System.out.println("Please make a selection: ");
        System.out.println("(D) Display caTEring Items");
        System.out.println("(P) Purchase");
        System.out.println("(E) Exit");
        System.out.println();
        String mainMenuReply = userInput.nextLine();

        switch(mainMenuReply) {
            case "D":
                displayMenu.runDisplay();
            case "P":
                purchaseMenu.run();
            case "E":
                menu.keepRunning = false;
        }
    }

    public static void displayPurchaseMenu(){

    }
}
