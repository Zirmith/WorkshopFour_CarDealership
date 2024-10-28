package org.ps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Vehicle> inventory = new ArrayList<>();

    public static void init() {
        System.out.println("Welcome to the Vehicle Inventory System!");
        loadInventory();
        System.out.println("Inventory loaded with " + inventory.size() + " vehicles.");
    }

    public static void display() {
        init(); // Load inventory data

        boolean running = true;
        while (running) {
            showMenu();
            int choice = getUserChoice();
            running = handleUserChoice(choice);
        }
        System.out.println("Exiting the application. Goodbye!");
    }

    private static void showMenu() {
        System.out.println(ColorCodes.CYAN + "\n=== Vehicle Inventory System ===" + ColorCodes.RESET);
        System.out.println(ColorCodes.YELLOW + "Please select an option:" + ColorCodes.RESET);
        
        System.out.println(ColorCodes.GREEN + "1 - Find vehicles within a price range" + ColorCodes.RESET);
        System.out.println(ColorCodes.BLUE + "2 - Find vehicles by make/model" + ColorCodes.RESET);
        System.out.println(ColorCodes.PURPLE + "3 - Find vehicles by year range" + ColorCodes.RESET);
        System.out.println(ColorCodes.CYAN + "4 - Find vehicles by color" + ColorCodes.RESET);
        System.out.println(ColorCodes.YELLOW + "5 - Find vehicles by mileage range" + ColorCodes.RESET);
        System.out.println(ColorCodes.GREEN + "6 - Find vehicles by type (car, truck, SUV, van)" + ColorCodes.RESET);
        System.out.println(ColorCodes.BLUE + "7 - List ALL vehicles" + ColorCodes.RESET);
        System.out.println(ColorCodes.PURPLE + "8 - Add a vehicle" + ColorCodes.RESET);
        System.out.println(ColorCodes.CYAN + "9 - Remove a vehicle" + ColorCodes.RESET);
        System.out.println(ColorCodes.RED + "10 - Quit" + ColorCodes.RESET);
    
        System.out.print(ColorCodes.YELLOW + "Enter your choice: " + ColorCodes.RESET);
    }
    

    private static int getUserChoice() {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
        return choice;
    }

    private static boolean handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Finding vehicles within a price range...");
                // Add functionality for finding vehicles by price range
                break;
            case 2:
                System.out.println("Finding vehicles by make/model...");
                // Add functionality for finding vehicles by make/model
                break;
            case 3:
                System.out.println("Finding vehicles by year range...");
                // Add functionality for finding vehicles by year range
                break;
            case 4:
                System.out.println("Finding vehicles by color...");
                // Add functionality for finding vehicles by color
                break;
            case 5:
                System.out.println("Finding vehicles by mileage range...");
                // Add functionality for finding vehicles by mileage range
                break;
            case 6:
                System.out.println("Finding vehicles by type...");
                // Add functionality for finding vehicles by type
                break;
            case 7:
                System.out.println("Listing all vehicles...");
                listAllVehicles();
                break;
            case 8:
                System.out.println("Adding a vehicle...");
                // Add functionality to add a vehicle
                break;
            case 9:
                System.out.println("Removing a vehicle...");
                // Add functionality to remove a vehicle
                break;
            case 10:
                return false; // End the loop, quit the application
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }
        return true; // Continue the loop
    }

    private static void loadInventory() {
        String fileName = "inventory.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 7) { // Ensure the line has all required fields
                    String make = details[0];
                    String model = details[1];
                    int year = Integer.parseInt(details[2]);
                    String color = details[3];
                    int mileage = Integer.parseInt(details[4]);
                    int price = Integer.parseInt(details[5]);
                    String type = details[6];
                    
                    // Assuming you have a Vehicle constructor like: 
                    // new Vehicle(make, model, year, color, mileage, price, type)
                    inventory.add(new Vehicle(make, model, year, color, mileage, price, type));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading inventory: " + e.getMessage());
        }
    }

    private static void listAllVehicles() {
        if (inventory.isEmpty()) {
            System.out.println("No vehicles found in inventory.");
        } else {
            for (Vehicle vehicle : inventory) {
                System.out.println(vehicle);
            }
        }
    }
}
