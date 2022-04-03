package com.techelevator.item;

public abstract class Item {
    private String name;
    private double price;
    private String slotLocation;
    private int quantityAvailable = 7;


    public Item(String name, double price, String slotLocation){
        this.name = name;
        this.price = price;
        this.slotLocation = slotLocation;
        }


    public abstract String printMessage();

    public String productInfo(){
        String forInfo = name;
        while(forInfo.length() < 17){
           forInfo = forInfo + " ";
        }
      return slotLocation + ": " +  forInfo + " $" + price + " " + quantityAvailable + " available | ";
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }



}
