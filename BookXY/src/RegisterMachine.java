import java.util.Scanner;
import java.util.ArrayList;

public class RegisterMachine {
    private double totalAmount;
    private double cashReceived;
    private String item;
    private int quantity;
    private double price;
    private int machineSN;
    
    public RegisterMachine(double totalAmount, double cashReceived, String item, int quantity, double price) {
        this.totalAmount = totalAmount;
        this.cashReceived = cashReceived;
        this.item = item;
        this.quantity = quantity;
        this.price = price;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public double getCashReceived() {
        return cashReceived;
    }
    public void setCashReceived(double cashReceived) {
        this.cashReceived = cashReceived;
    }
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getMachineSN() {
        return machineSN;
    }
    public void setMachineSN(int machineSN) {
        this.machineSN = machineSN;
    }
}
