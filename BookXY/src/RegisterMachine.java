import java.util.Scanner;
import java.util.ArrayList;

public class RegisterMachine {

    private static double balance;
    private static double eftpos;
    private static double aFpa;
    private static double bFpa;
    private static double cFpa;
    private static double dFpa;

    static ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    static ArrayList<Costumer> newCostumer = new ArrayList<Costumer>();

    public RegisterMachine(double balance, double eftpos, double aFpa, double bFpa, double cFpa, double dFpa) {
        this.balance = balance;
        this.eftpos = eftpos;
        this.aFpa = aFpa;
        this.bFpa = bFpa;
        this.cFpa = cFpa;
        this.dFpa = dFpa;
    }

    public static double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static double getEftpos() {
        return eftpos;
    }

    public void setEftpos(double eftpos) {
        this.eftpos = eftpos;
    }

    public static double getaFpa() {
        return aFpa;
    }

    public void setaFpa(double aFpa) {
        this.aFpa = aFpa;
    }

    public static double getbFpa() {
        return bFpa;
    }

    public void setbFpa(double bFpa) {
        this.bFpa = bFpa;
    }

    public static double getcFpa() {
        return cFpa;
    }

    public void setcFpa(double cFpa) {
        this.cFpa = cFpa;
    }

    public static double getdFpa() {
        return dFpa;
    }

    public void setdFpa(double dFpa) {
        this.dFpa = dFpa;
    }

    public static void makeOneOrMultipleSales() {
        Scanner sc = new Scanner(System.in);
        boolean openReceipt = true;
        double count = 0;
        double total = 0;
        int itemQuantityCount = 0;
        System.out.println("---Product Sale---");
        while (openReceipt) {
            String itemBarcode = inputItemBarcodeForaSale();
            for (Items item : Inventory.items) {
                if (item.getBarcode().equals(itemBarcode)) {
                    System.out.println(item);
                    System.out.println(item.getItemname() + " selected.");
                    System.out.println(item.getPrice() + " selected too.");
                    itemQuantityCount = enteredQuantityOfItemForSaleViaBarcode();
                    count = taxItemsCategorySettings(itemBarcode) * itemQuantityCount;
                    System.out.println("total before: " + total);
                    total += count;
                    System.out.println("total afterrr: " + total);
                    System.out.println("Total price: " + total);
                    item.setQuantity(item.getQuantity() - itemQuantityCount);
                    System.out.println("Would you like to add another item to the sale? (Y/N)");
                    String closeReceiptcheck = sc.nextLine();
                    if (closeReceiptcheck.equalsIgnoreCase("y")) {
                        count = 0;
                        break;
                    } else {
                        openReceipt = false;
                    }
                    System.out.println("Your total is: " + total);
                    paymentMethodSettings(total);
                    System.out.println("Total Balance: " + balance);
                    System.out.println("EftPOS Balance: " + eftpos);
                    Transaction newTransaction = new Transaction(item, null, itemQuantityCount, total, false);
                    transactions.add(newTransaction);
                    System.out.println("Transaction made: " + newTransaction);
                }
            }
        }
        return;
    }

    public static String inputItemBarcodeForaSale() {
        String itemBarcode = Inventory.inputItemBarcode();
        return itemBarcode;
    }

    public static Integer enteredQuantityOfItemForSaleViaBarcode() {
        int quantityOfItemToBeSold = Inventory.addItemQuantity();
        return quantityOfItemToBeSold;
    }

    public static void addPurchase(Transaction t) {
        System.out.println("Purchase");
        System.out.print("Enter item name: ");
        Scanner sc = new Scanner(System.in);
        String itemname = sc.nextLine();
        for (Items item : Inventory.items) {
            if (item.getItemname().equals(itemname) == false || Inventory.items.isEmpty()) {
                System.out.println("Item not found in inventory, Would you Like to Add new Item? (Y/N)?");
                String response = sc.nextLine();
                if (response.equalsIgnoreCase("Y")) {
                    Inventory.addItems();
                    return;
                } else {
                    return;
                }
            } else if (item.getItemname().equals(itemname)) {
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
    // ---WORK IN PROGRESS---//

    public static void btbsale(Transaction t) {
        boolean openReceipt = true;
        System.out.println(" ---B2B Sale--- ");
        while (openReceipt) {
            System.out.print("Enter Customer Password: ");
            Scanner sc = new Scanner(System.in);
            String password = sc.nextLine();
            for (Costumer customer : Costumer.costumers) {
                if (customer.getPassword().equals(password)) {
                    System.out.println("Customer Found: " + customer.getName());
                    makeOneOrMultipleSales();
                    openReceipt = false;
                }
            }
        }
    }

    public static void taxModificationSettings(Scanner sc, RegisterMachine register) {
        System.out.print("Enter Fpa A rate(%): ");
        double newAFpa = sc.nextDouble();
        register.setaFpa(newAFpa);
        System.out.print("Enter Fpa B rate(%): ");
        double newBFpa = sc.nextDouble();
        register.setbFpa(newBFpa);
        System.out.print("Enter Fpa C rate(%): ");
        double newCFpa = sc.nextDouble();
        register.setcFpa(newCFpa);
        System.out.print("Enter Fpa D rate(%): ");
        double newDFpa = sc.nextDouble();
        register.setdFpa(newDFpa);
        System.out.println("Tax rates updated successfully!");
    }

    public static double taxItemsCategorySettings(String barcodeOfITemToBeTaxed) {
        double itemTaxation = 0.0;
        double finalscore = 0.0;
        for (Items item : Inventory.items) {
            if (barcodeOfITemToBeTaxed.equals(item.getBarcode())) {
                if (item.getTaxCategory().equalsIgnoreCase("a")) {
                    itemTaxation = getaFpa();
                    finalscore = item.getPrice() * itemTaxation;
                } else if (item.getTaxCategory().equalsIgnoreCase("b")) {
                    itemTaxation = getbFpa();
                    finalscore = item.getPrice() * itemTaxation;
                } else if (item.getTaxCategory().equalsIgnoreCase("c")) {
                    itemTaxation = getcFpa();
                    finalscore = item.getPrice() * itemTaxation;
                } else if (item.getTaxCategory().equalsIgnoreCase("d")) {
                    itemTaxation = getdFpa();
                    finalscore = item.getPrice() * itemTaxation;
                } else {
                    System.out.println("---WARNING---");
                    System.out.println("Item does not have a tax, setting to 0%.");
                    finalscore = item.getPrice();
                }
            }
        }
        return finalscore;
    }

    public static double paymentMethodSettings(double total) {
        System.out.println("Select Payment Method: 1.Cash / 2.EftPOS");
        Scanner sc = new Scanner(System.in);
        boolean receiptPaymentMethod = true;
        while (receiptPaymentMethod) {
            int paymentMethod = sc.nextInt();
            if (paymentMethod == 2) {
                eftpos = RegisterMachine.getEftpos() + total;
                receiptPaymentMethod = false;
                return total;
            } else if (paymentMethod == 1) {
                balance = RegisterMachine.getBalance() + total;
                receiptPaymentMethod = false;
                return total;
            } else {
                System.out.println("Invalid Payment Method. Please select 1 for Cash or 2 for EftPOS.");
            }
        }
        return total;
    }

    // ---WORK IN PROGRESS---//
    public static void listTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("*No Transactions on record.*");
            return;
        }
        System.out.println("Transaction History:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
