
public class Transaction {

    private Items item;

    private String costumer;
    private int quantity;
    private double totalprice;
    private boolean isPurchase;

    public Transaction(Items item, String costumer, int quantity, double totalprice,
            boolean isPurchase) {
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

    public String getCostumer() {
        return costumer;
    }

    public void setCostumer(String costumer) {
        this.costumer = costumer;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "item=" + item +
                ", costumer=" + costumer +
                ", quantity=" + quantity +
                ", totalprice=" + getTotalprice() +
                ", isPurchase=" + isPurchase +
                '}';
    }

}
