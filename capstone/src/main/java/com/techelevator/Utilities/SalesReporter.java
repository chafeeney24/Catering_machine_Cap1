package com.techelevator.Utilities;

import com.techelevator.item.Item;
import com.techelevator.view.MainMenu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class SalesReporter {

    double totalSales = 0.00;
    LocalDateTime now = LocalDateTime.now();                                                //Should we put date time in the logger class?!
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH-mm-ss");     //The only time we are using it is when printing to the reports.
    String formatDateTime = now.format(formatter);

    public void logSales(Map<String, Item> currentInventory) {

        String salesFilePathName;
        salesFilePathName = "Sales Reports/Sales Report_"+formatDateTime+".csv";
        Logger salesReport = new Logger(salesFilePathName);


        for (String key : currentInventory.keySet()) {

            int quantitySold = 7 - currentInventory.get(key).getQuantityAvailable();
            salesReport.writeSales(currentInventory.get(key).getName() + "," + quantitySold);
            totalSales += (quantitySold*currentInventory.get(key).getPrice());
        }
        salesReport.writeSales("Total Gross Sales: $"+String.format("%.2f",totalSales));
    }
}
