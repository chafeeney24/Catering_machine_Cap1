package com.techelevator.item;

public abstract class Item {
    private String name;
    private double price;
    private String slotLocation;
    private int quantityAvailable = 7;
    private int totalQuantityPurchased;

    public Item(String name, double price, String slotLocation){
        this.name = name;
        this.price = price;
        this.slotLocation = slotLocation;
        }


    public abstract String printMessage();

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public void setTotalQuantityPurchased(int totalQuantityPurchased) {
        this.totalQuantityPurchased = totalQuantityPurchased;
    }

    public double getTotalSales(){
        return this.totalQuantityPurchased * this.price;
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

    public int getTotalQuantityPurchased() {
        return totalQuantityPurchased;
    }

}
