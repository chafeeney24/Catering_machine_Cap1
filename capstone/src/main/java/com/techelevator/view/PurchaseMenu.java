package com.techelevator.view;

import com.techelevator.item.Item;

public class PurchaseMenu extends MainMenu {
    public void run() {
//        UserInput.displayPurchaseMenu();

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
                    System.out.println("Sorry, your payment was not accepted.");
                }
                //Log moneyInserted to be logged
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
                            System.out.println("Please enter more money for the item selected." + "\n");
                        }
                    } else {
                        System.out.println("Sorry that Item is no longer available." + "\n");
                    }

                } else {
                    System.out.println("Please select valid Item" + "\n");
                }
                choice = UserInput.displayPurchaseMenu(totalMoneyProvided);
            }
            if(choice.equals("Invalid Response")){
                System.out.println("I'm sorry, I didn't understand that. Please enter a response from the list above."+"\n");
                choice = UserInput.displayPurchaseMenu(totalMoneyProvided);
            }
        }
if(totalMoneyProvided>0){
    System.out.println(giveChange(totalMoneyProvided)+"\n");

}
else{
            System.out.println("Thank You. Please Come Again."+"\n");
        }
super.run();
    }

    public void dispenseItem(String itemSelection) {
        int currentAvailable = currentInventory.get(itemSelection).getQuantityAvailable() - 1;
        currentInventory.get(itemSelection).setQuantityAvailable(currentAvailable);
        totalMoneyProvided -= currentInventory.get(itemSelection).getPrice();
        System.out.println(currentInventory.get(itemSelection).getName() + " $" + currentInventory.get(itemSelection).getPrice() +
                " - Money Remaining: $" + totalMoneyProvided + "\n" + currentInventory.get(itemSelection).printMessage() + "\n");
        //Log currentInventory.get(itemSelection);

    }

    public String giveChange(Double totalMoney){
        double change=totalMoney;
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
            if(cents>0){
                System.out.println("rounding error");
            }
        }

        String endingMessage="Your change of $"+totalMoney+" will be returned as:";
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



        return endingMessage;
    }

}
