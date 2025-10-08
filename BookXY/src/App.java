import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {


        while (true){ 
        System.out.println("Welcome to BookXY App!");
        System.out.println("#######################");
        System.out.println("MENU: ");
        System.out.println("-------------------------------");
        System.out.println("1. Add Book");
        System.out.println("2. View Books");
        System.out.println("3. Remove Book");
        System.out.println("4. Exit");
        System.out.println("!-------------------------------!");

        Scanner input = new Scanner(System.in);
        int line= input.nextInt();
        
        switch (line) {
            case 1:
                Items.addItems(input);
                break;
            case 2:
                Items.listItems();
                break;
            case 3:
                Items.deleteItems(input);
                break;
            case 4:
                System.out.println("Saving items and exiting.");
                return;
            default:
                break;
        }
        }
    }
}
