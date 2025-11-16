import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        RegisterMachine register = new RegisterMachine(input.nextDouble(), 0.0,0.0, 0.0, 0.0, 0.0);
        System.out.println(register.getBalance());

        while (true){ 
        System.out.println("Patch: 0.3.1");
        System.out.println("Welcome to BookXY App!");
        System.out.println("*******************************");
        System.out.println("MENU: ");
        System.out.println("-------------------------------");
        System.out.println("1. Add Book");
        System.out.println("2. View Info");
        System.out.println("3. Find Book by Barcode");
        System.out.println("4. Make Sale");
        System.out.println("5. Make Purchase");
        System.out.println("6. Exit Register Machine");
        System.out.println("7. Add Costumer Card");
        System.out.println("8. View Costumer Cards");
        System.out.println("9. Make Costumer Order");
        System.out.println("10. Settings");
        System.out.println("11. Transaction History");
        System.out.println("!-------------------------------!");


        int line= input.nextInt();
        
        switch (line) {
            case 1:
                Inventory.addItems(input);
                break;
            case 2:
                Inventory.listItems();
                System.out.println("Register Balance: " + RegisterMachine.getBalance());
                break;
            case 3:
                Inventory.findByBarcode(input);
                break;
            case 4:
                RegisterMachine.addSale(null);
                break;
            case 5:
                RegisterMachine.addPurchase(null);
                break;
            case 6:
                System.out.println("Exiting the application. Goodbye!");
                System.exit(0);
                break;
            case 7:
                RegisterMachine.addCustomer(null);
                break;
            case 8:
                RegisterMachine.listCustomers();
                break;
            case 9:
                RegisterMachine.btbsale(null);
                break;
            case 10:
                System.out.println("---SETTINGS---");
                System.out.println("---------------");
                System.out.println("1. Modify Tax Rate ");
                System.out.println("2. Exit Settings ");
                System.out.println("3. View Tax Rates ");
                int settingLine = input.nextInt();
                switch (settingLine) {
                    case 1:
                        RegisterMachine.taxModificationSettings(input, register);
                        break;
                    case 2:
                        System.out.println("Exiting Settings.");
                        break;
                    case 3:
                        System.out.println("Printing tax ratings.");
                        System.out.println("------------------------");
                        System.out.println("A FPA: " + RegisterMachine.getaFpa());
                        System.out.println("B FPA: " + RegisterMachine.getbFpa());
                        System.out.println("C FPA: " + RegisterMachine.getcFpa());
                        System.out.println("D FPA: " + RegisterMachine.getdFpa());
                        break;
                    default:
                        System.out.println("Invalid option in Settings.");
                break;
            }
            case 11:
                System.out.println("---Transaction List---");
                RegisterMachine.listTransactions();
                break;
            default:
                break;
            }
        }
    }
}
