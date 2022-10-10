
package tables;

import javax.persistence.*;
import java.util.*;

@Entity
public class Category 
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int cId;
    private String cName;
    private String cDesc;
    @OneToMany(mappedBy ="category")
    private List<Products>products=new ArrayList<>();

    public String getcDesc() {
        return cDesc;
    }

    public void setcDesc(String cDesc) {
        this.cDesc = cDesc;
    }

    public Category(String cDesc) {
        this.cDesc = cDesc;
    }
    

    public Category( String cName,List<Products>products) {
      
        this.cName = cName;
        this.products=products;
    }

    public Category() {
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }
    
    
    
    
}