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
        }

    }

    public void dispenseItem(String itemSelection) {
        int currentAvailable = currentInventory.get(itemSelection).getQuantityAvailable() - 1;
        currentInventory.get(itemSelection).setQuantityAvailable(currentAvailable);
        totalMoneyProvided -= currentInventory.get(itemSelection).getPrice();
        System.out.println(currentInventory.get(itemSelection).getName() + " $" + currentInventory.get(itemSelection).getPrice() +
                " - Money Remaining: $" + totalMoneyProvided + "\n" + currentInventory.get(itemSelection).printMessage() + "\n");
        //Log currentInventory.get(itemSelection);
    }

}
