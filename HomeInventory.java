public class HomeInventory {
    private List<Home> homes;
    public HomeInventory() {
        this.homes = new ArrayList<>();
    }
    Home newHome(int squareFeet, String address, String city, String state, int zipCode, String modelName, String saleStatus) {
        try {
            Home home = new Home(squareFeet, address, city, state, zipCode, modelName, saleStatus);
            homes.add(home);
            return home;
        } catch (Exception e) {
            System.out.println("Error creating home: " + e.getMessage());
            return null;
        }
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
        public String listHomes() {
            if (home.isEmpty()) {
                System.out.println("No homes in inventory.");
                return;
            }
            for (Home home : homes) {
                System.out.println(home);
            }
            }
        public String printToFile(String filePath) {
            try (FIleWriter writer = new FileWriter(filePath)) {
                for (Home home : homes) {
                    writer.write(home.toString() + System.lineSeparator());
                }
                return "Inventory written to " + filePath + " successfully.";
            } catch (IOException e) {
                return "Failed to write inventory to file: " + e.getMessage();
        }

        
            }
        } 
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            HomeInventory inventory = new HomeInventory();
            home1 = inventory.newHome(2500, "123 Main St", "Springfield", "IL", 62701, "Model A", "For Sale");
            home2 = inventory.newHome(1800, "456 Oak St", "Springfield", "IL", 62702, "Model B", "Sold");
            System.out.println("Inventory: ", inventory.listHomes());
        }   

    }
