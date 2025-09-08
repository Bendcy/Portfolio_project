
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeInventory {
    private List<Home> homes;

    public HomeInventory() {
        homes = new ArrayList<>();
    }

    // Create a new home and add to inventory
    Home newHome(int squareFeet, String address, String city, String state, int zipCode, String modelName, String saleStatus) {
        try {
            Home home = new Home(squareFeet, address, city, state, zipCode, modelName, saleStatus);
            homes.add(home);
            return home;
        } catch (Exception e) {
            System.out.println("Error creating home: " + e.getMessage());
            return null;
        }
    }

    // Remove a home by address
    public String removeHome(String address) {
        try {
            boolean removed = homes.removeIf(home -> home.getAddress().equals(address));
            if (removed) {
                return "Home at " + address + " removed successfully.";
            } else {
                return "Home at " + address + " not found.";
            }
        } catch (Exception e) {
            return "Failed to remove home: " + e.getMessage();
        }
    }

    // Update home details by address
    public String updateHome(String address, int squareFeet, String city, String state, int zipCode, String modelName, String saleStatus) {
        try {
            for (Home home : homes) {
                if (home.getAddress().equals(address)) {
                    home.setSquareFeet(squareFeet);
                    home.setCity(city);
                    home.setState(state);
                    home.setZipCode(zipCode);
                    home.setModelName(modelName);
                    home.setSaleStatus(saleStatus);
                    return "Home at " + address + " updated successfully.";
                }
            }
            return "Home at " + address + " not found.";
        } catch (Exception e) {
            return "Failed to update home: " + e.getMessage();
        }
    }

    // List all homes in inventory
    public void listHomes() {
        if (homes.isEmpty()) {
            System.out.println("No homes in inventory.");
            return;
        }
        for (Home home : homes) {
            System.out.println(home);
        }
    }

    // Print inventory to a file
    public String printToFile(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Home home : homes) {
                writer.write(home.toString() + System.lineSeparator());
            }
            return "Inventory written to " + filePath + " successfully.";
        } catch (IOException e) {
            return "Failed to write inventory to file: " + e.getMessage();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        HomeInventory inventory = new HomeInventory();
        inventory.newHome(2500, "123 Main St", "Springfield", "IL", 62701, "Model A", "For Sale");
        inventory.newHome(1800, "456 Oak St", "Springfield", "IL", 62702, "Model B", "Sold");
        System.out.println("Inventory:");
        inventory.listHomes();

        // Remove a home and print the result
        String result = inventory.removeHome("123 Main St");
        System.out.println(result);

        // Print inventory after removal
        System.out.println("Inventory after removal:");
        inventory.listHomes();

        // Add a new home and print the return value
        Home newHome = inventory.newHome(2200, "789 Pine St", "Springfield", "IL", 62703, "Model C", "For Sale");
        System.out.println("New home added: " + newHome);

        // Print inventory to show the new home
        System.out.println("Inventory after adding new home:");
        inventory.listHomes();

        // Update a home and print the result
        String updateResults = inventory.updateHome("789 Pine St", 2200, "Springfield", "IL", 62703, "Model C", "Sold");
        System.out.println("Inventory after Update: " + updateResults);
        inventory.listHomes();

        // Ask user if they want to print inventory to file
        System.out.println("Do you want to print the inventory to a file? (Y/N): ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        if (userInput.equalsIgnoreCase("Y")) {
            String filePath = "home_inventory.txt";
            String fileResult = inventory.printToFile(filePath);
            System.out.println(fileResult);
        } else {
            System.out.println("Inventory not printed to file.");
        }
        scanner.close();
    }
}
