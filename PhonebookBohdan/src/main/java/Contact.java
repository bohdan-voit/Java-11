
// Клас для зберігання імені, адреси та номера телефону.
public class Contact implements Component {
    private String name;
    private String address;
    private String phonenumber;

    public  Contact(){
        name="";
        address="";
        phonenumber="";


    }

    public Contact(String name, String address, String phonenumber) {
        this.name = name;
        this.address = address;
        this.phonenumber = phonenumber;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getAdress() {
        return address;
    }

    public String getPhoneNumber() {
        return phonenumber;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setAddress(String address) {
        this.address = address;
    }


    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}