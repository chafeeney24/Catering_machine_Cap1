package com.techelevator.view;

public class DisplayMenu extends MainMenu {

    public void run(){
        PurchaseMenu purchaseMenu=new PurchaseMenu();
        UserOutput.displayItems(super.currentInventory);
      String choice=UserInput.bottomOfDisplay();
      if(choice.equals("Purchase")){
          purchaseMenu.run();
      }
      else if(choice.equals("Back")){
          super.run();
      }
    }
}
