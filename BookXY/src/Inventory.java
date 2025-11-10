import java.util.Scanner;
import java.util.ArrayList;

public class Inventory {
    
    static ArrayList<Items> items = new ArrayList<Items>();

    public static void addItems(Scanner sc){
        System.out.println("Adding items...");
        System.out.print("Enter item name: ");
        sc.nextLine();
        String itemname = sc.nextLine();
        if(itemname.isEmpty()){
            System.out.println("Item name cannot be empty.");
            return;
        }
        System.out.print("Enter item year: ");
        int year = sc.nextInt();
        if(year < 0){
            System.out.println("Year cannot be negative.");
            return;
        }
        System.out.print("Enter item price: ");
        double price = sc.nextDouble();
        if(price < 0){
            System.out.println("Price cannot be negative.");
            return;
        }
        System.out.print("Enter item quantity: ");
        int quantity = sc.nextInt();
        if(quantity < 0){
            System.out.println("Quantity cannot be negative.");
            return;
        }
        sc.nextLine(); 
        System.out.print("Enter item barcode: ");
        String barcode = sc.nextLine();
        if(barcode.isEmpty()){
            System.out.println("Barcode cannot be empty.");
            return;
        }
        System.out.print("Enter item brand: ");
        String branditem = sc.nextLine();
        if(branditem.isEmpty()){
            System.out.println("Brand cannot be empty.");
            return;
        }

        System.out.print("Enter item tax category: (a, b, c, d)");
        String taxCategory = sc.nextLine();
        if(taxCategory.isEmpty()){
            System.out.println("Tax category cannot be empty.");
            return;
        }
        if(!taxCategory.equalsIgnoreCase("a") && !taxCategory.equalsIgnoreCase("b") && !taxCategory.equalsIgnoreCase("c") && !taxCategory.equalsIgnoreCase("d")){
            System.out.println("Invalid tax category. Please enter a, b, c, or d.");
            return;
        }

        Items newItem = new Items(itemname, year, price, quantity, barcode, branditem, taxCategory);
        items.add(newItem);
        System.out.println("Item added successfully.");
    }

    public static void deleteItems(Scanner sc) {
        System.out.print("Enter the barcode of the item to delete: ");
        sc.nextLine();
        String barcodeToDelete = sc.nextLine();
        if (barcodeToDelete.isEmpty()) {
            System.out.println("Barcode cannot be empty.");
            return;
            
        }
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getBarcode().equals(barcodeToDelete)) {
                items.remove(i);
                System.out.println("Item with barcode " + barcodeToDelete + " has been removed.");
                break;
            }
        }
    }

    public static void findByBarcode(Scanner sc){
        System.out.print("Enter the barcode to search: ");
        sc.nextLine();
        String barcodeToFind = sc.nextLine();
        if(barcodeToFind.isEmpty()){
            System.out.println("Barcode cannot be empty.");
            return;
        }
        for(Items item : items){
            if(item.getBarcode().equals(barcodeToFind)){
                System.out.println("Item found: " + item);
                return;
            }
        }
    }

    public static void listItems() {
        if (items.isEmpty()) {
            System.out.println("*No items available.*");
            return;
        }
        System.out.println("Listing items:");
        for (Items item : items) {
            System.out.println(item);
        }
    }
}
