package com.techelevator.view;

import com.techelevator.Utilities.Colors;
import com.techelevator.Utilities.Logger;
import com.techelevator.item.Item;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PurchaseMenu extends MainMenu {
    LocalDateTime now = LocalDateTime.now();                                                //Should we put date time in the logger class?!
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");     //The only time we are using it is when printing to the reports.
    String formatDateTime = now.format(formatter);                                          //I've put comments in the logger class.


    public void run() {
//        UserInput.displayPurchaseMenu();

//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
//        String formatDateTime = now.format(formatter);
        String choice = UserInput.displayPurchaseMenu(totalMoneyProvided);

        while (!choice.equals("Finish Transaction")) {
//            if(choice.equals("Back")){
//                super.run();
//                break;
//            }
            if (choice.equals("Feed Money")) {
                double inserted = UserInput.feedMoney();
                super.totalMoneyProvided += inserted;
                //System.out.println(super.totalMoneyProvided);
                if (inserted == 0.00) {
                    System.out.println("\u001B[31m" + "Sorry, your payment was not accepted." + "\u001B[0m");
                }
                super.auditLogger.write(formatDateTime +  " MONEY FED: " +"$" + inserted + " $" + totalMoneyProvided);
                choice = UserInput.displayPurchaseMenu(totalMoneyProvided);
            }

            if (choice.equals("Select Item")) {
                UserOutput.displayItems(super.currentInventory);
                String itemSelection = UserInput.selectItem();
                if (currentInventory.containsKey(itemSelection)) {
                    if (currentInventory.get(itemSelection).getQuantityAvailable() > 0) {
                        if (currentInventory.get(itemSelection).getPrice() <= totalMoneyProvided) {
                            dispenseItem(itemSelection);
                        } else {
                            System.out.println("\u001B[31m" + "Please enter more money for the item selected." + "\n" + "\u001B[0m");
                        }
                    } else {
                        System.out.println("\u001B[31m" + "Sorry that Item is no longer available." + "\n" + "\u001B[0m");
                    }

                } else {
                    System.out.println("\u001B[31m" + "Please select valid Item" + "\n" + "\u001B[0m");
                }
                choice = UserInput.displayPurchaseMenu(totalMoneyProvided);
            }
            if(choice.equals("Invalid Response")){
                System.out.println(Colors.Red + "I'm sorry, I didn't understand that. Please enter a response from the list above."+ "\n" + Colors.Reset);
                choice = UserInput.displayPurchaseMenu(totalMoneyProvided);
            }
        }
if(totalMoneyProvided>0){
    System.out.println(giveChange(totalMoneyProvided)+"\n");

}
else{
            System.out.println(Colors.Yellow + "Thank You. Please Come Again." + "\n" + Colors.Reset);
        }
//super.run();                  //  I TOOK THIS OUT AND IT STOPPED THE LOOPING ERROR, WHY DID WE HAVE THIS IN THERE?
                                // WAS IT JUST FOR IT TO LOOP AS A TEMP FIX?
    }

    public void dispenseItem(String itemSelection) {
        int currentAvailable = currentInventory.get(itemSelection).getQuantityAvailable() - 1;

        currentInventory.get(itemSelection).setQuantityAvailable(currentAvailable);

        totalMoneyProvided -= currentInventory.get(itemSelection).getPrice();


        System.out.println(currentInventory.get(itemSelection).getName() + " $" +  currentInventory.get(itemSelection).getPrice() +
                " - Money Remaining: $" + String.format("%.2f", totalMoneyProvided) + "\n" + currentInventory.get(itemSelection).printMessage() + "\n");

        super.auditLogger.write(formatDateTime + " " + currentInventory.get(itemSelection).getName() +  " " +
                currentInventory.get(itemSelection).getSlotLocation() + " $" + (String.format("%.2f", totalMoneyProvided + currentInventory.get(itemSelection).getPrice())) + " $" + String.format("%.2f", totalMoneyProvided));

    }

    public String giveChange(Double totalMoney){
        double change = totalMoney;
        int numberOfDollars=totalMoney.intValue();
        int cents=(int)Math.ceil((totalMoney-numberOfDollars)*100);
        int numberOfQuarters=0;
        int numberOfDimes=0;
        int numberOfNickels=0;
        if(cents>=25){
            numberOfQuarters=cents/25;
            cents=cents%25;
        }
        if(cents>=10){
            numberOfDimes=cents/10;
            cents=cents%10;
        }
        if(cents>=5){
            numberOfNickels=cents/5;
            cents=cents%5;
//            if(cents>0){
//                System.out.println("rounding error");
        }

        String endingMessage="Your change of $"+ String.format("%.2f", totalMoney) +" will be returned as:";
        if(numberOfDollars>0) {
            endingMessage += "\n" + numberOfDollars + " One dollar bill(s)";
        }
        if(numberOfQuarters>0) {
            endingMessage += "\n" + numberOfQuarters + " quarter(s)";
        }
        if(numberOfDimes>0) {
            endingMessage += "\n" + numberOfDimes + " dime(s)";
        }
        if(numberOfNickels>0) {
            endingMessage += "\n" + numberOfNickels + " nickel(s)";
        }
        endingMessage+="\n"+"Thank You! Please come again.";

        super.auditLogger.write(formatDateTime +  " CHANGE GIVEN: " + " $" + String.format("%.2f", totalMoneyProvided) + " $0.00");

        return endingMessage;
    }

}
