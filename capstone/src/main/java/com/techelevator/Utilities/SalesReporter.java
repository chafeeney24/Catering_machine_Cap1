package com.techelevator.Utilities;

import com.techelevator.item.Item;
import com.techelevator.view.MainMenu;

import java.util.Map;

public class SalesReporter {
private String salesFilePathName;

Logger salesReport = new Logger(salesFilePathName);

 public void logSales(Map<String,Item> currentInventory){
     for(String key:currentInventory.keySet())
     salesReport.write(currentInventory.get(key).getName()+", "+(7-currentInventory.get(key).getQuantityAvailable()));
 }
}
