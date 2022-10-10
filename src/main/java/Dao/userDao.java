
package Dao;

import org.hibernate.*;
import tables.User;

public class userDao 
{
    private static SessionFactory factory;

    public userDao(SessionFactory factory) {
        this.factory = factory;
    }
    
    
    
    public static User getUserByEmailAndPassword(String Email,String Password)
    {
        User us=null;
        
        try 
        {
            String query="from User where email=:e and password=:p";
            Session ss=factory.openSession();
            Query q=ss.createQuery(query);
            q.setParameter("e", Email);
            q.setParameter("p", Password);
            us=(User)q.uniqueResult();
            
            ss.close();
        
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
      return us;  
    }
    
    
}
