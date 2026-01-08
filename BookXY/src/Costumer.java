import java.util.ArrayList;

public class Costumer {

    private String name;
    private String email;
    private String password;
    private String phonenumber;
    private String address;

    static ArrayList<Costumer> costumers = new ArrayList<Costumer>();

    public Costumer(String name, String email, String password, String phonenumber, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phonenumber = phonenumber;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    public String toString() {
        return "Costumer [name=" + name + ", email=" + email + ", password=" + password + ", phonenumber=" + phonenumber
                + ", address=" + address + "]";
    }
}
