import java.util.Scanner;
import java.util.ArrayList;

public class RegisterMachine {

    private double balance;

    static ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    private Inventory inventory;

    public RegisterMachine(double balance) {
        this.balance = 2000.00;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void addSale(Transaction t) {
        System.out.println("Sale");
        System.out.print("Enter barcode name: ");
        Scanner sc = new Scanner(System.in);
        String itemname = sc.nextLine();
        for (Items item : Inventory.items) {
            if (item.getItemname().equals(itemname)) {
                System.out.print("Enter quantity: ");
                int quantity = sc.nextInt();
                if (quantity > item.getQuantity()) {
                    System.out.println("Not enough items in stock.");
                    return;
                }
                double total = item.getPrice() * quantity;
                System.out.println("Total price: " + total);
                item.setQuantity(item.getQuantity() - quantity);
                Transaction newTransaction = new Transaction(item, null, quantity, total, false);
                transactions.add(newTransaction);
                return;
            }
        }

    }

    public static void addPurchase(double balance) {
        System.out.println("Purchase");
        System.out.print("Enter item name: ");
        Scanner sc = new Scanner(System.in);
        String itemname = sc.nextLine();
        for(Items item : Inventory.items){
            if(item.getItemname().equals(itemname)){
                System.out.println("Enter Quantity: ");
                int quantity = sc.nextInt();
                double total = balance - (item.getPrice() * quantity);
                System.out.println("Total Balance: " + total);
                item.setQuantity(item.getQuantity() + quantity);
                Transaction newTransaction = new Transaction(item, null, quantity, total, false);
                transactions.add(newTransaction);
                return;
            }
        }
    }

    public static void addPurchase(Transaction t) {
        System.out.println("Purchase");
        System.out.print("Enter item name: ");
        double total = t.getTotalprice();
        System.out.println("Total price: " + total);
    }
}