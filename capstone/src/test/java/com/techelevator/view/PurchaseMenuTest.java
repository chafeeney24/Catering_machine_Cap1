package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PurchaseMenuTest {
    PurchaseMenu purchaseMenu = new PurchaseMenu();


    @Test
    public void change_when_total_money_equals_whole_numnber(){
        double totalMoney = 10.00;
        int numberOfDollars = 10;
        String expected = "Your change of $"+ String.format("%.2f", totalMoney) +" will be returned as:" + "\n" + numberOfDollars + " One dollar bill(s)" + "\n"+"Thank You! Please come again.";
        Assert.assertEquals(expected, purchaseMenu.giveChange(totalMoney));

        double totalMoney2 = 73.00;
        int numberOfDollars2 = 73;
        String expected2 = "Your change of $"+ String.format("%.2f", totalMoney2) +" will be returned as:" + "\n" + numberOfDollars2 + " One dollar bill(s)" + "\n"+"Thank You! Please come again.";
        Assert.assertEquals(expected2, purchaseMenu.giveChange(totalMoney2));
    }

    @Test
    public void change_with_dollars_and_quarters(){
        double totalMoney = 7.50;
        int numberOfDollars = 7;
        int numberOfQuarters = 2;
        String expected = "Your change of $"+ String.format("%.2f", totalMoney) +" will be returned as:" + "\n" + numberOfDollars + " One dollar bill(s)" + "\n" + numberOfQuarters + " quarter(s)" + "\n"+"Thank You! Please come again.";
        Assert.assertEquals(expected, purchaseMenu.giveChange(totalMoney));

        double totalMoney2 = 1.75;
        int numberOfDollars2 = 1;
        int numberOfQuarters2 = 3;
        String expected2 = "Your change of $"+ String.format("%.2f", totalMoney2) +" will be returned as:" + "\n" + numberOfDollars2 + " One dollar bill(s)" +"\n" + numberOfQuarters2 + " quarter(s)"+ "\n"+"Thank You! Please come again.";
        Assert.assertEquals(expected2, purchaseMenu.giveChange(totalMoney2));

        double totalMoney3 = 117.25;
        int numberOfDollars3 = 117;
        int numberOfQuarters3 = 1;
        String expected3 = "Your change of $"+ String.format("%.2f", totalMoney3) +" will be returned as:" + "\n" + numberOfDollars3 + " One dollar bill(s)" + "\n" + numberOfQuarters3 + " quarter(s)" + "\n"+"Thank You! Please come again.";
        Assert.assertEquals(expected3, purchaseMenu.giveChange(totalMoney3));
    }

    @Test
    public void change_with_dollars_quarters_dimes(){
        double totalMoney = 8.95;
        int numberOfDollars = 8;
        int numberOfQuarters = 2;
        int numberOfDimes = 2;
        String expected = "Your change of $"+ String.format("%.2f", totalMoney) +" will be returned as:" + "\n" + numberOfDollars + " One dollar bill(s)" + "\n" + numberOfQuarters + " quarter(s)" + "\n"+"Thank You! Please come again.";
        Assert.assertEquals(expected, purchaseMenu.giveChange(totalMoney));

        double totalMoney2 = 1.75;
        int numberOfDollars2 = 1;
        int numberOfQuarters2 = 3;
        int numberOfDimes2 = 1;
        String expected2 = "Your change of $"+ String.format("%.2f", totalMoney2) +" will be returned as:" + "\n" + numberOfDollars2 + " One dollar bill(s)" +"\n" + numberOfQuarters2 + " quarter(s)"+ "\n"+"Thank You! Please come again.";
        Assert.assertEquals(expected2, purchaseMenu.giveChange(totalMoney2));

        double totalMoney3 = 117.25;
        int numberOfDollars3 = 117;
        int numberOfQuarters3 = 1;
        String expected3 = "Your change of $"+ String.format("%.2f", totalMoney3) +" will be returned as:" + "\n" + numberOfDollars3 + " One dollar bill(s)" + "\n" + numberOfQuarters3 + " quarter(s)" + "\n"+"Thank You! Please come again.";
        Assert.assertEquals(expected3, purchaseMenu.giveChange(totalMoney3));
    }
}
