
package Dao;

import java.util.List;
import org.hibernate.*;
import tables.Products;


public class productDao {
    private SessionFactory factory;

    public productDao(SessionFactory factory) {
        this.factory = factory;
    }
    
    public List<Products> getProducts()
    {
        Session s=factory.openSession();
        Query q=s.createQuery("from Products");
        List<Products> list=q.list();
   
        return list;
        
    }
      
    
}
