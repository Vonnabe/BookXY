import java.util.Scanner;
import java.util.ArrayList;

public class Inventory {

    static ArrayList<Items> items = new ArrayList<Items>();
    static ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    static ArrayList<RegisterMachine> registerMachines = new ArrayList<RegisterMachine>();

    public static void addItems(Scanner sc) {
        System.out.println("Adding items...");
        Items newItem = new Items(addItemName(), addItemYear(), addItemPrice(), addItemQuantity(), addItemBarcode(),
                addItemBrand(), inputTaxCategoryonItem());
        items.add(newItem);
        System.out.println("Item added successfully.");
    }

    static String addItemName() {
        System.out.print("Enter item name: ");
        Scanner sc = new Scanner(System.in);
        String itemname = sc.nextLine();
        if (itemname.isEmpty()) {
            System.out.println("Item name cannot be empty.");
            return null;
        }
        return itemname;
    }

    static Integer addItemYear() {
        System.out.print("Enter item year: ");
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        if (year < 0) {
            System.out.println("Year cannot be negative.");
            return null;
        }
        return year;
    }

    static Double addItemPrice() {
        System.out.print("Enter item price: ");
        Scanner sc = new Scanner(System.in);
        double price = sc.nextDouble();
        if (price < 0) {
            System.out.println("Price cannot be negative.");
            return null;
        }
        return price;
    }

    static Integer addItemQuantity() {
        System.out.print("Enter item quantity: ");
        Scanner sc = new Scanner(System.in);
        int quantity = sc.nextInt();
        if (quantity < 0) {
            System.out.println("Quantity cannot be negative.");
            return null;
        }
        return quantity;
    }

    static String addItemBarcode() {
        System.out.print("Enter item barcode: ");
        Scanner sc = new Scanner(System.in);
        String barcode = sc.nextLine();
        if (barcode.isEmpty()) {
            System.out.println("Barcode cannot be empty.");
            return null;
        }
        return barcode;
    }

    static String addItemBrand() {
        System.out.print("Enter item brand: ");
        Scanner sc = new Scanner(System.in);
        String branditem = sc.nextLine();
        if (branditem.isEmpty()) {
            System.out.println("Brand cannot be empty.");
            return null;
        }
        return branditem;
    }

    static String inputTaxCategoryonItem() {
        System.out.print("Enter item tax category: (a, b, c, d)");
        Scanner sc = new Scanner(System.in);
        String taxCategory = sc.nextLine();
        if (taxCategory.isEmpty()) {
            System.out.println("Tax category cannot be empty.");
            return null;
        }
        if (!taxCategory.equalsIgnoreCase("a") && !taxCategory.equalsIgnoreCase("b")
                && !taxCategory.equalsIgnoreCase("c") && !taxCategory.equalsIgnoreCase("d")) {
            System.out.println("Invalid tax category. Please enter a, b, c, or d.");
            return null;
        }
        return taxCategory;
    }

    public static void deleteItemsByBarcode() { // not tested yet
        addItemBarcode();
        String barcodeToDelete = addItemBarcode();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getBarcode().equals(barcodeToDelete)) {
                items.remove(i);
                System.out.println("Item with barcode " + barcodeToDelete + " has been removed.");
                break;
            }
        }
    }

    public static void findByBarcode() { // not tested yet
        addItemBarcode();
        String barcodeToFind = addItemBarcode();
        for (Items item : items) {
            if (item.getBarcode().equals(barcodeToFind)) {
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
