
package Dao;
import java.util.List;
import tables.Category;
import org.hibernate.*;
import org.hibernate.SessionFactory;

public class categoryDao 
{
    private SessionFactory factory;

    public categoryDao(SessionFactory factory) {
        this.factory = factory;
    }
    
    public void saveCategory(String cname,String Desc)
    {
        Category ct=new Category();
        ct.setcName(cname);
        ct.setcDesc(Desc);
        
        Session ss = factory.openSession();
        Transaction tx = ss.beginTransaction(); 
        ss.save(ct);
        tx.commit();
        ss.close();
 
//        return cId ;
    }
    public  List<Category>getCategory()
    {
        Session s=factory.openSession();
        Query q=s.createQuery("from Category");
        List<Category> list=q.list();
        
        return list;
    }
   
    
    public Category getCategoryById(int cId)
    {
       Category cat=null ;
        try
        {
           Session s=factory.openSession();
         cat =s.get(Category.class, cId);

            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return cat;
    }
}
