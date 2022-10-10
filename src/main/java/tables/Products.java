
package tables;

import javax.persistence.*;

@Entity
public class Products 
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int pId;
    private String pName;
    @Column(length=500)
    private String pDesc;
    private int price;
    private String photo;
    
    @ManyToOne
    private Category category;
   

    public Products( String pName, String pDesc, int price, Category category, String photo) {
        
        this.pName = pName;
        this.pDesc = pDesc;
        this.price = price;
        this.category = category;
        this.photo = photo;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpDesc() {
        return pDesc;
    }

    public void setpDesc(String pDesc) {
        this.pDesc = pDesc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Products() {
    }
    
    
    
}

