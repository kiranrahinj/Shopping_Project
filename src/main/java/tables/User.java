package tables;

import javax.persistence.*;

@Entity
public class User 
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int uId;
    private String uName;
    private String email;
    private String password;
    @Column(length=10)
    private String PhoneNumber;
    private String Address;
    private String uType;

    public User(String uName, String email, String password, String PhoneNumber, String Address,String uType) {
        this.uName = uName;
        this.email = email;
        this.password = password;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
        this.uType=uType;
    }

    public User() {
    }

    public String getuType() {
        return uType;
    }

    public void setuType(String uType) {
        this.uType = uType;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
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

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    
    
}
