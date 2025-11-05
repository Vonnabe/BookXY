import java.util.Scanner;
import java.util.ArrayList;

public class RegisterMachine {

    private static double balance;

    static ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    static ArrayList<Costumer> newCostumer = new ArrayList<Costumer>();

    public RegisterMachine(double balance) {
        this.balance = balance;
    }

    public static double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void addSale(Transaction t) {
        System.out.println("Sale");
        System.out.print("Enter Item Barcode: ");
        Scanner sc = new Scanner(System.in);
        String itembarcode = sc.nextLine();
        for (Items item : Inventory.items) {
            if (item.getBarcode().equals(itembarcode)) {
                System.out.print("Enter quantity: ");
                int quantity = sc.nextInt();
                if (quantity > item.getQuantity()) {
                    System.out.println("Not enough items in stock.");
                    return;
                }
                double total = item.getPrice() * quantity;
                System.out.println("Total price: " + total);
                //double finalbalance = RegisterMachine.getBalance() + total;
                item.setQuantity(item.getQuantity() - quantity);
                balance = RegisterMachine.getBalance() + total;
                System.out.println("Total Balance: " + balance);
                Transaction newTransaction = new Transaction(item, null, quantity, total, false);
                transactions.add(newTransaction);
                return;
            }
        }

    }

    public static void addPurchase(Transaction t) {
        System.out.println("Purchase");
        System.out.print("Enter item name: ");
        Scanner sc = new Scanner(System.in);
        String itemname = sc.nextLine();
        for(Items item : Inventory.items){
            if(item.getItemname().equals(itemname) == false || Inventory.items.isEmpty()){ 
                System.out.println("Item not found in inventory, Would you Like to Add new Item? (Y/N)?");
                String response = sc.nextLine();
                if (response.equalsIgnoreCase("Y")) {
                    Inventory.addItems(sc);
                    return;
                } else {
                    return;
                }
            }else if(item.getItemname().equals(itemname)){
                System.out.println("Enter Quantity: ");
                int quantity = sc.nextInt();
                double total = RegisterMachine.getBalance() - (item.getPrice() * quantity);
                System.out.println("Total Balance: " + total);
                item.setQuantity(item.getQuantity() + quantity);
                Transaction newTransaction = new Transaction(item, null, quantity, total, false);
                transactions.add(newTransaction);
                return;
            }
        }
    }

    public static void addCustomer(Costumer c) {
        System.out.println("Add Costumer Card");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        System.out.print("Enter Phone Number: ");
        String phonenumber = sc.nextLine();
        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        Costumer newCostumer = new Costumer(name, email, password, phonenumber, address);
        Costumer.costumers.add(newCostumer);
        System.out.println("Costumer Card Added Successfully!");
    }

    public static void listCustomers() {
            if (Costumer.costumers.isEmpty()) {
            System.out.println("*No Costumer Listed available.*");
            return;
        }
        System.out.println("Listing Customer Cards:");
        for (Costumer customer : Costumer.costumers) {
            System.out.println(customer);
        }
    }

}