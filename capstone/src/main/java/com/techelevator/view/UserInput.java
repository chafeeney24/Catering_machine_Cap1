package com.techelevator.view;

import java.util.Scanner;

public class UserInput {

    private static Scanner userInput = new Scanner(System.in);


    public static String showMainMenu() {

        System.out.println("Please make a selection: ");
        System.out.println("(D) Display caTEring Items");
        System.out.println("(P) Purchase");
        System.out.println("(E) Exit");
        String mainMenuReply = userInput.nextLine().toUpperCase();

        switch (mainMenuReply) {
            case "D":
                //displayMenu.runDisplay();
                return "Display";
            case "P":
                //purchaseMenu.run();
                return "Purchase";
            case "E":
                //menu.keepRunning = false;
                return "Exit";
            default:
                return "";
        }
    }

    public static String bottomOfDisplay() {
        System.out.print("\n\n" + "(P) Make a Purchase | ");
        System.out.println("(B) Go Back to Main Menu");
        String bottomOfDisplayChoice = userInput.nextLine().toUpperCase();

        switch (bottomOfDisplayChoice) {
            case "P":
                return "Purchase";
            case "B":
                return "Back";
            default:
                return "";
        }
    }

    public static String displayPurchaseMenu() {
        System.out.println("(M) Feed Money");
        System.out.println("(S) Select Item");
        System.out.println("(F) Finish Transaction");
        System.out.println("(B) Go Back to Main Menu");

        String purchaseMenuReply = userInput.nextLine().toUpperCase();

        switch (purchaseMenuReply) {
            case "M":
                return "Feed Money";
            case "S":
                return "Select Item";
            case "F":
                return "Finish Transaction";
            case "B":
                return "Back";
            default:
                return "";

        }
    }

    public static double feedMoney() {
        System.out.println("Insert Your Money:");
        System.out.println("Machine accepts bills in the following denominations:");
        System.out.println("$1");
        System.out.println("$5");
        System.out.println("$10");
        System.out.println("$20");
        String feedMoneyInput = userInput.nextLine().replace("$", "");
        switch (feedMoneyInput) {
            case "1":
                return 1.00;
            case "5":
                return 5.00;
            case "10":
                return 10.00;
            case "20":
                return 20.00;
            default:
                return 0.00;

        }
    }
}
