package com.techelevator.view;

public class PurchaseMenu extends MainMenu {
    public void run() {
//        UserInput.displayPurchaseMenu();

        String choice = UserInput.displayPurchaseMenu();
//        System.out.println("\n" + "Current Money Provided: $"+super.totalMoneyProvided);
        if (choice.equals("Feed Money")) {
            double inserted=UserInput.feedMoney();
            super.totalMoneyProvided+=inserted;
            System.out.println(super.totalMoneyProvided);
            if(inserted==0.00){
                System.out.println("Sorry, your payment was not accepted.");
            }

        }
        UserInput.displayPurchaseMenu();
    }
}
