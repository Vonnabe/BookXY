public class Items {

    private String itemname;
    private int year;
    private double price;
    private int quantity;
    private String barcode;
    private String branditem;
    private String taxCategory;

    public Items(String itemname, int year, double price, int quantity, String barcode, String branditem, String taxCategory) {
        this.itemname = itemname;
        this.year = year;
        this.price = price;
        this.quantity = quantity;
        this.barcode = barcode;
        this.branditem = branditem;
        this.taxCategory = taxCategory;
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

    public String getTaxCategory() {
        return taxCategory;
    }

    public void setTaxCategory(String taxCategory) {
        this.taxCategory = taxCategory;
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
                ", taxCategory='" + taxCategory + '\'' +
                '}';
    }

}
