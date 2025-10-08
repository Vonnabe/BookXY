import java.util.Scanner;
import java.util.ArrayList;

public class Items {

    private String itemname;
    private int year;
    private double price;
    private int quantity;
    private String barcode;
    private String branditem;

    static ArrayList<Items> items = new ArrayList<Items>();

    public Items(String itemname, int year, double price, int quantity, String barcode, String branditem) {
        this.itemname = itemname;
        this.year = year;
        this.price = price;
        this.quantity = quantity;
        this.barcode = barcode;
        this.branditem = branditem;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getBranditem() {
        return branditem;
    }

    public void setBranditem(String branditem) {
        this.branditem = branditem;
    }

        @Override
    public String toString() {
        return "Items{" +
                "itemname='" + itemname + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", quantity=" + quantity +
                ", barcode='" + barcode + '\'' +
                ", branditem='" + branditem + '\'' +
                '}';
    }

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

        Items newItem = new Items(itemname, year, price, quantity, barcode, branditem);
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
