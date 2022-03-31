package com.techelevator.view;

public class DisplayMenu extends Menu {

    public void runDisplay() {
        System.out.print(super.currentInventory.get("A1").productInfo());
        System.out.print(super.currentInventory.get("A2").productInfo());
        System.out.print(super.currentInventory.get("A3").productInfo());
        System.out.print(super.currentInventory.get("A4").productInfo());
        System.out.println();
        System.out.print(super.currentInventory.get("B1").productInfo());
        System.out.print(super.currentInventory.get("B2").productInfo());
        System.out.print(super.currentInventory.get("B3").productInfo());
        System.out.print(super.currentInventory.get("B4").productInfo());
        System.out.println();
        System.out.print(super.currentInventory.get("C1").productInfo());
        System.out.print(super.currentInventory.get("C2").productInfo());
        System.out.print(super.currentInventory.get("C3").productInfo());
        System.out.print(super.currentInventory.get("C4").productInfo());
        System.out.println();
        System.out.print(super.currentInventory.get("D1").productInfo());
        System.out.print(super.currentInventory.get("D2").productInfo());
        System.out.print(super.currentInventory.get("D3").productInfo());
        System.out.print(super.currentInventory.get("D4").productInfo());
    }
}
