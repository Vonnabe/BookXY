import java.util.Scanner;
import java.beans.Customizer;
import java.util.ArrayList;

public class Transaction {
    
    private Items item;
    private Costumer costumer;

    private int quantity;
    private double totalprice;
    private boolean isPurchase;

    public Transaction(Items item, Costumer customer, int quantity, double totalprice, boolean isPurchase) {
        this.item = item;
        this.costumer = costumer;
        this.quantity = quantity;
        this.totalprice = totalprice;
        this.isPurchase = isPurchase;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalprice() {
        return item.getPrice() * quantity;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isPurchase() {
        return isPurchase;
    }

    public void setPurchase(boolean isPurchase) {
        this.isPurchase = isPurchase;
    }

        @Override
    public String toString() {
        return "Transaction{" +
                "itemname='" + quantity + '\'' +
                ", year=" + isPurchase +
                ", price=" + totalprice+ '\'' +
                '}';
    }
}
