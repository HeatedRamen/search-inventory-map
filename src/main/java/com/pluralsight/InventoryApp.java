package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class InventoryApp {

    static HashMap<String, Product> inventory = new HashMap<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        loadInventory();
        boolean isRunning = true;
        String userSearchItem;
        do {
            println("What item are you looking for? (e to exit)");
            userSearchItem = input.nextLine();

            if(userSearchItem.equalsIgnoreCase("e")){
                isRunning = false;
            }else {
                Product matchedItem = inventory.get(userSearchItem);

                if (matchedItem == null) {
                    println("Item was not found");
                } else {
                    println("Item found: " + matchedItem);
                }
            }

        }while(isRunning);


    }
    static void loadInventory(){
        try {
            FileReader fileReader = new FileReader("inventory.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);

            String line = bufReader.readLine();
            String[] parsedInventory;

            while(line != null){
                parsedInventory = line.split("\\|");
                inventory.put(parsedInventory[1], new Product(Integer.parseInt(parsedInventory[0]), parsedInventory[1], Double.parseDouble(parsedInventory[2])));
                line = bufReader.readLine();
            }
        }catch(Exception e){
            println("File can not be found");
        }

    }
    static void println(String message){
        System.out.println(message);
    }
}
