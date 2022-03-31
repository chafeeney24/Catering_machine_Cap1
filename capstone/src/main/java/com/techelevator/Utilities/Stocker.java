package com.techelevator.Utilities;

import com.techelevator.item.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Stocker {
    String filePath="catering1.csv";
    File machineContents=new File(filePath);
    Scanner fileScanner=new Scanner(machineContents);
    Map<String, Item> selectionMap=new HashMap<>();
    public Stocker() throws FileNotFoundException {
    }

    public Map<String,Item> stockItems(){
        while(fileScanner.hasNextLine()){
            String lineOfText=fileScanner.nextLine();
           String[]productInfo= lineOfText.split(",");
           if(productInfo[2].equals("Munchy")){
               selectionMap.put(productInfo[0],new Munchy(productInfo[1],Double.parseDouble(productInfo[3]),productInfo[0]));
           }
           else if(productInfo[2].equals("Drink")){
               selectionMap.put(productInfo[0],new Drink(productInfo[1],Double.parseDouble(productInfo[3]),productInfo[0]));
           }
           else if(productInfo[2].equals("Dessert")){
               selectionMap.put(productInfo[0],new Dessert(productInfo[1],Double.parseDouble(productInfo[3]),productInfo[0]));
           }
           else if(productInfo[2].equals("Sandwich")){
               selectionMap.put(productInfo[0],new Sandwich(productInfo[1],Double.parseDouble(productInfo[3]),productInfo[0]));
           }
        }
        return selectionMap;
    }

}
