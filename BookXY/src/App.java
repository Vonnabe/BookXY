import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        RegisterMachine register = new RegisterMachine(input.nextDouble());
        System.out.println(register.getBalance());

        while (true){ 
        System.out.println("Welcome to BookXY App!");
        System.out.println("*******************************");
        System.out.println("MENU: ");
        System.out.println("-------------------------------");
        System.out.println("1. Add Book");
        System.out.println("2. View Info");
        System.out.println("3. Find Book by Barcode");
        System.out.println("4. Make Sale");
        System.out.println("5. Make Purchase");
        System.out.println("6. Exit");
        System.out.println("!-------------------------------!");


        int line= input.nextInt();
        
        switch (line) {
            case 1:
                Inventory.addItems(input);
                break;
            case 2:
                Inventory.listItems();
                System.out.println("Register Balance: " + register.getBalance());
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
            default:
                break;
        }
        }
    }
}
